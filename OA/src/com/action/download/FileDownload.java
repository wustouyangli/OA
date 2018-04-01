package com.action.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownload extends ActionSupport{
	
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String filename = request.getParameter("filename");
		filename = new String(request.getParameter("filename").getBytes("iso8859-1"),"utf-8");
		String fileSaveRootPath ="C:\\E\\upload";
        
        String path = findFileSavePathByFileName(filename, fileSaveRootPath);
        String realname = filename.substring(filename.indexOf("_")+1);
        
        String userAgent = request.getHeader("User-Agent");  
        byte[] bytes = userAgent.contains("MSIE") ? realname.getBytes() : realname.getBytes("UTF-8"); // name.getBytes("UTF-8")处理safari的乱码问题  
        realname = new String(bytes, "ISO-8859-1"); // 各浏览器基本都支持ISO编码  
        response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", realname)); 
        //response.setHeader("content-disposition", "attachment;filename=" +  java.net.URLEncoder.encode(realname, "UTF-8"));
        
        FileInputStream in = new FileInputStream(path + "\\" + filename);
        OutputStream out = response.getOutputStream();
        
        byte buffer[] = new byte[1024];
        int len = 0;
        while((len=in.read(buffer))>0){
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
		return null;
	}
	
	public String findFileSavePathByFileName(String filename,String saveRootPath){
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;
        File file = new File(dir);
        if(!file.exists()){
            file.mkdirs();
        }
        return dir;
    }
}
