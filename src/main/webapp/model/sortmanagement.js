Vue.component("sortmanagement",{
	template:
	    '<table class="layui-hide" id="sorttable" lay-filter="sortdemo"></table>'
		
});
includeCss('./model/css/sortManagement.css');
function nosp(t){
    if(2<t.length&&t.length<12)
        return true;
    else
    return false;	
};
new Vue(
    {
        el: "#sortmanagement",
        mounted: function () {

            layui.use(['table', 'jquery'], function () {
                var $ = layui.jquery //重点处
                    ,
                    table = layui.table;
                var gdata = [];
                var sortdo = {

                    addsort: function (iurl, idata) {
                        return this.doajax(iurl, idata, 'addsort');
                    },
                    resort: function (iurl, idata) {
                        return this.doajax(iurl, idata, 'resort');
                    },
                    delsort: function (iurl, idata) {
                        return this.doajax(iurl, idata, 'delsort');
                    },
                    doajax: function (iurl, idata, operate) {
                        var v_this = this;
                        var re;
                        $.ajax({
                            type: "post",
                            url: iurl,
                            data: idata,
                            dataType: "json",
                            async: false,
                            success: function (data, textStatus, jqXHR) {

                                switch (operate) {
                                    case 'addsort':
                                        if (data.hasOwnProperty("data")) {

                                            gdata.push(data.data);
                                            v_this.tableready(gdata, "");
                                            console.log(operate);
                                            re = "success";
                                        } else {
                                            re = "fial";
                                        }
                                        break;
                                    case 'resort':
                                        if (data.hasOwnProperty("data")) {
                                            v_this.redata(data.data);
                                            v_this.tableready(gdata, "");
                                            re = 'success';
                                        } else {
                                            return "fial";
                                        }
                                        break;
                                    case 'delsort':
                                        if (data.code === "success") {
                                            v_this.deldata(idata.sort_article_id);
                                            v_this.tableready(gdata, "");
                                            console.log(operate);
                                            re = "success";
                                        }
                                        else {
                                            re = "fail";
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            },
                            error: function (XMLHttpRequest, textStatus, errorThrown) {
                                console.log("请求失败");
                                re = "fail";
                            }
                        });
                        return re;
                    },
                    tablereload: function (mdata, murl) {


                    },
                    tableready: function (mdata, murl) {
                        table.render({
                            elem: '#sorttable',
                            limit: mdata.length,
                            url: murl,
                            data: mdata,
                            cols: [
                                [ //标题栏
                                    {
                                        title: '分类ID',
                                        field: 'sort_article_id',
                                        width: '20%',
                                        sort: true,
                                        rowspan: 3
                                    } //rowspan即纵向跨越的单元格数
                                    , {
                                        title: '分类名',
                                        field: 'sort_article_name',
                                        width: '20%',
                                        rowspan: 3
                                    }, {
                                        title: '添加时间',
                                        field: 'sort_article_time',
                                        width: '20%',
                                        rowspan: 3
                                    } //colspan即横跨的单元格数，这种情况下不用设置field和width
                                    , {
                                        title: '修改时间',
                                        field: 'sort_article_retime',
                                        width: '20%',
                                        rowspan: 3
                                    } //colspan即横跨的单元格数，这种情况下不用设置field和width, {
                                    , {
                                        title: '添加',
                                        align: 'center',
                                        width: '20%',
                                        toolbar: '#barsort',
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
                            id: 'tabrload',
                            done: function (res, curr, count) {
                                console.log(res);
                                gdata = res.data;
                                console.log(gdata);
                            }

                        })
                    },
                    deldata: function (sortID) {

                        gdata.forEach(function (ele, index) {
                            if (ele.sort_article_id === sortID) {
                                gdata.splice(index, 1);
                                return false;
                            }
                        });
                        console.log(gdata);
                    },
                    redata: function (adata) {
                        gdata.forEach(function (ele, index) {
                            if (ele.sort_article_id === adata.sort_article_id) {
                                gdata.splice(index, 1, adata);
                                return false;
                            }
                        })
                        console.log(gdata);
                    }
                };


                sortdo.tableready({}, 'bloger/sort/getSorts.do');


                table.on('tool(sortdemo)', function (obj) {
                    var data = obj.data;
                    var dataobj = {};
                    dataobj.sort_article_id = data.sort_article_id;
                    if (obj.event === 'del') {
                        layer.confirm('真的删除行么', function (index) {

                            if (sortdo.delsort('bloger/sort/delSort.do', dataobj) === 'success') {

                                /*  obj.del(); */
                                layer.msg('删除成功');

                            }
                            else {
                                layer.msg('删除失败');

                            }
                            layer.close(index);
                        });
                    }
                    else {
                        var dataobj = {};
                        dataobj.sort_article_id = data.sort_article_id;
                        layer.prompt({
                            formType: 0,
                            value: data.sort_article_name,
                            title: '修改ID为' + data.sort_article_id + '的分类名',
                            area: ['160px', '20px'] //自定义文本域宽高
                            , cancel: function (index, layero) {
                                layer.closeAll();
                                return false;
                            }
                        }, function (value, index, elem) {
                        	
                            value = value.replace(/\s/g, "");
                            if (!nosp(value)) {
                                layer.open({
                                    id: 'sorttip',
                                    type: 4,
                                    shade: 0,
                                    time: 2000,
                                    closeBtn:false,
                                    content: ['有效字符2—12', elem] //数组第二项即吸附元素选择器或者DOM
                                });
                            }
                            else {
                                dataobj.sort_article_name = value;
                                if (sortdo.resort('bloger/sort/reSortname.do', dataobj) === 'success') {

                                    /*  obj.del(); */
                                    layer.msg('修改成功');

                                }
                                else {
                                    layer.msg('修改失败');

                                }
                                layer.close(index);
                            }
                        });

                        /* layer.alert('编辑行：<br>'+ JSON.stringify(data)); */
                    }

                });


                $(document).on('click', '#sorttable+div tr:first-child>th:last-child>div>span', function () {
                    layer.open({
                        type: 1,
                        title: false //不显示标题栏
                        ,
                        closeBtn: false,
                        area: '300px;',
                        shade: 0.8,
                        id: 'LAY_layuipro' //设定一个id，防止重复弹出
                        ,
                        btn: ['添加', '退出'],
                        btnAlign: 'c',
                        moveType: 1 //拖拽模式，0或者1
                        ,
                        content: '<div style="padding: 30px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"><input type="txt" name="sort_article_name" placeholder="标签名" class="layui-input" ></div>',
                        btn1: function (index, layero) {
                            var addobj = {};
                            var sort_article_name = $.trim($("input[name='sort_article_name']").val());
                            sort_article_name.replace(/\s/g, "");
                            if (!nosp(sort_article_name)) {
                                layer.open({
                                    id: 'mytip',
                                    type: 4,
                                    shade: 0,
                                    time: 2000,
                                    closeBtn: false,
                                    content: ['有效2-12个字符', $("input[name='sort_article_name']")] //数组第二项即吸附元素选择器或者DOM
                                });
                            }
                            else {
                                addobj.sort_article_name = sort_article_name;
                                if (sortdo.addsort('bloger/sort/addSort.do', addobj) === 'success') {

                                    /*  obj.del(); */
                                    layer.msg('添加成功');

                                }
                                else {
                                    layer.msg('添加失败');

                                }
                                layer.close(index);
                            }
                        },
                        end: function () {


                        }
                    });
                });
            })
        }

	});