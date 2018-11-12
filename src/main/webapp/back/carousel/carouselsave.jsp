<%@page pageEncoding="UTF-8" %>

<div style="text-align: center;">
    <form id="carouseladdForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            标题: <input type="text" name="title" class="easyui-textbox" data-options="required:true,prompt:'title'">
        </div>
        <div style="margin-top: 20px;">
            图片: <input type="text" name="file"  class="easyui-filebox" data-options="required:true,buttonAlign:'left'">
        </div>
        <div style="margin-top: 20px;">
            状态: <input type="text" name="status"  class="easyui-textbox" data-options="required:true,prompt:'yes or no'">
        </div>
        <div style="margin-top: 20px;">
            顺序: <input type="text" name="ordernum"  class="easyui-textbox" data-options="required:true,prompt:'number'">
        </div>
    </form>
</div>