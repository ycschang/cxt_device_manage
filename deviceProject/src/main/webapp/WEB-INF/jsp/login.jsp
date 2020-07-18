<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录界面</title>
<script type="text/javascript"
	src=" ${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript"
	src=" ${pageContext.request.contextPath}/js/layui-v2.5.6/layui/layui.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/layui-v2.5.6/layui/css/layui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css">
<body>
	<div id="container">
		<div class="admin-login-background">
			<form class="layui-form">
				<div>
					<iclass ="layui-icon layui-icon-username admin-iconadmin-icon-username">
					</i> <input type="text" name="username" placeholder="请输入用户名"
						autocomplete="off"
						class="layui-input admin-input admin-input-username">
				</div>
				<div>
					<iclass ="layui-icon layui-icon-password admin-iconadmin-icon-password">
					</i> <input type="password" name="password" placeholder="请输入密码"
						autocomplete="off" class="layui-input admin-input">
				</div>
				<button class="layui-btn admin-button" lay-submit
					lay-filter="formDemo">登陆</button>
			</form>
		</div>
	</div>
	<script >
		layui.use('form', function() {
			var form = layui.form;
			//监听提交
			form.on('submit(formDemo)', function(data) {
				/* layer.msg(JSON.stringify(data.field)); */
				$.ajax({
					type: "POST",   //提交的方法
		            url:"${pageContext.request.contextPath}/user/login.action", //提交的地址  
		            data:data.field,// 序列化表单值  
		            async: false,  
		            error: function(request) {  //失败的话
		                 alert("Connection error");  
		            },  
		            success: function(data) {  //成
		            	/* layer.msg(JSON.stringify(data)) */
		            	if(data.username!=null){
		            		window.location.href="${pageContext.request.contextPath}/page/main.jsp";
		            	} else {
		            		layer.msg("用户不存在");
		            	}
		                
		            }
				})
				return false; 
			})
			});
	</script>
	
</body>
</html>
































