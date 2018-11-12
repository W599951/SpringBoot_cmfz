<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("#countereditForm").form('load','${pageContext.request.contextPath}/counter/findOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="countereditForm" class="easyui-form" method="post">
        <div style="margin-top: 70px;">
            标题: <input type="text" name="title" class="easyui-textbox" data-options="required:true,prompt:'title'">
        </div>
        <div style="margin-top: 20px;">
            数值: <input type="text" name="count"  class="easyui-textbox" data-options="required:true,buttonAlign:'left'">
        </div>
        <div style="margin-top: 20px;">
            用户ID: <input type="text" name="user_id"  class="easyui-textbox" data-options="required:true,prompt:'number'">
        </div>
        <div style="margin-top: 20px;">
            课程ID: <input type="text" name="course_id"  class="easyui-textbox" data-options="required:true,prompt:'number'">
        </div>
    </form>
</div>