package com.action.login;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.table.personmanage.user.*;

public class LoginAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
    private static final String ADMIN = "admin";
    
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String userCheckCode = (String)request.getParameter("checkCode");
		String sysCheckCode = (String)request.getSession().getAttribute("checkCode");
		if (!userCheckCode.equals(sysCheckCode)){
			request.getSession().setAttribute("error", "验证码有误！");
			return ERROR;
		}
		
		TbUserDAO userDAO = new TbUserDAO();
		String alias = request.getParameter("alias");
		List userList = userDAO.findByAlias(alias);
		
		if(userList.size() == 0){
			request.getSession().setAttribute("error", "用户名不存在！");
			return ERROR;
		}
		
		TbUser user = (TbUser)userList.get(0);
		String password = request.getParameter("password");
		if(!password.equals(user.getPassword())){
			request.getSession().setAttribute("error", "密码错误！");
			return ERROR;
		}
		
		request.getSession().setAttribute("authority", user.getAuthority());
		request.getSession().setAttribute("alias", alias);
		request.getSession().setAttribute("name", user.getName());
		request.getSession().setAttribute("department", user.getDepartment());
		if (request.getSession().getAttribute("error") != null){
			request.getSession().removeAttribute("error");
		}
		return SUCCESS;
	}

}
