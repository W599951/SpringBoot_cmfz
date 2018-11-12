<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("#gurneditForm").form('load','${pageContext.request.contextPath}/gurn/findOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="gurneditForm" class="easyui-form" method="post">
        <input type="hidden" name="id"/>
        <div style="margin-top: 70px;">
            名字: <input type="text" name="name" class="easyui-textbox" data-options="required:true,prompt:'title'">
        </div>
        <div style="margin-top: 20px;">
            性别: <input type="text" name="sex"  class="easyui-textbox" data-options="required:true">
        </div>
    </form>
</div>