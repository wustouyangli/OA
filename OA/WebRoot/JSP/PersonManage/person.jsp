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
    
    <title>My JSP 'person.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   	<link rel="stylesheet" type="text/css" href="CSS/Manage/common.css">
   
  </head>
  
  <body id="mainBody" style="background-image: url('Image/mainBodyBg.png');background-size: cover; ">
  <img src="Image/return.png" style=" position: absolute;left: 10px;top: 10px;" height="30px" width="30px" onclick="history.back()"> <br>
  
    <%String authority = (String)request.getSession().getAttribute("authority"); %>
    <%int offset = Integer.parseInt(request.getParameter("offset")); %>
    <%int MAXNUM = 10; %>
  
    <%@page import="com.table.personmanage.user.*" %>
    <%TbUserDAO dao = new TbUserDAO(); %>
    <%List userList = dao.findAll(); %>
    
    <div>
     <h1 class="title">员工信息表</h1>
    </div>
    
    <div class="tools">
     <s:form method="POST" action="personsearch">
       <label>全文搜索</label> <s:textfield name="key" size="30"></s:textfield> <s:submit value="搜索"></s:submit> <br>
     </s:form>
    </div>
    
    <div >
    <table border="1" class="tb">
       <tr align="center" >
        <td hidden="hidden">编号</td>
        <td>Alias</td>
        <td>姓名</td>
        <td>性别</td>
        <td>部门</td>
        <td>职位</td>
        <td>级别</td>
        <td>完整信息</td>
     
      </tr>
    <%int size = userList.size(); %>
    <%int group = size == 0 ? 1 : (size - 1) / 10 + 1; %>
    
    <%for (int i = offset * MAXNUM; i <Math.min((offset + 1) * MAXNUM, size) ; i++){ %>
    <%TbUser m = (TbUser)userList.get(i); %>
      <tr align="center">
        <td hidden="hidden"><%=m.getId() %></td>
        <td><%=m.getAlias() %></td>
        <td><%=m.getName() %></td>
        <td><%=m.getSex() %></td>
        <td><%=m.getDepartment() %></td>
        <td><%=m.getJob() %></td>
        <td><%=m.getBestEmployee() %></td>
        <td><a href="JSP/PersonManage/personDetail.jsp?id=<%=m.getId() %>">详情</a></td>
        
      </tr>
    <%} %>
    </table>
    </div>
    
    <div class="filterPage">
    <%if (offset == 0){ %>
      <a href="javascript:return false;" id="prePageLink">[上一页]</a>
      
    <%}else{ %>
      <a href="JSP/PersonManage/person.jsp?offset=<%=offset-1 %>">[上一页]</a>
    <%} %> 
    <%for (int i = 0; i < group; i++){ %>
       <%if (i == offset){ %>
        <a href="JSP/PersonManage/person.jsp?offset=<%=i %>" id="curPageLink">[<%=i + 1 %>]</a>
       <%}else{ %>
        <a href="JSP/PersonManage/person.jsp?offset=<%=i %>">[<%=i + 1 %>]</a>
       <%} %>
    <%} %>
    <%if (offset == group-1){ %>
      <a href="javascript:return false;" id="nextPageLink">[下一页]</a>
    <%}else{ %>
      <a href="JSP/PersonManage/person.jsp?offset=<%=offset+1 %>">[下一页]</a>
    <%} %>
    </div>
    
  </body>
</html>
