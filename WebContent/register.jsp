<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
body {
	background-image: url(../img/user_register.jpg);
	background-size: 100%, 100%;
	font-size: 20px;
	color: blue;
}

table {
	text-align: left;
	border-collapse: collapse;
	font-size: larger;
	width: 600px;
	height: 400px;
	margin-top: 20px;
}

td {
	width: 60px;
	height: 40px;
}

tr:hover {
	color: #FFFF00;
}
</style>
<head>
<meta charset="UTF-8">
<title>快速注册</title>
</head>
<body>
	<form action="registerAction.action" method="post">
		<div align="center">
			<table>
				<tr>
					<td colspan="2" align="center">快速注册</td>
				</tr>
				<tr>
					<td>账号：</td>
					<td><input type="text" name="name" id="name"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="pwd" id="pwd"></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" name="repwd"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>