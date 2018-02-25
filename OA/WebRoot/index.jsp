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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./CSS/Login/index.css">
	<script src="JS/jquery-1.7.1.js"></script>
	<script >
	   function check()
		{
			var alias = document.getElementsByName("alias")[0];
            var password = document.getElementsByName("password")[0];
            var checkCode = document.getElementsByName("checkCode")[0];
            if(alias.value == "" || password.value == ""){
               alert("用户名或密码为空");
            }
            else if (checkCode.value == ""){
               alert("验证码为空");
            }
            
			return true;
		}
	</script>
  </head>
  <body style="background-image: url('Image/officeTower.png'); background-size: cover;" >
  <marquee id="title" onMouseOut="this.start()" onMouseOver="this.stop()" >登陆界面</marquee>
  <div id="mainDiv" style="background-image: url('Image/leftPage.png'); background-size: cover;" >
  <form action="login" onsubmit="return check()" method="POST">
       
       <label class="lb">用户名</label> <input type="text" name="alias" size="30" > <br>
       <label class="lb">密码</label> <input type="password" name="password" size="30"  id="password" > <br>
       <label class="lb">验证码</label> <input type="text" size="10" name="checkCode"> <img alt="" src="checkcode" style="position:relative; top: 18px;"> <br> 
       <p align="center"><input type="submit" value="提交"> </p> 
       <%if (request.getSession().getAttribute("error") != null){ %>
       <p align="center" class="error"><%=request.getSession().getAttribute("error") %></p>
       <%} %>
    </form>
    </div>
  </body>
</html>
