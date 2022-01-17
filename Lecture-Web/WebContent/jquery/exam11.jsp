<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   h1 {
      display: none
   }
</style>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
   $(document).ready(function() {
      
      /*
         3초에 걸려서 Hello World 문장이 화면에 보인  뒤, complete 메세지를 경고창에 띄우기
      */
   //   $('h1').show(3000)
   //   alert('complete...')
      /* $('h1').show(3000, function() {
         alert('complete...')
      }) */
   
   
   //3초에 걸려서 Hello World 문장이 화면에 보인  뒤, 글자색  파란색 -> 슬라이드 효과 ->배경색 노란색
   
   $('h1').show(3000, function() {
         $(this).css('color','blue')
         $(this).slideUp('slow').slideDown('slow',function(){
            
            $(this).css('background-color','yellow')
         })
         
      })
   
   })
   
</script>
</head>
<body>
   <h1>Hello World</h1>
</body>
</html>


