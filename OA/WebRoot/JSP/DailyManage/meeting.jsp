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
    
    <title>My JSP 'meeting.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="CSS/Manage/common.css">
	<script src="datetimepicker/datetimepicker/jquery.js"></script>
	<script src="datetimepicker/datetimepicker/build/jquery.datetimepicker.full.js"></script>
	<link rel="stylesheet" type="text/css" href="datetimepicker/datetimepicker/jquery.datetimepicker.css">
	
    <script type="text/javascript">
       function DeleteConfrim(){
          
          return confirm("确定删除此会议安排吗？");
       }
    </script>
    <script>
	  $(function(){
	     $("#time_start").datetimepicker({
	       format: 'Y-m-d 00:00:00',
         
	     });
	     $("#time_end").datetimepicker({
	       format: 'Y-m-d 00:00:00',
         
	     });
	  });
	</script>
  </head>
  
  <body id="mainBody" style="background-image: url('Image/mainBodyBg.png');background-size: cover; ">
    <%String authority = (String)request.getSession().getAttribute("authority"); %>
    <%int offset = Integer.parseInt(request.getParameter("offset")); %>
    <%int MAXNUM = 10; %>
    
    <%@page import="com.table.dailymanage.meeting.*" %>
    <%@page import="java.text.SimpleDateFormat" %>
    <%SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
    <%TbMeetingDAO dao = new TbMeetingDAO(); %>
    <%List meetingList = dao.findAll(); %>
    <%meetingList.sort(new Comparator<TbMeeting>(){
       public int compare(TbMeeting o1, TbMeeting o2) {
        return - o1.getPublishTime().compareTo(o2.getPublishTime());
        }
    }); %>
    <img src="Image/return.png" style=" position: absolute;left: 10px;top: 10px;" height="30px" width="30px" onclick="history.back()"> <br>
    <div>
     <h1 class="title">会议</h1>
    </div>
    <div class="tools">
     <s:form method="POST" action="meetingsearch">
       <label>全文搜索</label> <s:textfield name="key" size="30"></s:textfield> <s:submit value="搜索"></s:submit>
       <%if (authority != null && authority.equals("admin")){ %>
       <a href="JSP/DailyManage/meetingAdd.jsp" class="addLink">增加会议安排</a>
       <%} %>
     </s:form>
     <s:form method="POST" action="meetingtimerangesearch">
       <label>会议时间</label>
       <input type="text" id="time_start" name="time_start" size="20"> 
       <span>至</span>
       <input type="text" id="time_end" name="time_end" size="20">
       <s:submit value="搜索"></s:submit>
     </s:form>
    
    </div>
    
    <div>
    <table class="tb" border="1">
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
    
    
    <%int size = meetingList.size(); %>
    <%int group = size == 0 ? 1 : (size - 1) / 10 + 1; %>
    
    <%for (int i = offset * MAXNUM; i <Math.min((offset + 1) * MAXNUM, size) ; i++){ %>
    <%TbMeeting m = (TbMeeting)meetingList.get(i); %>
      <tr align="center">
        <td hidden="hidden"><%=m.getId() %></td>
        <td><%=m.getSubject() %></td>
        <td><%=m.getHost() %></td>
        <td><%=m.getAddress() %></td>
        <td><%=f.format( m.getTime() ) %></td>
        <td><%=m.getPublishManAlias() %></td>
        <td><%=m.getPublishManName() %></td>
        
        
        <td><%=f.format( m.getPublishTime() ) %></td>
        <td><a href="JSP/DailyManage/meetingDetail.jsp?id=<%=m.getId() %>">详情</a></td>
        
        <%if (authority != null && authority.equals("admin")){ %>
        <td>
           <a href="meetingdelete.action?id=<%=m.getId() %>" onclick="return DeleteConfrim()" class="op">删除</a>
           <a href="JSP/DailyManage/meetingUpdate.jsp?id=<%=m.getId() %>" class="op">修改</a>
        </td>
        <%} %>
        
      </tr>
      
    <%} %>
    </table>
    
    </div>
    <div class="filterPage">
    <%if (offset == 0){ %>
      <a href="javascript:return false;" id="prePageLink">[上一页]</a>
      
    <%}else{ %>
      <a href="JSP/DailyManage/meeting.jsp?offset=<%=offset-1 %>">[上一页]</a>
    <%} %> 
    <%for (int i = 0; i < group; i++){ %>
       <%if (i == offset){ %>
        <a href="JSP/DailyManage/meeting.jsp?offset=<%=i %>" id="curPageLink">[<%=i + 1 %>]</a>
       <%}else{ %>
        <a href="JSP/DailyManage/meeting.jsp?offset=<%=i %>">[<%=i + 1 %>]</a>
       <%} %>
    <%} %>
    <%if (offset == group-1){ %>
      <a href="javascript:return false;" id="nextPageLink">[下一页]</a>
    <%}else{ %>
      <a href="JSP/DailyManage/meeting.jsp?offset=<%=offset+1 %>">[下一页]</a>
    <%} %>
    </div>
    
  </body>
</html>
