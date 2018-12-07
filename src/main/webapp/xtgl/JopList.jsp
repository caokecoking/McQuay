<%--
  Created by IntelliJ IDEA.
  User: 93525
  Date: 2018/11/30
  Time: 9:16
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
    <input name="id" class="layui-input" placeholder="职位名称" id="JopName" type="text">
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
            , url: '/Jop/findAll.action' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'JopId', title: '职位编码', width: '15%', sort: true, fixed: 'left'}
                , {field: 'JopName', title: '职位名称', width: '15%'}
                , {field: 'Rel', title: '职位职能', width: '15%'}
                , {fixed: 'right', title: '操作', width: '20%', align: 'center', toolbar: '#barDemo'}
            ]], limits: [5, 10, 15, 20],
            limit: 5

        });
        //数据重载（查询）
        var $ = layui.$, active = {
            reload: function () {
                //执行重载
                table.reload('testReload', {
                    url: '/Jop/findAll.action',
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        JopName: $('#JopName').val()
                    }
                });
            }
        };

        $('.layui-table-tool-temp .layui-inline').on('click',function(){
            layer.open({
                title: '增加岗位',
                type : 2,
                content: 'JopAdd.jsp', //数组第二项即吸附元素选择器或者DOM
                area :['600px','320px']
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
                    content: 'JopList.jsp?JopId='+data.JopId, //数组第二项即吸附元素选择器或者DOM
                    area :['600px','320px']
                });
            }else if (layEvent === 'del') {
                layer.confirm('真的删除吗？', function (index) {
                    if(index>0){
                        $.ajax({
                            type: "POST",
                            url: "/Jop/removeJop.action",
                            data: {
                                JopId: data.JopId
                            },
                            dataType: "json",
                            success: function (data) {
                                table.reload('testReload', {
                                    url: '/Jop/findAll.action',
                                    page: {
                                        curr: 1 //重新从第 1 页开始
                                    }
                                    , where: {
                                        JopName: $('#JopName').val()
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
                    content: 'JopEdit.jsp?JopId='+data.JopId, //数组第二项即吸附元素选择器或者DOM
                    area :['600px','320px']
                });
            }
        });
    });
</script>
</body>
</html>

