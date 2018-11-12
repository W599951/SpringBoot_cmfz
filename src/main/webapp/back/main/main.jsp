<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%
    if (session.getAttribute("name") == null) {
        response.sendRedirect("../user/login.jsp");
        return;
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/css/jquery.treegrid.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/metro-orange/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/jquery.etree.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        $(function () {
            //页面加载完成之后显示菜单数据
            $.post("${pageContext.request.contextPath}/menu/findAll",function (menu) {
                //通过accordion的添加方法追加菜单
                console.log(menu);
                //遍历一级菜单
                $.each(menu,function (index,m) {
                    //遍历二级菜单
                    var context = "<div style='text-align: center;'>";
                    $.each(m.menus,function (idx,child) {
                        context +="<a onclick=\"addTabs('"+child.title+"','"+child.iconCls+"','"+child.href+"')\" style='width:95%;margin:10px 0px; border: 2px #00ee00 solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\">"+child.title+"</a><br>";
                    });
                    context += "</div>";
                    //添加菜单
                    $("#menu").accordion('add',{
                        title:m.title,
                        iconCls:m.iconCls,
                        content:context,
                    })
                });
            });
        });
        //点击菜单追加选项卡
        function addTabs(title,iconCls,href) {
            //添加以前先判断tabs中是否存在这个选项卡
            if (!$("#tabs").tabs('exists',title)){
                $("#tabs").tabs('add',{
                    title:title,
                    iconCls:iconCls,
                    closable:true,
                    href:"${pageContext.request.contextPath}/"+href,
                    fit:true,
                });
            } else {
                $("#tabs").tabs('select',title);
            }
        }
        //修改密码
        function editpswd() {
            $("#editDialog").dialog({
                href:'${pageContext.request.contextPath}/back/user/editpassword.jsp',
                buttons:[
                    {
                    text:'确认',
                    iconCls:'icon-save',
                    handler: function () {
                        $("#editpwdForm").form('submit',{
                            url:'${pageContext.request.contextPath}/admin/update',
                            success:function (result) {
                                var json=$.parseJSON(result);
                                if(json.success){
                                    $.messager.show({title:'提示',msg:"修改密码成功！！！"});
                                }else{
                                    $.messager.show({title:'提示',msg:"修改密码失败！！！"});
                                }
                                $("#editDialog").dialog('close');
                            }
                        })
                    }
                },{
                    iconCls:'icon-cencel',
                    text:'关闭',
                    handler:function () {
                        $("#editDialog").dialog('close');
                    }
                    }
        ]
        });
        }
    </script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
        <div id="time1"
             style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 260px;float:left;padding-top:15px;padding-left: -30px">
            <script type="text/javascript">
                //非动态显示
                //document.getElementById('time1').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());
                //动态显示
                setInterval("document.getElementById('time1').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());", 500);
            </script>
        </div>
        <div style="font-size: 24px;text-align:center;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 200px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.name} &nbsp;<a class="easyui-linkbutton" onclick="editpswd()" data-options="iconCls:'icon-edit'">修改密码
        </a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/exit" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="menu" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/back/easyui/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 90%;"></div>
		</div>  
    </div>

    <%--修改密码对话框--%>
    <div id="editDialog" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'修改管理员密码'">
    </div>
</body> 
</html>