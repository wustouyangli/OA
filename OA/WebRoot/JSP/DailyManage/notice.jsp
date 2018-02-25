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
    
    <title>My JSP 'notice.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="CSS/Manage/common.css">
    <script type="text/javascript">
       function DeleteConfrim(){
          return confirm("确定删除此公告通知吗？");
       }
    </script>

  </head>
  
  <body id="mainBody" style="background-image: url('Image/mainBodyBg.png');background-size: cover; ">
    <%String authority = (String)request.getSession().getAttribute("authority"); %>
    <%int offset = Integer.parseInt(request.getParameter("offset")); %>
    <%int MAXNUM = 10; %>
    
    <%@ page import="com.table.dailymanage.notice.*" %>
    <%@page import="java.text.SimpleDateFormat" %>
    <%SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
    <% TbNoticeDAO dao = new TbNoticeDAO(); %>
    <% List noticeList = dao.findAll(); %>
    <%noticeList.sort(new Comparator<TbNotice>(){
       public int compare(TbNotice o1, TbNotice o2) {
        return - o1.getPublishTime().compareTo(o2.getPublishTime());
        }
    }); %>
    
    <div>
      <h1 class="title">公告</h1>
    </div>
    
    <div class="tools">
     <s:form method="POST" action="noticesearch">
       <s:textfield name="key" size="30"></s:textfield> <s:submit value="搜索"></s:submit> 
       <%if (authority != null && authority.equals("admin")){ %>
       <a href="JSP/DailyManage/noticeAdd.jsp" class="addLink">增加公告通知</a>
    <%} %>
     </s:form>
    </div>
    
    <div>
    <table border="1" class="tb">
       <tr align="center">
        <td hidden="hidden">编号</td>
        <td>公告主题</td>
        <td>发布者Alias</td>
        <td>发布者姓名</td>
        <td>发布时间</td>
        <td>公告内容</td>
        
        <%if (authority != null && authority.equals("admin")){ %>
        <td>编辑区</td>
        <%} %>
        
      </tr>
      
      <%int size = noticeList.size(); %>
      <%int group = size == 0 ? 1 : (size - 1) / 10 + 1; %>
      <% for (int i = offset * MAXNUM; i <Math.min((offset + 1) * MAXNUM, size) ; i++){  %>
      <% TbNotice m = (TbNotice)noticeList.get(i); %>
      <tr align="center">
        <td hidden="hidden"><%=m.getId() %></td>
        <td><%=m.getSubject() %></td>
        <td><%=m.getPublishManAlias() %></td>
        <td><%=m.getPublishManName() %></td>
        <td><%=f.format( m.getPublishTime() ) %></td>
        <td><a href="JSP/DailyManage/noticeDetail.jsp?id=<%=m.getId() %>">详情</a></td>
        
        <%if (authority != null && authority.equals("admin")){ %>
        <td>
           <a href="noticedelete.action?id=<%=m.getId() %>" onclick="return DeleteConfrim()" class="op">删除</a> 
           <a href="JSP/DailyManage/noticeUpdate.jsp?id=<%=m.getId() %>" class="op">修改</a>
        </td>
        <%} %>
        
      </tr>
      <% } %>
      </table>
      </div>
      
    <div class="filterPage">
    <%if (offset == 0){ %>
      <a href="javascript:return false;" id="prePageLink">[上一页]</a>
      
    <%}else{ %>
      <a href="JSP/DailyManage/notice.jsp?offset=<%=offset-1 %>">[上一页]</a>
    <%} %> 
    <%for (int i = 0; i < group; i++){ %>
       <%if (i == offset){ %>
        <a href="JSP/DailyManage/notice.jsp?offset=<%=i %>" id="curPageLink">[<%=i + 1 %>]</a>
       <%}else{ %>
        <a href="JSP/DailyManage/notice.jsp?offset=<%=i %>">[<%=i + 1 %>]</a>
       <%} %>
    <%} %>
    <%if (offset == group-1){ %>
      <a href="javascript:return false;" id="nextPageLink">[下一页]</a>
    <%}else{ %>
      <a href="JSP/DailyManage/notice.jsp?offset=<%=offset+1 %>">[下一页]</a>
    <%} %>
    </div>
    
  </body>
</html>
