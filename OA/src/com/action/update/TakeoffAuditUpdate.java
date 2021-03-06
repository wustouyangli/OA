package com.action.update;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.table.outmanage.takeoff.TbTakeoff;
import com.table.outmanage.takeoff.TbTakeoffDAO;

public class TakeoffAuditUpdate extends ActionSupport{

	private static final long serialVersionUID = 1L;
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		TbTakeoffDAO dao = new TbTakeoffDAO();
		TbTakeoff t = dao.findById(Integer.parseInt(request.getParameter("id")));
		t.setState(request.getParameter("state"));
		int state = Integer.parseInt(request.getParameter("state"));
		if (state == 1) t.setState("已批准");
		else if (state == 2) t.setState("不批准");
		else if (state == 3) t.setState("未审核");
		dao.save(t);
		System.out.println("update success!");
		return SUCCESS;
	}
}
