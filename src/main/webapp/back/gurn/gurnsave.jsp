<%@page pageEncoding="UTF-8" %>

<div style="text-align: center;">
    <form id="gurnaddForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            名字: <input type="text" name="name" class="easyui-textbox" data-options="required:true,prompt:'title'">
        </div>
        <div style="margin-top: 20px;">
            图片: <input type="text" name="file"  class="easyui-filebox" data-options="required:true,buttonAlign:'left'">
        </div>
        <div style="margin-top: 20px;">
            性别: <input type="text" name="sex"  class="easyui-sexbox" data-options="required:true,prompt:'number'">
        </div>
    </form>
</div>