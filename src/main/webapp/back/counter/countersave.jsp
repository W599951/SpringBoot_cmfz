<%@page pageEncoding="UTF-8" %>

<div style="text-align: center;">
    <form id="counteraddForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            标题: <input type="text" name="title" class="easyui-textbox" data-options="required:true,prompt:'title'">
        </div>
        <div style="margin-top: 20px;">
            数值: <input type="text" name="count"  class="easyui-textbox" data-options="required:true,buttonAlign:'left'">
        </div>
        <div style="margin-top: 20px;">
            状态: <input type="text" name="marking"  class="easyui-textbox" data-options="required:true,prompt:'yes or no'">
        </div>
        <div style="margin-top: 20px;">
            用户ID: <input type="text" name="user_id"  class="easyui-textbox" data-options="required:true,prompt:'number'">
        </div>
        <div style="margin-top: 20px;">
            课程ID: <input type="text" name="course_id"  class="easyui-textbox" data-options="required:true,prompt:'number'">
        </div>
    </form>
</div>