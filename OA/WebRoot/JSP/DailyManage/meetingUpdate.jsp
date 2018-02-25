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
    
    <title>My JSP 'meetingUpdate.jsp' starting page</title>
    
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
	     $("#time").datetimepicker({
	       format: 'Y-m-d H:i:00',
	       step: 15,
         
	     });
	  });
	</script>
	
	<style type="text/css">
      #mainBody{ margin-left: 100px;}
      .lb{width: 100px; display: inline-block;}
      .txt{ font-size: 18px;}
      .ckeDiv{ width: 80%;}
    </style>
	
    <script type="text/javascript">
      function Confirm(){
         var subject = document.getElementsByName("subject")[0];
         var host = document.getElementsByName("host")[0];
         var address = document.getElementsByName("address")[0];
         var time = document.getElementsByName("time")[0];
         var content = document.getElementsByName("content")[0];
         if (subject.value == "" || 
             host.value == "" || 
             address.value == "" || 
             time.value =="" || 
             content.value == ""){
             alert("内容不完整");
             return false;
         }
         return confirm("确定提交修改后的会议安排吗？");
      }
    </script>
  </head>
  
  <body id="mainBody" style="background-image: url('Image/mainBodyBg.png');background-size: cover; ">
    <%@page import="com.table.dailymanage.meeting.*" %>
    <%@page import="java.text.SimpleDateFormat" %>
    <%SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); %>
    <%TbMeetingDAO dao = new TbMeetingDAO(); %>
    <%TbMeeting m = dao.findById(Integer.parseInt(request.getParameter("id"))); %>
    <%if (m != null){ %>
   
    <s:form action="meetingupdate" onsubmit="return Confirm()" method="POST">
      <input type="text" name="id" hidden="hidden" value="<%=m.getId() %>"> <br>
      <label class="lb">会议主题</label><input type="text" name="subject" class="txt" size="30" value="<%=m.getSubject()%>"> 
      <label class="lb">会议主持</label><input type="text" name="host" class="txt" size="30" value="<%=m.getHost()%>" > <br>
      <label class="lb">会议地点</label><input type="text" name="address" class="txt" size="30" value="<%=m.getAddress() %>"> 
      <label class="lb">会议时间</label><input type="text" id="time" name="time" class="txt" size="30" value="<%=f.format( m.getTime() ) %>"> <br>
      
      <label class="lb" style="vetial-algin: top; float:left;">会议内容</label> <br>
      <%-- <textarea  name="content" rows="5" cols="80" ><%=m.getContent()%></textarea> <br> --%>
      <script type="text/javascript" src="CKEditor/ckeditor/ckeditor.js" ></script>
      <div class="ckeDiv">
       <textarea rows="10" cols="20" class="ckeditor" name="content"><%=m.getContent() %></textarea>
      </div>
      <s:submit value="提交" ></s:submit>
    </s:form>
    <%} %>
  </body>
</html>
