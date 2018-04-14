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
    
    <title>My JSP 'oof.jsp' starting page</title>
    
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
    <%int offset = Integer.parseInt(request.getParameter("offset")); %>
    <%int MAXNUM = 10; %>
   
    <%@page import="com.table.outmanage.oof.*" %>
    <%@page import="java.text.SimpleDateFormat" %>
    <%SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
    <%TbOofDAO dao = new TbOofDAO(); %>
    <%String alias = (String)request.getSession().getAttribute("alias"); %>
    <%List oofList = dao.findByAlias(alias); %>
    <%oofList.sort(new Comparator<TbOof>(){
       public int compare(TbOof o1, TbOof o2) {
        return - o1.getPublishTime().compareTo(o2.getPublishTime());
        }
    }); %>
    
    <div>
     <h1 class="title">出差</h1>
    </div>
    
    <div class="tools">
     <s:form method="POST" action="oofsearch">
       <s:textfield name="key" size="30"></s:textfield> <s:submit value="搜索"></s:submit> 
       <a href="JSP/OutManage/oofAdd.jsp" class="addLink">增加出差登记</a>
     </s:form>
    </div>
    
    <div>
    <table border="1" class="tb">
       <tr align="center">
        <td hidden="hidden">编号</td>
        <td>出差登记人Alias</td>
        <td>出差登记人姓名</td>
        <td>部门</td>
        <td>出差原因</td>
        <td>登记时间</td>
        <td>离开时间</td>
        <td>预计归来时间</td>
        <td>审核状态</td>
      </tr>
      
    <%int size = oofList.size(); %>
    <%int group = size == 0 ? 1 : (size - 1) / 10 + 1; %>
    
    <%for (int i = offset * MAXNUM; i <Math.min((offset + 1) * MAXNUM, size) ; i++){ %>
    <%TbOof m = (TbOof)oofList.get(i); %>
      <tr align="center">
        <td hidden="hidden"><%=m.getId() %></td>
        <td><%=m.getAlias() %></td>
        <td><%=m.getName() %></td>
        <td><%=m.getDepartment() %></td>
        <td><%=m.getContent() %></td>
        <td><%=f.format( m.getPublishTime() ) %></td>
        <td><%=f.format( m.getLeaveTime() ) %></td>
        <td><%=f.format( m.getReturnTime() ) %></td>
        <%if (m.getState().equals("未审核")){%>
        <td style="color: blue;"><%=m.getState() %></td>
        <%}else if (m.getState().equals("已批准")){ %>
        <td style="color: green;"><%=m.getState() %></td>
        <%}else{ %>
        <td style="color: grey;"><%=m.getState() %></td>
        <%} %>
      </tr>
    <%} %>
    </table>
    </div>
    
    <div class="filterPage">
    <%if (offset == 0){ %>
      <a href="javascript:return false;" id="prePageLink">[上一页]</a>
      
    <%}else{ %>
      <a href="JSP/OutManage/oof.jsp?offset=<%=offset-1 %>">[上一页]</a>
    <%} %> 
    <%for (int i = 0; i < group; i++){ %>
       <%if (i == offset){ %>
        <a href="JSP/OutManage/oof.jsp?offset=<%=i %>" id="curPageLink">[<%=i + 1 %>]</a>
       <%}else{ %>
        <a href="JSP/OutManage/oof.jsp?offset=<%=i %>">[<%=i + 1 %>]</a>
       <%} %>
    <%} %>
    <%if (offset == group-1){ %>
      <a href="javascript:return false;" id="nextPageLink">[下一页]</a>
    <%}else{ %>
      <a href="JSP/OutManage/oof.jsp?offset=<%=offset+1 %>">[下一页]</a>
    <%} %>
    </div>
    
  </body>
</html>
