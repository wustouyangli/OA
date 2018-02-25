package com.action.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lucene.LuceneSearch;
import com.opensymphony.xwork2.ActionSupport;
import com.table.personmanage.user.TbUser;
import com.table.personmanage.user.TbUserDAO;


public class PersonSearch extends ActionSupport{
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();		
		String key = request.getParameter("key");		
		TbUserDAO dao = new TbUserDAO();
		List list = dao.findAll();		
		LuceneSearch ls = new LuceneSearch();
		ls.DeleteAll();	
		for (int i = 0; i < list.size(); i++){
			TbUser t = (TbUser)list.get(i);
			String filename = String.valueOf(t.getId()) + ".txt";
			StringBuffer value = new StringBuffer();
			value.append(t.getAlias()); 
			value.append("\r\n");
			value.append(t.getName());
			value.append("\r\n");
			value.append(t.getAuthority());
			value.append("\r\n");
			value.append(t.getSex());
			value.append("\r\n");
			value.append(t.getBirthday());
			value.append("\r\n");
			value.append(t.getDepartment());
			value.append("\r\n");
			value.append(t.getJob());
			value.append("\r\n");
			value.append(t.getEmail());
			value.append("\r\n");
			value.append(t.getOfficeTel());
			value.append("\r\n");
			value.append(t.getTel());
			value.append("\r\n");
			value.append(t.getFamilyTel());
			value.append("\r\n");
			value.append(t.getAddress());
			value.append("\r\n");
			value.append(t.getBestEmployee());
			
			ls.CreateDataFile(filename, new String(value));
		}
		ArrayList<Integer> idList = ls.getResult(key);
		request.getSession().setAttribute("idList", idList);
		return SUCCESS;
	}
    
}
