<%--
  Created by IntelliJ IDEA.
  User: 93525
  Date: 2018/11/28
  Time: 14:23
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
    <input name="id" class="layui-input" placeholder="分公司名称" id="name" type="text">
</div>
<div class="layui-inline">
    <input name="id" class="layui-input" placeholder="省/直辖市" id="Prov" type="text">
</div>
<div class="layui-inline">
    <input name="id" class="layui-input" placeholder="协议店名称" id="AgreName" type="text">
</div>
<button class="layui-btn" data-type="reload">搜索</button>
<table id="demo" lay-filter="test"></table>
<script type="text/html" id="compName">
    {{d.c.compName }}
</script>
<script type="text/html" id="compCoding">
    {{d.c.compCoding }}
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
            , url: '/Agreement/findAll.action' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'AgreCoding', title: '协议店编码', width: '9%'}
                , {field: 'AgreName', title: '协议店名称', width: '9%'}
                , {field: 'c.compCoding', title: '分公司编码', width: '9%',templet:'#compCoding'}
                , {field: 'c.compName', title: '分公司名称', width: '9%',templet:'#compName'}
                , {field: 'Prov', title: '省/直辖市', width: '7%'}
                , {field: 'Dist', title: '地区/市', width: '7%'}
                , {field: 'Coun', title: '市/县', width: '7%'}
                , {field: 'AgreAddress', title: '详细地址', width: '9%'}
                , {field: 'AgreStartTime', title: '协议起始日期', width: '9%'}
                , {field: 'AgreFinishTime', title: '协议到期申请', width: '9%'}
                , {fixed: 'right', title: '操作', width: '15%', align: 'center', toolbar: '#barDemo'}
            ]], limits: [5, 10, 15, 20],
            limit: 5

        });
        //数据重载（查询）
        var $ = layui.$, active = {
            reload: function () {
                //执行重载
                table.reload('testReload', {
                    url: '/Agreement/findAll.action',
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        name: $('#name').val(),
                        Prov: $('#Prov').val(),
                        AgreName: $('#AgreName').val()
                    }
                });
            }
        };

        $('.layui-table-tool-temp .layui-inline').on('click',function(){
            layer.open({
                title: '增加协议店',
                type : 2,
                content: 'AgreementAdd.jsp', //数组第二项即吸附元素选择器或者DOM
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
                    title: '查看协议店',
                    type : 2,
                    content: 'AgreementLook.jsp?AgreCoding='+data.AgreCoding, //数组第二项即吸附元素选择器或者DOM
                    area :['600px','560px']
                });
            } else if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    if(index>0){
                        $.ajax({
                            type: "POST",
                            url: "/Agreement/removeAgreement.action",
                            data: {
                                AgreCoding: data.AgreCoding
                            },
                            dataType: "json",
                            success: function (data) {
                                table.reload('testReload', {
                                    url: '/Agreement/findAll.action',
                                    page: {
                                        curr: 1 //重新从第 1 页开始
                                    }
                                    , where: {
                                        name: $('#name').val(),
                                        Prov: $('#Prov').val(),
                                        AgreName: $('#AgreName').val()
                                    }
                                });
                                parent.layer.close(index);
                            }
                        });
                    }
                });
            } else if (layEvent === 'edit') {
                layer.open({
                    title: '修改协议店',
                    type : 2,
                    content: 'AgreementEdit.jsp?AgreCoding='+data.AgreCoding, //数组第二项即吸附元素选择器或者DOM
                    area :['600px','560px']
                });
            }
        });
    });
</script>
</body>
</html>

