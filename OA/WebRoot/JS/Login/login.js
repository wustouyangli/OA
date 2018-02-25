$(function(){
	$(".menuItem").click(function(){

	    $(this).parent().children("ul").toggle();
	    if ($(this).children(".showtag").attr("src") == "Image/show.png"){
	        $(this).children(".showtag").attr("src", "Image/hide.png");
	        
	    }
	    else{
	    	$(this).children(".showtag").attr("src", "Image/show.png");
	    }
	});
	$("#homeLink").click(function(){
		$("#mainPage").attr("src", "JSP/Login/loginMainPage.jsp");
	});

	$("#meeting").click(function(){
		$("#mainPage").attr("src", "JSP/DailyManage/meeting.jsp?offset=0");
	});

	$("#notice").click(function(){
		$("#mainPage").attr("src", "JSP/DailyManage/notice.jsp?offset=0");
	});

	$("#oof").click(function(){
		$("#mainPage").attr("src", "JSP/OutManage/oof.jsp?offset=0");
	});

	$("#takeoff").click(function(){
		$("#mainPage").attr("src", "JSP/OutManage/takeoff.jsp?offset=0");
	});

	$("#eplan").click(function(){
		$("#mainPage").attr("src", "JSP/PlanManage/eplan.jsp?offset=0");
	});

	$("#dplan").click(function(){
		$("#mainPage").attr("src", "JSP/PlanManage/dplan.jsp?offset=0");
	});

	$("#person").click(function(){
		$("#mainPage").attr("src", "JSP/PersonManage/person.jsp?offset=0");
	});
	
	$("#oofAudit").click(function(){
		$("#mainPage").attr("src", "JSP/AuditManage/oofAudit.jsp?offset=0");
	});
	
	$("#takeoffAudit").click(function(){
		$("#mainPage").attr("src", "JSP/AuditManage/takeoffAudit.jsp?offset=0");
	});
	
});