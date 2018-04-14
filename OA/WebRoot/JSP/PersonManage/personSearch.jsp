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
    
    <title>My JSP 'personSearch.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-image: url('Image/mainBodyBg.png');background-size: cover; ">
  <img src="Image/return.png" style=" position: absolute;left: 10px;top: 10px;" height="30px" width="30px" onclick="history.back()"> <br>
    <%String authority = (String)request.getSession().getAttribute("authority"); %>
    <%ArrayList<Integer> idList = (ArrayList<Integer>)request.getSession().getAttribute("idList"); %>
    <%@page import="com.table.personmanage.user.*" %>
    <%TbUserDAO dao = new TbUserDAO(); %>
  
    <div style="width: 100%;">
     <h1 style="text-align: center;">查询结果如下</h1>
    </div>
    
    <div style="">
    <table border="1" style="margin: auto;">
      <tr align="center">
        <td hidden="hidden">编号</td>
        <td>Alias</td>
        <td>姓名</td>
        <td>性别</td>
        <td>部门</td>
        <td>职位</td>
        <td>级别</td>
        <td>完整信息</td>
        
      </tr>
      
      <%for (int i = 0; i < idList.size(); i++){ %>
      <%TbUser m = dao.findById(idList.get(i)); %>
      <tr align="center">
        <td hidden="hidden"><%=m.getId() %></td>
        <td><%=m.getAlias() %></td>
        <td><%=m.getName() %></td>
        <td><%=m.getSex() %></td>
        <td><%=m.getDepartment() %></td>
        <td><%=m.getJob() %></td>
        <td><%=m.getBestEmployee() %></td>
        <td><a href="JSP/PersonManage/personDetail.jsp?id=<%=m.getId() %>">详情</a></td>
        
      </tr>
      
    <%} %>
    </table>
    </div>
  </body>
</html>
