<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
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
            url: '../FindCustomermessageMapperDateBind.action',
            dataType: 'json',
            success: function (data) {
                $.each(data.outstr, function (index, item) {
                    $('#city').append(new Option(item.custName, item.custId));// 下拉菜单里添加元素
                });
                layui.form.render('select');
            }
        })

        $.ajax({
            type: 'post',
            url: '../FindcustomerDate.action',
            dataType: 'json',
            data: {
                Cid: $('#ids').val()
            },
            success: function (data) {
                $('#CName').val(data.c.cname);
                $('#CustSeat').val(data.c.custSeat);
                $('#CustPhone').val(data.c.custPhone);
                $('#CustPartphone').val(data.c.custPartphone);
                $('#CustEmail').val(data.c.custEmail);
                $('#city').val(data.c.custId);
                $('#Cid').val(data.c.cid);
            }
        })
    })

    function CustomerEdit() {
        $.ajax({
            type: "POST",
            url: "../Findx_customerEdit.action",
            dataType: "text",
            data: {
                CName: $('#CName').val(),
                CustSeat: $('#CustSeat').val(),
                CustPhone: $('#CustPhone').val(),
                CustPartphone: $('#CustPartphone').val(),
                CustEmail: $('#CustEmail').val(),
                CustId: $('#city').val(),
                Cid: $('#Cid').val()
            },
            success: function (data) {
                if (data > 0) {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    parent.location.reload();
                } else {
                    alert("修改失败");
                }
            }
        });
    }
</script>
<body>
<div class="layui-form">
    <input type="hidden" id="ids" value="<%=request.getParameter("ids")%>">
    <input type="hidden" id="Cid">
    <div>
        <label style="font-size: 20px">客户联系人的增加</label>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系人名称</label>
        <div class="layui-input-block">
            <input type="text" name="CName" id="CName" placeholder="请输入" autocomplete="off"
                   style="width: 200px"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">联系人电话号码</label>
        <div class="layui-input-block">
            <input type="text" name="CustSeat" id="CustSeat" placeholder="请输入" autocomplete="off"
                   style="width: 200px"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系人手机号码</label>
        <div class="layui-input-block">
            <input type="text" name="CustPhone" id="CustPhone" placeholder="请输入"
                   autocomplete="off" style="width: 200px"
                   class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">联系人分手机号码</label>
        <div class="layui-input-block">
            <input type="text" name="CustPartphone" id="CustPartphone" placeholder="请输入"
                   autocomplete="off"
                   style="width: 200px"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">联系人电子邮件</label>
        <div class="layui-input-block">
            <input type="text" name="CustEmail" id="CustEmail" placeholder="请输入"
                   autocomplete="off" style="width: 200px"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">服务客户</label>
        <div class="layui-input-block">
            <select id="city">
                <option value="">请选择客户</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">

        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="*" onclick="CustomerEdit();">立即提交</button>
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
