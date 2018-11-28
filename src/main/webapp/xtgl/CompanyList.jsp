<%--
  Created by IntelliJ IDEA.
  User: 93525
  Date: 2018/11/26
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<script src="../layui/layui.js"></script>
<script type="text/html" id="barDemo">
    <a id="query" class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit" >编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
    <html>
<head>
    <title>Title</title>
</head>
<body>
<div class="layui-inline">
<input name="id" class="layui-input" placeholder="分公司名称" id="CompName" type="text">
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
            , height: '600px'
            , toolbar: 'default'
            , url: '/Company/findAll.action' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'CompCoding', title: '分公司编码', width: '10%', sort: true, fixed: 'left'}
                , {field: 'CompName', title: '分公司名称', width: '15%'}
                , {field: 'CompAddress', title: '详细地址', width: '15%', sort: true}
                , {field: 'CompAttribute', title: '属性', width: '10%'}
                , {field: 'CompEmailAddress', title: '邮箱地址', width: '10%',templet:'#isPayment1'}
                , {field: 'CompEmailPassword', title: '邮箱密码', width: '15%', sort: true}
                , {fixed: 'right', title: '操作', width: '20%', align: 'center', toolbar: '#barDemo'}
            ]], limits: [5, 10, 15, 20],
            limit: 5

        });
        //数据重载（查询）
        var $ = layui.$, active = {
            reload: function () {
                var CompName = $('#CompName');
                //执行重载
                table.reload('testReload', {
                    url: '/Company/findAll.action',
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        CompName: CompName.val()
                    }
                });
            }
        };

        $('.layui-table-tool-temp .layui-inline').on('click',function(){
                layer.open({
                    title: '增加界面',
                    type : 2,
                    content: 'CompanyAdd.jsp', //数组第二项即吸附元素选择器或者DOM
                    area :['600px','560px']
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
                    title: 'ck界面',
                    type : 2,
                    content: 'CompanyLook.jsp?id='+data.Compid, //数组第二项即吸附元素选择器或者DOM
                    area :['600px','560px']
                });
            } else if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    if(index>0){
                        $.ajax({
                            type: "POST",
                            url: "/Company/removeCompany.action",
                            data: {
                                Compid: data.Compid
                            },
                            dataType: "json",
                            success: function (data) {
                                table.reload('testReload', {
                                    url: '/Company/findAll.action',
                                    page: {
                                        curr: 1 //重新从第 1 页开始
                                    }
                                    , where: {
                                        CompName: $('#CompName').val()
                                    }
                                });
                                parent.layer.close(index);
                            }
                        });
                    }
                });
            } else if (layEvent === 'edit') {
                layer.open({
                    title: '修改界面',
                    type : 2,
                    content: 'CompanyEdit.jsp?id='+data.Compid, //数组第二项即吸附元素选择器或者DOM
                    area :['600px','560px']
                });
            }
        });
    });
</script>
</body>
</html>
