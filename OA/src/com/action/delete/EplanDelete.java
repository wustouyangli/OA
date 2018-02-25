package com.action.delete;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.table.planmanage.enterpriseplan.TbEnterprisePlan;
import com.table.planmanage.enterpriseplan.TbEnterprisePlanDAO;
import com.utils.FileTools;

public class EplanDelete extends ActionSupport{

	private static final long serialVersionUID = 1L;
	public String execute() throws Exception{
		TbEnterprisePlanDAO dao = new TbEnterprisePlanDAO();
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		TbEnterprisePlan t = dao.findById(id);
		
		String oldFilename = t.getFilename();
		if (oldFilename != null && !oldFilename.trim().equals("")){
		    String oldRealSavePath = FileTools.makePath(oldFilename, FileTools.SavePath);
		    FileTools.deleteFile(oldRealSavePath, oldFilename);
		}
		dao.delete(t);
		//System.out.println("delete success!");
		return SUCCESS;
	}
	
}
