<%--
  Created by IntelliJ IDEA.
  User: 杨少婷
  Date: 2018/10/26
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

    <script type="text/javascript">
            $(function(){
                $("#guruTable").datagrid({
                    url:'${pageContext.request.contextPath}/guru/findByPage',
                    fitColumns:true,
                    fit:true,
                    method:'post',
                    striped:true,
                    pagination:true,
                    ctrlSelect:true,
                    checkOnSelect:true,
                    pageNumber:1,
                    toolbar:'#guruToolbar',
                    pageList:[3,5,10,15,20,25],
                    columns:[[
                        {title:' ',field:'checkbox',resizable:true,checkbox:true,fixed:true,width:280,},
                        {title:'ID',field:'guruId',resizable:true,fixed:true,width:340,},
                        {title:'名字',field:'guruName',resizable:true,fixed:true,width:220,},
                        {title:'头像',field:'guruAvatar',resizable:true,fixed:true,width:260,},
                        {title:'性别',field:'guruGender',resizable:true,fixed:true,width:150,},
                        {title:'Options',field:'options',resizable:true,width:240,fixed:true,
                            formatter:function (value, row, index) {
                                return "<a  class='delGuru' onclick=\"delGuruRow('"+row.guruId+"')\" data-options=\"iconCls:'icon-remove',plain:true,\">删除</a>&nbsp;&nbsp;" +
                                    "<a class='editGuru' onclick=\"editGuru('"+row.guruId+"','"+row.guruAvatar+"')\"  data-options=\"iconCls:'icon-edit',plain:true,\">更新</a>";
                            },

                        },
                    ]],
                    onLoadSuccess:function(id){
                      $(".delGuru").linkbutton();
                      $(".editGuru").linkbutton();
                    },
                    view: detailview,
                    detailFormatter: function(rowIndex, rowData){
                        return '<table><tr>' +
                            '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/'+rowData.guruAvatar+'" style="height:50px;"></td>' +
                            '<td style="border:0">' +
                            '<p>Name: ' + rowData.guruId + '</p>' +
                            '<p>Gender: ' + rowData.guruName + '</p>' +
                            '</td>' +
                            '</tr></table>';
                    }
                });
            });
    //delete
            function delGuruRow(id){
                console.log(id);
                $.post("${pageContext.request.contextPath}/guru/remove","id="+id,function(result){
                    if(result.success){
                        $("#guruTable").datagrid('reload');
                        $.messager.show({title:'提示信息',msg:"删除成功"});
                    }else{
                        $("#guruTable").datagrid('reload');
                        $.messager.show({title:'错误信息',msg:result.message});

                    }
                });

            }
//edit
        function editGuru(id,avatar){
           // $("#grey").textbox("setValue", "22012");
            $("#updateGuruDialog").dialog({
                href:'${pageContext.request.contextPath}/back/guru/edit.jsp?id='+id+'&avatar='+avatar,
                width:500,
                height:400,
                resizable:true,

                buttons:[
                    {iconCls:'icon-edit',text:'edit',
                        handler:function(){
                            $("#editGuruForm").form('submit',{
                               url:'${pageContext.request.contextPath}/guru/modify',
                               success:function(result){
                                   $.messager.show({title:'提示信息',msg:'修改成功',});
                                   $("#updateGuruDialog").dialog('close');
                                  $("#guruTable").datagrid('reload');
                               } ,
                            });
                        },
                    },
                    {iconCls:'icon-remove',text:'close',
                    handler:function(){
                        $("#updateGuruDialog").dialog('close');
                    }}

                ],

            });
        }
//save
            function saveGuru(id){
                $("#saveGuruDialog").dialog({
                    href:'${pageContext.request.contextPath}/back/guru/add.jsp',
                    width:500,
                    height:400,
                    resizable:true,
                    buttons:[
                        {iconCls:'icon-save',text:'edit',
                            handler:function(){
                                $("#saveGuruForm").form('submit',{
                                    url:'${pageContext.request.contextPath}/guru/add',
                                    success:function(data){
                                        var result=$.parseJSON(data);
                                        console.log("--r----"+result);
                                        if(result) {
                                            $.messager.show({title: '提示信息', msg: '保存成功',});
                                            $("#saveGuruDialog").dialog('close');
                                        }else{
                                            $.messager.alert('提示消息','请选择上传图片！','warning');
                                            $("#saveGuruDialog").dialog('close');
                                        }
                                        $("#guruTable").datagrid('reload');
                                    } ,
                                });
                            },
                        },
                        {iconCls:'icon-remove',text:'close',
                            handler:function(){
                                $("#saveGuruDialog").dialog('close');
                            }}
                    ],

                });
            }


  //delete more
            function delMoreRows(){

                var rows=$("#guruTable").datagrid('getSelections');
                if(rows.length<=0){
                    $.messager.show({title:'提示',msg:'至少选中一行！'});
                }else{
                    //设置一个空的数组存放
                    var ids=[];
                    for(var i=0;i<rows.length;i++) {
                        //把接收的id填充到rows中
                        console.log(rows[i].guruId);
                        ids.push(rows[i].guruId);
                    }
                    console.log(ids);
                    $.ajax({
                        url:'${pageContext.request.contextPath}/guru/deleteMore',
                        type:"POST",
                        traditional:true,//传递数据类型的数据时必须设置这个属性为true
                        data:{id:ids},
                        success:function (result) {
                            //消息提示
                            $.messager.show({title:'提示',msg:"删除成功!!!"});
                            //刷新datagrid
                            $("#guruTable").datagrid('reload');
                        },
                        error:function () {
                            //消息提示
                            $.messager.show({title:'提示',msg:"删除失败!!!"});
                            //刷新datagrid
                            $("#guruTable").datagrid('reload');
                        }
                    })
                }
            }


    </script>

<table id="guruTable" class="easyui-datagrid"></table>

<%--修改guru的对话框--%>
<div  id="updateGuruDialog"></div>
<%--工具栏--%>
<div id="guruToolbar">
    <a href="#" class="easyui-linkbutton" onclick="delMoreRows()" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
    <a href="#" onclick="saveGuru()" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">添加</a>
</div>
<div id="saveGuruDialog"></div>

