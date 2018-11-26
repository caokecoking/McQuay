<%--
  Created by IntelliJ IDEA.
  User: 93525
  Date: 2018/11/26
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../layui/css/layui.css" media="all">
    <script src="../layui/layui.js"></script>
    <script src="../js/distpicker.data.js"></script>
    <script src="../js/distpicker.js"></script>
</head>
<body>
<form class="layui-form" action="/Company/addCompany.action">
    <br/>
    <div class="layui-form-item">
        <label class="layui-form-label">分公司名称</label>
        <div class="layui-input-block">
            <input type="text" placeholder="请输入分公司名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div data-toggle="distpicker">
        <%--<div class="layui-form-item">--%>
            <%--<label class="layui-form-label">省/直辖市</label>--%>
            <%--<div class="layui-input-block">--%>
                <%--<select id="province" name="province"></select>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="layui-form-item">--%>
            <%--<label class="layui-form-label">地区/市</label>--%>
            <%--<div class="layui-input-block">--%>
                <%--<select id="city" name="city"></select>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="layui-form-item">--%>
            <%--<label class="layui-form-label">市/县</label>--%>
            <%--<div class="layui-input-block">--%>
                <%--<select id="district" name="district"></select>--%>
            <%--</div>--%>
        <%--</div>--%>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">详情地址</label>
        <div class="layui-input-block">
            <input type="text" placeholder="详情地址" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">属性</label>
        <div class="layui-input-block">
            <select id="CompAttribute">
                <option value="">--请选择--</option>
                <option value="工厂">工厂</option>
                <option value="销售公司">销售公司</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱地址</label>
        <div class="layui-input-block">
            <input type="text" placeholder="邮箱地址" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱密码</label>
        <div class="layui-input-block">
            <input type="text" placeholder="邮箱密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" type="submit">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>
    //Demo
    layui.use('form', function () {
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</body>
</html>
