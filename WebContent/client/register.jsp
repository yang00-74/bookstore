<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>

<style>
</style>
</head>
<body style="text-align:center">

			<form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
				<div  style="line-height:45px;
                              font-size:20px;">
					用户：<input type="text" name="username" />
				</div>
				<div style="line-height:45px;
                              font-size:20px;">
					密码：<input  type="password" name="password" />
				</div>
				<div style="line-height:45px;
                              font-size:20px;">
					电话:<input  type="text" name="phone" />
				</div>
				<div style="line-height:45px;
                              font-size:20px;">
					地址:<input  type="text" name="address" />
				</div>
				<div id="bt">
					<input class="btn" type="reset" value="重置" /></a>
					 <input class="btn" type="submit" value="注册" />
				</div>
			</form>


</body>
</html>