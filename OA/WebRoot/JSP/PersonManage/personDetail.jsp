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
    
    <title>My JSP 'personDetail.jsp' starting page</title>
    
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
      .mainDiv{ margin-left: 100px; margin-top: 20px; }
      .txt{ color: black; font-size: 18px; background-color: white;}
    </style>
    
  </head>
  
  <body style="background-image: url('Image/mainBodyBg.png');background-size: cover; ">
  <img src="Image/return.png" style=" position: absolute;left: 10px;top: 10px;" height="30px" width="30px" onclick="history.back()"> <br>
    <%@page import="com.table.personmanage.user.*" %>
    <%@page import="java.text.SimpleDateFormat" %>
    <%SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd"); %>
    <%TbUserDAO dao = new TbUserDAO(); %>
    <%TbUser m = dao.findById(Integer.parseInt(request.getParameter("id"))); %>
    <%if (m != null){ %> 
    <div class="mainDiv">
    <input type="text" name="id" hidden="hidden" value="<%=m.getId() %>"> <br>
    <label class="lb">Alias</label><input type="text" name="alias" class="txt" disabled="true" size="50" value="<%=m.getAlias() %>"> <br>
    <label class="lb">姓名</label><input type="text" name="name" class="txt" disabled="true" size="50" value="<%=m.getName() %>"> <br>
    <label class="lb">权限</label><input type="text" name="authority" class="txt" disabled="true" size="50" value="<%=m.getAuthority() %>"> <br>
    <label class="lb">性别</label><input type="text" name="sex" class="txt" disabled="true" size="50" value="<%=m.getSex() %>"> <br>
    <label class="lb">出生日期</label><input type="text" name="birthday" class="txt" disabled="true" size="50" value="<%=f.format( m.getBirthday() ) %>"> <br>
    <label class="lb">部门</label><input type="text" name="department" class="txt" disabled="true" size="50" value="<%=m.getDepartment() %>"> <br>
    <label class="lb">职位</label><input type="text" name="job" class="txt" disabled="true" size="50" value="<%=m.getJob() %>"> <br>
    <label class="lb">Email</label><input type="text" name="email" class="txt" disabled="true" size="50" value="<%=m.getEmail() %>"> <br>
    <label class="lb">办公电话</label><input type="text" name="officeTel" class="txt" disabled="true" size="50" value="<%=m.getOfficeTel() %>"> <br>
    <label class="lb">移动电话</label><input type="text" name="tel" class="txt" disabled="true" size="50" value="<%=m.getTel() %>"> <br>
    <label class="lb">家庭电话</label><input type="text" name="familytel" class="txt" disabled="true" size="50" value="<%=m.getFamilyTel() %>"> <br>
    <label class="lb">家庭住址</label><input type="text" name="address" class="txt" disabled="true" size="50" value="<%=m.getAddress() %>"> <br>
    <label class="lb">级别</label><input type="text" name="bestEmployee" class="txt" disabled="true" size="50" value="<%=m.getBestEmployee() %>"> <br>
    </div>
    <%} %> 
  </body>
</html>
