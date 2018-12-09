<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>登录界面</title>
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <script src="layui/layui.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
            function login() {
                layui.use('table', function () {
                $
                    .ajax({
                        type: "POST",
                        url: "Personnel/login.action",
                        data: {
                            PersCoding: $('#PersCoding').val(),
                            PersPassword: $('#PersPassword').val()
                        },
                        dataType: "text",
                        success: function (data) {
                            if (data == 1) {
                                layer.open({
                                    title: '提示消息',
                                    content: '登录成功' //数组第二项即吸附元素选择器或者DOM
                                });
                                location.href = 'http://localhost:8080/index2.jsp';
                            } else {
                                layer.open({
                                    title: '提示消息',
                                    content: '登录失败' //数组第二项即吸附元素选择器或者DOM
                                });
                            }
                        }
                    });
                });
            }
    </script>
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0,user-scalable=no">
    <link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="Images/style.css" type="text/css" rel="stylesheet">
    <style>
        body {
            color: #fff;
            font-family: "微软雅黑";
            font-size: 14px;
        }

        .wrap1 {
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto
        }

        /*把整个屏幕真正撑开--而且能自己实现居中*/
        .main_content {
            background: url(images/bg.jpg) repeat;
            margin-left: auto;
            margin-right: auto;
            text-align: left;
            float: none;
            border-radius: 8px;
        }

        .form-group {
            position: relative;
        }

        .login_btn {
            display: block;
            background: #3872f6;
            color: #fff;
            font-size: 15px;
            width: 100%;
            line-height: 50px;
            border-radius: 3px;
            border: none;
        }

        .login_input {
            width: 100%;
            border: 1px solid #3872f6;
            border-radius: 3px;
            line-height: 40px;
            padding: 2px 5px 2px 30px;
            background: none;
        }

        .icon_font {
            position: absolute;
            bottom: 15px;
            left: 10px;
            font-size: 18px;
            color: #3872f6;
        }

        .font16 {
            font-size: 16px;
        }

        .mg-t20 {
            margin-top: 20px;
        }

        @media ( min-width: 200px) {
            .pd-xs-20 {
                padding: 20px;
            }
        }

        @media ( min-width: 768px) {
            .pd-sm-50 {
                padding: 50px;
            }
        }

        #grad {
            background: -webkit-linear-gradient(#4990c1, #52a3d2, #6186a3);
            /* Safari 5.1 - 6.0 */
            background: -o-linear-gradient(#4990c1, #52a3d2, #6186a3);
            /* Opera 11.1 - 12.0 */
            background: -moz-linear-gradient(#4990c1, #52a3d2, #6186a3);
            /* Firefox 3.6 - 15 */
            background: linear-gradient(#4990c1, #52a3d2, #6186a3); /* 标准的语法 */
        }
    </style>
</head>

<body style="background: url(Images/bbg.jpg) no-repeat;">

<div class="container wrap1" style="height: 450px;">
    <h2 class="mg-b20 text-center">麦克维尔服务平台登录页面</h2>
    <div
            class="col-sm-8 col-md-5 center-auto pd-sm-50 pd-xs-20 main_content">
        <p class="text-center font16">用户登录</p>
        <div class="form-group mg-t20">
            <i class="icon-user icon_font"></i> <input type="text"
                                                       class="login_input" id="PersCoding" placeholder="请输入用户名"/>
        </div>
        <div class="form-group mg-t20">
            <i class="icon-lock icon_font"></i> <input type="password"
                                                       class="login_input" id="PersPassword" placeholder="请输入密码"/>
        </div>
        <button class="login_btn" onclick="login();">登 录</button>
    </div>
    <!--row end-->
</div>
<!--container end-->

</body>
</html>
