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
    
    <title>My JSP 'takeoffAuditConfirm.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
      .lb{width: 100px; display: inline-block;}
      .auditop{ margin-left: 80px; }
      .mainDiv{ margin-left: 200px;margin-top:100px; }
      .txt{color: black;font-size: 20px;}
    </style>

  </head>
  
  <body style="background-image: url('Image/mainBodyBg.png');background-size: cover; ">
    <%@page import="com.table.outmanage.takeoff.*" %>
    <%@page import="java.text.SimpleDateFormat" %>
    <%SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
    <%TbTakeoffDAO dao = new TbTakeoffDAO(); %>
    <%TbTakeoff m = dao.findById(Integer.parseInt(request.getParameter("id"))); %>
    <%if (m != null){ %> 
    <div class="mainDiv">
    <input type="text" name="id" hidden="hidden" value="<%=m.getId() %>"> <br>
    <label class="lb">Alias</label><input type="text" name="alias" class="txt" disabled="true" size="50" value="<%=m.getAlias() %>"> <br>
    <label class="lb">姓名</label><input type="text" name="name" class="txt" disabled="true" size="50" value="<%=m.getName() %>" > <br>
    <label class="lb">部门</label><input type="text" name="department" class="txt" disabled="true" size="50" value="<%=m.getDepartment() %>"> <br>
    <label class="lb">请假原因</label><input type="text" name="content" class="txt" disabled="true" size="50" value="<%=m.getContent() %>"> <br>
    <label class="lb">登记时间</label><input type="text" name="publishTime" class="txt" disabled="true" size="50" value="<%=f.format( m.getPublishTime() ) %>"> <br>
    <label class="lb">离开时间</label><input type="text" name="leaveTime" class="txt" disabled="true" size="50" value="<%=f.format( m.getLeaveTime() ) %>"> <br>
    <label class="lb">预计归来时间</label><input type="text" name="returnTime" class="txt" disabled="true" size="50" value="<%=f.format( m.getReturnTime() ) %>"> <br>
    <a class="auditop" href="takeoffauditupdate.action?id=<%=m.getId()%>&state=1">批准</a>
    <a class="auditop" href="takeoffauditupdate.action?id=<%=m.getId()%>&state=2">不批准</a> 
    <a class="auditop" href="takeoffauditupdate.action?id=<%=m.getId()%>&state=3">暂不审核</a> <br>  
    </div>  
    <%} %> 
  </body>
</html>
