<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>持名法州后台管理中心</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/form.validator.rules.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/easyui-lang-zh_CN.js"></script>

    <link rel="icon" href="${pageContext.request.contextPath}/back/easyui/img/favicon.ico" type="${pageContext.request.contextPath}/back/easyui/image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/easyui/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back/easyui/css/login.css" type="text/css"></link>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/script/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/script/common.js"></script>
    <script type="text/javascript">

        	$(function(){
                //点击更换验证码：
            $("#captchaImage").click(function(){//点击更换验证码
                $("#captchaImage").src = "${pageContext.request.contextPath}/Code/code?time="+new Date();
            });


            });
            function fun(tag){
                tag.src ="${pageContext.request.contextPath}/Code/code?time="+new Date();
            }
    </script>
</head>
<body>

<div class="login">
    <form id="loginForm" action="${pageContext.request.contextPath}/admin/login" method="post" >

        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="${pageContext.request.contextPath}/back/easyui/img/header_logo.gif" />
                </td>
                <th>
                    用户名:
                </th>
                <td>
                    <input name="name" type="text" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'" prompt="请输入用户名,邮箱,手机号登陆">
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input name="password" type="test" class="easyui-passwordbox" data-options="required:true," prompt="请输入密码">
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input type="text" id="enCode" name="code" class="text captcha" maxlength="4" autocomplete="off"/>
                    <img id="captchaImage" onclick="fun(this)" class="captchaImage" src="${pageContext.request.contextPath}/Code/code" title="点击更换验证码"/>
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
                <th>
                    &nbsp;
                </th>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
                </td>
            </tr>
            </tbody></table>
        <div class="powered">COPYRIGHT © 2008-2018.</div>
        <div class="link">
            <a href="http://www.chimingfowang.com/">持名佛网首页</a> |
            <a href="http://www.chimingbbs.com/">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
    </form>
</div>
</body>
</html>