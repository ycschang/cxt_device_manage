<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/layui-v2.5.6/layui/css/layui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/public.css" media="all" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/device.css" media="all" />
<script type="text/javascript"
	src=" ${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript"
	src=" ${pageContext.request.contextPath}/js/layui-v2.5.6/layui/layui.js"></script>
<script type="text/javascript"
	src=" ${pageContext.request.contextPath}/js/net_card.js"></script>
</head>
<body class="childrenBody">
	<form class="layui-form">
		<blockquote class="layui-elem-quote quoteBox">
			<form class="layui-form">
				<div class="layui-inline">
					<div class="layui-input-inline">
						<input type="text" class="layui-input searchVal"
							placeholder="请输入搜索的物联网号" />
					</div>
					<a class="layui-btn search_btn" data-type="reload">搜索</a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn layui-btn-norma addDevice_btn" id="btnAdd"
						data-type="auto">添加设备</a>
				</div>
				<!-- <div class="layui-inline">
					<a class="layui-btn layui-btn-danger layui-btn-normal delAll_btn">批量删除</a>
				</div> -->
			</form>
		</blockquote>
		<table id="deviceList" lay-filter="deviceList"></table>
		<!--操作-->
		<script type="text/html" id="deviceListBar">
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
			<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
		</script>
		<!-- <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="cheek">查看</a> -->
	</form>
	<!-- 添加设备信息 -->
	<!-- <form class="layui-form" id="addDevice" lay-filter="addDevice" hidden="hidden">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">设备编号</label>
				<div class="layui-input-block">
					<input type="text" name="device_card" lay-verify="title"
						autocomplete="off" placeholder="请输入设备编号" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">设备类型</label>
				<div class="layui-input-block">
					<select name="device_type" lay-filter="aihao">
						<option value="">请选设备类型</option>
						<option value="穿戴">穿戴</option>
						<option value="居家">居家</option>
					</select>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">设备名称</label>
				<div class="layui-input-block">
					<input type="text" name="device_name" lay-verify="title"
						autocomplete="off" placeholder="请输入设备名称" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">设备状态</label>
				<div class="layui-input-block">
					<select name="device_status" lay-filter="aihao">
						<option value="">请选设备状态</option>
						<option value="损坏">损坏</option>
						<option value="正常">正常</option>
					</select>
				</div>
			</div>
		</div>
	</form>-->
	<!-- 编辑设备信息 -->
	<!--<form class="layui-form" id="updateDevice" lay-filter="updateDevice" hidden="hidden">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">设备编号</label>
				<div class="layui-input-block">
					<input type="text" name="device_card" lay-verify="title"
						autocomplete="off" placeholder="请输入设备编号" class="layui-input" readOnly="true">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">设备类型</label>
				<div class="layui-input-block">
					<select name="device_type" lay-filter="aihao">
						<option value="">请选设备类型</option>
						<option value="穿戴">穿戴</option>
						<option value="居家">居家</option>
					</select>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">设备名称</label>
				<div class="layui-input-block">
					<input type="text" name="device_name" lay-verify="title"
						autocomplete="off" placeholder="请输入设备名称" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">设备状态</label>
				<div class="layui-input-block">
					<select name="device_status" lay-filter="aihao">
						<option value="">请选设备状态</option>
						<option value="损坏">损坏</option>
						<option value="正常">正常</option>
					</select>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">物联网卡号</label>
				<div class="layui-input-block">
					<input type="text" name="net_card" lay-verify="title"
						autocomplete="off" placeholder="请输入物联网卡号" class="layui-input">
				</div>
			</div>
		</div>
	</form>-->
</body>
</html>