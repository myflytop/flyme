<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<head>
		<meta charset="utf-8" />
		<title>Full example - Editor.md examples</title>
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="<%=path %>/layui/css/layui.css" />
		<script src="<%=path %>/js/vue.js"></script>
		<script src="<%=path %>/js/vue-resource.js"></script>
		<link rel="stylesheet" href="../css/editormd.css" />
		<link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon" />
	</head>
	
     <style>
			/*.editormd-preview-theme-dark {
                color: #777;
                background:#2C2827;
            }
            
            .editormd-preview-theme-dark .editormd-toc-menu > .markdown-toc {
                background:#fff;
                border:none;
            }
            
            .editormd-preview-theme-dark .editormd-toc-menu > .markdown-toc h1{
                border-color:#ddd;
            }
            
            .editormd-preview-theme-dark .markdown-body h1,
            .editormd-preview-theme-dark .markdown-body h2,
            .editormd-preview-theme-dark .markdown-body hr {
                border-color: #222;
            }
            
            .editormd-preview-theme-dark .editormd-preview-container  blockquote {
                color: #555;
                border-color: #333;
                background: #222;
                padding: 0.5em;
            }
            
            .editormd-preview-theme-dark .editormd-preview-container abbr {
                background:#ff9900;
                color: #fff;
                padding: 1px 3px;
                border-radius: 3px; 
            }
            
            .editormd-preview-theme-dark .editormd-preview-container code {
                background: #5A9600;
                color: #fff;
                border: none;
                padding: 1px 3px;
                border-radius: 3px; 
            }
            
            .editormd-preview-theme-dark .editormd-preview-container table {
                border: none;
            }
            
            .editormd-preview-theme-dark .editormd-preview-container .fa-emoji {
                color: #B4BF42;
            }
            
            .editormd-preview-theme-dark .editormd-preview-container .katex {
                color: #FEC93F;
            }
            
            .editormd-preview-theme-dark [class*=editormd-logo] {
                color: #2196F3;
            }
            
            .editormd-preview-theme-dark .sequence-diagram text {
                fill: #fff;
            }
            
            .editormd-preview-theme-dark .sequence-diagram rect, 
            .editormd-preview-theme-dark .sequence-diagram path {
                color:#fff;
                fill : #64D1CB;
                stroke : #64D1CB;
            }
            
            .editormd-preview-theme-dark .flowchart rect, 
            .editormd-preview-theme-dark .flowchart path {
                stroke : #A6C6FF;
            }
            
            .editormd-preview-theme-dark .flowchart rect {
                fill: #A6C6FF;
            }
            
            .editormd-preview-theme-dark .flowchart text {
                fill: #5879B4;
            }*/
		</style>
	</head>

	<body>

		<!-- <div id="app">
			{{ message }}
		</div> -->
		<input value="<%=path %>" id="path" type="hidden" />
		<h2 style="margin-top: 20px;margin-bottom: 20px;">添加博文</h2>
		<form class="layui-form" id="editForm" llay-filter="editForm">
			<!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
			<div class="layui-form-item" style="width: 400px;margin: 0 auto;">
				<label class="layui-form-label" style="width: 100px;">添加标题</label>
				<div class="layui-input-block" tyle="width: 100px;">
					<input type="text" name="article_title" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item" style="width: 400px;margin: 0 auto;margin-top: 20px;margin-bottom: 20px;">
				<label class="layui-form-label" style="width: 100px;">选择分类</label>
				<div class="layui-input-block">
					<select name="sort_article_id" lay-filter="sort">
						<option v-for="sort in opdata" v-bind:value="sort.sort_article_id" v-html="sort.sort_article_name"></option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="getForm">立即提交</button>
				</div>
			</div>
		</form>
		
		<div id="layout">
			<div class="btns">
				<button id="goto-line-btn">Goto line 90</button>
				<button id="show-btn">Show editor</button>
				<button id="hide-btn">Hide editor</button>
				<button id="get-md-btn">Get Markdown</button>
				<button id="get-html-btn">Get HTML</button>
				<button id="watch-btn">Watch</button>
				<button id="unwatch-btn">Unwatch</button>
				<button id="preview-btn">Preview HTML (Press Shift + ESC cancel)</button>
				<button id="fullscreen-btn">Fullscreen (Press ESC cancel)</button>
				<button id="show-toolbar-btn">Show toolbar</button>
				<button id="close-toolbar-btn">Hide toolbar</button>
				<button id="toc-menu-btn">ToC Dropdown menu</button>
				<button id="toc-default-btn">ToC default</button>
			</div>
			<div id="test-editormd"></div>
		</div>
		<script src="js/jquery.min.js"></script>
		<script src="../editormd.js"></script>
		<script src="<%=path %>/layui/layui.js" charset="UTF-8"></script>

		<script type="text/javascript">
			var testEditor;
			$(function() {
				$.get('test.md', function(md) {
					testEditor = editormd("test-editormd", {
						width: "90%",
						height: 740,
						path: '../lib/',
						theme: "dark",
						previewTheme: "dark",
						editorTheme: "pastel-on-dark",
						markdown: md,
						codeFold: true,
						//syncScrolling : false,
						saveHTMLToTextarea: true, // 保存 HTML 到 Textarea
						searchReplace: true,
						//watch : false,                // 关闭实时预览
						htmlDecode: "style,script,iframe|on*", // 开启 HTML 标签解析，为了安全性，默认不开启    
						//toolbar  : false,             //关闭工具栏
						//previewCodeHighlight : false, // 关闭预览 HTML 的代码块高亮，默认开启
						emoji: true,
						taskList: true,
						tocm: true, // Using [TOCM]
						tex: true, // 开启科学公式TeX语言支持，默认关闭
						flowChart: true, // 开启流程图支持，默认关闭
						sequenceDiagram: true, // 开启时序/序列图支持，默认关闭,
						//dialogLockScreen : false,   // 设置弹出层对话框不锁屏，全局通用，默认为true
						//dialogShowMask : false,     // 设置弹出层对话框显示透明遮罩层，全局通用，默认为true
						//dialogDraggable : false,    // 设置弹出层对话框不可拖动，全局通用，默认为true
						//dialogMaskOpacity : 0.4,    // 设置透明遮罩层的透明度，全局通用，默认值为0.1
						//dialogMaskBgColor : "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为#fff
						imageUpload: true,
						imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
						imageUploadURL: "./php/upload.php",
						onload: function() {
							console.log('onload', this);
							//this.fullscreen();
							//this.unwatch();
							//this.watch().fullscreen();

							//this.setMarkdown("#PHP");
							//this.width("100%");
							//this.height(480);
							//this.resize("100%", 640);
						}
					});
				});

				$("#goto-line-btn").bind("click", function() {
					testEditor.gotoLine(90);
				});

				$("#show-btn").bind('click', function() {
					testEditor.show();
				});

				$("#hide-btn").bind('click', function() {
					testEditor.hide();
				});

				$("#get-md-btn").bind('click', function() {
					console.log(testEditor.getMarkdown());
					alert(testEditor.getMarkdown());
				});

				$("#get-html-btn").bind('click', function() {
					console.log(testEditor.getHTML());
					alert(testEditor.getHTML());
				});

				$("#watch-btn").bind('click', function() {
					testEditor.watch();
				});

				$("#unwatch-btn").bind('click', function() {
					testEditor.unwatch();
				});

				$("#preview-btn").bind('click', function() {
					testEditor.previewing();
				});

				$("#fullscreen-btn").bind('click', function() {
					testEditor.fullscreen();
				});

				$("#show-toolbar-btn").bind('click', function() {
					testEditor.showToolbar();
				});

				$("#close-toolbar-btn").bind('click', function() {
					testEditor.hideToolbar();
				});

				$("#toc-menu-btn").click(function() {
					testEditor.config({
						tocDropdown: true,
						tocTitle: "目录 Table of Contents",
					});
				});

				$("#toc-default-btn").click(function() {
					testEditor.config("tocDropdown", false);
				});
			});
			
			function renderForm() {
				layui.use('form', function() {
					var form = layui.form;
					form.render();
					form.on('select(sort)', function(obj) {
						var v = obj.value;
						console.log(v + $(obj.othis).find('input').val());

					});
					form.on('submit(getForm)', function(data) {
						var sel=$("#editForm").find("dl").find("dd[class='layui-this']");
						console.log(sel.html()+sel.attr("lay-value"));
						console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
						console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
						console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
						var mydata=data.field;
						mydata['bloger_id']=10001;
						mydata['article_content']=testEditor.getMarkdown();
				var bie=$('.editormd-preview-container');
				var bifp=bie.find('P:first').text();
				var imgsrc=bie.find('img:first')[0].src;
				mydata['article_img_brief']=imgsrc;
				mydata['article_con_brief']=bifp;
						console.log(mydata);
						$.ajax({
                            type: "post",
                            url: $("#path").val()+'/bloger/article/addArticle.do',
                            data: data.field,
                            dataType: "json",
                            async: false,
                            success: function (data, textStatus, jqXHR) {
                            	if(data.code===1)
                            		{
                            		layer.alert("添加成功");
                            		}
                            	else{
                            		layer.alert("添加失败");
                            	}
                            	console.log(data);
                                
                            },
                            error: function (XMLHttpRequest, textStatus, errorThrown) {
                                console.log("请求失败");
                              
                            }
                        });
						return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
					});
				});
			};

			var myoption = new Vue({
				el: '#editForm',
				data: {
					opdata: ''
				},
				mounted: function() {
					var x = this;
					this.$http({
						method: 'GET',
						url:$("#path").val()+'/bloger/article/getSorts.do'
					}).then(function(res) {
						x.opdata = res.body.data;
						console.log(res);
						console.log(x.opdata);
						renderForm();

					})
				},
				methods: {

				}
			})
		</script>
		<script type="text/javascript">
		/* 	var app = new Vue({
				el: '#app',
				data: {
					message: 'Hello Vue!'
				}

			}) */
		</script>
		
	</body>

</html>