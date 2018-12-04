<%--
  Created by IntelliJ IDEA.
  User: 93525
  Date: 2018/12/3
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <title>tree-table</title>
    <link rel="stylesheet" href="../layui/common.css"/>
    <link rel="stylesheet" href="../layui/css/layui.css" media="all">
    <script src="../layui/layui.js"></script>
    <script src="../js/jquery.js"></script>
    <script src="../js/jquery-3.2.1.js"></script>
</head>
<body>
<div class="layui-container">
    <br><br>
    &nbsp;&nbsp;
    <div class="layui-btn-group">
        <button class="layui-btn" id="btn-expand">全部展开</button>
        <button class="layui-btn" id="btn-fold">全部折叠</button>
        <button class="layui-btn" id="btn-refresh">刷新表格</button>
        <button class="layui-btn" id="addMenu">增加菜单</button>
    </div>
    <div class="layui-inline">
        <input name="id" class="layui-input" placeholder="菜单名称" id="MenuName" type="text">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
    <table id="table1" class="layui-table" lay-filter="table1" ></table>
</div>
<!-- 操作列 -->
<script type="text/html" id="oper-col">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="../layui/layui.js"></script>
<script>
    layui.config({
        base: '../extends/'
    }).extend({
        treetable: 'treetable'
    }).use(['table', 'form', 'element', 'treetable'], function () {
        var $ = layui.jquery;
        var table = layui.table;
        var form = layui.form;
        var element = layui.element;
        var treetable = layui.treetable;

        // 渲染表格
        var renderTable = function () {
            treetable.render({
                id:'testReload',
                treeColIndex: 2,
                treeSpid: -1,
                treeIdName: 'id',
                treePidName: 'mparent',
                elem: '#table1',
                url: '/Menu/findMenuTree.action',
                page: false,
                cols: [[
                    {type: 'numbers'},
                    {field: 'id', title: '菜单id'},
                    {field: 'name', title: '菜单名称'},
                    {field: 'mpath', title: '菜单地址'},
                    {templet: '#oper-col', title: '操作'}
                ]],
                done: function () {
                    layer.closeAll('loading');
                }
            });
        };

        renderTable();

        $('#btn-expand').click(function () {
            treetable.expandAll('#table1');
        });

        $('#btn-fold').click(function () {
            treetable.foldAll('#table1');
        });

        $('#btn-refresh').click(function () {
            renderTable();
        });

        $('#addMenu').click(function () {
            layer.open({
                title: '增加菜单',
                type : 2,
                content: 'MenuAdd.jsp', //数组第二项即吸附元素选择器或者DOM
                area :['600px','300px']
            });
        });
        //数据重载（查询）
        var $ = layui.$, active = {
            reload: function () {
                //执行重载
                table.reload('testReload', {
                    url: '/Menu/findMenuTree.action',
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        MenuName: $('#MenuName').val()
                    }
                });
            }
        };
        $('.layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
        //监听行工具事件
        table.on('tool(table1)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'del') {
                layer.confirm('真的删除该菜单吗？', function (index) {
                    if(index>0){
                        $.ajax({
                            type: "POST",
                            url: "/Menu/removeMenu.action",
                            data: {
                                MenuId: data.id
                            },
                            dataType: "json",
                            success: function (data) {
                                location.reload();
                            }
                        });
                    }
                });
            } else if (layEvent === 'edit') {
                layer.open({
                    title: '修改菜单',
                    type : 2,
                    content: 'MenuEdit.jsp?MenuId='+data.id, //数组第二项即吸附元素选择器或者DOM
                    area :['600px','300px']
                });
            }
        });
    });
</script>
</body>
</html>