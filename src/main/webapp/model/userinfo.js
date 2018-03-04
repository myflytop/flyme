
/*var data = { counter: 5 };*/
var data={"bloger_name":"张哈哈","bloger_profession":"[\"zhangsan\"]","bloger_address":"张家口","bloger_hobby":"[\"zhangsan\",\"zhangsanppp3\",\"zhang网二san3\",\"zhangsan3\",\"zhangsan3\",\"hhhhhhhhhhhhhhhhh\"]","bloger_nikename":"票琵琶","bloger_birthday":"2017-10-23","bloger_id":10001,"bloger_sex":1,"bloger_introduce":"撒大声地所多","bloger_regtime":"2017-10-20","bloger_imgurl":"7777"};

Vue.component('userinfo', {
	props: ['bloger','hobbys'],
	template: '<ul class="layui-timeline">\
	<li class="layui-timeline-item">\
		<i class="layui-icon layui-timeline-axis">&#xe63f;</i>\
		<div class="layui-timeline-content layui-text">\
			<h3 class="layui-timeline-title">基本资料</h3>\
			<div class="layui-row">\
				<div class="layui-col-md5">\
					<form class="layui-form" id="myform">\
						<div class="layui-form-item">\
							<label class="layui-form-label">账号</label>\
							<div class="layui-input-block">\
								<input type="text" name="bloger_id" disabled readonly="true" placeholder="" v-bind:value="bloger.bloger_id" autocomplete="off" class="layui-input layui-disabled" style="width: 300px">\
							</div>\
						</div>\
						<div class="layui-form-item">\
							<label class="layui-form-label">姓名</label>\
							<div class="layui-input-block">\
								<input type="text" name="bloger_name" required lay-verify="required" v-bind:placeholder="bloger.bloger_name" v-bind:value="bloger.bloger_name" autocomplete="off" class="layui-input" style="width: 300px">\
							</div>\
						</div>\
						<div class="layui-form-item">\
							<label class="layui-form-label">昵称</label>\
							<div class="layui-input-block">\
								<input type="text" name="bloger_nikename" required lay-verify="required" v-bind:placeholder="bloger.bloger_nikename" v-bind:value="bloger.bloger_nikename" autocomplete="off" class="layui-input" style="width: 300px">\
							</div>\
						</div>\
						<div class="layui-form-item">\
							<label class="layui-form-label">性别</label>\
							<div class="layui-input-block">\
								<input type="radio" name="bloger_sex" value="1" v-bind:checked="bloger.bloger_sex==1?true:false" title="男" v-bind:placeholder="bloger.bloger_sex">\
								<input type="radio" name="bloger_sex" value="0" v-bind:checked="bloger.bloger_sex==0?true:false" title="女" v-bind:placeholder="bloger.bloger_sex">\
							</div>\
						</div>\
						<div class="layui-form-item">\
							<label class="layui-form-label">生日</label>\
							<div class="layui-input-block">\
								<input type="text" name="bloger_birthday" required lay-verify="required" v-bind:placeholder="bloger.bloger_birthday" v-bind:value="bloger.bloger_birthday" autocomplete="off" class="layui-input" style="width: 300px" id="meansdata">\
							</div>\
						</div>\
						<div class="layui-form-item layui-form-text">\
							<label class="layui-form-label">个人介绍</label>\
							<div class="layui-input-block">\
								<textarea name="bloger_introduce" v-bind:placeholder="bloger.bloger_introduce" v-bind:value="bloger.bloger_introduce" required lay-verify="required" class="layui-textarea" style="width: 600px"></textarea>\
							</div>\
						</div>\
						<div class="layui-form-item">\
							<div class="layui-input-block">\
								<button class="layui-btn" lay-submit lay-filter="meansform">立即提交</button>\
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>\
							</div>\
						</div>\
					</form>\
				</div>\
				<div class="layui-col-md7">6\
					<div>\
						<img v-bind:src="bloger.bloger_imgurl" width="200" height="200" id="loadimg">\
		                <button id="loadbtn" style="display:none">ok\
		                </button>\
					</div>\
				</div>\
			</div>\
		</div>\
	</li>\
	<li class="layui-timeline-item">\
		<i class="layui-icon layui-timeline-axis">&#xe63f;</i>\
		<div class="layui-timeline-content layui-text">\
			<h3 class="layui-timeline-title">个人标签</h3>\
			<div class="layui-row">\
				<div class="layui-col-md6 layui-col-md-offset1">\
					<div class="layui-row">\
						<fieldset class="layui-elem-field">\
							<div class="layui-col-md12" style="padding: 4px;">\
								<div class="layui-btn-group ">\
									<ul  class="myul">\
										<li v-for="hobby in hobbys" @mouseenter="toggleShow($event)" @mouseleave="toggleRemove($event)">\
											<p v-html="hobby"></p>\
											<span @click="delhobby($event)" class="layui-icon">&#x1006;</span>\
										</li>\
										<li class="layui-icon" style="padding:0"><button class="layui-btn" style="width:100%;height:100%" @click="addhobby($event)"> <i class="layui-icon">&#xe608;</i> 添加</button></li>\
									</ul>\
								</div>\
							</div>\
						</fieldset>\
					</div>\
				</div>\
			</div>\
		</div>\
	</li>\
	<li class="layui-timeline-item">\
		<i class="layui-icon layui-timeline-axis">&#xe63f;</i>\
		<div class="layui-timeline-content layui-text">\
			<h3 class="layui-timeline-title" >联系方式</h3>\
		</div>\
	</li>\
</ul>',
 
	data: function() {
		return {
			counter: data
		}
	}
		,methods:{
		addhobby:function(event){
		layer.open({
        type: 1
        ,title: false //不显示标题栏
        ,closeBtn: false
        ,area: '300px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
        ,btn: ['添加', '退出']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content: '<div style="padding: 30px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"><input type="txt" name="hobby" placeholder="标签名" class="layui-input" ></div>'
        ,btn1: function(index,layero){
        
        var v=[];
        var hobby=$.trim($("input[name='hobby']").val());
        if(hobby.length<2||hobby.length>8)
        {
        	layer.open({
        	id:'mytip',
  			type: 4,
  			shade: 0,
  			time:2000,
  	        closeBtn: false
  			,content: ['限制2-8个字符',$("input[name='hobby']")] //数组第二项即吸附元素选择器或者DOM
			});
        }
        else{
				var obj=$(event.target).parent().siblings().find("p");
				 
    for(i=0;i< obj.length;i++)
    {
      v.push(obj.eq(i).text());
    }
    v.push(hobby);
       /*alert(JSON.stringify(v));*/
      $.ajax({
			url : 'bloger/blogerData_hobby.do',
			data : {
				bloger_id : 10001,
				mydata:JSON.stringify(v)
			},
			type : 'POST', //GET
			timeout : 5000,
			success : function(data) {
				 myvue.mhobbys=eval("("+data+")");
				 layer.closeAll();
			},
			error:function(){
				
				
			}
      });
			}
        }  
      ,end:function(){
      	
      	layer.closeAll();
      }
		});
				
			}
			,delhobby:function(event){
				var v=[];
				var obj=$(event.target).parent().siblings().find("p");
				 
    for(i=0;i< obj.length;i++)
    {
      v.push(obj.eq(i).text());
    }
      $.ajax({
			url : 'bloger/blogerData_hobby.do',
			data : {
				bloger_id : 10001,
				mydata:JSON.stringify(v)
			},
			type : 'POST', //GET
			timeout : 5000,
			success : function(data) {
				 myvue.mhobbys=eval("("+data+")");
				 layer.closeAll();
			},
			error:function(){
				
				
			}
    });
				 
			}
			,toggleShow: function(event) {
            /*$(event.target).append('<span @click="ok()">x</span>');*/
           $(event.target).find("span").show();
                },
               toggleRemove: function(event) {
            $(event.target).find("span").hide();
           
                }
		}, filters: {
                    getobj: function (value) {
                        return eval("("+value+")");
                    }
                    },
		
			
});

var myvue;
includeCss('./model/css/userInfo.css');
$.ajax({
	url : 'bloger/blogerData_info.do',
	data : {
		bloger_id : 10001
	},
	type : 'POST', //GET
	timeout : 5000,
	success : function(req) {
		
		   var mdata=eval("("+req+")");
           var mblogerData=mdata;
           var hobbys=eval("("+mdata.bloger_hobby+")");
           console.log(hobbys);
		myvue = new Vue({
			el: '#userinfo',
			data: {
				blogerData: mdata,
				mhobbys: hobbys

			},
			created: function () {
				/*this.$http.get('bloger.json',{id:123})
								.then(function(res){
								this.blogerData=res.body;
								}) ;*/
			},
			mounted: function () {
				uselayui();
			}
			, methods: {

			}
		});
	}
           });

	function uselayui(){
		
		
			layui.use(['element', 'form', 'laydate', 'upload'], function() {
	var $ = layui.jquery,
		element = layui.element, //Tab的切换功能，切换事件监听等，需要依赖element模块
		laydate = layui.laydate,
		upload = layui.upload,
		form = layui.form;
  
     form.verify({
  	bloger_name: function(value, item) {
  		if(value.length < 2 || value.length > 16) {
  			return '标题至少得2——16个字符啊';
  		}

  	}
  });
				//监听提交
				form.on('submit(meansform)', function(data) {
					
					for(var o in data.field)
					{
						console.log(o);
						console.log(data.field[o]);
						if(data.field[o]==$("#myform").find("[name="+o+"]").attr("placeholder"))
						{
							delete data.field[o];
						}
					}
					
					layer.msg(JSON.stringify(data.field));
					
					
					$.ajax({
						url : 'bloger/updateBloger_info.do',
						data : data.field,
						type : 'POST', //GET
						timeout : 5000,
						success : function(msg) {
							
							 myvue.blogerData=eval("("+msg+")");
							 console.log(myvue.blogerData);
					         myvue.mhobbys=eval("("+msg.bloger_hobby+")");
							 
						},
						error:function(){
							
							
						}
			      });
					
					
					return false;
				});
  
    form.render();
    uoloadd(upload);  
    laydate.render({
					elem: '#meansdata' //指定元素
				});
});
	}
	
		function uoloadd(upload) {

		upload.render({
			elem: '#loadimg',
			url: 'bloger/blogerData_imgurl.do',
			data: {bloger_id:10001}
		    ,auto: false, //选择文件后不自动上传
			bindAction: '#loadbtn' //指向一个按钮触发上传
			,
		    before: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
		        layer.load(); //上传loading
		      }
			,choose: function(obj) {
				//将每次选择的文件追加到文件队列
				var files = obj.pushFile();
				//预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
				obj.preview(function(index, file, result) {
					var reader = new FileReader();
					//弹出一个页面层
					layer.open({
						type: 1,
						area: ['600px', '360px'],
						shadeClose: true, //点击遮罩关闭
						content: '<div style="width:200px;padding:20px;margin:0 auto;"><img id="loadview" width="200" height="200" /></div>',
						btnAlign: 'c',
						btn: ["确定上传"],
						yes: function() {
							$("#loadbtn").click();
							return false;
						},
						end: function() {
							$('#loadimg').parent().find('input').val('');
						},success:function(){
							$('#loadview').attr('src', result); //图片链接（base64）
						}
					});
				});
			},done: function(res, index, upload){
				layer.closeAll('loading'); //关闭loading
				console.log(res);
				if(res.msg===200)
					{
				$('#loadimg').attr('src', res.data);
				layer.msg('上传成功', {
			        time: 2000, //2s后自动关闭
			        end:function(){
			        	layer.closeAll()
			        }
			      });
					}
				else
					{
					layer.msg('上传失败', {
				        time: 2000, //2s后自动关闭
				        end:function(){
				        	layer.closeAll()
				        }
				      });
					}
			  },
				error: function(index, upload) {
					layer.closeAll('loading'); //关闭loading
					layer.msg('上传失败', {
				        time: 2000, //20s后自动关闭
				        end:function(){
				        	layer.closeAll()
				        }
				      });
					
				}

		})
	}
	
	