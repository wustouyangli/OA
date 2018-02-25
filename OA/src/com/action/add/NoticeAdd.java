package com.action.add;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.table.dailymanage.notice.TbNotice;
import com.table.dailymanage.notice.TbNoticeDAO;


public class NoticeAdd extends ActionSupport{
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		TbNoticeDAO dao = new TbNoticeDAO();
		TbNotice t = new TbNotice();
		t.setSubject(request.getParameter("subject"));
		t.setPublishManAlias((String)request.getSession().getAttribute("alias"));
		t.setPublishManName((String)request.getSession().getAttribute("name"));
		t.setPublishTime(new Timestamp(new Date().getTime()));
		t.setContent(request.getParameter("content"));
		dao.save(t);
		System.out.println("save success!");
		
		return SUCCESS;
	}
}
