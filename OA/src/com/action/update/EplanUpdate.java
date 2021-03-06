package com.action.update;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.table.planmanage.enterpriseplan.TbEnterprisePlan;
import com.table.planmanage.enterpriseplan.TbEnterprisePlanDAO;
import com.utils.FileTools;


public class EplanUpdate extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
    private File file;
	
    private String fileContentType;
	
	private String fileFileName;
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		TbEnterprisePlanDAO dao = new TbEnterprisePlanDAO();
		TbEnterprisePlan t = dao.findById(Integer.parseInt(request.getParameter("id")));
		
		String oldFilename = t.getFilename();
		if (oldFilename != null && !oldFilename.trim().equals("")){
		    String oldRealSavePath = FileTools.makePath(oldFilename, FileTools.SavePath);
		    FileTools.deleteFile(oldRealSavePath, oldFilename);
		}
		
		t.setSubject(request.getParameter("subject"));
		t.setPublishManAlias((String)request.getSession().getAttribute("alias"));
		t.setPublishManName((String)request.getSession().getAttribute("name"));
		t.setTime(new Timestamp(new Date().getTime()));
		t.setContent(request.getParameter("content"));
		t.setFilename(null);
		if (this.getFile() != null){
		    String saveFilename = FileTools.makeFileName(this.getFileFileName());
            t.setFilename(saveFilename);
            FileOutputStream out = null;
    		FileInputStream in = null;
            try{
            
                String realSavePath = FileTools.makePath(saveFilename, FileTools.SavePath);
                String absoluteSavePath = realSavePath + "\\" + saveFilename;
                System.out.println("upload: " + absoluteSavePath);
                out = new FileOutputStream(absoluteSavePath);
                in = new FileInputStream(this.getFile());
                byte buffer[] = new byte[1024];
                int len = 0;
                while((len=in.read(buffer))>0){
            	    //System.out.println(buffer);
                    out.write(buffer, 0, len);
                } 
            }catch (Exception e) {
                System.out.println("�ļ��ϴ�ʧ��");
                e.printStackTrace();
            }finally {
                in.close();
                out.close();
            }
		}
		
		dao.save(t);
		//System.out.println("update success!");
		return SUCCESS;
	}
}