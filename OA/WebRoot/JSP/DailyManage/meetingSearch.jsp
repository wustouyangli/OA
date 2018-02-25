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
    
    <title>My JSP 'meetingSearch.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body id="mainBody" style="background-image: url('Image/mainBodyBg.png');background-size: cover; ">
    <%String authority = (String)request.getSession().getAttribute("authority"); %>
    <%ArrayList<Integer> idList = (ArrayList<Integer>)request.getSession().getAttribute("idList"); %>
    <%@page import="com.table.dailymanage.meeting.*" %>
    <%TbMeetingDAO dao = new TbMeetingDAO(); %>
  
    <div style="width: 100%;">
     <h1 style="text-align: center;">查询结果如下</h1>
    </div>
    
    <div style="">
    <table border="1" style="margin: auto;">
      <tr align="center">
        <td hidden="hidden">编号</td>
        <td>会议主题</td>
        <td>会议主持人</td>
        <td>会议地点</td>
        <td>会议时间</td>
        <td>发布者Alias</td>
        <td>发布者姓名</td>
        <td>发布时间</td>
        <td>会议内容</td>
        
        <%if (authority != null && authority.equals("admin")){ %>
        <td>编辑区</td>
        <%} %>
      </tr>
      
      <%for (int i = 0; i < idList.size(); i++){ %>
      <%TbMeeting m = dao.findById(idList.get(i)); %>
      <tr align="center">
        <td hidden="hidden"><%=m.getId() %></td>
        <td><%=m.getSubject() %></td>
        <td><%=m.getHost() %></td>
        <td><%=m.getAddress() %></td>
        <td><%=m.getTime() %></td>
        <td><%=m.getPublishManAlias() %></td>
        <td><%=m.getPublishManName() %></td>
        <td><%=m.getPublishTime() %></td>
        <td><a href="JSP/DailyManage/meetingDetail.jsp?id=<%=m.getId() %>">详情</a></td>
        
        <%if (authority != null && authority.equals("admin")){ %>
        <td>
           <a href="meetingdelete.action?id=<%=m.getId() %>" onclick="return DeleteConfrim()" style="color: red;">删除</a>
           <a href="JSP/DailyManage/meetingUpdate.jsp?id=<%=m.getId() %>" style="color: red;">修改</a>
        </td>
        <%} %>
        
      </tr>
      
    <%} %>
    </table>
    </div>
  </body>
</html>
