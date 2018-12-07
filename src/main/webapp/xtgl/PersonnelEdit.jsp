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
            <input type="text" placeholder="员工名称" id="PersName" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="text" placeholder="密码" id="PersPassword" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="text" placeholder="性别" id="Sex" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">工作中心</label>
        <div class="layui-input-block">
            <input type="text" placeholder="工作中心" id="WorkCenter" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">电话号码</label>
        <div class="layui-input-block">
            <input type="text" placeholder="电话号码" id="Phone" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">电子邮件</label>
        <div class="layui-input-block">
            <input type="text" placeholder="电子邮件" id="Email" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">公司</label>
        <div class="layui-input-block">
            <select id="Compid" lay-submit lay-filter="Comp">
                <option value="">--请选择--</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">部门</label>
        <div class="layui-input-block">
            <select id="Deptid" lay-submit lay-filter="Dept">
                <option value="">--请选择--</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">职位</label>
        <div class="layui-input-block">
            <select id="Jopid">
                <option value="">--请选择--</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</div>


<script >
    layui.use('form', function () {
        var form = layui.form;
        form.on('select(Comp)', function (data) {
            if (data.value != null) {
                $.ajax({
                    async: false,
                    type: "POST",
                    url: "/department/findAllByCompid.action",
                    dataType: "json",
                    data: {
                        name: data.value,
                        page: 0,
                        limit: 1000
                    },
                    success: function (data) {
                        var option = "";
                        $("#Deptid").empty();
                        for (var i = 0; i < data.length; i++) {
                            option = "<option value=\"" + data[i].Deptid + "\" >" + data[i].DeptName + "</option>"; //动态添加数据
                            $("#Deptid").append(option);
                        }
                        layui.form.render('select');
                    }
                })
            }
        });
        form.on('select(Dept)', function (data) {
            if (data.value != null) {
                $.ajax({
                    async: false,
                    type: "POST",
                    url: "/Jop/findAllByDeptid.action",
                    dataType: "json",
                    data: {
                        name: data.value,
                        page: 0,
                        limit: 1000
                    },
                    success: function (data) {
                        var option = "";
                        $("#Jopid").empty();
                        for (var i = 0; i < data.length; i++) {
                            option = "<option value=\"" + data[i].jopId + "\" >" + data[i].JopName + "</option>"; //动态添加数据
                            $("#Jopid").append(option);
                        }
                        layui.form.render('select');
                    }
                })
            }
        });
    });
</script>
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
            $("#Compid").val(data.sc[0].Compid);
            var option1 = "<option value=\"" + data.sd[0].Deptid + "\" selected='selected'>" + data.sd[0].DeptName + "</option>"; //动态添加数据
            $("#Deptid").append(option1);
            var option2 = "<option value=\"" + data.sj[0].JopId + "\" selected='selected'>" + data.sj[0].JopName + "</option>"; //动态添加数据
            $("#Jopid").append(option2);
            layui.form.render('select');
        }
    });
    $(function() {
        $.ajax({
            async: false,
            type: "POST",
            url: "/Company/findAll.action",
            dataType: "json",
            data: {
                page: 0,
                limit: 1000
            },
            success: function (res) {
                $("#Compid").empty();
                for (var i = 0; i < res.data.length; i++) {
                    var option = "<option value=\"" + res.data[i].compid + "\" >" + res.data[i].compName + "</option>"; //动态添加数据
                    $("#Compid").append(option);
                }
            }
        });
    });
    //Demo
    layui.use('form', function () {
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function (data) {
            $.ajax({
                type: "POST",
                url: "/Personnel/edit.action",
                data: {
                    PersId: $('#PersId').val(),
                    PersName: $('#PersName').val(),
                    PersPassword: $('#PersPassword').val(),
                    Sex: $('#Sex').val(),
                    WorkCenter: $('#WorkCenter').val(),
                    Phone: $('#Phone').val(),
                    Email: $('#Email').val(),
                    name: $('#Compid').val(),
                    startTime: $('#Deptid').val(),
                    endTime: $('#Jopid').val()
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
