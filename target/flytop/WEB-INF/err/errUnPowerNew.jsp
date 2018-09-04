<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>问题提示</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" href="<%=path %>/layui/css/layui.css" />
		<link rel="stylesheet" href="<%=path %>/font-awesome-4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="<%=path %>/css/public.css" />
		
			
			
	</head>

	<body ondragstart="return false">
		<!--导航开始-->
		<nav class="top-nav">
			<ul class="layui-nav my-nav-style" id="main-nav" lay-filter="my-top-nav" style="text-align: center;">
				<li id="nav-login" class="layui-nav-item layui-layout-right" lay-unselect="" style="margin-right:80px;">
					
			    </li>
				<li class="layui-nav-item">
					<a href="<%=path %>/indexNew.html"><i class="fa fa-home fa-fw"></i>网站首页</a>
				</li>
				<li class="layui-nav-item">
					<a href="<%=path %>/searcharticleNew.html"><i class="fa fa-book fa-fw"></i>博文专栏</a>
				</li>
				<li class="layui-nav-item">
					<a href=""><i class="fa fa-tags fa-fw"></i>教程专栏</a>
				</li>
				<li class="layui-nav-item">
					<a href=""><i class="fa fa-download fa-fw"></i>资源分享</a>
				</li>
				<li class="layui-nav-item ">
					<a href="<%=path %>/aboutNew.html"><i class="fa fa-info fa-fw"></i>关于本站</a>
				</li>
			</ul>
			<a class="nav-logo" href="javascript:void(0)">FLYTOP</a>
			<span class="nav-btn"><i class="fa fa-navicon  fa-2x fa-fw"></i></span>
		</nav>
		<!--导航结束-->
		  <input id="err" value="${msg.msg}" type="hidden"/>
		
		<!--内容区域开始-->
	<div class="layui-row layui-col-space20 main-body">
			<!--路径导航开始-->
			<div class="layui-col-md10 layui-col-md-offset1">
				<blockquote class="layui-elem-quote layui-breadcrumb sitemap">
					<a href="<%=path %>/indexNew.html" title="网站首页">网站首页</a>
					<a>
					<cite>出现了一点点问题</cite>
				    </a>
				</blockquote>
			</div>
            <!--路径导航结束-->
           <!-- 左边内容开始-->
			<div class="layui-col-md10 layui-col-md-offset1 ">
			<div class="main-body-con">
			<ul style="display:block;width:80%;margin:0 auto">	
		   <li> 出现标识：<span class="layui-text">${msg.code}</span></li>
		   <li> 问题消息：<span class="layui-text">${msg.msg}</span></li>
		   <li> 问题类型：<span class="layui-text">${msg.ex} &nbsp;${msg.data}</span></li>
		    </ul>  
		      <div style="width:width:400px;margin:0 auto;margin-top:100px;padding-bottom:100px">
		       <p style="text-align:center;">扫描微信反馈问题</p>
		       <div style="width:200px;margin:0 auto;padding:20px">
		       
		       <img alt="微信" src="<%=path %>/img/weixin.png" style="width:200px;height:200px;">
		      </div>
		      </div>
           </div>
			</div>
		</div>
           <!-- 左边内容开始-->
	
    <!--内容区域结束-->
    
			<script type="text/javascript" src="<%=path %>/layui/layui.js"></script>
		    <script type="text/javascript" src="<%=path %>/js/jquery3.2.1.js"></script>
		    <script type="text/javascript" src="<%=path %>/js/jquery.cookie.js"></script>
			<script type="text/javascript" src="<%=path %>/js/public.js" ></script>
			<script>
			
				layui.use(['element', 'form', 'layer', 'laytpl'], function() {
			var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
		    var layer = layui.layer;
			var laytpl = layui.laytpl;
			var form = layui.form;
           

					//初始化窗口变化事件
					window.onresize = function() {
                   initindex.initnav();
					}
					//初始化按钮事件
					$('.nav-btn').click(function() {		 
		            initindex.navbtn();
					});
					initindex.initnav();
					var er=$("#err").val();
					if(er.length>1)
						{
						layer.msg(er);
						}			
				});
			</script>
			
	</body>

</html>