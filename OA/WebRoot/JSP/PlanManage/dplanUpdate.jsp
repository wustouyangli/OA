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
    
    <title>My JSP 'dplanUpdate.jsp' starting page</title>
    
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
      .txt{ font-size: 18px;}
      .ckeDiv{ width: 80%;}
    </style>
	
    <script type="text/javascript">
      function Confirm(){
         var subject = document.getElementsByName("subject")[0];
         var department = document.getElementsByName("department")[0];
         var content = document.getElementsByName("content")[0];
         if (subject.value == "" ||
             department.value == "" ||
             content.value == ""){
             alert("内容不完整(上传文件可选)");
             return false;
         }
         return confirm("确定提交修改后的部门计划吗？");
      }
    </script>
    
  </head>
  
  <body id="mainBody" style="background-image: url('Image/mainBodyBg.png');background-size: cover; ">
    <%@page import="com.table.planmanage.departmentplan.*" %>
    <%TbDepartmentPlanDAO dao = new TbDepartmentPlanDAO(); %>
    <%TbDepartmentPlan m = dao.findById(Integer.parseInt(request.getParameter("id"))); %>
    <%if (m != null){ %>
   
    <form action="dplanupdate" onsubmit="return Confirm()" enctype="multipart/form-data" method="POST">
      <input type="text" name="id" hidden="hidden" value="<%=m.getId() %>"> <br>
      <label class="lb">计划主题</label><input type="text" name="subject" class="txt" size="30" value="<%=m.getSubject()%>"> <br>
      <label class="lb">部门</label><input type="text" name="department" class="txt" size="30" value="<%=m.getDepartment() %> "><br>
      <label class="lb" style="vetial-algin: top; float:left;">计划内容</label> <br>
      <%-- <textarea  name="content" rows="5" cols="80" ><%=m.getContent()%></textarea> <br> --%>
      <script type="text/javascript" src="CKEditor/ckeditor/ckeditor.js" ></script>
      <div class="ckeDiv">
       <textarea rows="10" cols="20" class="ckeditor" name="content"><%=m.getContent() %></textarea>
      </div>
      <label class="lb">附件</label><input type="file" name="file"> <br>
      <input type="submit" value="提交"> <br>
    </form>
    <%} %>
  </body>
</html>
