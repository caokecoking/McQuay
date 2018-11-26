<!DOCTYPE html PUBLIC "-//W3C//DTD sHTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>

<div class="layui-container">

    <div class="layui-col-md6 layui-col-md-offset1">
        <form class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">选择权限</label>
                <div class="layui-input-block">
                    <div id="LAY-auth-tree-index"></div>
                </div>
            </div>
        </form>
    </div>
</div>
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
        // 初始化
        $.ajax({
            url: '/Menu/findParentMenuByJop.action',
            dataType: 'json',
            success: function (data) {
                // 渲染时传入渲染目标ID，树形结构数据（具体结构看样例，checked表示默认选中），以及input表单的名字
                authtree.render('#LAY-auth-tree-index', data.trees, {
                    inputname: 'authids[]'
                    , layfilter: 'lay-check-auth'
                    // ,autoclose: false
                    // ,autochecked: false
                    // ,openchecked: true
                    // ,openall: true
                    , autowidth: true
                });
                // PS:使用 form.on() 会引起了事件冒泡延迟的BUG，需要 setTimeout()，并且无法监听全选/全不选
                // PS:如果开启双击展开配置，form.on()会记录两次点击事件，authtree.on()不会
                form.on('checkbox(lay-check-auth)', function (data) {
                    // 注意这里：需要等待事件冒泡完成，不然获取叶子节点不准确。
                    setTimeout(function () {
                        console.log('监听 form 触发事件数据', data);
                        // 获取选中的叶子节点
                        var leaf = authtree.getLeaf('#LAY-auth-tree-index');
                        console.log('leaf', leaf);
                        // 获取最新选中
                        var lastChecked = authtree.getLastChecked('#LAY-auth-tree-index');
                        console.log('lastChecked', lastChecked);
                        // 获取最新取消
                        var lastNotChecked = authtree.getLastNotChecked('#LAY-auth-tree-index');
                        console.log('lastNotChecked', lastNotChecked);
                    }, 100);
                });
                // 使用 authtree.on() 不会有冒泡延迟
                authtree.on('change(lay-check-auth)', function (data) {
                    console.log('监听 authtree 触发事件数据', data);
                    // 获取所有节点
                    var all = authtree.getAll('#LAY-auth-tree-index');
                    console.log('all', all);
                    // 获取所有已选中节点
                    var checked = authtree.getChecked('#LAY-auth-tree-index');
                    console.log('checked', checked);
                    // 获取所有未选中节点
                    var notchecked = authtree.getNotChecked('#LAY-auth-tree-index');
                    console.log('notchecked', notchecked);
                    // 获取选中的叶子节点
                    var leaf = authtree.getLeaf('#LAY-auth-tree-index');
                    console.log('leaf', leaf);
                    // 获取最新选中
                    var lastChecked = authtree.getLastChecked('#LAY-auth-tree-index');
                    console.log('lastChecked', lastChecked);
                    // 获取最新取消
                    var lastNotChecked = authtree.getLastNotChecked('#LAY-auth-tree-index');
                    console.log('lastNotChecked', lastNotChecked);
                });
                authtree.on('deptChange(lay-check-auth)', function (data) {
                    console.log('监听到显示层数改变', data);
                });
            },
            error: function (xml, errstr, err) {
                layer.alert(errstr + '，获取样例数据失败，请检查是否部署在本地服务器中！');
            }
        });
        form.on('submit(LAY-auth-tree-submit)', function (obj) {
            var authids = authtree.getChecked('#LAY-auth-tree-index');
            console.log('Choosed authids is', authids);
            obj.field.authids = authids;
            $.ajax({
                url: 'tree.json',
                dataType: 'json',
                data: obj.field,
                success: function (res) {
                    layer.alert('提交成功！');
                }
            });
            return false;
        });
    });
</script>
</html>