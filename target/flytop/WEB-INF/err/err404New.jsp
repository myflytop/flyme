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
		<title>页面未找到</title>
		
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" href="<%=path %>/layui/css/layui.css" />
		<link rel="stylesheet" href="<%=path %>/font-awesome-4.7.0/css/font-awesome.min.css" />
		
        <link rel="stylesheet" href="<%=path %>/css/public.css" />
		<link rel="stylesheet" href="<%=path %>/css/err.css" />
			
			
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
		
		
		<!--内容区域开始-->
	<div class="layui-row layui-col-space20 main-body">
			<!--路径导航开始-->
			<div class="layui-col-md10 layui-col-md-offset1">
				<blockquote class="layui-elem-quote layui-breadcrumb sitemap">
					<a href="<%=path %>/indexNew.html" title="网站首页">网站首页</a>
					<a>
					<cite>404错误</cite>
				    </a>
				</blockquote>
			</div>
            <!--路径导航结束-->
           <!-- 左边内容开始-->
			<div class="layui-col-md10 layui-col-md-offset1 ">
			<div class="main-body-con">
				<div id="da-wrapper" class="fluid">
        <!-- Content -->
        <div id="da-content">
            
            <!-- Container -->
            <div class="da-container clearfix">
            
            	<div id="da-error-wrapper">
                	
                   	<div id="da-error-pin"></div>
                    <div id="da-error-code">
                    	error <span>404</span>                    </div>
                
                	<h1 class="da-error-heading">哎哟喂！页面让狗狗叼走了！</h1>
                    <p>大家可以到狗狗没有叼过的地方看看！ <a href="<%=path %>/indexNew.html">FLYTOP</a></p>
                </div>
            </div>
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
					
				});
			</script>
			
	</body>

</html>