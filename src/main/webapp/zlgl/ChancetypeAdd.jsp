<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<script src="../layui/layui.js"></script>
<script src="../js/jquery.js"></script>
<script src="../js/jquery-3.2.1.js"></script>
<script src="../js/distpicker.data.js"></script>
<script src="../js/distpicker.js"></script>
<body>
<script>
    $(function () {
        $.ajax({
            type: 'post',
            url: '../Company/FindCompanyByAttribute2.action',
            dataType: 'json',
            success: function (data) {
                $.each(data.st, function (index, item) {
                    $('#Compid').append(new Option(item.CompName, item.compid));// 下拉菜单里添加元素
                });
                layui.form.render('select');
            }
        })

        $.ajax({
            type: 'post',
            url: '../FindProducttypeAlls.action',
            dataType: 'json',
            success: function (data) {
                $.each(data.s, function (index, item) {
                    $('#Ptid').append(new Option(item.ptDescribe, item.ptId));// 下拉菜单里添加元素
                });
                layui.form.render('select');
            }
        })
    })

    function ChancetypeAdd() {
        $.ajax({
            type: "POST",
            url: "../FindChancetypeAdd.action",
            dataType: "text",
            data: {
                CtName: $('#CtName').val(),
                PtId: $('#Ptid').val(),
                CtDescribe: $('#CtDescribe').val(),
                Compid: $('#Compid').val(),
                CtUnit: $('#CtUnit').val(),
                CtUnitprice: $('#CtUnitprice').val()
            },
            success: function (data) {
                if (data > 0) {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    parent.location.reload();
                } else {
                    alert("增加失败");
                }
            }
        });
    }
</script>
<br/>

<div class="layui-form-item">
    <label class="layui-form-label">机型名称</label>
    <div class="layui-input-block">
        <input type="text" name="CtName" id="CtName" placeholder="请输入" autocomplete="off"
               style="width: 200px"
               class="layui-input">
    </div>
</div>

<div class="layui-inline">
    <label class="layui-form-label">生产工厂</label>
    <div class="layui-input-block">
        <select id="Compid" style="height: 35px;">
            <option value="">请选择</option>
        </select>
    </div>
</div>

<div class="layui-inline">
    <label class="layui-form-label">产品类型</label>
    <div class="layui-input-block">
        <select id="Ptid" style="height: 35px;">
            <option value="">请选择</option>
        </select>
    </div>
</div>
<div id="distpicker" data-toggle="distpicker">


    <div class="layui-form-item">
        <label class="layui-form-label">机型描述</label>
        <div class="layui-input-block">
            <input type="text" name="CtDescribe" id="CtDescribe" placeholder="请输入" autocomplete="off"
                   style="width: 200px"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">单位</label>
        <div class="layui-input-block">
            <input type="text" name="CtUnit" id="CtUnit" placeholder="请输入" autocomplete="off" style="width: 200px"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">价格</label>
        <div class="layui-input-block">
            <input type="text" name="CtUnitprice" id="CtUnitprice" placeholder="请输入" autocomplete="off"
                   style="width: 200px"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="ChancetypeAdd();">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</div>
<script>
    //Demo
    layui.use('form', function () {
        var form = layui.form;
    });
</script>
</body>
</html>
