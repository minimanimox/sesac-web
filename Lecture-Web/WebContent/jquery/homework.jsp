<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

		
	p {
      width: 100px;
      height: 100px;
      padding : 2%;
      float : left;
	
	}
	#mon {
		background-color: red;
		
	}
	
	#tue {
		background-color: orange;
		
	}	
	
	#wed {
		background-color: yellow;
		
	}
	#thu {
		background-color: green;
		
	}
	#fri {
		color: white;
		background-color: blue;
		
	}
	#sat {
		color: white;
		background-color: navy;
		
	}
	#sun {
		color: white;
		background-color: purple;
		
	}	
</style>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function() {
		$('#mon').hover(function() {
			$(this).mouseenter({
				'width': '200%',
				'height' : '200%'
			})
						
			$('#m').text('월요일')
			
		}) 
		
		
		
		$('#wed').mouseenter(function() {
			$('#wed').animate({
				'width': '200px',
				'height' : '200px'
			})
			
			$('#w').text('수요일')
			
		}) 
		
		$('#thu').mouseenter(function() {
			$(this).animate({
				'width': '200px',
				'height' : '200px'
			})
			
			$('#th').text('목요일')
		
		})
		
		$('#fri').mouseenter(function() {
			$(this).animate({
				'width': '200px',
				'height' : '200px'
			}, function() {
				$('#fri').mouseleave(function() {
					'width': '100px',
					'height' : '100px'
				}))
			}, function() {
				$('#f').text('금요일')
				
			})
			
		}) 
		
		$('#sat').mouseenter(function() {
			$(this).animate({
				'width': '200px',
				'height' : '200px'
			})
			
			$('#s').text('토요일')
			
		}) 
		
		$('#sun').mouseenter(function() {
			$(this).animate({
				'width': '200px',
				'height' : '200px'
			})
			
			$('#su').text('일요일')
			
		}) 
	}) 
	
</script>
</head>
<body>
<div class="wrapper">
	<p id="mon" align="center"><span id= "m">월</span></p>
	<p id="tue" align="center"><span id= "t">화</span></p>
	<p id="wed" align="center"><span id= "w">수</span></p>
	<p id="thu" align="center"><span id= "th">목</span></p>
	<p id="fri" align="center"><span id= "f">금</span></p>
	<p id="sat" align="center"><span id= "s">토</span></p>
	<p id="sun" align="center"><span id= "su">일</span></p>
</div>
</body>
</html>