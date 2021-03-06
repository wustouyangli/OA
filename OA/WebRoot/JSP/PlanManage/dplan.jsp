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
    
    <title>My JSP 'dplan.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	
    <meta http-equiv="Cache" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="CSS/Manage/common.css">
    <script type="text/javascript">
       function DeleteConfirm(){
          return confirm("确定删除此部门计划吗？");
       }
    </script>

  </head>
  
  <body id="mainBody" style="background-image: url('Image/mainBodyBg.png');background-size: cover; ">
  
    <%String authority = (String)request.getSession().getAttribute("authority"); %>
    <%int offset = Integer.parseInt(request.getParameter("offset")); %>
    <%int MAXNUM = 10; %>
     
    <%@page import="com.table.planmanage.departmentplan.*" %>
    <%@page import="java.text.SimpleDateFormat" %>
    <%SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
    <%TbDepartmentPlanDAO dao = new TbDepartmentPlanDAO(); %>
    <%List dplanList = dao.findAll(); %>
    <%dplanList.sort(new Comparator<TbDepartmentPlan>(){
       public int compare(TbDepartmentPlan o1, TbDepartmentPlan o2) {
        return - o1.getTime().compareTo(o2.getTime());
        }
    }); %>
    
    <div>
     <h1 class="title">部门计划</h1>
    </div>
    
    <div class="tools">
     <s:form method="POST" action="dplansearch">
       <s:textfield name="key" size="30"></s:textfield> <s:submit value="搜索"></s:submit> 
       <%if (authority != null && authority.equals("admin")){ %>
        <a href="JSP/PlanManage/dplanAdd.jsp" class="addLink">增加部门计划</a>
       <%} %>
     </s:form>
    </div>
   
    <div>
    <table border="1" class="tb">
       <tr align="center">
        <td hidden="hidden">编号</td>
        <td>计划主题</td>
        <td>部门</td>
        <td>发布人Alias</td>
        <td>发布人姓名</td>
        <td>发布时间</td>
        <td>计划内容</td>
        
        <%if (authority != null && authority.equals("admin")){ %>
        <td>编辑区</td>
        <%} %>
        
      </tr>
    <%int size = dplanList.size(); %>
    <%int group = size == 0 ? 1 : (size - 1) / 10 + 1; %>
    
    <%for (int i = offset * MAXNUM; i <Math.min((offset + 1) * MAXNUM, size) ; i++){ %>
    <%TbDepartmentPlan m = (TbDepartmentPlan)dplanList.get(i); %>
      <tr align="center">
        <td hidden="hidden"><%=m.getId() %></td>
        <td><%=m.getSubject() %></td>
        <td><%=m.getDepartment() %></td>
        <td><%=m.getPublishManAlias() %></td>
        <td><%=m.getPublishManName() %></td>
        <td><%=f.format( m.getTime() ) %></td>
        <td><a href="JSP/PlanManage/dplanDetail.jsp?id=<%=m.getId() %>">详情</a></td>
        
        <%if (authority != null && authority.equals("admin")){ %>
        <td>
           <a href="dplandelete.action?id=<%=m.getId() %>" onclick="return DeleteConfirm()" class="op">删除</a> 
           <a href="JSP/PlanManage/dplanUpdate.jsp?id=<%=m.getId() %>" class="op">修改</a></td>
        <%} %>
        
      </tr>
    <%} %>
    </table>
    </div>
    
    <div class="filterPage">
    <%if (offset == 0){ %>
      <a href="javascript:return false;" id="prePageLink">[上一页]</a>
      
    <%}else{ %>
      <a href="JSP/PlanManage/dplan.jsp?offset=<%=offset-1 %>">[上一页]</a>
    <%} %> 
    <%for (int i = 0; i < group; i++){ %>
       <%if (i == offset){ %>
        <a href="JSP/PlanManage/dplan.jsp?offset=<%=i %>" id="curPageLink">[<%=i + 1 %>]</a>
       <%}else{ %>
        <a href="JSP/PlanManage/dplan.jsp?offset=<%=i %>">[<%=i + 1 %>]</a>
       <%} %>
    <%} %>
    <%if (offset == group-1){ %>
      <a href="javascript:return false;" id="nextPageLink">[下一页]</a>
    <%}else{ %>
      <a href="JSP/PlanManage/dplan.jsp?offset=<%=offset+1 %>">[下一页]</a>
    <%} %>
    </div>
    
  </body>
</html>
