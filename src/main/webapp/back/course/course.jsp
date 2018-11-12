<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $("#course").datagrid({
            url: '${pageContext.request.contextPath}/course/findAll',
            pagination: true,
            fit: true,
            toolbar: [
                {
                    text: '添加',
                    iconCls: 'icon-add',
                    handler: function () {
                        $("#coursesaveDialog").dialog({
                            buttons: [
                                {
                                    text: '保存',
                                    iconCls: 'icon-save',
                                    handler: function () {
                                        //保存用户信息
                                        $("#courseaddForm").form('submit', {
                                            url:'${pageContext.request.contextPath}/course/save',
                                            success: function (result) {//响应的一定是json格式字符串   使用应该先转为js对象
                                                //提示信息
                                                $.messager.show({title: '提示', msg: '添加成功！'});
                                                //关闭对话框
                                                $("#coursesaveDialog").dialog('close');
                                                //刷新datagrid
                                                $("#course").datagrid('reload');
                                            }
                                        });
                                    }
                                }, {
                                    iconCls: 'icon-cancel',
                                    text: '关闭',
                                    handler: function () {
                                        $("#coursesaveDialog").dialog('close');
                                    }
                                }
                            ],
                        });
                    }
                },
                {
                    text: '删除',
                    iconCls: 'icon-remove',
                    handler: function () {
                        var rows = $("#course").datagrid('getSelections');
                        if (rows.length < 0) {
                            $.messager.show({title: '提示', msg: '至少选一行'});
                        } else {
                            var ids = [];
                            for (var i = 0; i < rows.length; i++) {
                                ids.push(rows[i].id);
                            }
                            //发送ajax请求传递数组  注意: $.get $.post 只能传递简单数据(key=value) 不能数组类型的数据
                            //如果想要传递数组类型的数据只能使用  $.ajax 并且还要设置其中的一个属性
                            $.ajax({
                                url: '${pageContext.request.contextPath}/course/delBatchRows',
                                type: 'POST',
                                traditional: true,//传递数据类型的数据时必须设置这个属性为true
                                data: {id: ids},
                                success: function (result) {
                                    //消息提示
                                    $.messager.show({title: '提示', msg: "删除成功!!!"});
                                    //刷新datagrid
                                    $("#course").datagrid('reload');
                                },
                                error: function () {
                                    //消息提示
                                    $.messager.show({title: '提示', msg: "删除失败!!!"});
                                    //刷新datagrid
                                    $("#course").datagrid('reload');
                                }
                            })
                        }
                    }
                }
            ],
            columns: [[
                {title: "cks", field: "cks", checkbox: true},
                {title: '名字', field: 'title', width: 120,},
                {title: '状态', field: 'marking', width: 120,},
                {title: '用户ID', field: 'user_id', width: 120,},
                {title: '时间', field: 'createDate', width: 120,},
                {title:'操作',field:'options',width:120,
                    formatter:function (value,row,index) {
                        return "<a href='javascript:;' class='del' onclick=\"delRow('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>";
                    }
                },
            ]],
            onLoadSuccess:function () {
                $(".del").linkbutton();
            },
        });
    });
    //删除一行的事件
    function delRow(id){
        $.messager.confirm("确认对话框","确定删除么？？",function(b){
            if(b){

                //获取当前点击id发送ajax请求删除id这个人的信息
                $.post("${pageContext.request.contextPath}/course/delete",{"id":id},function (result) {//响应成功之后回调
                    //刷新datagrid数据
                    $("#course").datagrid('reload');//刷新当前datagrid
                });
            }
        })

    }

</script>
<table id="course" class="easyui-datagrid" data-options="fit:true"></table>

<%--添加对话框--%>
<div id="coursesaveDialog"
     data-options="href:'${pageContext.request.contextPath}/back/course/coursesave.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'添加'"></div>

    <%--修改对话框--%>
    <div id="courseeditDialog" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'修改信息'">
    </div>
