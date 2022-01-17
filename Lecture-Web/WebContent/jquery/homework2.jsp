<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   div {
      width: 100px;
      height: 100px;
      padding : 2%;
      float : left;
      
      
   }
   h1{
   display:none;
   
   }
   
   #mon{
   background-color: red;
   }
   
   #tue{
   background-color: orange;
   }
   
   #wed{
   background-color: yellow;
   }
   
   #thu{
   background-color: green;
   }
   
   #fri{
   background-color: blue;
   }
   
   #sat{
   background-color: navy;
   }
   
   #sun{
   background-color: purple;
   }
   
</style>

<script src="js/jquery-3.6.0.min.js"></script>
<script>
   $(document).ready(function() {
      $('#mon').hover(function(){
         $(this).slideToggle(1000)
         $('h2').hide(1000)
      },function(){
         
         $('#mon').slideToggle(1000)   
         
      })
      
      
   })
   </script>
</head>
<body>
   <div id="mon" align="center">
   <h1>월</h1>
   <h2>월요일</h2>
   </div>
   
   <div id="tue" align="center">
   <h1>화</h1>
   </div>
   
   <div id="wed" align="center">
   <h1>수</h1>
   </div>
   
   <div id="thu" align="center">
   <h1>목</h1>
   </div>
   
   <div id="fri" align="center">
   <h1>금</h1>
   </div>
   
   <div id="sat" align="center">
   <h1>토</h1>
   </div>
   
   <div id="sun" align="center">
   <h1>일</h1>
   </div>
   
</body>
</html>