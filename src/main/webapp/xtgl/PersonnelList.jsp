<%--
  Created by IntelliJ IDEA.
  User: 93525
  Date: 2018/11/30
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<script src="../layui/layui.js"></script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit" >编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="layui-inline">
    <input name="id" class="layui-input" placeholder="员工名称" id="PersName" type="text">
</div>
<button class="layui-btn" data-type="reload">搜索</button>
<table id="demo" lay-filter="test"></table>

<script type="text/html" id="CompName">
    {{d.sc[0].CompName }}
</script>
<script type="text/html" id="DeptName">
    {{d.sd[0].DeptName }}
</script>
<script type="text/html" id="JopName">
    {{d.sj[0].JopName }}
</script>
<script>
    layui.use('table', function () {
        var table = layui.table;
        var layEvent = table.event;
        //第一个实例
        table.render({
            elem: '#demo',
            id: 'testReload'
            , height: '600px'
            , toolbar: 'default'
            , url: '/Personnel/findAll.action' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'PersCoding', title: '员工编码', width: '8%', sort: true, fixed: 'left'}
                , {field: 'PersName', title: '员工名称', width: '8%'}
                , {field: 'Sex', title: '性别', width: '8%'}
                , {field: 'Phone', title: '电话', width: '8%'}
                , {field: 'Email', title: '电子邮箱', width: '10%'}
                , {field: 'sc[0].CompName', title: '所属分公司', width: '12%',templet:'#CompName'}
                , {field: 'sd[0].DeptName', title: '所属部门', width: '12%',templet:'#DeptName'}
                , {field: 'sj[0].JopName', title: '岗位', width: '12%',templet:'#JopName'}
                , {field: 'Hiredate', title: '参加工作时间', width: '12%'}
                , {fixed: 'right', title: '操作', width: '10%', align: 'center', toolbar: '#barDemo'}
            ]], limits: [5, 10, 15, 20],
            limit: 5

        });
        //数据重载（查询）
        var $ = layui.$, active = {
            reload: function () {
                //执行重载
                table.reload('testReload', {
                    url: '/Personnel/findAll.action',
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        PersName: $('#PersName').val()
                    }
                });
            }
        };

        $('.layui-table-tool-temp .layui-inline').on('click',function(){
            layer.open({
                title: '增加岗位',
                type : 2,
                content: 'PersonnelAdd.jsp', //数组第二项即吸附元素选择器或者DOM
                area :['600px','700px']
            });
        });
        $('.layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
        //监听行工具事件
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'detail') {
                layer.open({
                    title: '查看员工信息',
                    type : 2,
                    content: 'PersonnelLook.jsp?PersId='+data.PersId, //数组第二项即吸附元素选择器或者DOM
                    area :['600px','700px']
                });
            }else if (layEvent === 'del') {
                layer.confirm('真的删除该员工信息吗？', function (index) {
                    if(index>0){
                        $.ajax({
                            type: "POST",
                            url: "/Personnel/remove.action",
                            data: {
                                PersId: data.PersId
                            },
                            dataType: "json",
                            success: function (data) {
                                table.reload('testReload', {
                                    url: '/Personnel/findAll.action',
                                    page: {
                                        curr: 1 //重新从第 1 页开始
                                    }
                                    , where: {
                                        PersName: $('#PersName').val()
                                    }
                                });
                                parent.layer.close(index);
                            }
                        });
                    }
                });
            }  else if (layEvent === 'edit') {
                layer.open({
                    title: '修改职务',
                    type : 2,
                    content: 'PersonnelEdit.jsp?PersId='+data.PersId, //数组第二项即吸附元素选择器或者DOM
                    area :['600px','700px']
                });
            }
        });
    });
</script>
</body>
</html>