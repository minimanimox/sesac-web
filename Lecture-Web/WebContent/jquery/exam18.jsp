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
		$('#btn01').click(function() {
			/*
			let h1Tag = document.createElement('h1')
			let text = document. createTextNode('세번째 문장')
			h1Tag.appendChild(text)
			//console.log(h1Tag)
			//document.getElementsByTagName("div")[0]
			document.querySelector('div').appendChild(h1Tag) //많아도 맨처음 나온애만 뽑기때문에 따로 지정 필요 없어짐
			
			
			*/
			
			$('div').append('<h1>세번째 문장</h1>')
			
			})
			$('#btn02').click(function() {
				//$('ol').append('<li>노랑</li>')   //마지막
				$('ol').prepend('<li>노랑</li>')    //맨위
		})
		
	})
	
		$(document).ready(function() {
			$('#btn03').click(function() {
				//$('body').prepend('<h4>추가된 문장</h4>')
				//$('body').prepend('<h3>또 추가된 문장</h3>')
				//$('body').prepend('<h6>또 또 추가된 문장</h6>') //순서가 가장 먼저
				$('body').prepend('<h4>추가된 문장</h4>', '<h3>또 추가된 문장</h3>', '<h6>또 또 추가된 문장</h6>')
				//순서가 반대가 됨
			})
		})
	
</script>
</head>
<body>
	<div>
		<h1>첫번째 문장</h1>
		<h1>두번째 문장</h1>
		
	</div>
		<h2>색상표</h2>
		<ol> <!-- 순서를 가진 리스트 1.2.3.-->
			<li>빨강</li>
			<li>파랑</li>
			<li>초록</li>
		</ol>
	<button id="btn01">문장추가</button>
	<button id="btn02">색상추가</button>
	<button id="btn03">본문추가</button>
</body>
</html>