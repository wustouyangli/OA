package com.action.search;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.table.dailymanage.meeting.TbMeeting;
import com.table.dailymanage.meeting.TbMeetingDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeetingTimeRangeSearch extends ActionSupport{
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception{
		// 两个时间段
		HttpServletRequest request = ServletActionContext.getRequest();	
		String time_start = request.getParameter("time_start");
		String time_end = request.getParameter("time_end");
		
		if (time_end == null || time_end.equals("")){
			Date now = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time_end = formatter.format(now);
		}
		
		TbMeetingDAO dao = new TbMeetingDAO();
		
		List<TbMeeting> list = dao.findByTimeRange(time_start, time_end);
		
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++){
			idList.add(list.get(i).getId());
		}
		request.getSession().setAttribute("idList", idList);
		
		return SUCCESS;
		
		
	   	
	}
}
