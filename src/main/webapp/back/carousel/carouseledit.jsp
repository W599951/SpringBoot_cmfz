<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("#carouseleditForm").form('load','${pageContext.request.contextPath}/carousel/findOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="carouseleditForm" class="easyui-form" method="post">
        <div style="margin-top: 70px;">
            id: <input type="text" name="id" class="easyui-textbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            标题: <input type="text" name="title" class="easyui-textbox" data-options="required:true,prompt:'title'">
        </div>
        <div style="margin-top: 20px;">
            时间: <input type="text" name="createDate"  class="easyui-datebox" data-options="required:true,buttonAlign:'left'">
        </div>
        <div style="margin-top: 20px;">
            状态: <input type="text" name="status"  class="easyui-textbox" data-options="required:true,prompt:'yes or no'">
        </div>
       <%-- <div style="margin-top: 20px;">
            顺序: <input type="text" name="ordernum"  class="easyui-textbox" data-options="required:true,prompt:'number'">
        </div>--%>
    </form>
</div>