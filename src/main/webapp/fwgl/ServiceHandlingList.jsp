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
<script>
    $(function () {
        $.ajax({
            type: 'post',
            url: '../FindCustomermessageDateAll.action',
            dataType: 'json',
            success: function (data) {
                $.each(data.c, function (index, item) {
                    $('#CustId').append(new Option(item.custName, item.custId));// 下拉菜单里添加元素
                });
            }
        })

    })
</script>
<body>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-xs" lay-event="zhiding">制定计划</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<div class="search">
    搜索服务状态:
    <div class="layui-inline">
        <div class="layui-input-block">
            <select id="state" style="height: 35px;">
                <option value="">请选择</option>
                <option value="已拒绝">已拒绝</option>
                <option value="已接单">已接单</option>
            </select>
        </div>
    </div>

    搜索产品类型:
    <div class="layui-inline">
        <div class="layui-input-block">
            <select id="HandlingType" style="height: 35px;">
                <option value="">请选择</option>
                <option value="分公司质保">分公司质保</option>
                <option value="工厂质保">工厂质保</option>
            </select>
        </div>
    </div>

    搜索产品类型:
    <div class="layui-inline">
        <div class="layui-input-block">
            <select id="CustId" style="height: 35px;">
                <option value="">请选择</option>
            </select>
        </div>
    </div>

    搜索客户地址：
    <div class="layui-inline">
        <input class="layui-input" name="CustAddress" id="CustAddress" autocomplete="off">
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
            , url: '../FindServiceHandlingAll.action' //数据接口
            , title: '受理服务'
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'shId', title: '服务单号', width: '15%', sort: true, fixed: 'left'}
                , {field: 'state', title: '服务状态', width: '15%'}
                , {field: 'handlingType', title: '受理类型', width: '15%'}
                , {field: 'custName', title: '客户名称', width: '15%'}
                , {field: 'custAddress', title: '详细地址', width: '15%'}
                , {field: 'cname', title: '联系人名称', width: '15%'}
                , {field: 'dateOfPurchase', title: '受理日期', width: '15%'}
                , {field: 'custSeat', title: '联系电话', width: '15%'}
                , {fixed: 'right', width: 200, align: 'center', toolbar: '#barDemo'}
            ]], limits: [5, 10, 15, 20],
            limit: 5
        });

//数据重载（查询）
        var $ = layui.$, active = {

            reload: function () {
                var HandlingType = $('#HandlingType');
                var CustId = $('#CustId');
                var CustAddress = $('#CustAddress');
                var state = $('#state');
                //执行重载
                table.reload('demo', {
                    url: '../FindServiceHandlingAll.action',
                    type: 'post',
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        HandlingType: HandlingType.val(),
                        CustId: CustId.val(),
                        CustAddress: CustAddress.val(),
                        state: state.val()
                    },
                });
            }
        };

        $('.search .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });


        //监听行工具事件
        table.on('tool(test)', function (obj) {
            //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    location.href = '../FindServiceHandlingRemove.action?ShId=' + data.shId;
                });
            } else if (layEvent == 'zhiding') {
                $.ajax({
                    type: 'post',
                    url: '../FindShIdCount.action',
                    dataType: 'json',
                    data: {
                        ShId: data.shId
                    },
                    success: function (da) {
                        if (da > 0) {
                            alert('改受理已经制定了计划');
                        } else {
                            if (data.cause != null && data.cause != '') {
                                alert('该服务已经被拒绝请修改该服务或销毁该记录');
                            } else {
                                layer.open({
                                    title: "制定计划",
                                    type: 2,
                                    content: 'http://localhost:8080/fwgl/ServicePlanAdd.jsp?CustId=' + data.custId + '&ShId=' + data.shId //这里content是一个普通的String
                                    , offset: 'auto',
                                    area: ['800px', '700px']
                                });
                            }
                        }

                    }
                })
            } else if (layEvent === 'edit') {
                layer.open({
                    title: "计划修改",
                    type: 2,
                    content: 'http://localhost:8080/fwgl/ServiceHandlingEdit.jsp?ShId=' + data.shId //这里content是一个普通的String
                    , offset: 'auto',
                    area: ['800px', '700px']
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
                        title: "新定义受理",
                        type: 2,
                        content: 'http://localhost:8080/fwgl/ServiceHandlingAdd.jsp' //这里content是一个普通的String
                        , offset: 'auto',
                        area: ['800px', '700px']
                    });
                    break;
            }
            ;
        });

    });
</script>
</body>
</html>
