<%--
  Created by IntelliJ IDEA.
  User: 93525
  Date: 2018/12/3
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>
<div class="layui-form">
    <div class="layui-form-item">
        <label class="layui-form-label">角色名称</label>
        <div class="layui-input-block">
            <input class="layui-input" type="text" name="name" placeholder="请输入角色名称" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">选择权限</label>
        <div class="layui-input-block">
            <div id="LAY-auth-tree-index"></div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" type="submit" lay-submit lay-filter="LAY-auth-tree-submit">提交</button>
            <button class="layui-btn layui-btn-primary" type="reset">重置</button>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    layui.config({
        base: 'extends/',
    }).extend({
        authtree: 'authtree',
    });
    layui.use(['jquery', 'authtree', 'form', 'layer'], function(){
        var $ = layui.jquery;
        var authtree = layui.authtree;
        var form = layui.form;
        var layer = layui.layer;
        // 一般来说，权限数据是异步传递过来的
        $.ajax({
            url: '/tree/findMenuTree1.action',
            dataType: 'json',
            success: function(data){
                var trees = data.data;
                // 如果后台返回的不是树结构，请使用 authtree.listConvert 转换
                authtree.render('#LAY-auth-tree-index', trees, {
                    inputname: 'authids[]',
                    layfilter: 'lay-check-auth',
                    autowidth: true,
                });
            }
        });
    });
</script>
</html>