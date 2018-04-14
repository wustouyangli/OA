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
    
    <title>My JSP 'changePassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="CSS/Login/changePassword.css">
    <script src="JS/jquery-1.7.1.js"></script>
    <script >
		function check(){
		    var oldPassword = document.getElementsByName("oldPassword")[0];
		    var newPassword = document.getElementsByName("newPassword")[0];
			if(oldPassword.value == "" || newPassword.value == ""){
				alert("密码为空");
				return false;
			}
			return true;
		}

	</script>
  </head>
  
  <body style="background-image: url('Image/officeTower.png'); background-size: cover;" >
    <img src="Image/return.png" style=" position: absolute;left: 10px;top: 10px;" height="30px" width="30px" onclick="history.back()"> <br>
  	<marquee id="title" onMouseOut="this.start()" onMouseOver="this.stop()" >修改密码界面</marquee>
    <div id="mainDiv" style="background-image: url('Image/leftPage.png'); background-size: cover;">

      <form action="changepassword" method="POST" onsubmit="return check()">
        <label class="lb">用户名</label> <input type="text" size="30" name="alias" value="<%=request.getSession().getAttribute("alias") %>" disabled="disabled"> <br>
        <label class="lb">原密码</label> <input type="password" size="30" name="oldPassword" id="oldPassword"> <br>
        <label class="lb">新密码</label> <input type="password" size="30" name="newPassword" id="newPassword"> <br>
        <p align="center"> <input type="submit" value="提交"> </p>
        <%String error = (String)request.getSession().getAttribute("errorOfChangePsd"); %>
        <%if (error != null){ %>
           <p align="center" style="color: red;"><%=error %></p>
        <%} %>
      </form>
    </div>
  </body>
</html>
