<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
</head>
<script src="js/jquery.min.js"></script>
<style>
	li
	{
		text-shadow: 5px 5px 5px #FF0000;
	}
</style>
<body>
	<table>
		<tr>
			<h1>
				<div>
					<font style="margin-left:500px" size=10px>欢迎来到论坛</font>
					<font style="margin-left:500px" size=5px><%
					String username=(String)request.getParameter("name");
					out.print(username);
					%>
					</font>					
				</div>	
			</h1>
		</tr>
		<tr>
			<td style="background-color:#FFD700;width:20px;vertical-align:top;">
			<body>
				<li>
					<font size="5" >首页</font>
				</li>
				<li>
					<font size="5"> 综合</font>
				</li>
			</body>
			</td>
			<td style="background-color:#eeeeee;height:600px;width:1500px;vertical-align:top;">
			
		</td>
		</tr>
		<tr>
		<td colspan="2" style="background-color:#FFA500;text-align:center;">
		撒大苏打</td>
		</tr>
	</table>
</body>
</html>