<%--
  Created by IntelliJ IDEA.
  User: 杨少婷
  Date: 2018/10/26
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/form.validator.rules.js"></script>

    <script type="text/javascript">
        $(function(){
            //显示左侧栏 菜单数据
            $.ajax({
                url:"${pageContext.request.contextPath}/menu/findAll",
                type:'post',
                dataType:'json',
                success:function (menu) {
                    //遍历一级菜单
                    $.each(menu,function(index,m){
                        //遍历二级菜单\
                        console.log("menu:"+menu);
                        var content="<div >"
                        $.each(m.menus,function(idx,child){
                            console.log("-------------------------");
                            content+="<a onclick=\"openTabs('"+child.name+"','"+child.iconCls+"','"+child.href+"')\"      style='width:69%;margin:10px 0px; border: 2px #9FF solid;' class='easyui-linkbutton' data-options=\"iconCls:'"+child.iconCls+"'\"   >  "+child.name+"</a>";
                        });
                        content+="</div>"
                        $("#menu").accordion("add",{
                            title:m.name,
                            iconCls:m.iconCls,
                            content:content,
                        });
                    });
                },
                error:function () {
                    location.href="${pageContext.request.contextPath}/back/login.jsp";
                }
            })
            $("#tabs").tabs({fit:true,fitColumns:true,});
        });
 //----------点击左侧栏菜单  显示选项卡
            function openTabs(title,iconCls,href){
                if(!$('#tabs').tabs('exists',title)){
                    $("#tabs").tabs('add',{
                       title:title,
                        iconCls:iconCls,
                        closable:true,
                        href:'${pageContext.request.contextPath}/'+href,
                    });
                }else{
                    $("#tabs").tabs('select',title);
                }
            }
//------------------修改管理员密码

        function editAdminPassword(){
            $("#editAdminPasswordDialog").dialog({
                width:400,
                height:300,
                resizable:true,
                method:'post',
                href:'${pageContext.request.contextPath}/back/admin/editAdminPassword.jsp',
                buttons:[
                    {
                        text:"修改",
                        handler:function(){
                            $("#editAdminPasswordForm").form('submit',{
                                url:"${pageContext.request.contextPath}/admin/update",
                                success:function(result){
                                    var data=$.parseJSON(result);
                                    console.log(data)
                                    if(data==true) {
                                        $.messager.show({title:'提示信息',msg:'修改成功',});
                                        $("#editAdminPasswordDialog").dialog('close');
                                    }else{
                                        $.messager.show({title:'错误信息',msg:'修改错误',});
                                        $("#editAdminPasswordDialog").dialog('close');
                                    }
                                }
                            });
                        }
                    },
                    {
                        text:"取消",
                        handler:function(){
                            $("#editAdminPassword").dialog('close');
                        }
                    },
                ]
            });
        }
//退出系统
        function quit(){
                location.href="${pageContext.request.contextPath}/admin/quit";
        };
    </script>
</head>











<body class="easyui-layout">

<!-- 页面头部分 -->
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.realname} &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="editAdminPassword()">修改密码</a>&nbsp;&nbsp;
        <a href="#" class="easyui-linkbutton"  onclick="quit()" data-options="iconCls:'icon-no'">退出系统</a></div>
</div>
<%--********************************************************************************************--%>
<%--   左边栏菜单   --%>
<div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    <!--菜单  -->
    <div id="menu" class="easyui-accordion" data-options="fitL:true" style="width:300px;height:300px;">

    </div>

</div>

<%--修改密码框--%>
<div id="editAdminPasswordDialog"></div>

<%--中心主页--%>

<div data-options="region:'center',fit:true,fitColumns:true,">
    <%--选项卡--%>
    <div id="tabs" class="easyui-tabs" data-options="narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/back/img/others/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
</body>
<%--**********************************************************&************************--%>
<!-- 页面尾部分 -->
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
</div>

</html>
