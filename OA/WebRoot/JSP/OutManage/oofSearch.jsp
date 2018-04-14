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
    
    <title>My JSP 'oofSearch.jsp' starting page</title>
    
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
    <%@page import="com.table.outmanage.oof.*" %>
    <%TbOofDAO dao = new TbOofDAO(); %>
  
    <div style="width: 100%;">
     <h1 style="text-align: center;">查询结果如下</h1>
    </div>
    
    <div style="">
    <table border="1" style="margin: auto;">
      <tr align="center">
        <td hidden="hidden">编号</td>
        <td>出差登记人Alias</td>
        <td>出差登记人姓名</td>
        <td>部门</td>
        <td>出差原因</td>
        <td>登记时间</td>
        <td>离开时间</td>
        <td>预计归来时间</td>
        <td>审核状态</td>
      </tr>
      
      <%for (int i = 0; i < idList.size(); i++){ %>
      <%TbOof m = dao.findById(idList.get(i)); %>
      <tr align="center">
        <td hidden="hidden"><%=m.getId() %></td>
        <td><%=m.getAlias() %></td>
        <td><%=m.getName() %></td>
        <td><%=m.getDepartment() %></td>
        <td><%=m.getContent() %></td>
        <td><%=m.getPublishTime() %></td>
        <td><%=m.getLeaveTime() %></td>
        <td><%=m.getReturnTime() %></td>
        <%if (m.getState().equals("未审核")){%>
        <td style="color: blue;"><%=m.getState() %></td>
        <%}else if (m.getState().equals("已批准")){ %>
        <td style="color: green;"><%=m.getState() %></td>
        <%}else{ %>
        <td style="color: grey;"><%=m.getState() %></td>
        <%} %>
        
      </tr>
      
    <%} %>
    </table>
    </div>
  </body>
</html>
