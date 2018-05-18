package com.action.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.table.personmanage.user.TbUser;
import com.table.personmanage.user.TbUserDAO;


public class ChangePassword extends ActionSupport{
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		TbUserDAO dao = new TbUserDAO();
		String alias = (String)request.getSession().getAttribute("alias");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		System.out.println(alias);
		System.out.println(newPassword);
		System.out.println(confirmPassword);
		List list = dao.findByAlias(alias);
		System.out.println(list.size());
	    if (list.size() > 0){
	    	TbUser t = (TbUser)list.get(0);
	    	
	    	if(!newPassword.equals(confirmPassword)){
	    		request.getSession().setAttribute("errorOfChangePsd", "确认密码与新密码不一致");
	    		return ERROR;
	    	}
	    	else{
	    		t.setPassword(newPassword);
	    		dao.save(t);
	    	}
	    	
	    }
	    if(request.getSession().getAttribute("errorOfChangePsd") != null){
	    	request.getSession().removeAttribute("errorOfChangePsd");
	    }
		return SUCCESS;
	}
}
