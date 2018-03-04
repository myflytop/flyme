var initindex = {
    /* 初始化导航 */
    initnav: function () {
        $('.my-nav-style').fadeIn();
        if ($(window).width() < 769) {
            $("#main-nav").addClass("layui-nav-tree");
            $('#nav-login').removeClass('layui-layout-right');
            $(".my-nav-style").css({
                'width': '120px',
                'top': '60px',
                'left': '-120px',
                'height': '100vh'
            });
            $(".nav-logo").css({
                'position': 'static'
            });
            $('.nav-btn').show();
        } else {
            $("#main-nav").removeClass("layui-nav-tree");
            $("#nav-login").removeClass("layui-nav-itemed");
            $(".nav-logo").css({
                'position': 'fixed'
            });
            $('#nav-login').addClass('layui-layout-right');
            $('.my-nav-style').css({
                'left': '0px',
                'top': '0px',
                'width': '100%',
                'height': '60px'
            });
            $('.nav-btn').hide();
        }
    },
    /* 按钮折叠事件 */
    navbtn: function () {
        if ($('.my-nav-style').offset().left === (-120)) {
            $('.my-nav-style').animate({
                left: '0px'
            }, function () {
                console.log('open');
            });
        } else {
            $('.my-nav-style').animate({
                left: '-120px'
            }, function () {
                console.log('close');
            });
        }
    },
   /*  登陆弹框 */
    login: function (layer,form) {
        //示范一个公告层
        layer.open({
            type: 1,
            title: false //不显示标题栏
            ,
            offset: '100px',
            closeBtn: true,
            area: 'auto',
            shade: 0.8,
            id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,
            btnAlign: 'c',
            moveType: 0 //拖拽模式，0或者1
            ,
            content: $("#inmodel").html(),
            success: function (layero) {
                var slider = new SliderUnlock("#slider", {
                    successLabelTip: "验证成功"
                }, function () {
                    var loginbtn = $("#loginbtn");
                    loginbtn.removeClass('layui-btn-disabled');
                    loginbtn.attr('disabled', false);
                    console.log(1);
                });
                slider.init();
                form.render();
            }
        });

    },
    /* 退出事件 */
    logout: function() {
        var ucookie1=$.cookie('ucookie');
        if(ucookie1!="null"&&ucookie1!="undefined")
            {
            }
        else{
            ucookie1=-1;
        }
        $.ajax({
            data:{user_id:ucookie1},
            type:"get",
            url:'user/login/logoutUser.do',
            async:true,
            dataType:"json",
            success:function(data,textStatus){
                console.log(data);
             if(data.msg==="unlike")
                    {
                    $.cookie('ucookie',null);
                     window.location.reload();
                    
                    }
                else
                    {
                    $.cookie('ucookie',null);
                     window.location.reload();
                    }
            },
            error:function(XMLHttpRequest,textStatus,errorThrow){
             console.log(1);
            }
        });     
    },
    /* 初始化表单事件 */
    initform:function(form,layer,laytpl,element){
        form.on('submit(loginDemo)', function(data) {     
                $.ajax({
                data:data.field,
                type:"post",
                url:'user/login/loginUser.do',
                async:true,
                dataType:"json",
                success:function(data,textStatus){
                	console.log(data)
                    if(data.msg==="loginSuccess")
                    {   layer.msg("登陆成功！");
                        $.cookie('ucookie', data.data);
                        
                        
                        setInterval(function() {
                        	 window.location.reload();
                        }, 1000);
                        /*layer.closeAll();
                        initindex.initcook(laytpl,element);*/
                       
                    }
                    else
                    	{     	
                    	layer.msg("登陆失败");
                    	 setInterval(function() {
                        	 window.location.reload();
                        }, 1000);
                    	}
                },
                error:function(XMLHttpRequest,textStatus,errorThrow){
                 console.log(1);
                }
            });
            
            return false;
        });
        //监听提交
        form.on('submit(getcodeDemo)', function(data) {
            var getcode=$("#getcode");
            var getusermail=$("input[name='user_mail']");
            getcode.attr('disabled',true);
            getcode.addClass("layui-btn-disabled");
            getusermail.addClass("layui-disabled");
            getusermail.attr('disabled',true);	
                $.ajax({
                data:data.field,
                type:"get",
                url:'user/reg/getCode.do',
                async:true,
                success:function(data,textStatus){          	 
                    console.log(data);
                    if(data==="sendSuccess")
                    {   layer.msg("发送成功！");
                    	var eqcode=$('#eqcode');
                        var cond=$("input[name='code']");
                        cond.attr('disabled',false);
                        cond.removeClass("layui-disabled");
                        eqcode.removeClass("layui-btn-disabled");
                        eqcode.attr('disabled',false);	
                    }
                    else{
                    	 setInterval(function() {
                        	 window.location.reload();
                        }, 1000);
                    }
                      
                },
                error:function(XMLHttpRequest,textStatus,errorThrow){
                 console.log(1);
                }
            });
            return false;
        });
            form.on('submit(eqcodeDemo)', function(data) {
                var eqdata=data.field;
                eqdata['user_mail']=$("input[name='user_mail']").val();
                $.ajax({
                data:eqdata,
                type:"get",
                url:'user/reg/eqCode.do',
                async:true,
                success:function(data,textStatus){
                    console.log(data);     
                    if(data==="codeOK")
                    { layer.msg("验证成功！");
                        var iokreg=$('#iokreg');
                        var eqcode=$('#eqcode');
                        var cond=$("input[name='code']");
                        var user_pas=$("input[name='user_pas']");
                        cond.attr('disabled',true);
                        cond.addClass("layui-disabled");
                        eqcode.addClass("layui-btn-disabled");
                        eqcode.attr('disabled',true);
                        user_pas.attr('disabled',false);
                        user_pas.removeClass("layui-disabled");
                        iokreg.attr('disabled',false);
                        form.render(); //更新全部
                        form.render('checkbox'); //刷新select选择框渲染form
                        
                        
                    }
                    else{
                    	layer.msg("验证失败！");
                    	 setInterval(function() {
                        	 window.location.reload();
                        }, 1000);
                    }
                      
                },
                error:function(XMLHttpRequest,textStatus,errorThrow){
                 console.log(1);
                }
            });
            return false;
        });
        form.on('switch(iokreg)', function(data) {
            var regbtn=$("#regbtn");
            console.log(data.elem);
            console.log(data.elem.checked);
            if(data.elem.checked)
            {$('#iokreglab').text("我同意");
            
            regbtn.removeClass('layui-btn-disabled');
            regbtn.attr('disabled',false);}
            
            else
            {$('#iokreglab').text("我不同意");
            regbtn.addClass('layui-btn-disabled');
            regbtn.attr('disabled',true);
            
            }
        });
        
      //监听提交
        form.on('submit(regDemo)', function(data) {
            
            var regdata=data.field;
            regdata['code']=$("input[name='code']").val();
            regdata['user_mail']=$("input[name='user_mail']").val();
            $.ajax({
                data:regdata,
                type:"get",
                url:'user/reg/regUser.do',
                async:true,
                success:function(data,textStatus){
                    console.log(data);
                    if(data==="regOK")
                    {
                       layer.msg("注册成功！");
                        
                    }
                    else{
                    	layer.msg("注册失败！");
                    }
                  setInterval(function() {
                   	 window.location.reload();
                   }, 1000);
                },
                error:function(XMLHttpRequest,textStatus,errorThrow){
                 console.log(1);
                }
            });
            return false;
        });
    },
    initcook:function(laytpl,element){
            $.ajax({
             	type:"get",
             	url:"user/basic/tgetuser.do",
             	dataType:'json',
             	async:true,
             	success:function(data)
             	{  
             		console.log(data);
             		if(data.user===-1)
             		{
             		 $.cookie('ucookie','undefined');
             		}
             	else {
             		$.cookie('ucookie',data.user);
             	}
             	 ucookie = $.cookie('ucookie');
             	laytpl($("#loginmodel").html()).render(ucookie, function (modelhtml) {
                    $("#nav-login").empty();
                    $("#nav-login").append(modelhtml);
                    element.init();
                });
             	},
             	 error:function(jqXHR,textStatus,err){
                 console.log('请求错误');
                 console.log(jqXHR);
                 console.log(textStatus);
                 console.log(err);
                   }

                });
            
    },
    boolenlogin:function(){
    	ucookie =$.cookie('ucookie');
    	 if(ucookie === undefined ||ucookie==null)
    		 {
    		 return false;
    		 }
    	 else
    		 {
    		 return true;
    		 }
    }
}
