package com.action.add;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.table.planmanage.enterpriseplan.TbEnterprisePlan;
import com.table.planmanage.enterpriseplan.TbEnterprisePlanDAO;
import com.utils.FileTools;


public class EplanAdd extends ActionSupport{
	//private static final long serialVersionUID = 1L;
	
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
		TbEnterprisePlan t = new TbEnterprisePlan();
	
		t.setSubject(request.getParameter("subject"));
		t.setPublishManAlias((String)request.getSession().getAttribute("alias"));
		t.setPublishManName((String)request.getSession().getAttribute("name"));
		t.setTime(new Timestamp(new Date().getTime()));
		t.setContent(request.getParameter("content"));
		System.out.println("enter");
		t.setFilename(null);
		if (this.getFile() != null){
		    String saveFilename = FileTools.makeFileName(this.getFileFileName());
            t.setFilename(saveFilename);
            FileOutputStream out = null;
    		FileInputStream in = null;
    		System.out.println(saveFilename);
            try{
            	System.out.println("oyl");
            	System.out.println(FileTools.SavePath);
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
                System.out.println("文件上传失败");
                e.printStackTrace();
            }finally {
                in.close();
                out.close();
            }
		}
		
		dao.save(t);
		//System.out.println("save success!");
		return SUCCESS;
	}
	
}
