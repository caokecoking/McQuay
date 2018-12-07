<%--
  Created by IntelliJ IDEA.
  User: 93525
  Date: 2018/12/3
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>
<div class="layui-row">
    <div class="layui-col-xs3">
        <div class="layui-form-item layui-form">
            <div class="layui-input-inline">
                <div><a style="font-size: 30px;font-style: inherit">权限管理</a></div>
                <div id="LAY-auth-tree-index"></div>
            </div>
        </div>
    </div>
    <div class="layui-col-xs9">
        <div class="layui-inline">
            <input name="id" class="layui-input" placeholder="职位名称" id="JopName" type="text">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
        <table id="demo" lay-filter="test"></table>
    </div>
</div>
<input type="hidden" id="JopId"/>
</body>
<script type="text/javascript">
    layui.config({
        base: 'extends/',
    }).extend({
        authtree: 'authtree',
    });
    layui.use(['jquery', 'authtree', 'form', 'layer'], function () {
        var $ = layui.jquery;
        var authtree = layui.authtree;
        var form = layui.form;
        var layer = layui.layer;
        // 一般来说，权限数据是异步传递过来的
        $.ajax({
            url: '/tree/findMenuTree.action',
            dataType: 'json',
            success: function (data) {
                var trees = data;
                // 如果后台返回的不是树结构，请使用 authtree.listConvert 转换
                authtree.render('#LAY-auth-tree-index', trees, {
                    inputname: 'authids[]',
                    layfilter: 'lay-check-auth',
                    autowidth: true,
                });
            }
        });
        authtree.on('change(lay-check-auth)', function (data) {
            // 获取最新选中
            var lastChecked = authtree.getLastChecked('#LAY-auth-tree-index');
            if (lastChecked.length > 0) {
                for (var i=0; i<lastChecked.length;i++){
                    console.log(lastChecked[i]);
                   $.ajax({
                    url: '/tree/addMenuByJop.action',
                    dataType: 'json',
                    data:{
                        Jobid: $('#JopId').val(),
                        MenuId:lastChecked[i]
                    },
                    success: function (data) {
                    }
                });
                }
            }
            // 获取最新取消
            var lastNotChecked = authtree.getLastNotChecked('#LAY-auth-tree-index');
            if (lastNotChecked.length > 0) {
                for (var i=0; i<lastNotChecked.length;i++){
                    $.ajax({
                        url: '/tree/removeMenuByJop.action',
                        dataType: 'json',
                        data:{
                            Jobid: $('#JopId').val(),
                            MenuId:lastNotChecked[i]
                        },
                        success: function (data) {
                        }
                    });
                }
            }
        });
    });
    layui.use('table', function () {
        var table = layui.table;
        var layEvent = table.event;
        //第一个实例
        table.render({
            elem: '#demo',
            id: 'testReload'
            , height: '675px'
            , url: '/Jop/findAll.action' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'JopName', title: '职位名称', width: '50%'}
                , {field: 'Rel', title: '职位职能', width: '50%'}
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
        var $ = layui.jquery;
        var authtree = layui.authtree;
        var form = layui.form;
        var layer = layui.layer;
        table.on('row(test)', function (obj) {
            console.log(obj.data) //得到当前行数据
            $('#JopId').val(obj.data.JopId);
            $.ajax({
                url: '/tree/findParentMenuByJop.action?JopId=' + obj.data.JopId,
                dataType: 'json',
                success: function (data) {
                    var trees = data;
                    // 如果后台返回的不是树结构，请使用 authtree.listConvert 转换
                    authtree.render('#LAY-auth-tree-index', trees, {
                        inputname: 'authids[]',
                        layfilter: 'lay-check-auth',
                        autowidth: true,
                    });
                }
            });
        });
    });

</script>
</html>