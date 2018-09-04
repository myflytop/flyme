//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
$(document).ready(function(){
layui.use(['element', 'form', 'laydate', 'upload'], function() {
	var $ = layui.jquery,
		element = layui.element, //Tab的切换功能，切换事件监听等，需要依赖element模块
		laydate = layui.laydate,
		upload = layui.upload,
		form = layui.form;

	form.on('submit(formDemo)', function(data) {
		layer.msg(JSON.stringify(data.field));
		return false;
	});
	//触发事件
	var active = {
		tabAdd: function() {
			//新增一个Tab项
			var myid = new Date().getTime()
			element.tabAdd('demo', {
				title: '新选项' + myid //用于演示
					,
				content: '内容' + myid,
				id: myid //实际使用一般是规定好的id，这里以时间戳模拟下
			});
			element.tabChange('demo', myid); //切换到：用户管理
		},
		tabDelete: function(othis) {
			//删除指定Tab项
			element.tabDelete('demo', '44'); //删除：“商品管理”

			othis.addClass('layui-btn-disabled');
		},
		tabChange: function() {
			//切换到指定Tab项
			element.tabChange('demo', '22'); //切换到：用户管理
		}
	};
	//绑定指定事件
	$('.site-demo-active').on('click', function() {

		var othis = $(this),
			type = othis.data('type');
		active[type] ? active[type].call(this, othis) : '';
	});

	//Hash地址的定位
	var layid = location.hash.replace(/^#test=/, '');
	element.tabChange('test', layid);

	element.on('tab(test)', function(elem) {
		location.hash = 'test=' + $(this).attr('lay-id');

	});
	//当前展开的页面,默认第一个
	var now_up = "u0";
	//已经打开的页面
	var my_up = new Array("u0");

	//切换时监听
	element.on('tab(demo)', function(data) {
		if($(this).attr("lay-id") == undefined) {

		} else {
			now_up = $(this).attr("lay-id");
		}
		console.log("当前" + now_up);
		console.log(this); //当前Tab标题所在的原始DOM元素
		console.log(data.index); //得到当前Tab的所在下标
		console.log(data.elem); //得到当前的Tab大容器
		console.log(now_up + "change");
		location.hash = 'test=' + $(this).attr('lay-id');

	});
	//Tab选项卡被删除时触发，回调函数返回一个object参数，携带两个成员：
	element.on('tabDelete(demo)', function(data) {
		var curl = $(this).parent().attr('lay-id');
		delmyup(curl);
		console.log(this); //当前Tab标题所在的原始DOM元素
		console.log(data.index); //得到当前Tab的所在下标
		console.log(data.elem); //得到当前的Tab大容器
	});
  //删除
	function delmyup(curl) {
		for(i = 0; i < my_up.length + 1; i++) {
			if(my_up[i] == curl) {
				my_up.splice(i, 1);
				break;
			}

		}

	}
	//判断是否被打开
	function booldurl(durl) {
		console.log(my_up + "_" + durl);

		for(i = 0; i < my_up.length + 1; i++) {
			if(my_up[i] == durl) {
				return true;
				break;
			}
		}
		return false;
	}
	
	
	var fal=true;
			//获取点击请求
	$("#admin-navbar-side>li>dl>dd>a").click(function() {
		if(fal)
			{
			fal=false;
		console.log(my_up.length)
		var durl = $(this).attr("data-url");
		var dtitle=$(this).html();
		if(booldurl(durl)) {
			if(durl==now_up)
			{
			
			}
			else
			{
			now_up = durl;
			element.tabChange('demo', durl);
       }
		} else {
              var conv='';
			if(durl==="sortmanagement")
				{
				conv='<span id="' + durl + '"><'+durl+'></'+durl+'></span>'+
		          '<script type="text/html" id="barsort">'+
				  '<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>'+
				  '<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>'+
				'</script>';
				
				}
			else if(durl==='articlemanagement')
				{
				conv='<span id="' + durl + '"><'+durl+' v-bind:msorts="Msorts"></'+durl+'></span>'+
				'<table class="layui-hide" id="arttable" lay-filter="artdemo"></table>'+
					'<script type="text/html" id="titleTpl">' +
					'<a href="/detail/{{d.article_id}}" class="layui-table-link">{{d.article_id+"."+d.article_title}}</a>' +
					'</script>' +
					'<script type="text/html" id="articlebar">' +
					'<a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>' +
					'<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>'+
					'</script>';	
				}
			else if(durl==="userinfo")
				{
					conv='<span id="' + durl + '"><'+durl+' v-bind:bloger="blogerData" v-bind:hobbys="mhobbys"></'+durl+'></span>';
				}
			else
				{
				conv='<span id="' + durl + '"><'+durl+'></'+durl+'><table class="layui-hide" id="usermanagementtable"></table></span>'
				+'<script type="text/html" id="checklock">'
				+'<input type="checkbox" name="user_lock" value="{{d.user_id}}" title="锁定" lay-filter="user_lockDemo" {{ d.user_lock==1 ? "checked" : "" }}>'
				+'</script>'
				+'<script type="text/html" id="usersexTpl">'
				  +'<p>{{d.user_sex==1?"男":"女"}}</>'
				+'</script>'
				+'<script type="text/html" id="useridTpl">'
				  +'<a  lay-event="getmore" href="javascript:void(0)" class="layui-table-link" title="查看更多">{{d.user_id}}</a>'
				+'</script>';
				}
			element.tabAdd('demo', {
				title:  dtitle //于演示
					,
				content: conv ,
				id: durl 
			});

			
			
			
       
			$.getScript("model/"+durl+".js", function() {
			now_up = durl;
	        my_up.push(durl);
			element.tabChange('demo', durl); 
			});
		
		}
		fal=true;
			}
		else{
			
		}
			
		
		return false;
	});
	});
	//内容区域到顶部距离
	var conoffsetTop = $("#admi-con").offset().top;
	//浏览器可视高度
	var vheight = $(window).height();
	$("#admi-con").height(vheight - conoffsetTop + 20);
});