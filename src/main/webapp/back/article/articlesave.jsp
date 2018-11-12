<%@page pageEncoding="UTF-8" %>

<div style="text-align: center;">
    <form id="articleaddForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            标题: <input type="text" name="title" class="easyui-textbox" data-options="required:true,prompt:'title'">
        </div>
        <div style="margin-top: 20px;">
            内容: <input type="text" name="content"  class="easyui-textbox" data-options="required:true,prompt:'content'">
        </div>
        <div style="margin-top: 20px;">
            图片: <input type="text" name="file"  class="easyui-filebox" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            用户ID: <input type="text" name="gurn_id"  class="easyui-textbox" data-options="required:true,prompt:'number'">
        </div>
    </form>
</div>