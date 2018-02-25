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
    
    <title>My JSP 'loginMainPage.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script src="JS/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="JS/Login/loginMainPage.js" charset="gb2312"></script>
    <link rel="stylesheet" type="text/css" href="CSS/Login/loginMainPage.css">
  </head>
  
  <body id="mainbody" style="background-image: url('Image/officeTower.png'); background-size: cover" >
  	<marquee onMouseOut="this.start()" onMouseOver="this.stop()" style="font-size: 50px;color: #500000; margin-left: 150px;margin-right: 150px;">欢迎登陆办公自动化系统</marquee>
  	<div style="width: 100%; height: 300px;" align="right">
    <div id="calendar">
   <h4>2013年10月</h4>
   <a href="javascript:return false;" rel="external nofollow" rel="external nofollow" class="a1">上月</a>
   <a href="javascript:return false;" rel="external nofollow" rel="external nofollow" class="a2">下月</a>
   <ul class="week">
    <li>日</li>
    <li>一</li>
    <li>二</li>
    <li>三</li>
    <li>四</li>
    <li>五</li>
    <li>六</li>
 
   </ul>
   <ul class="dateList"></ul>
  </div>
</div>
  <div style="width: 100%;height: 100px; " align="center">
     <img class="smallImg" src="Image/officeTower.png">
     <img class="smallImg" src="Image/diningHall.png">
     <img class="smallImg" src="Image/gym.png">
     <img class="smallImg" src="Image/kaffee.png">
     <img class="smallImg" src="Image/stadium.png">
     
  </div>
  </body>
</html>
