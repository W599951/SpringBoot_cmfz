<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center;">
    <form id="editpwdForm" class="easyui-form" method="post">
        <div style="margin-top: 70px;">
            管理员: <input type="text" name="name" value="${sessionScope.name}" class="easyui-textbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            旧密码: <input type="text" name="oldpassword"  class="easyui-textbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            新密码: <input type="text" name="password"  class="easyui-passwordbox" data-options="required:true">
        </div>
    </form>
</div>0