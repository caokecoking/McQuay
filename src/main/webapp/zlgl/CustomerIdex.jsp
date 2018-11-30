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
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<div class="search">
    搜索客户联系人名称：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="names" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>


<table id="demo" lay-filter="test"></table>


<script>
    layui.use(['table'], function () {
        var table = layui.table;
        table.render({
            elem: '#demo'
            , height: 420
            , toolbar: 'default'
            , url: '../FindAll.action' //数据接口
            , title: '客户联系人表'
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'cid', title: 'ID', width: '10%', sort: true, fixed: 'left'}
                , {field: 'cname', title: '联系人名称', width: '10%'}
                , {field: 'custSeat', title: '联系人手机号码', width: '10%'}
                , {field: 'custPhone', title: '联系人分手机号码', width: '10%'}
                , {field: 'custPartphone', title: '座机号码', width: '10%'}
                , {field: 'custEmail', title: '邮箱', width: '10%'}
                , {field: 'edi_DateTime', title: '最后修改时间', width: '10%'},
                {
                    field: 'x_customermessage',
                    title: '客户名',
                    width: "15%",
                    templet: '<div>{{d.x_customermessage.custName}}</div>'
                }
                , {fixed: 'right', width: 165, align: 'center', toolbar: '#barDemo'}
            ]], limits: [5, 10, 15, 20],
            limit: 5
        });


        //数据重载（查询）
        var $ = layui.$, active = {

            reload: function () {
                var names = $('#names');
                //执行重载
                table.reload('demo', {
                    url: '../FindAll.action',
                    type: 'post',
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        CName: names.val(),
                    },
                });
            }
        };

        $('.search .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });


        //监听行工具事件
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    location.href = '../FindCustomerremove.action?Cid=' + data.cid;
                });
            } else if (layEvent === 'edit') {
                layer.open({
                    title: "联系人修改",
                    type: 2,
                    content: 'http://localhost:8080/zlgl/CustomerEdit.jsp?ids=' + data.cid //这里content是一个普通的String
                    , offset: 'auto',
                    area: ['700px', '600px']
                });
            }
        });


        //监听头工具栏事件l
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id)
                , data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    layer.open({
                        title: "联系人增加",
                        type: 2,
                        content: 'http://localhost:8080/zlgl/CustomerAdd.jsp' //这里content是一个普通的String
                        , offset: 'auto',
                        area: ['700px', '600px']
                    });
                    break;
                case 'update':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else if (data.length > 1) {
                        layer.msg('只能同时编辑一个');
                    } else {
                        checkStatus.data[0].cid;
                    }
                    break;
                case 'delete':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else {
                        layer.msg('删除');
                    }
                    break;
            }
            ;
        });
    });
</script>
</body>
</html>
