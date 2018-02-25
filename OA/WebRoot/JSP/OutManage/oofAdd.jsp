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
    
    <title>My JSP 'oofAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="datetimepicker/datetimepicker/jquery.js"></script>
	<script src="datetimepicker/datetimepicker/build/jquery.datetimepicker.full.js"></script>
	<link rel="stylesheet" type="text/css" href="datetimepicker/datetimepicker/jquery.datetimepicker.css">
	
	<script>
	  $(function(){
	     $("#leaveTime").datetimepicker({
	       format: 'Y-m-d H:i:00',
	       step: 15,
         
	     });
	     $("#returnTime").datetimepicker({
	       format: 'Y-m-d H:i:00',
	       step: 15,
         
	     });
	  });
	</script>
	
	<style type="text/css">
      #mainBody{ margin-left: 100px;}
      .lb{width: 100px; display: inline-block;}
      .txt{ font-size: 18px;}
    </style>
	
    <script type="text/javascript">
      function Confirm(){
         var leaveTime = document.getElementsByName("leaveTime")[0];
         var returnTime = document.getElementsByName("returnTime")[0];
         var content = document.getElementsByName("content")[0];
         if (leaveTime.value == "" ||
             returnTime.value == "" ||
             content.value == ""){
             alert("内容不完整");
             return false;
         }
         
         return confirm("确定提交新的出差登记吗？");
      }
    </script>

  </head>
  
  <body id="mainBody" style="background-image: url('Image/mainBodyBg.png');background-size: cover; ">
    <s:form action="oofadd" onsubmit="return Confirm()" method="POST">
      <input type="text" name="id" hidden="hidden"> <br>
      <label class="lb">离开时间</label><input type="text" id="leaveTime" name="leaveTime" class="txt" size="30"> <br>
      <label class="lb">预计归来时间</label><input type="text" id="returnTime" name="returnTime" class="txt" size="30"> <br>
      <label class="lb" style="vetial-algin: top; float:left;">出差原因</label>
      <textarea  name="content" rows="5" cols="80" class="txt" ></textarea> <br>
      
      <s:submit value="提交" ></s:submit>
    </s:form>
  </body>
</html>
