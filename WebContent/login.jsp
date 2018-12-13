<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/login.css">
<head>
<meta charset="UTF-8">
<title>login</title>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
</head>
<body>
	<form action="loginAction.action" method="post">
		<div id="login">
			<input name="method" value="login" type="hidden">
			<!-- 隐藏login -->
			<table>
				<caption>欢迎登陆心理咨询和诊断平台</caption>
				<tr>
					<td>账号：</td>
					<td><input type="text" name="name" placeholder="用户名长度3-12"
						id="username"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="pwd" placeholder="请输入密码"
						id="pwd"></td>
				</tr>
			</table>
			<div align="center">
				<input type="submit" name="logBtn" id="logBtn" value="立即登录"><br>
				<a href="<%=request.getContextPath()%>/register.jsp">快速注册</a>
			</div>
		</div>
	</form>
</body>

</html>