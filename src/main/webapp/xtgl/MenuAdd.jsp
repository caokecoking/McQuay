<%--
  Created by IntelliJ IDEA.
  User: 93525
  Date: 2018/12/4
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../layui/css/layui.css" media="all">
    <script src="../layui/layui.js"></script>
    <script src="../js/jquery.js"></script>
    <script src="../js/jquery-3.2.1.js"></script>
    <script src="../js/distpicker.data.js"></script>
    <script src="../js/distpicker.js"></script>
</head>
<body>
<div class="layui-form">
    <br/>
    <div class="layui-form-item">
        <label class="layui-form-label">菜单名称</label>
        <div class="layui-input-block">
            <input type="text" placeholder="菜单名称" id="MenuName" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">父级菜单</label>
        <div class="layui-input-block">
            <select id="MenuParent"></select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">菜单地址</label>
        <div class="layui-input-block">
            <input type="text" placeholder="菜单地址" id="MenuPath" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</div>

<script>$(function () {
    $.ajax({
        async: false,
        type: "POST",
        url: "/Menu/findParentMenuAll1.action",
        dataType: "json",
        data: {
            page: 0,
            limit: 1000
        },
        success: function (res) {
            var opt = "<option value='-1' selected = \'selected\'>--请选择--</option>";
            $("#MenuParent").append(opt);
            for (var i = 0; i < res.data.length; i++) {
                var option = "<option value=\"" + res.data[i].MenuId + "\"";
                option += ">" + res.data[i].MenuName + "</option>"; //动态添加数据
                $("#MenuParent").append(option);
            }
        }
    });
});
    //Demo
    layui.use('form', function () {
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function (data1) {
            $.ajax({
                type: "POST",
                url: "/Menu/addMenu.action",
                data: {
                    MenuName: $('#MenuName').val(),
                    MenuParent: $('#MenuParent').val(),
                    MenuPath: $('#MenuPath').val()
                },
                dataType: "text",
                success: function (data) {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    parent.location.reload();
                }
            });
        });

    });
</script>

</body>
</html>

