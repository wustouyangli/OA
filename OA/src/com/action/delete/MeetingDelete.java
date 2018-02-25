package com.action.delete;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.table.dailymanage.meeting.TbMeeting;
import com.table.dailymanage.meeting.TbMeetingDAO;

public class MeetingDelete extends ActionSupport{

	private static final long serialVersionUID = 1L;
	public String execute() throws Exception{
		TbMeetingDAO dao = new TbMeetingDAO();
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		TbMeeting t = dao.findById(id);
		dao.delete(t);
		//System.out.println("delete success!");
		return SUCCESS;
	}
	
}