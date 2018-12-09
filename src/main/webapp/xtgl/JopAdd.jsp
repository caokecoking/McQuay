<%--
  Created by IntelliJ IDEA.
  User: 93525
  Date: 2018/11/30
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
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
        <label class="layui-form-label">角色名称</label>
        <div class="layui-input-block">
            <input type="text" placeholder="角色名称" id="JopName" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">角色职能</label>
        <div class="layui-input-block">
            <textarea name="desc" placeholder="角色职能" id="Rel" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</div>

<script>
    //Demo
    layui.use('form', function () {
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function (data1) {
            $.ajax({
                type: "POST",
                url: "/Jop/add.action",
                data: {
                    JopName: $('#JopName').val(),
                    Rel: $('#Rel').val()
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
