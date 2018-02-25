package com.action.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lucene.LuceneSearch;
import com.opensymphony.xwork2.ActionSupport;
import com.table.outmanage.takeoff.TbTakeoff;
import com.table.outmanage.takeoff.TbTakeoffDAO;


public class TakeoffAuditSearch extends ActionSupport{
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();		
		String key = request.getParameter("key");		
		TbTakeoffDAO dao = new TbTakeoffDAO();
		List list = dao.findAll();		
		LuceneSearch ls = new LuceneSearch();
		ls.DeleteAll();	
		for (int i = 0; i < list.size(); i++){
			TbTakeoff t = (TbTakeoff)list.get(i);
			String filename = String.valueOf(t.getId()) + ".txt";
			StringBuffer value = new StringBuffer();
			value.append(t.getAlias());
			value.append("\r\n");
			value.append(t.getName());
			value.append("\r\n");
			value.append(t.getDepartment());
			value.append("\r\n");
			value.append(t.getLeaveTime());
			value.append("\r\n");
			value.append(t.getReturnTime());
			value.append("\r\n");
			value.append(t.getPublishTime());
			value.append("\r\n");
			value.append(t.getContent());
			value.append("\r\n");
			value.append(t.getState());
			
			ls.CreateDataFile(filename, new String(value));
		}
		ArrayList<Integer> idList = ls.getResult(key);
		request.getSession().setAttribute("idList", idList);
		return SUCCESS;
	}
    
}
