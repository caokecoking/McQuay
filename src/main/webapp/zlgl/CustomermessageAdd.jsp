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
<script>
    $(function () {
        $.ajax({
            type: 'post',
            url: '../Company/FindCompanyByAttribute.action',
            dataType: 'json',
            success: function (data) {
                alert(data);
                $.each(data.st, function (index, item) {
                    $('#cd').append(new Option(item.compName, item.compid));// 下拉菜单里添加元素
                });
                layui.form.render('select');
            }
        })
    })


    function CustomermessageAdd() {
        $.ajax({
            type: "POST",
            url: "../FindCustomermessageadd.action",
            dataType: "text",
            data: {
                CustName: $('#CustName').val(),
                CustProject: $('#CustProject').val(),
                Prov: $('#province').val(),
                Dist: $('#city').val(),
                Coun: $('#district').val(),
                CustAddress: $('#CustAddress').val(),
                CustType: $('#CustType').val(),
                Compid: $('#cd').val()
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
<body>
<br/>
<div id="distpicker" data-toggle="distpicker">
    <div class="layui-form-item">
        <label class="layui-form-label">省/市/区</label>
        <div class="layui-input-block">
            <select id="province" name="province" style="height: 35px;">
                <option value="">--请选择--</option>
            </select>
            <select id="city" name="city" style="height: 35px;">
                <option value="">--请选择--</option>
            </select>
            <select id="district" name="district" style="height: 35px;">
                <option value="">--请选择--</option>
            </select>
        </div>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">客户详细地址</label>
    <div class="layui-input-block">
        <input type="text" name="CustAddress" id="CustAddress" placeholder="请输入" autocomplete="off"
               style="width: 200px"
               class="layui-input">
    </div>
</div>
<div class="layui-form">
    <div class="layui-form-item">
        <label class="layui-form-label">客户名称</label>
        <div class="layui-input-block">
            <input type="text" name="CustName" id="CustName" placeholder="请输入" autocomplete="off" style="width: 200px"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">项目名称</label>
        <div class="layui-input-block">
            <input type="text" name="CustProject" id="CustProject" placeholder="请输入" autocomplete="off"
                   style="width: 200px"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">客户类型</label>
        <div class="layui-input-block">
            <select id="CustType">
                <option value="">请选择</option>
                <option value="普通用户">普通用户</option>
                <option value="VIP客户">VIP客户</option>
            </select>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">提供商</label>
        <div class="layui-input-block">
            <select id="cd">
                <option value="">请选择</option>
            </select>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="CustomermessageAdd();">立即提交</button>
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
