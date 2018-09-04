Vue.component("usermanagement", {
	template: 
`<div class="layui-form" style="width: 80%;margin: 0 auto;">
	<div class="layui-form-item">
		<label class="layui-form-label">
				用户ID</label>
		<div class="layui-input-block">
			<input type="text" name="user_id" lay-verify="mynumber" placeholder="请输入用户ID" class="layui-input" style="width: 200px;" />
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">用户名</label>
		<div class="layui-input-block">
			<input type="text" name="user_name" placeholder="用户名" class="layui-input" style="width: 200px;">
		</div>
		</div>
	<div class="layui-form-item">
			<label class="layui-form-label">条件筛选</label>
			<div class="layui-input-block">
				<input type="checkbox" name="oid" value="1" title="ID降序">
				<input type="checkbox" name="olasttime" value="1" title="最近登陆">
				<input type="checkbox" name="user_lock" value="1" title="锁定用户">
			</div>
		</div>
	<div class="layui-form-item">
			<button class="layui-btn" lay-submit="" lay-filter="sform" style="margin-left: 80px;margin-top: 10px;">
					搜索</button>
		</div>
</div>
 `

});
/*includeCss('./model/css/useranagement.css');*/
new Vue({
	el: "#usermanagement",
	mounted: function() {
		layui.use(['table', 'form','jquery'], function() {
			var table = layui.table;
			var form = layui.form;
			form.render(); //更新全部
			//自定义验证规则
			form.verify({
				mynumber: function(value) {

					if(value.length < 12 && value.length > 0 && isNaN(parseInt(value))) {
						return 'ID必须为数字';
					}
				}

			});
			//监听提交
			form.on('submit(sform)', function(data) {
				var mydata=data.field;
				
				//获取不为空的参数
				/*for(var o in mydata)
				{   
					if(mydata[o].length===0)
						{
						delete mydata[o];
						}
					
				}*/
				
				if(typeof(mydata.oid)==='undefined')
				{
				mydata['oid']=0;
				};
				if(typeof(mydata.oid)==='undefined')
				{
				mydata['oid']=0;
				};
				if(typeof(mydata.oid)==='undefined')
					{
					mydata['oid']=0;
					};
					if(typeof(mydata.olasttime)==='undefined')
					{
				    mydata['olasttime']=0;
					}
					if(typeof(mydata.user_lock)==='undefined')
					{
				    mydata['user_lock']=0;
					}
					
				table.reload('userReload', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where:mydata
			});
				return false;
			});
			
			//监听锁定操作
			form.on('checkbox(user_lockDemo)', function(obj) {
				var user_id=this.value;
				var user_lock=obj.elem.checked?1:0;
				$.ajax({
					url : 'bloger/user/upUserlock.do',
					data : {
						user_id : user_id,
						user_lock:user_lock
					},
					type : 'get', //GET
					timeout : 5000,
					dataType : "json",
					success : function(data) {
						 layer.msg(data.msg);
						 setTimeout(function() {
						 table.reload('userReload', {
								page: {
									curr: 1 //重新从第 1 页开始
								}
							});
						 }, 1000);
					},
					error:function(){
						
					}
				});
				
			});
			table.render({
				elem: '#usermanagementtable',
				url: 'bloger/user/getUser.do',
				cinWidth: 80,
				cols: [
					[
						{
							field: 'user_id',
							title: 'ID',
							unresize: true,
							templet:'#useridTpl',
							sort: true
						}, {
							field: 'user_name',
							title: '用户名'
						}, {
							field: 'user_sex',
							templet:'#usersexTpl',
							title: '性别'
						}, {
							field: 'user_birthday',
							title: '生日'
						}, {
							field: 'user_lasttime',
							title: '最近登陆',
							unresize: true,
							sort: true
						}, {
							field: 'user_signature',
							title: '签名'
						}, {
							field: 'user_location',
							title: '住址'
						}, {
							field: 'user_time',
							title: '注册时间'
						}, {
							field: 'user_lock',
							title: '是否锁定',
							templet: '#checklock',
							unresize: true
						}
					]
				],
				id: 'userReload',
				page: true
			});
			//执行重载
		/*	table.reload('userReload', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					
				}
			});*/
		})
	}

});