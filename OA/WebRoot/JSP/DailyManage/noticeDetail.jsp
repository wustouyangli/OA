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
    
    <title>My JSP 'noticeDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
    <style type="text/css">
      #mainBody{ margin-left: 100px;}
      .lb{width: 100px; display: inline-block;}
      .txt{ font-size: 18px; color: black; background-color: white;}
      .ckeDiv{ width: 80%; height: 100px;}
    </style>
    
  </head>
  
  <body id="mainBody" style="background-image: url('Image/mainBodyBg.png');background-size: cover; ">
    <img src="Image/return.png" style=" position: absolute;left: 10px;top: 10px;" height="30px" width="30px" onclick="history.back()"> <br>
    <%@page import="com.table.dailymanage.notice.*" %>
    <%@page import="java.text.SimpleDateFormat" %>
    <%SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
    <%TbNoticeDAO dao = new TbNoticeDAO(); %>
    <%TbNotice m = dao.findById(Integer.parseInt(request.getParameter("id"))); %>
    <%if (m != null){ %> 
    <input type="text" name="id" hidden="hidden" value="<%=m.getId() %>"> <br>
    <label class="lb">公告主题</label><input type="text" name="subject" class="txt" disabled="true" size="30" value="<%=m.getSubject()%>"> 
    <label class="lb">发布人Alias</label><input type="text" name="publishManAlias" class="txt" disabled="true" size="30" value="<%=m.getPublishManAlias() %>"> <br>
    <label class="lb">发布人姓名</label><input type="text" name="publishManName" class="txt" disabled="true" size="30" value="<%=m.getPublishManName() %>"> 
    <label class="lb">发布时间</label><input type="text" name="publishTime" class="txt" disabled="true" size="30" value="<%=f.format( m.getPublishTime() ) %>"> <br>
      
    <label class="lb" style="vetial-algin: top; float:left;">公告内容</label>  <br>
    <%-- <textarea  name="content" rows="5" cols="80" disabled="true"><%=m.getContent()%></textarea> <br> --%>
    <script type="text/javascript" src="CKEditor/ckeditor/ckeditor.js"></script>
      <div class="ckeDiv">
       <textarea rows="10" cols="20" class="ckeditor" name="content" disabled="disabled"><%=m.getContent() %></textarea>
      </div>
    <%} %> 
  </body>
</html>
