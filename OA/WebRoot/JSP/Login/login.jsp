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
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script src="JS/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="JS/Login/login.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS/Login/login.css">
  </head>
  
  <body>
    <div id="topPage">
      <div id="topPageMain" style="background-image: url('Image/topBack.png');">
      <div id="topPageTitle">
      <span style="font-family: '华文琥珀'; font-size: 50; color: #480000;text-shadow: 2px 2px 5px #500000;">
      <span style="font-family: 'Times New Roman'; font-style: oblique; font-size: 80;">OA</span>
                             办公自动化系统
      <span style="font-family: 'Times New Roman';">Office Automation</span>
      </span>
      </div>
       <div id="topPageHome">
          <img src="Image/home.png" width="80px" height="60px" style="position: relative;top: 15%; left: 23%;">  <br>
          <p style="text-align: center;" ><a id="homeLink" href="javascript:return false;">主页</a></p>
       </div>
       <div id="topPageUser">
          <img src="Image/user.png" width="80px" height="60px" style="position: relative; left: 56.6%; top: 15%;"> <br>
          <p style="text-align: right; margin-right: 15px;"> 
            <span style="position: relative; color: blue;"> <%=request.getSession().getAttribute("alias") %> </span> 
            <span>|</span> 
            <a href="JSP/Login/changePassword.jsp">修改密码</a> 
            <span>|</span> 
            <a href="index.jsp">退出登陆</a> 
          </p>
          
       </div>
      </div>
      <div id="topPageBottom" style="background-image: url('Image/topBackBorder.png'); ">
      </div>
    </div>
    
    <div id="leftPage" style="background-image: url('Image/leftPage.png')">
      
       <ul class="menuList">
       <li id="dailyManage"><span class="menuItem"><img src="Image/show.png" class="showtag"></span>日常管理
          <ul class="sonItem">
           <li id="meeting">会议管理</li>  
           <li id="notice">公告管理</li>
          </ul>
       </li>

       <li id="outManage"><span class="menuItem"><img src="Image/show.png" class="showtag"></span>考勤管理
          <ul class="sonItem">
            <li id="oof">出差登记</li>
            <li id="takeoff">请假登记</li>
          </ul>
       </li>

       <li id="planManage"><span class="menuItem"><img src="Image/show.png" class="showtag"></span>计划管理
          <ul class="sonItem">
            <li id="eplan">企业计划</li>
            <li id="dplan">部门计划</li>
          </ul>
       </li>

       <li id="personManage"><span class="menuItem"><img src="Image/show.png" class="showtag"></span>人员管理
          <ul class="sonItem">
            <li id="person">人员信息</li>
          </ul>
       </li>
       <%String authority = (String)request.getSession().getAttribute("authority");%>
       <%if (authority != null && authority.equals("admin")) {%>
       <li id="auditManage"><span class="menuItem"><img src="Image/show.png" class="showtag"></span>审核管理
          <ul class="sonItem">
            <li id="oofAudit">出差审核</li>
            <li id="takeoffAudit">请假审核</li>
          </ul>
       </li>
       <%} %>
       </ul>
    </div>
    <iframe src="JSP/Login/loginMainPage.jsp" id="mainPage" ></iframe>
  </body>
</html>
