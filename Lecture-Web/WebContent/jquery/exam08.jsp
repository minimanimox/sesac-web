<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
   $(document).ready(function() {
  /* h1태그를 클릭하면 글자색이 빨간색으로 변하고  
     h1에 마우스를 접근시키면 노란색으로 변경하고 
     h1에서 마우스가 벗어나면 배경을 흰색으로 변경*/

   //click에 '해줘도 되고 안해줘도 됨
     
     $('h1').on({
         //클릭이벤트가 발생하면 함수를 실행
         'click' : function() {
            $(this).css('color','red')
         },
         'mouseenter' : function() {
            $(this).css('background-color','yellow')
            
         },
         'mouseleave' : function() {
            $(this).css('background-color','white')
         }

      })
     
     /* $('h1').click(function() {
    	$(this).css('color', 'red') 
     })
     
     $('h1').mouseenter(function() {
    	 
     })
     
     $('h1').mouseleave(function() {
    	 
     }) */
   })
</script>
</head>
<body>
   

   <h1>첫번째 문장</h1>
   <h1>두번째 문장</h1>
   <div>
      <h1>세번째 문장</h1>
   </div>
   <h1>네번째 문장</h1>
   <button>클릭</button>
</body>
</html>