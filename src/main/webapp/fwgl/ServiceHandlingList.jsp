<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../EasyUIUrl.jsp"%>
<script type="text/javascript">
	$(function() {
		DataGrid();
		//绑定客户名称
		CustNameCompbox();
		//绑定客户来电
		CustPhoneCompbox();
		//产品类型绑定
		ProductTypeCompbox();

		$('#ChargeType').combobox({
			onSelect : function(record) {
				if (record.value == "不收费") {
					$("#DoorFee").textbox({
						disabled : true
					});
				} else {
					$("#DoorFee").textbox({
						disabled : false
					});
				}
			}
		});
	})

	function DataGrid() {
		$('#dg')
				.datagrid(
						{
							url : 'findAllByServiceHandling',
							queryParams : {
								Dispatch : $('#Dispatch3').val(),
								CustName : $('#CustName').val(),
								CustAddress : $('#CustAddress').val(),
								startTime : $('#startTime').val(),
								endTime : $('#endTime').val()
							},
							columns : [ [
									{
										field : 'b',
										title : '',
										width : '3%',
										formatter : function(value, row, index) {
											return '<input id="'+row.shId+'" type="checkbox" />';
										}
									},
									{
										field : 'dispatch',
										width : '13%',
										title : '服务状态'
									},
									{
										field : 'shId',
										width : '14%',
										title : '受理单号'
									},
									{
										field : 'stDescribe',
										width : '14%',
										title : '受理类型'
									},
									{
										field : 'custId',
										width : '14%',
										title : '客户名称',
										formatter : function(value, row, index) {
											return row.c.custName;
										}
									},
									{
										field : 'sex',
										width : '14%',
										title : '详细地址',
										formatter : function(value, row, index) {
											return row.c.custAddress;
										}
									},
									{
										field : 'acceptDate',
										width : '14%',
										title : '受理日期'
									},
									{
										field : '操作',
										width : '14%',
										title : '操作',
										formatter : function(value, row, index) {
											if (row.dispatch == "已派工") {
												return "<a id='btn' href='javascript:void(0);' class='easyui-linkbutton' data-options=iconCls:'icon-edit' onclick='editOpen();'>修改</a>";
											} else {
												return "<a id='btn' href='javascript:void(0);' class='easyui-linkbutton' data-options=iconCls:'icon-edit' onclick='editOpen();'>修改</a>"
														+ '  <a id="btn" href="#" class=easyui-linkbutton data-options=iconCls:"icon-edit" onclick="OpenPaigon();">派工</a>';
											}
										}
									} ] ],
							pagination : true,
							singleSelect : false,
							pageNumber : 1,
							toolbar : '#tb',
							fit : true,
							pageSize : 5,
							pageList : [ 5, 10, 15, 20 ],
							onSelect : function(index, row) {
								$('#ShId2').textbox('setValue', row.shId);
								$('#ShPhone2')
										.combobox('setValue', row.shPhone);
								$('#AppointmentTime2').datebox('setValue',
										row.appointmentTime);
								$('#PtDescribe2').combobox('setValue',
										row.ptDescribe);
								$('#PurchaseDate2').datebox('setValue',
										row.purchaseDate);
								$('#StDescribe2').combobox('setValue',
										row.stDescribe);
								$('#ChargeType2').combobox('setValue',
										row.chargeType);
								$('#DoorFee2').textbox('setValue', row.doorFee);
								$('#AcceptDescription2').textbox('setValue',
										row.acceptDescription);
							}
						});
	}

	function addOpen() {
		$('#win').window({
			title : '增加面板',
			width : 900,
			height : 370,
			modal : true
		});

	}



	
	function editOpen() {
		$('#win2').window({
			title : '修改面板',
			width : 900,
			height : 370,
			modal : true
		});
	}

	function OpenPaigon() {
		$.ajax({
			type : "POST",
			url : "../xtgl/queryPeopleCode",
			dataType : "text",
			success : function(data) {
				if (data == 0) {
					$.messager.show({
						title : '提示',
						msg : '你没有权限进行派工!'
					});
				} else {
					$('#SendCharge').textbox('setValue',data.PersName);
					$('#win3').window({
						title : '派工面板',
						width : 900,
						height : 370,
						modal : true
					});
				}
			}
		});
	}
	function add() {
		$.ajax({
			type : "POST",
			url : "addByServiceHandling",
			data : {
				PersId : $('#PersId').val(),
				ShPhone : $('#ShPhone').combobox('getValue'),
				AppointmentTime : $('#AppointmentTime').datebox('getValue'),
				PtDescribe : $('#PtDescribe').combobox('getValue'),
				PurchaseDate : $('#PurchaseDate').datebox('getValue'),
				StDescribe : $('#StDescribe').combobox('getValue'),
				ChargeType : $('#ChargeType').combobox('getValue'),
				DoorFee : $('#DoorFee').textbox('getValue'),
				AcceptDescription : $('#AcceptDescription').textbox('getValue')
			},
			dataType : "text",
			success : function(data) {
				if (data == 1) {
					$.messager.show({
						title : '提示消息',
						msg : '增加受理单成功',
						timeout : 5000,
						showType : 'slide'
					})
					$('#dg').datagrid('reload');
					$('#win').window('close');
				} else {
					$.messager.show({
						title : '提示消息',
						msg : '增加受理单失败',
						timeout : 5000,
						showType : 'slide'
					})
					$('#dg').datagrid('reload');
					addclose();
				}
			}
		});
	}

	function addclose() {
		$('#ShPhone').combobox('setValue', '');
		$('#AppointmentTime').datebox('setValue', '');
		$('#PtDescribe').combobox('setValue', '');
		$('#PurchaseDate').datebox('setValue', '');
		$('#StDescribe').combobox('setValue', '');
		$('#ChargeType').combobox('setValue', '');
		$('#DoorFee').textbox('setValue', '');
		$('#AcceptDescription').val('');
		$('#win').window('close');
	}
	function paigonclose() {
		$('#ShPhone2').combobox('setValue', '');
		$('#Dispatch').datebox('setValue', '');
		$('#SendCharge').combobox('setValue', '');
		$('#Other').combobox('setValue', '');
		$('#win3').window('close');
	}
	function editclose() {
		$('#ShPhone2').combobox('setValue', '');
		$('#AppointmentTime2').datebox('setValue', '');
		$('#PtDescribe2').combobox('setValue', '');
		$('#PurchaseDate2').datebox('setValue', '');
		$('#StDescribe2').combobox('setValue', '');
		$('#ChargeType2').combobox('setValue', '');
		$('#DoorFee2').textbox('setValue', '');
		$('#AcceptDescription2').val('');
		$('#win2').window('close');
	}
	function edit() {
		$.ajax({
			type : "POST",
			url : "editByServiceHandling",
			data : {
				ShId : $('#ShId2').val(),
				ShPhone : $('#ShPhone2').combobox('getValue'),
				AppointmentTime : $('#AppointmentTime2').datebox('getValue'),
				PtDescribe : $('#PtDescribe2').combobox('getValue'),
				PurchaseDate : $('#PurchaseDate2').datebox('getValue'),
				StDescribe : $('#StDescribe2').combobox('getValue'),
				ChargeType : $('#ChargeType2').combobox('getValue'),
				DoorFee : $('#DoorFee2').textbox('getValue'),
				AcceptDescription : $('#AcceptDescription2')
						.textbox('getValue')
			},
			dataType : "text",
			success : function(data) {
				if (data == 1) {
					$.messager.show({
						title : '修改受理单成功',
						timeout : 5000,
						showType : 'slide'
					})
					$('#dg').datagrid('reload');
					editclose();
				} else {
					$.messager.show({
						title : '修改受理单失败',
						timeout : 5000,
						showType : 'slide'
					})
					$('#dg').datagrid('reload');
					editclose();
				}
			}
		});
	}
	function paigon() {
		$.ajax({
			type : "POST",
			url : "editByServiceHandling",
			data : {
				ShId : $('#ShId2').val(),
				ShPhone : $('#ShPhone2').combobox('getValue'),
				AppointmentTime : $('#AppointmentTime2').datebox('getValue'),
				PtDescribe : $('#PtDescribe2').combobox('getValue'),
				PurchaseDate : $('#PurchaseDate2').datebox('getValue'),
				StDescribe : $('#StDescribe2').combobox('getValue'),
				ChargeType : $('#ChargeType2').combobox('getValue'),
				DoorFee : $('#DoorFee2').textbox('getValue'),
				AcceptDescription : $('#AcceptDescription2').textbox('getValue'),
				Dispatch : $('#Dispatch').datebox('setValue', ''),
				SendCharge : $('#SendCharge').combobox('setValue', ''),
				Other : $('#Other').combobox('setValue', '')
			},
			dataType : "text",
			success : function(data) {
				if (data == 1) {
					$.messager.show({
						title : '修改受理单成功',
						timeout : 5000,
						showType : 'slide'
					})
					$('#dg').datagrid('reload');
					editclose();
				} else {
					$.messager.show({
						title : '修改受理单失败',
						timeout : 5000,
						showType : 'slide'
					})
					$('#dg').datagrid('reload');
					editclose();
				}
			}
		});
	}
	function remove(myid) {
		$.messager.confirm('确认', '您确认想要删除吗？', function(r) {
			if (r) {
				$.ajax({
					type : "POST",
					url : "removeByAgreement",
					data : {
						AgreCoding : myid
					},
					dataType : "text",
					success : function(data) {
						$.messager.show({
							title : '提示消息',
							msg : '删除受理单成功',
							timeout : 5000,
							showType : 'slide'
						})
						$('#dg').datagrid('reload');
					}
				});
			}
		});
	}
	//导出
	function dayinOpen() {
		// 得到选中的行
		//var selRow = otGrid.datagrid("getSelected");//返回选中一行 这个是注释过的  就是取一个
		var selRow = $('#dg').datagrid("getSelections");//返回选中多行

		if (selRow.length == 0) {
			alert("请至少选择一行数据!");
			return false;
		}
		var ids = [];
		for (var i = 0; i < selRow.length; i++) {
			//获取自定义table 的中的checkbox值
			var id = selRow[i].shId; //OTRECORDID这个是你要在列表中取的单个id 
			ids.push(id); //然后把单个id循环放到ids的数组中
		}
		if (confirm("确定要导出选中的服务信息吗?")) {
			$.ajax({
				type : "POST",
				url : "DaYingServiceHandling",
				data : {
					list : ids
				},
				dataType : "text",
				success : function(data) {
					$.messager.show({
						title : '提示消息',
						msg : '导出服务信息成功',
						timeout : 5000,
						showType : 'slide'
					})
					$('#dg').datagrid('reload');
				}
			});
		}
	}

	//导出
	function pdfOpen() {
		// 得到选中的行
		//var selRow = otGrid.datagrid("getSelected");//返回选中一行 这个是注释过的  就是取一个
		var selRow = $('#dg').datagrid("getSelections");//返回选中多行

		if (selRow.length == 0) {
			alert("请至少选择一行数据!");
			return false;
		}
		var ids = [];
		for (var i = 0; i < selRow.length; i++) {
			//获取自定义table 的中的checkbox值
			var id = selRow[i].shId; //OTRECORDID这个是你要在列表中取的单个id 
			ids.push(id); //然后把单个id循环放到ids的数组中
		}
		if (confirm("确定要导出选中的服务信息吗?")) {
			$.ajax({
				type : "POST",
				url : "PDFServiceHandling",
				data : {
					list : ids
				},
				dataType : "text",
				success : function(data) {
					$.messager.show({
						title : '提示消息',
						msg : '导出服务信息成功',
						timeout : 5000,
						showType : 'slide'
					})
					$('#dg').datagrid('reload');
				}
			});
		}
	}
	//客户名称绑定
	function CustNameCompbox() {
		$('#CustName').combobox({
			url : '../zking/customerDates',
			valueField : 'custId',
			textField : 'custName'
		});
	}
	//来电名称绑定
	function CustPhoneCompbox() {
		$('#ShPhone').combobox({
			url : '../zking/Customerfindall',
			valueField : 'custPhone',
			textField : 'custPhone'
		});
		$('#ShPhone').combobox('select', '---客户来电---');
		$('#ShPhone2').combobox({
			url : '../zking/Customerfindall',
			valueField : 'custPhone',
			textField : 'custPhone'
		});
		$('#ShPhone2').combobox('select', '---客户来电---');
	}
	//产品类型绑定
	function ProductTypeCompbox() {
		$('#PtDescribe').combobox({
			url : '../zking/ProductTypeall',
			valueField : 'ptId',
			textField : 'ptDescribe'
		});
		$('#PtDescribe').combobox('select', '---产品类型---');
		$('#PtDescribe2').combobox({
			url : '../zking/ProductTypeall',
			valueField : 'ptId',
			textField : 'ptDescribe'
		});
		$('#PtDescribe2').combobox('select', '---产品类型---');
	}
	
</script>
</head>

<body>
	<div id="win3" style="display: none;">
		<br /> <br /> <select id="Dispatch" class="easyui-combobox"
			style="width: 280px;" data-options="label:'是否派工',labelAlign:'right'">
			<option value="是">是</option>
			<option value="否">否</option>
		</select> <input id="SendCharge" class="easyui-textbox"
			data-options="label:'派单主管',labelAlign:'right',disabled:true" style="width: 280px">
		<select id="CounselContent" class="easyui-combobox"
			style="width: 280px;" data-options="label:'咨询内容',labelAlign:'right'">
			<option value="安装咨询">安装咨询</option>
			<option value="保养咨询">保养咨询</option>
			<option value="维修咨询">维修咨询</option>
			<option value="调试咨询">调试咨询</option>
		</select><br /> <br /> <input id="Other" class="easyui-textbox"
			data-options="label:'其他',labelAlign:'right',multiline:true"
			style="width: 840px; height: 100px"><br /> <br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a id="btn" href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-add'" onclick="paigon();">派工</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
			id="btn" href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel'" onclick="paigonclose();">取消</a><br />
	</div>
	<div id="win" style="display: none;">
		<br /> <br /> <input id="ShPhone" class="easyui-combobox"
			data-options="label:'来电',labelAlign:'right',editable:false"
			style="width: 280px"> <input id="AppointmentTime"
			class="easyui-datebox"
			data-options="label:'预约时间',labelAlign:'right',editable:false"
			style="width: 280px"><br /> <br /> <input id="PtDescribe"
			class="easyui-combobox"
			data-options="label:'产品类型',labelAlign:'right'" style="width: 280px">
		<input id="PurchaseDate" class="easyui-datebox"
			data-options="label:'购买日期',labelAlign:'right',editable:false"
			style="width: 280px"> <select id="StDescribe"
			class="easyui-combobox" style="width: 280px;"
			data-options="label:'受理类型',labelAlign:'right'">
			<option value="非计划性服务">非计划性服务</option>
			<option value="计划性服务">计划性服务</option>
		</select> <br /> <br /> <select id="ChargeType" class="easyui-combobox"
			style="width: 280px;" data-options="label:'收费类型',labelAlign:'right'">
			<option value="不收费">不收费</option>
			<option value="上门收费">上门收费</option>
		</select> <input id="DoorFee" class="easyui-textbox"
			data-options="label:'上门费',labelAlign:'right'" style="width: 280px"><br />
		<br /> <input id="AcceptDescription" class="easyui-textbox"
			data-options="label:'受理描述',labelAlign:'right',multiline:true"
			style="width: 840px; height: 100px"><br /> <br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a id="btn" href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-add'" onclick="add();">增加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
			id="btn" href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel'" onclick="addclose();">取消</a><br />
	</div>
	<div id="win2" style="display: none;">
		<br /> <br /> <input id="ShId2" class="easyui-combobox"
			type="hidden" style="width: 0px"> <input id="ShPhone2"
			class="easyui-combobox"
			data-options="label:'来电',labelAlign:'right',editable:false"
			style="width: 280px"> <input id="AppointmentTime2"
			class="easyui-datebox"
			data-options="label:'预约时间',labelAlign:'right',editable:false"
			style="width: 280px"><br /> <br /> <input id="PtDescribe2"
			class="easyui-combobox"
			data-options="label:'产品类型',labelAlign:'right'" style="width: 280px">
		<input id="PurchaseDate2" class="easyui-datebox"
			data-options="label:'购买日期',labelAlign:'right',editable:false"
			style="width: 280px"> <select id="StDescribe2"
			class="easyui-combobox" style="width: 280px;"
			data-options="label:'受理类型',labelAlign:'right'">
			<option value="非计划性服务">非计划性服务</option>
			<option value="计划性服务">计划性服务</option>
		</select> <br /> <br /> <select id="ChargeType2" class="easyui-combobox"
			style="width: 280px;" data-options="label:'收费类型',labelAlign:'right'">
			<option value="不收费">不收费</option>
			<option value="上门收费">上门收费</option>
		</select> <input id="DoorFee2" class="easyui-textbox"
			data-options="label:'上门费',labelAlign:'right'" style="width: 280px"><br />
		<br /> <input id="AcceptDescription2" class="easyui-textbox"
			data-options="label:'受理描述',labelAlign:'right',multiline:true"
			style="width: 840px; height: 100px"><br /> <br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a id="btn" href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-add'" onclick="edit();">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
			id="btn" href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel'" onclick="editclose();">取消</a><br />
	</div>

	<div id="tb">
		<select id="Dispatch3" class="easyui-combobox" style="width: 400px"
			data-options="prompt:'服务状态',label:'服务状态',labelAlign:'right',editable:false">
			<option value="">服务状态</option>
			<option value="已接单">已接单</option>
			<option value="已派工">已派工</option>
		</select> <input id="CustName" class="easyui-combobox"
			data-options="prompt:'客户名称',label:' 客户名称',labelAlign:'right',editable:false"
			style="width: 400px"> <input id="CustAddress"
			class="easyui-textbox"
			data-options="prompt:'客户地址',label:' 客户地址',labelAlign:'right'"
			style="width: 400px"> <br /> <input id="startTime"
			class="easyui-datebox"
			data-options="label:' 受理日期 ',labelAlign:'right'" style="width: 400px">
		<input id="endTime" class="easyui-datebox"
			data-options="label:' 到',labelAlign:'right'" style="width: 400px">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a id="btn"
			href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'" onclick="DataGrid();">查询</a> <a
			id="btn" href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-add'" onclick="addOpen();">增加</a> <a
			id="btn" href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-print'" onclick="dayinOpen();">导出Excel</a><a
			id="btn" href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-print'" onclick="pdfOpen();">导出Pdf</a>
	</div>
	<table id="dg"></table>
</body>
</html>