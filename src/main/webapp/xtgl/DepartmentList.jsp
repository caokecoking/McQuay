<%--
  Created by IntelliJ IDEA.
  User: 93525
  Date: 2018/11/29
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<script src="../layui/layui.js"></script>
<script type="text/html" id="barDemo">
    <a id="query" class="layui-btn layui-btn-xs" lay-event="detail">查看职务</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit" >编辑</a>
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="layui-inline">
    <input name="id" class="layui-input" placeholder="部门名称" id="DeptName" type="text">
</div>
<button class="layui-btn" data-type="reload">搜索</button>
<table id="demo" lay-filter="test"></table>
<script>
    layui.use('table', function () {
        var table = layui.table;
        var layEvent = table.event;
        //第一个实例
        table.render({
            elem: '#demo',
            id: 'testReload'
            , height: '500px'
            , toolbar: 'default'
            , url: '/department/findAll.action' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'DeptCoding', title: '部门编码', width: '15%', sort: true, fixed: 'left'}
                , {field: 'DeptName', title: '部门名称', width: '15%'}
                , {fixed: 'right', title: '操作', width: '20%', align: 'center', toolbar: '#barDemo'}
            ]], limits: [5, 10, 15, 20],
            limit: 5

        });
        //数据重载（查询）
        var $ = layui.$, active = {
            reload: function () {
                //执行重载
                table.reload('testReload', {
                    url: '/department/findAll.action',
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        DeptName: $('#DeptName').val()
                    }
                });
            }
        };

        $('.layui-table-tool-temp .layui-inline').on('click',function(){
            layer.open({
                title: '增加岗位',
                type : 2,
                content: 'DepartmentAdd.jsp', //数组第二项即吸附元素选择器或者DOM
                area :['600px','160px']
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
                    title: '查看职务',
                    type : 2,
                    content: 'JopList.jsp?Deptid='+data.Deptid, //数组第二项即吸附元素选择器或者DOM
                    area :['600px','160px']
                });
            }  else if (layEvent === 'edit') {
                layer.open({
                    title: '修改职务',
                    type : 2,
                    content: 'DepartmentEdit.jsp?Deptid='+data.Deptid, //数组第二项即吸附元素选择器或者DOM
                    area :['600px','160px']
                });
            }
        });
    });
</script>
</body>
</html>
