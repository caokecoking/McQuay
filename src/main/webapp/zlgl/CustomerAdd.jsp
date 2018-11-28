<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<script src="../layui/layui.js"></script>
<script src="../js/jquery-3.2.1.js"></script>
<script>
    $(function () {
        $.ajax({
            type: 'post',
            url: '../FindCustomermessageMapperDateBind.action',
            dataType: 'json',
            success: function (data) {
                $.each(data, function (index, item) {
                    $('#city').append(new Option(item.custName, item.custId));// 下拉菜单里添加元素
                });
                layui.form.render('select');
            }
        })
    })


    function CustomerAdd() {
        $.ajax({
            type: "POST",
            url: "../Findx_customerAdd.action",
            dataType: "text",
            data: {
                CName: $('#CName').val(),
                CustSeat: $('#CustSeat').val(),
                CustPhone: $('#CustPhone').val(),
                CustPartphone: $('#CustPartphone').val(),
                CustEmail: $('#CustEmail').val(),
                CustId: $('#city').val(),
            },
            success: function (data) {
                if (data > 0) {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    window.parent.location.replace(location.href);
                } else {
                    alert("增加失败");
                }
            }
        });
    }
</script>
<body>
<div class="layui-form">
    <div>
        <label style="font-size: 20px">客户联系人的增加</label>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系人名称</label>
        <div class="layui-input-block">
            <input type="text" name="CName" id="CName" placeholder="请输入" autocomplete="off" style="width: 200px"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">联系人电话号码</label>
        <div class="layui-input-block">
            <input type="text" name="CustSeat" id="CustSeat" placeholder="请输入" autocomplete="off" style="width: 200px"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系人手机号码</label>
        <div class="layui-input-block">
            <input type="text" name="CustPhone" id="CustPhone" placeholder="请输入" autocomplete="off" style="width: 200px"
                   class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">联系人分手机号码</label>
        <div class="layui-input-block">
            <input type="text" name="CustPartphone" id="CustPartphone" placeholder="请输入" autocomplete="off"
                   style="width: 200px"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">联系人电子邮件</label>
        <div class="layui-input-block">
            <input type="text" name="CustEmail" id="CustEmail" placeholder="请输入" autocomplete="off" style="width: 200px"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">服务客户</label>
        <div class="layui-input-block">
            <select id="city" name="city" lay-verify="required" lay-filter="xmFilter">
                <option value="">请选择客户</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">

        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="*" onclick="CustomerAdd();">立即提交</button>
        </div>
    </div>
</div>
</body>
</html>
