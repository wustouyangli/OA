package com.action.delete;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.table.dailymanage.notice.TbNotice;
import com.table.dailymanage.notice.TbNoticeDAO;

public class NoticeDelete extends ActionSupport{

	private static final long serialVersionUID = 1L;
	public String execute() throws Exception{
		TbNoticeDAO dao = new TbNoticeDAO();
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		TbNotice t = dao.findById(id);
		dao.delete(t);
		System.out.println("delete success!");
		return SUCCESS;
	}
	
}
