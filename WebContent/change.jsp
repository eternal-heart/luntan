<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功</title>
<script type="text/javascript">
	var i = 2 ;
	var Interval = setInterval(function() {
		document.getElementById("s").innerHTML = i +"";
		i--;
		if (i==0) {
			clearInterval(Interval);
			window.location="http://localhost:8080/forum/login.html"; 
		}
	},1000);

</script>
</head>
<body>
<h1 style="font-size:25px;margin-left:500px">密码修改成功</h1>
<div style="margin-left:500px;margin-top:20px;font-size:20px">
	<a href="http://localhost:8080/forum/login.html">立即跳转到登录页面</a><br>
	<span id="s">3</span>秒后自动跳转
</div>

</body>
</html>