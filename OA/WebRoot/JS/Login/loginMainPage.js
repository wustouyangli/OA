
$(function(){
	var iNow=0;
     
    function run(n) {
 
     var oDate = new Date(); //����ʱ��
     oDate.setMonth(oDate.getMonth()+n);//�����·�
     var year = oDate.getFullYear(); //��
     var month = oDate.getMonth(); //��
     var today = oDate.getDate(); //��
 
     //���㱾���ж�����
     var allDay = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][month];
 
     //�ж�����
     if(month == 1) {
      if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
       allDay = 29;
      }
     }
 
     //�жϱ��µ�һ�������ڼ�
     oDate.setDate(1); //ʱ����������µ�һ��
     var week = oDate.getDay(); //��ȡ���µ�һ�������ڼ�
 
     //console.log(week);
     $(".dateList").empty();//ÿ�����
     //����հ�
 
     for(var i = 0; i < week; i++) {
      $(".dateList").append("<li></li>");
     }
 
     //���ڲ��뵽dateList
     for(var i = 1; i <= allDay; i++) {
      $(".dateList").append("<li>" + i + "</li>")
     }
     //�����ɫ=====================
     $(".dateList li").each(function(i, elm){
      //console.log(index,elm);
      var val = $(this).text();
      //console.log(val);
      if (n==0) {
       if(val<today){
       $(this).addClass('ccc')
      }else if(val==today){
       $(this).addClass('red')
      }else if(i%7==0 || i%7==6 ){
       $(this).addClass('sun')
      }
      }else if(n<0){
       $(this).addClass('ccc')
      }else if(i%7==0 || i%7==6 ){
       $(this).addClass('sun')
      }
     });
 
     //�����������
     $("#calendar h4").text(year + "��" + (month + 1) + "��");
    };
    run(0);
     
    $(".a1").click(function(){
     iNow--;
     run(iNow);
    });
     
    $(".a2").click(function(){
     iNow++;
     run(iNow);
    })
    $(".smallImg").click(function(){
    	var src = $(this).attr('src');
    	$('#mainbody').css("background-image","url(" + src + ")");
    });
});