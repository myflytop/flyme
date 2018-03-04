<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>FLYTOP</title>
		<link rel="shortcut icon" href="img/mylog.ico" type="image/x-icon">
		<link rel="stylesheet" href="./layui/css/layui.css">
		<link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="model/loadcss.js"></script>
    
	</head>

	<body>

		<!-- 你的HTML代码 -->
		<div class="layui-layout layui-layout-admin">
			<div class="layui-header">
				<div class="layui-logo">
					<span style="font-size: 20px;">layui 后台布局</span>
				
				<span style="width: 40px;height: 40px;display: block;float: right;">
						<i  class="fa fa-bars admin-side-toggle" style="font-size: 40px;margin-top: 10px;color: white;"></i>
				</span>
				</div>
				
				<!-- 头部区域（可配合layui已有的水平导航） -->
				<ul class="layui-nav layui-layout-right">
					<li class="layui-nav-item">
						<a href="">控制台<span class="layui-badge">9</span></a>
					</li>
					<li class="layui-nav-item">
						<a href="">个人中心<span class="layui-badge-dot"></span></a>
					</li>
					<!-- <li class="layui-nav-item">
						<a href="javascript:;">
							<img src="http://t.cn/RCzsdCq" class="layui-nav-img"> 贤心
						</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="">基本资料</a>
							</dd>
							<dd>
								<a href="">安全设置</a>
							</dd>
							<dd>
								<a href="">退出</a>
							</dd>
						</dl>
					</li> -->

				</ul>
			</div>

			<div class="layui-side layui-bg-black" id="admin-side">
				<div class="layui-side-scroll">
					<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
					<ul class="layui-nav layui-nav-tree " lay-filter="test" id="admin-navbar-side">
						<li class="layui-nav-item layui-nav-itemed" >
							<a class="" href="javascript:;">个人中心</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;" data-url="userinfo">资料详情</a>
								</dd>
								<dd>
									<a href="javascript:;" data-url="website">站点监控</a>
								</dd>
								<dd>
									<a href="javascript:;" data-url="websettings">站点设置</a>
								</dd>
							</dl>
						</li>
						<li class="layui-nav-item">
							<a href="javascript:;">博文管理</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;" data-url="sortmanagement">博文分类</a>
								</dd>
								<dd>
									<a href="javascript:;" data-url="articlemanagement">博文管理</a>
								</dd>
							</dl>
						</li>
						<li class="layui-nav-item">
							<a href="javascript:;">教程管理</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;" data-url="tSortmanagement">教程分类</a>
								</dd>
								<dd>
									<a href="javascript:;" data-url="tutoriamanagement">教程管理</a>
								</dd>
							</dl>
						</li>
						<li class="layui-nav-item">
							<a href="javascript:;">下载管理</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;" data-url="dsortamanagement">下载分类</a>
								</dd>
								<dd>
									<a href="javascript:;" data-url="donwloadmanagement">下载管理</a>
								</dd>
							</dl>
						</li>

					</ul>
				</div>
				
			</div>

			<style type="text/css">
				.layui-tab-title li:first-child>.layui-tab-close {
					display: none;
				}
			</style>
			<div class="layui-tab layui-tab-card layui-body"  lay-filter="demo" id="admin-body" lay-allowClose="true" style="margin: 0;bottom: 0;">
				<ul class="layui-tab-title">
					<li class="layui-this" lay-id="u0">基本介绍</li>
				</ul>
				<script src="js/jquery-3.1.1.min.js" type="text/javascript" charset="utf-8"></script>
				<div class="layui-tab-content" style="overflow:auto;" id="admi-con" >
					<div class="layui-tab-item layui-show" id="result">
						<!--<iframe src="index.html" style="width: 100%;bottom: 0; display:inline-flex"></iframe>-->

					</div>
					<script type="text/javascript">
						$(document).ready(function() {

							$.get("info.html", function(data) {
								$("#result").html(data);
							});
						});
					</script>
		</div>
		<script src="./layui/layui.js"></script>
		<script src="js/vue.js"></script>
		<script src="js/vue-resource.js"></script>
		<script type="text/javascript" src="js/basic.js" ></script>
     <script type="text/javascript">
     	window.onload=function(){
/*导航点击显示隐藏控制按钮 .admin-side-toggle
包裹导航 盒子'#admin-side'
主面板   #admin-body
admin-footer 
*/
 $('.admin-side-toggle').on('click', function() {
		var sideWidth = $('#admin-side').width();
		if(sideWidth === 200) {
			$('#admin-body').animate({
				left: '0'
			}); //admin-footer
			/*$('#admin-footer').animate({
				left: '0'
			});*/
			$('#admin-side').animate({
				width: '0'
			});
		} else {
			$('#admin-body').animate({
				left: '200px'
			});
			/*$('#admin-footer').animate({
				left: '200px'
			});*/
			$('#admin-side').animate({
				width: '200px'
			});
		}
	});
     	}
     	
     	
     </script>

	</body>

</html>