package com.action.add;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.table.outmanage.oof.TbOof;
import com.table.outmanage.oof.TbOofDAO;


public class OofAdd extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private static final String UnAudit = "δ���";
	public String execute() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		TbOofDAO dao = new TbOofDAO();
		TbOof t = new TbOof();
		t.setAlias((String)request.getSession().getAttribute("alias"));
		t.setName((String)request.getSession().getAttribute("name"));
		t.setDepartment((String)request.getSession().getAttribute("department"));
		t.setLeaveTime(Timestamp.valueOf(request.getParameter("leaveTime")));
		t.setReturnTime(Timestamp.valueOf(request.getParameter("returnTime")));
		t.setPublishTime(new Timestamp(new Date().getTime()));
		t.setContent(request.getParameter("content"));
		t.setState(UnAudit);
		dao.save(t);
		System.out.println("save success!");
		
		return SUCCESS;
	}
}
