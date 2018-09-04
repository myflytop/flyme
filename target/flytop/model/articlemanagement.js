Vue.component('articlemanagement', {
	props: ['msorts'],
	template: '<div class="demoTable layui-form">\
        <div class="layui-form-item" style="width:700px">\
            <div class="layui-row">\
                <div class="layui-col-md6">\
                    <label class="layui-form-label" style="word-break:keep-all; ">选择查询方式:</label>\
                    <div class="layui-input-block" style="width:100%">\
                        <select name="key" lay-filter="getchoose">\
                            <option value="0">博文标题</option>\
                            <option value="1">博文ID</option>\
                        </select>\
                    </div>\
                </div>\
                <div class="layui-col-md6">\
                    <div class="layui-input-block">\
                        <input type="text" name="article_title" lay-verify="article_title" placeholder="请输入博文标题" autocomplete="off" class="layui-input">\
                </div>\
                    </div>\
                </div>\
            </div>\
            <div class="layui-form-item" style="width:35%">\
                <label class="layui-form-label">选择分类:</label>\
                <div class="layui-input-block">\
                    <select name="sort_article_id" lay-filter="sort">\
		                <option value="" >全部</option>\
                        <option v-for="msort in msorts" v-bind:value="msort.sort_article_id" v-html="msort.sort_article_name">写作</option>\
                    </select>\
                </div>\
            </div>\
            <div class="layui-form-item">\
                <div class="layui-input-block">\
                    <button class="layui-btn" lay-submit lay-filter="artivleForm">查询</button>\
                </div>\
            </div>\
        </div>',
	methods: {

	}

});

var myvue;
includeCss('./model/css/articlemanagement.css');
myvue = new Vue({
	el: '#articlemanagement',
	data: {
		Msorts: []
	},
	mounted: function() {
		var Vthis=this;
		this.$http.get('bloger/article/getSorts.do')
								.then(function(res){
									
									Vthis.Msorts=res.body.data;
									artusevue();
								}) ;	
	}

});

function artusevue() {
	layui.use(['table', 'jquery', 'form'], function() {
		var $ = layui.jquery //重点处
			,
			form = layui.form,
			table = layui.table;
		form.verify({
			article_title: function(value, item) { //value：表单的值、item：表单的DOM对象
				if(value.length > 8) {
					return '标题不能大于8';
				}

			}

		});
		form.on('select(getchoose)', function(data) {
			if(data.value === "0") {
				$("input[name='article_id']").attr('placeholder', '请输入博文标题');
				$("input[name='article_title']").attr('lay-verify', 'article_title');
				$("input[name='article_id']").attr('name', 'article_title');
				form.render();
			} else {
				$("input[name='article_title']").attr('placeholder', '请输入博文ID');
				$("input[name='article_title']").attr('lay-verify', 'number');
				$("input[name='article_title']").attr('name', 'article_id');
				form.render();
			}
			console.log(data);
		});
		form.on('submit(artivleForm)', function(data) {
			
			
			table.reload('arttableload', {
				  where: data.field
			});
			
			return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
		table.render({
			elem: '#arttable',
			url: 'bloger/article/getArticlelist.do',
			page: true,
			limits: [10, 20, 30],
			cols: [
				[ //标题栏
					{
						title: '博文标题',
						field: 'article_title',
						width: '30%',
						templet: '#titleTpl',
						rowspan: 3
					} //rowspan即纵向跨越的单元格数
					, {
						title: '作者',
						field: 'bloger_name',
						width: '10%',
						rowspan: 3
					},

					{
						title: '所属分类',
						field: 'sort_article_name',
						width: '10%',
						rowspan: 3
					}, {
						title: '添加时间',
						field: 'article_time',
						width: '10%',
						rowspan: 3
					} //colspan即横跨的单元格数，这种情况下不用设置field和width
					, {
						title: '浏览量',
						field: 'reading_count',
						width: '8%',
						rowspan: 3
					} //colspan即横跨的单元格数，这种情况下不用设置field和width, {
					, {
						title: '评论量',
						field: 'comment_count',
						width: '8%',
						rowspan: 3
					} //
					,
					{
						title: '点赞数',
						field: 'upvote_count',
						width: '8%',
						rowspan: 3
					} //colspan即横跨的单元格数，这种情况下不用设置field和width, {
					,
					{
						title: '添加',
						align: 'center',
						width: '16%',
						toolbar: '#articlebar',
						colspan: 1
					}
				],
				[{
						title: '操作',
						align: 'center',
						colspan: 2
					}

				]
			],
			id: 'arttableload',
			done: function(res, curr, count) {
				console.log(res);
				gdata = res.data;
				console.log(gdata);
			}

		});

		table.on("tool(artdemo)", function(obj) {
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			var tr = obj.tr; //获得当前行 tr 的DOM对象
			if(layEvent === 'del') { //删除

				alert(1);

			} else {
				alert(2);
			}

		});
		$(document).on('click', '#arttable+div tr:first-child>th:last-child>div>span', function() {
			//触发事件
			layer.open({
				id: "onl",
				type: 2,
				title: 'false',
				resize: true,
				skin: 'layui-ext-myskin',
				closeBtn: 1, //显示关闭按钮
				shade: [0],
				area: ['100%', '100%'],
				offset: 'rb', //右下角弹出
				shift: 2,
				shadeClose: true,
				shade: false,
				maxmin: true, //开启最大化最小化按钮
				content: 'marketdown/examples/addAtricle.jsp', //取消、关闭按钮的回调
				cancel: function(index) {
					layer.close(index);
					parent.isClick = true;
				},
				min: function(layero) {

				}
			});

		});
		form.render(); //更新全部

	});
}