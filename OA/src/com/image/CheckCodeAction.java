package com.image;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CheckCodeAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private ByteArrayInputStream imageStream = null;
	public String execute() throws Exception{
		try{
			//HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletRequest request = ServletActionContext.getRequest();
			String checkCode = SecurityCode.getSecurityCode();
			imageStream = SecurityImage.getImageAsInputStream(checkCode);
	        
			request.getSession().setAttribute("checkCode", checkCode);
			
		} catch (Exception e) {  
            e.printStackTrace();  
        } 
		return SUCCESS;
	}
	
	public ByteArrayInputStream getImageStream() {  
        return imageStream;  
    }  
  
    public void setImageStream(ByteArrayInputStream imageStream) {  
        this.imageStream = imageStream;  
    }
}

