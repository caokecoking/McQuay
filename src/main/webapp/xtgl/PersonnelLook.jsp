<%--
  Created by IntelliJ IDEA.
  User: 93525
  Date: 2018/12/1
  Time: 14:50
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
<br/>
<div class="layui-form">
    <input type="hidden" name="PersId" id="PersId" value="<%=request.getParameter("PersId")%>">
    <div class="layui-form-item">
        <label class="layui-form-label">员工名称</label>
        <div class="layui-input-block">
            <input type="text" placeholder="员工名称"   readonly="readonly" id="PersName" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="text" placeholder="密码"  readonly="readonly" id="PersPassword" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="text" placeholder="性别"  readonly="readonly" id="Sex" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">工作中心</label>
        <div class="layui-input-block">
            <input type="text" placeholder="工作中心"  readonly="readonly" id="WorkCenter" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">电话号码</label>
        <div class="layui-input-block">
            <input type="text" placeholder="电话号码"  readonly="readonly" id="Phone" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">电子邮件</label>
        <div class="layui-input-block">
            <input type="text" placeholder="电子邮件"  readonly="readonly" id="Email" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">公司</label>
        <div class="layui-input-block">
            <input type="text" placeholder="电子邮件"  readonly="readonly" id="Compid" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">部门</label>
        <div class="layui-input-block">
            <input type="text" placeholder="电子邮件"  readonly="readonly" id="Deptid" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">职位</label>
        <div class="layui-input-block">
            <input type="text" placeholder="电子邮件"  readonly="readonly" id="Jopid" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">返回</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</div>

<script>
    $.ajax({
        type: "POST",
        url: "/Personnel/findOnly.action",
        data: {
            PersId: $('#PersId').val()
        },
        dataType: "json",
        success: function (data) {
            $('#PersId').val(data.PersId);
            $('#PersName').val(data.PersName);
            $('#PersPassword').val(data.PersPassword);
            $('#Sex').val(data.Sex);
            $('#WorkCenter').val(data.WorkCenter);
            $('#Phone').val(data.Phone);
            $('#Email').val(data.Email);
            $('#TeleFax').val(data.TeleFax);
            $("#Compid").val(data.sc[0].CompName);
            $("#Deptid").val(data.sd[0].DeptName);
            $("#Jopid").val(data.sj[0].JopName);
        }
    });
    //Demo
    layui.use('form', function () {
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function (data) {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    parent.location.reload();
        });

    });
</script>

</body>
</html>
