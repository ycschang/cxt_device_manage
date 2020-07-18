layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    // 搜索【此功能需要后台配合，所以暂时没有动态效果演示】
   /* $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("newsListTable",{
                page: {
                    curr: 1 // 重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  // 搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });*/
    // 批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('newsListTable'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].newsId);
            }
            layer.confirm('确定删除选中的文章？', {icon: 3, title: '提示信息'}, function (index) {
                // $.get("删除文章接口",{
                // newsId : newsId //将需要删除的newsId作为参数传入
                // },function(data){
                tableIns.reload();
                layer.close(index);
                // })
            })
        }else{
            layer.msg("请选择需要删除的文章");
        }
    })
    // 转换后端传回的日期
    function timeFormat(nS) {
    	// /Date(1555554794000)/ 转换为 2019/4/18
		// return new Date(parseInt(("/Date("+nS+")/").substr(6,
		// 13))).toLocaleDateString();
    	// /Date(1555554794000)/ 转换为 2019/4/18 上午10:33:14
    	// return new Date(parseInt(("/Date("+nS+")/").substr(6,
		// 13))).toLocaleString()
    	// js转换时间戳-转换成 yyyy-MM-dd HH:mm:ss
    	var date = new Date(nS);
		  var YY = date.getFullYear() + '-';
		  var MM = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
		  var DD = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate());
		  var hh = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
		  var mm = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
		  var ss = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
		  return YY + MM + DD +" "+hh + mm + ss;
	};
    // 列表操作
    /*table.on('tool(deviceList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ // 编辑
            addNews(data);
        } else if(layEvent === 'del'){ // 删除
            layer.confirm('确定删除此文章？',{icon:3, title:'提示信息'},function(index){
                // $.get("删除文章接口",{
                // newsId : data.newsId //将需要删除的newsId作为参数传入
                // },function(data){
                    tableIns.reload();
                    layer.close(index);
                // })
            });
        } else if(layEvent === 'look'){ // 预览
            layer.alert("此功能需要前台展示，实际开发中传入对应的必要参数进行文章内容页面访问")
        }
    });*/
})
//设备增加修改
layui.use([ 'layer', 'form','table'], function() {
	var form = layui.form, layer = layui.layer,table = layui.table;
	 var tableIns = table.render({
	    elem: '#deviceList',
	    method:"post",
	    url:"${pageContext.request.contextPath}../../../device/getPageInfo.action",
	    cellMinWidth : 95,
	    page : true,
	    height : "full-125",
	    limit : 10,
	    limits : [10,15,20,25],
	    id : "deviceList",
	    cols : [[
	        {type: "checkbox", fixed:"left", width:50},
	        {field: '', title: '序号', width: 60, type:'numbers'},
	        {field: 'device_card', title: '设备编号', width:350},
	        {field: 'device_name', title: '姓名', align:'center'},
	        {field: 'device_type', title: '设备类型',  align:'center'},
	        {field: 'device_status', title: '设备状态', align:'center'},
	        {field: 'create_date', title: '添加时间', align:'center', minWidth:110, templet:function(d){
	        	if(d.create_date==null) {
	        		return "";
	        	} else {
	        		// /Date(1555554794000)/ 转换为 2019/4/18
	        		// return timeFormat(d.create_date).substring(0,10);
	        		return timeFormat(d.create_date);
	        	} 
	        }},
	        {title: '操作', width:170, templet:'#deviceListBar',fixed:"right",align:"center"}
	    ]]
	});
	// 搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	 $(".search_btn").on("click",function(){
	     if($(".searchVal").val() != ''){
	         table.reload("deviceList",{
	             page: {
	                 curr: 1 // 重新从第 1 页开始
	             },
	             where: {
	            	 "device_card": $(".searchVal").val()  // 搜索的关键字
	             }
	         })
	     }else{
	    	 layer.msg("全部查询");
	    	 table.reload("deviceList",{
	             page: {
	                 curr: 1 // 重新从第 1 页开始
	             },
	             where: {
	            	 "device_card": $(".searchVal").val()  // 搜索的关键字
	             }
	         })
	        
	     }
	 });
	// 转换后端传回的日期
    function timeFormat(nS) {
    	// /Date(1555554794000)/ 转换为 2019/4/18
		// return new Date(parseInt(("/Date("+nS+")/").substr(6,
		// 13))).toLocaleDateString();
    	// /Date(1555554794000)/ 转换为 2019/4/18 上午10:33:14
    	// return new Date(parseInt(("/Date("+nS+")/").substr(6,
		// 13))).toLocaleString()
    	// js转换时间戳-转换成 yyyy-MM-dd HH:mm:ss
    	var date = new Date(nS);
		  var YY = date.getFullYear() + '-';
		  var MM = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
		  var DD = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate());
		  var hh = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
		  var mm = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
		  var ss = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
		  return YY + MM + DD +" "+hh + mm + ss;
	};
	//添加设备
	$("#btnAdd").click(function() {
		// 通过这种方式弹出的层，每当它被选择，就会置顶。
		layer.open({
			type : 1,
			title : "添加设备信息",
			offset: ['18%', '22%'],
			shade : [ 0.4, '#393D49' ],
			area : [ '633px', '400px' ],
			maxmin : true,
			content : $("#addDevice"),
			btn : [ '提交', '关闭' ],
			yes : function(index, layero) {
				// 按钮【按钮一】的回调
				//layer.alert(JSON.stringify($("#addDevice").serialize()));
				$.post('${pageContext.request.contextPath}../../../device/addDevice.action',$("#addDevice").serialize(),function(res){
					if(res.code==200){
                        /*layer.msg("商品发布成功了，等待管理员审核", {time:3000});*/
						layer.msg("添加设备成功", {time:3000});//返回的结果
						$("#addDevice")[0].reset();
						layer.close(index);//关闭弹窗
						tableIns.reload();//刷新列表
					} else{
						//alert(6666666)
						layer.msg(res.result);//返回的结果
					}
				},"json")
			},
			btn2 : function(index, layero) {
				// 按钮【按钮二】的回调
				layer.closeAll()
				// return false 开启该代码可禁止点击该按钮关闭
			},
			cancel : function() {
				// 右上角关闭回调

				// return false 开启该代码可禁止点击该按钮关闭
			}
		});
	});
	table.on('tool(deviceList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'edit'){ // 编辑
        	var data = obj.data;
        	//数据回显
        	form.val('updateDevice',{
        		"device_card":data.device_card,
        		"device_type":data.device_type,
        		"device_name":data.device_name,
        		"device_status":data.device_status
        	});
        	layer.open({
    			type : 1,
    			title : "修改设备信息",
    			offset: ['18%', '22%'],
    			shade : [ 0.4, '#393D49' ],
    			area : [ '633px', '400px' ],
    			maxmin : true,
    			content : $("#updateDevice"),
    			btn : [ '提交', '关闭' ],
    			yes : function(index, layero) {
    				// 按钮【按钮一】的回调
    				/*alert(6666);*/
    				//layer.alert(JSON.stringify($("#updateDevice").serialize()));
    				$.post('${pageContext.request.contextPath}../../../device/updateDevice.action',$("#updateDevice").serialize(),function(res){
    					if(res.code==200){
    						layer.closeAll();//关闭弹窗
    						layer.msg(res.result);//返回的结果
    						tableIns.reload();//刷新列表
    					} else {
    						layer.alert(res.result);//返回的结果
    					}
    				},"json")
    			},
    			btn2 : function(index, layero) {
    				// 按钮【按钮二】的回调
    				layer.closeAll()
    				// return false 开启该代码可禁止点击该按钮关闭
    			}
    		});
        } else if(layEvent === 'cheek'){ // 预览
        	layer.open({
    			type : 1,
    			title : "查看设备信息",
    			offset: ['18%', '22%'],
    			shade : [ 0.4, '#393D49' ],
    			area : [ '633px', '400px' ],
    			maxmin : true,
    			content : $("#addDevice"),
    			btn : [ '关闭' ],
    			yes : function(index, layero) {
    				// 按钮【按钮一】的回调
    				/*layer.alert(JSON.stringify($("form").serialize()))*/
    				$.post('${pageContext.request.contextPath}../../../device/addDevice.action',$("form").serialize(),function(res){
    					if(res.code==200){
    						layer.alert(res.result);//返回的结果
    						layer.closeAll();//关闭弹窗
    						tableIns.reload();//刷新列表
    					} else {
    						layui.msg(res.result);//返回的结果
    					}
    				},"json")
    			}
    		});
        } else if(layEvent === 'del'){ // 删除
            layer.confirm('确定删除此设备？',{icon:3, title:'提示信息'},function(index){
                //alert(JSON.stringify(data.id));
                $.post('${pageContext.request.contextPath}../../../device/delDevice.action',{"device_card":data.device_card},function(res){
					if(res.code==200){
						layer.alert(res.result);//返回的结果
						layer.closeAll();//关闭弹窗
						tableIns.reload();//刷新列表
					} else {
						layui.msg(res.result);//返回的结果
					}
				},"json");
            });
        }
    });
});
