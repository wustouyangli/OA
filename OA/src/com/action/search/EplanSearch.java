package com.action.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lucene.LuceneSearch;
import com.opensymphony.xwork2.ActionSupport;
import com.table.planmanage.enterpriseplan.TbEnterprisePlan;
import com.table.planmanage.enterpriseplan.TbEnterprisePlanDAO;


public class EplanSearch extends ActionSupport{
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();		
		String key = request.getParameter("key");		
		TbEnterprisePlanDAO dao = new TbEnterprisePlanDAO();
		List list = dao.findAll();		
		LuceneSearch ls = new LuceneSearch();
		ls.DeleteAll();	
		for (int i = 0; i < list.size(); i++){
			TbEnterprisePlan t = (TbEnterprisePlan)list.get(i);
			String filename = String.valueOf(t.getId()) + ".txt";
			StringBuffer value = new StringBuffer();
			value.append(t.getSubject());
			value.append("\r\n");
			value.append(t.getPublishManAlias());
			value.append("\r\n");
			value.append(t.getPublishManName());
			value.append("\r\n");
			value.append(t.getTime());
			value.append("\r\n");
			value.append(t.getContent());
			
			ls.CreateDataFile(filename, new String(value));
		}
		ArrayList<Integer> idList = ls.getResult(key);
		request.getSession().setAttribute("idList", idList);
		return SUCCESS;
	}
    
}
