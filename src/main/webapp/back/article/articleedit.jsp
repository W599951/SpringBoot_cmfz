<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("#articleeditForm").form('load','${pageContext.request.contextPath}/article/findOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="articleeditForm" class="easyui-form" method="post">
        <div style="margin-top: 70px;">
            标题: <input type="text" name="title" class="easyui-textbox" data-options="required:true,prompt:'title'">
        </div>
        <div style="margin-top: 20px;">
            状态: <input type="text" name="marking"  class="easyui-textbox" data-options="required:true,prompt:'yes or no'">
        </div>
        <div style="margin-top: 20px;">
            用户ID: <input type="text" name="user_id"  class="easyui-textbox" data-options="required:true,prompt:'number'">
        </div>
    </form>
</div>