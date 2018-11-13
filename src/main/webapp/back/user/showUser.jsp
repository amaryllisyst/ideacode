<%--
  Created by IntelliJ IDEA.
  User: 杨少婷
  Date: 2018/11/5
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <script type="text/javascript">
        $(function(){
            $("#userTable").datagrid({
                url:'${pageContext.request.contextPath}/user/findByPage',
                fitColumns:true,
                fit:true,
                method:'post',
                striped:true,
                pagination:true,
                ctrlSelect:true,
                checkOnSelect:true,
                pageNumber:1,
                toolbar:'#userToolbar',
                pageList:[3,5,10,15,20,25],
                columns:[[
                    {title:' ',field:'checkbox',resizable:true,checkbox:true,fixed:true,width:120,},
                    {title:'ID',field:'userId',resizable:true,fixed:true,width:170,},
                    {title:'名字',field:'userPhone',resizable:true,fixed:true,width:80,},
                    {title:'昵称',field:'userNickname',resizable:true,fixed:true,width:80,},
                    {title:'真实姓名',field:'userRealname',resizable:true,fixed:true,width:80,},
                    {title:'盐值',field:'userSalt',resizable:true,fixed:true,width:170,},
                    {title:'省份',field:'userProvince',resizable:true,fixed:true,width:50,},
                    {title:'城市',field:'userCity',resizable:true,fixed:true,width:50,},
                    {title:'头像',field:'userAvatar',resizable:true,fixed:true,width:120,},
                    {title:'个签',field:'userSign',resizable:true,fixed:true,width:120,},
                    {title:'性别',field:'userGender',resizable:true,fixed:true,width:50,},
                    {title:'状态',field:'userStatus',resizable:true,fixed:true,width:60,},
                    {title:'日期',field:'userDate',resizable:true,fixed:true,width:80,},
                    {title:'Options',field:'options',resizable:true,width:130,fixed:true,
                        formatter:function (value, row, index) {
                            return "<a  class='editUser' onclick=\"editUser('"+row.userId+"','"+row.userStatus+"')\" data-options=\"iconCls:'icon-remove',plain:true,\">冻结或解除状态</a>&nbsp;&nbsp;"
                        },

                    },
                ]],
                onLoadSuccess:function(id){
                    $(".editUser").linkbutton();
                },
            });
        });

 //edit
        function editUser(id,status){
            $.messager.confirm('确认对话框', '您确定要执行此操作吗？', function(r){
                if (r){
                    console.log("---if---");
                    $.post("${pageContext.request.contextPath}/user/modify","userId="+id+"&userStatus="+status,function (result){
                        if(result.success){
                            $("#userTable").datagrid('reload');
                            $.messager.show({title:'提示信息',msg:"执行成功"});
                        }else{
                            $("#userTable").datagrid('reload');
                            $.messager.show({title:'错误信息',msg:result.message});

                        }
                    })
                    // 退出操作;
                }
            });


        }
    </script>

<table id="userTable" class="easyui-datagrid"></table>
<%--工具栏--%>
<div id="userToolbar">
    <%--<a href="#" onclick="likeUser()" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">查找</a>--%>
</div>

