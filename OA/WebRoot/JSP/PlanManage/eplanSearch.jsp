<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'eplanSearch.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body id="mainBody" style="background-image: url('Image/mainBodyBg.png');background-size: cover; ">
  <img src="Image/return.png" style=" position: absolute;left: 10px;top: 10px;" height="30px" width="30px" onclick="history.back()"> <br>
    <%String authority = (String)request.getSession().getAttribute("authority"); %>
    <%ArrayList<Integer> idList = (ArrayList<Integer>)request.getSession().getAttribute("idList"); %>
    <%@page import="com.table.planmanage.enterpriseplan.*" %>
    <%TbEnterprisePlanDAO dao = new TbEnterprisePlanDAO(); %>
  
    <div style="width: 100%;">
     <h1 style="text-align: center;">查询结果如下</h1>
    </div>
    
    <div style="">
    <table border="1" style="margin: auto;">
      <tr align="center">
        <td hidden="hidden">编号</td>
        <td>计划主题</td>
        <td>发布人Alias</td>
        <td>发布人姓名</td>
        <td>发布时间</td>
        <td>计划内容</td>
        
        <%if (authority != null && authority.equals("admin")){ %>
        <td>编辑区</td>
        <%} %>
      </tr>
      
      <%for (int i = 0; i < idList.size(); i++) { %>
      <%TbEnterprisePlan m = dao.findById(idList.get(i)); %>
      <tr align="center">
        <td hidden="hidden"><%=m.getId() %></td>
        <td><%=m.getSubject() %></td>
        <td><%=m.getPublishManAlias() %></td>
        <td><%=m.getPublishManName() %></td>
        <td><%=m.getTime() %></td>
        <td><a href="JSP/PlanManage/eplanDetail.jsp?id=<%=m.getId() %>">详情</a></td>
        
        <%if (authority != null && authority.equals("admin")){ %>
        <td>
           <a href="eplandelete.action?id=<%=m.getId() %>" onclick="return DeleteConfrim()" style="color: red;">删除</a> 
           <a href="JSP/PlanManage/eplanUpdate.jsp?id=<%=m.getId() %>" style="color: red">修改</a></td>
        <%} %>
        
      </tr>
    <%} %>
    </table>
    </div>
  </body>
</html>
