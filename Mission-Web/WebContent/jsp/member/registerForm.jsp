<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<style>
  
  document.write(str.fontsize(9))

	hr, table {
		width: 60%
		

	}
	th {
		width: 30%
	}
</style>
<script>
	function doRegister() {
		let form = document.inputForm
		
		if (form.id.value == '') {
			alert('id를 입력하세요')
			form.id.focus()
			return false
		}
		
		if (form.name.value == '') {
			alert('이름을 입력하세요')
			form.name.focus()
			return false
		}
			
		if (form.password.value =='') {
			alert('비밀번호를 입력하세요')
			form.password.focus()
			return false
		}
		return true
	}
</script>
</head>
<body>
	<div align="center">
		<hr>
		<h2>회원가입</h2>
		<hr>
		<br>
		<form action="regist.jsp" method="post" name="inputForm"
			onsubmit="return doRegist()">
			<table border="1">
				<tr>
					<th>id 입력</th>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<th>이름 입력</th>
					<td><input type="text" name="name"></td>
				</tr>
			    <tr>
					<th>password 입력</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<th>email id입력</th>
					<td><input type="text" name="email_id"></td>
				</tr>
				<tr>
					<th>email domain입력</th>
					<td><input type="text" name="email_domain"></td>
				</tr>
				<tr>
					<th>휴대폰번호 앞자리 입력(010~019)</th>
					<td><input type="text" name="tel1"></td>
				</tr>
			    <tr>
					<th>휴대폰번호 가운데 입력</th>
					<td><input type="text" name="tel2"></td>
				</tr>
				<tr>
					<th>휴대폰번호 끝자리 입력</th>
					<td><input type="text" name="tel3"></td>
				</tr>
				 <tr>
					<th>우편번호 입력</th>
					<td><input type="text" name="post"></td>
				</tr>
				<tr>
					<th>주소 입력</th>
					<td><input type="text" name="basic_addr"></td>
				</tr>
				 <tr>
					<th>상세 주소 입력</th>
					<td><input type="text" name="detail_addr"></td>
				</tr>
							
			</table>
		
		</form>
		<br>
		<input type="submit" value="가입완료">
	</div> 
	

</body>
</html>