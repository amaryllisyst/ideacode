<%--
  Created by IntelliJ IDEA.
  User: 杨少婷
  Date: 2018/11/2
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <script type="text/javascript">
        $(function(){
            $("#courceTable").datagrid({
                url:'${pageContext.request.contextPath}/cource/findAll',
                fitColumns:true,
                fit:true,
                method:'post',
                striped:true,
                ctrlSelect:true,
                checkOnSelect:true,
                toolbar:'#courceToolbar',
                columns:[[
                    {title:' ',field:'checkbox',resizable:true,checkbox:true,fixed:true,width:260,},
                    {title:'ID',field:'courceId',resizable:true,fixed:true,width:310,},
                    {title:'标题',field:'courceTitle',resizable:true,fixed:true,width:260,},
                    {title:'状态',field:'courceMarking',resizable:true,fixed:true,width:260,},
                    {title:'日期',field:'courceCreateTime',resizable:true,fixed:true,width:260,},
                    {title:'Options',field:'options',resizable:true,width:160,fixed:true,
                        formatter:function (value, row, index) {
                        if(row.courceMarking=="选修"){
                            console.log("if---选修");
                            return null;
                        }else{
                            console.log("else-----必修");
                            return "<a  class='delCource' onclick=\"delCourceRow('"+row.courceId+"','"+row.courceMarking+"')\" data-options=\"iconCls:'icon-remove',plain:true,\">删除</a>&nbsp;&nbsp;" ;

                        }

                        },

                    },
                ]],
                onLoadSuccess:function(id){
                    $(".delCource").linkbutton();
                    $(".editCource").linkbutton();
                },
            });
        });
        //delete
        function delCourceRow(id){
            console.log(id);
            $.post("${pageContext.request.contextPath}/cource/remove","id="+id,function(result){
                if(result.success){
                    $("#courceTable").datagrid('reload');
                    $.messager.show({title:'提示信息',msg:"删除成功"});
                }else{
                    $("#courceTable").datagrid('reload');
                    $.messager.show({title:'错误信息',msg:result.message});

                }
            });

        }

        //save
        function saveCource(id){
            $("#saveCourceDialog").dialog({
                href:'${pageContext.request.contextPath}/back/cource/save.jsp',
                width:500,
                height:400,
                resizable:true,
                buttons:[
                    {iconCls:'icon-save',text:'add',
                        handler:function(){
                            $("#saveCourceForm").form('submit',{
                                url:'${pageContext.request.contextPath}/cource/add',
                                success:function(data){
                                    var result=$.parseJSON(data);
                                    console.log("--r----"+result);
                                    if(result) {
                                        $.messager.show({title: '提示信息', msg: '保存成功',});
                                        $("#saveCourceDialog").dialog('close');
                                    }else{
                                        $.messager.show({title: '提示XX信息', msg: result.message,});
                                        $("#saveCourceDialog").dialog('close');
                                    }
                                    $("#courceTable").datagrid('reload');
                                } ,
                            });
                        },
                    },
                    {iconCls:'icon-remove',text:'close',
                        handler:function(){
                            $("#saveCourceDialog").dialog('close');
                        }}
                ],

            });
        }





    </script>


<table id="courceTable" class="easyui-datagrid"></table>

<%--修改ource的对话框--%>
<div  id="updateCourceDialog"></div>
<%--工具栏--%>
<div id="courceToolbar">
    <a href="#" onclick="saveCource()" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">添加</a>
</div>
<div id="saveCourceDialog"></div>


