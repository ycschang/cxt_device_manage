<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/layui-v2.5.6/layui/css/layui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/public.css">
<script type="text/javascript"
	src=" ${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript"
	src=" ${pageContext.request.contextPath}/js/layui-v2.5.6/layui/layui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/pageHome.js"></script>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote layui-bg-green">
		<div id="nowTime"></div>
	</blockquote>
	<div class="layui-row layui-col-space10 panel_box">
		<div
			class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="javascript:void(0);">
				<div class="panel_icon layui-bg-green">
					<i class="layui-anim seraph icon-good"></i>
				</div>
				<div class="panel_word">
					<span>设备总数</span> <cite>125个</cite>
				</div>
			</a>
		</div>
		<div
			class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="javascript:void(0);">
				<div class="panel_icon layui-bg-black">
					<i class="layui-anim seraph icon-github"></i>
				</div>
				<div class="panel_word">
					<span>已安装数</span> <cite>70个</cite>
				</div>
			</a>
		</div>
		<div
			class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="javascript:void(0);">
				<div class="panel_icon layui-bg-red">
					<i class="layui-anim seraph icon-oschina"></i>
				</div>
				<div class="panel_word">
					<span>未安装数</span> <cite>55个</cite>
				</div>
			</a>
		</div>
		<div
			class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="javascript:void(0);">
				<div class="panel_icon layui-bg-blue">
					<i class="layui-anim seraph icon-clock"></i>
				</div>
				<div class="panel_word">
					<span class="loginTime"></span> <cite>上次登录时间</cite>
				</div>
			</a>
		</div>
	</div>
</body>
</html>