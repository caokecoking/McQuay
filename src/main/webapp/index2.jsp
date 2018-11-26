<%--
  Created by IntelliJ IDEA.
  User: 93525
  Date: 2018/11/24
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<link rel="stylesheet" href="layui/css/layui.css" media="all">
<link rel="stylesheet" href="tree.css">
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">McQuay服务平台</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul id="tree"></ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->

        <div class="layui-tab"  lay-filter="demo" lay-allowclose="true">
            <ul class="layui-tab-title">
                <li lay-id="ss" class="layui-this" >首页</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show"></div>
            </div>
        </div>


        <div class="layui-footer">
            <!-- 底部固定区域 -->

        </div>
    </div>


    <script type="text/javascript">
        /*树菜单*/
        $.ajax({
            type: "post",
            url: "/tree/findMenuTree.action",
            datatype: "json",
            success: function (data) {
                layui.use(['tree','element'], function(){
                    var element=layui.element;
                    layui.tree({
                        elem: '#tree' //传入元素选择器
                        ,skin:'sidebar'
                        ,nodes:data
                        ,click:function(node){
                            if(node.mpath!=null){
                                var exist=$("li[lay-id='"+node.id+"']").length;
                                if(exist==1){   //tab已经打开
                                    element.tabChange('demo', node.id); //切换到：用户管理
                                }else{    //tab没有打开
                                    //新增一个Tab项
                                    element.tabAdd('demo', {
                                        title: node.name //用于演示
                                        ,content:'<iframe frameborder="0" src="'+node.mpath+'" style="width: 100%;height:100%;"></iframe>'
                                        ,id:node.id//实际使用一般是规定好的id，这里以时间戳模拟下
                                    })
                                    //展开tab下的内容
                                    element.tabChange('demo', node.id); //切换到：用户管理
                                }
                            }
                        }
                    });
                });
            }
        });
    </script>
    <%--按钮--%>
    <script type="text/html" id="barDemo" >
        <a   class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
        <a class="layui-btn layui-btn-xs" lay-event="update">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
    </script>
</body>
</html>
