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
    <script src="../js/jquery.js"></script>
    <script src="../js/jquery-3.2.1.js"></script>
    <script src="../js/distpicker.data.js"></script>
    <script src="../js/distpicker.js"></script>
</head>
<body>
    <input type="hidden" id="id" value="<%=request.getParameter("id")%>"/>
    <br/>
    <div class="layui-form-item">
        <label class="layui-form-label">分公司名称</label>
        <div class="layui-input-block">
            <input type="text" placeholder="请输入分公司名称" id="CompName" autocomplete="off" class="layui-input">
        </div>
    </div>
        <label class="layui-form-label">省 / 市 / 县</label>
        <div class="layui-input-block">
            <div data-toggle="distpicker" id="distpicker">
                <select id="Prov" name="province" style="height:30px"></select>
                <select id="Dist" name="city" style="height:30px"></select>
                <select id="Coun" name="district" style="height:30px"></select>
            </div>
        </div>
    <form class="layui-form">
    <div class="layui-form-item">
        <label class="layui-form-label">详情地址</label>
        <div class="layui-input-block">
            <input type="text" placeholder="详情地址" id="CompAddress" autocomplete="off" class="layui-input">
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
            <input type="text" id="CompEmailAddress" placeholder="邮箱地址" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱密码</label>
        <div class="layui-input-block">
            <input type="text" id="CompEmailPassword" placeholder="邮箱密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>
    $(function(){
        $.ajax({
            type: "POST",
            url: "/Company/findOnlyCompany1.action",
            data: {
                Compid: $('#id').val()
            },
            dataType: "json",
            success: function (data) {
                $('#id').val(data.company.compid);
                $('#CompName').val(data.company.compName);
                $('#CompAddress').val(data.company.compAddress);
                $("#distpicker").distpicker('destroy');
                $('#distpicker').distpicker({
                    province  : data.company.Prov,
                    city  : data.company.Dist,
                    district  : data.company.Coun
                });
                $('#CompAttribute').val(data.company.compAttribute);
                $('#CompEmailAddress').val(data.company.compEmailAddress);
                $('#CompEmailPassword').val(data.company.compEmailPassword);
                layui.form.render('select');
            }
        });
    })
    //Demo
    layui.use('form', function () {
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function (data1) {
            $.ajax({
                type: "POST",
                url: "/Company/editCompany.action",
                data: {
                    Compid: $('#id').val(),
                    CompName: $('#CompName').val(),
                    CompAddress: $('#CompAddress').val(),
                    Prov: $('#province').val(),
                    Dist: $('#city').val(),
                    Coun: $('#district').val(),
                    CompAttribute: $('#CompAttribute').val(),
                    CompEmailAddress: $('#CompEmailAddress').val(),
                    CompEmailPassword: $('#CompEmailPassword').val()
                },
                dataType: "json",
                success: function (data) {
                    alert($('#id').val());
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
