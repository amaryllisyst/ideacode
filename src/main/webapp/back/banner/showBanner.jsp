<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <script type="text/javascript">
            $(function(){
                $("#bannerTable").datagrid({
                    url:'${pageContext.request.contextPath}/banner/findByPage',
                    fitColumns:true,
                    fit:true,
                    method:'post',
                    striped:true,
                    pagination:true,
                    ctrlSelect:true,
                    checkOnSelect:true,
                    pageNumber:5,
                    toolbar:'#bannerToolbar',
                    pageList:[3,5,10,15,20,25],
                    columns:[[
                        {title:' ',field:'checkbox',resizable:true,checkbox:true,fixed:true,width:300,},
                        {title:'ID',field:'bannerId',resizable:true,fixed:true,width:247,},
                        {title:'标题',field:'bannerTitle',resizable:true,fixed:true,width:150,},
                        {title:'图片路径',field:'bannerImgPath',resizable:true,fixed:true,width:150,},
                        {title:'描述',field:'bannerDesc',resizable:true,fixed:true,width:150,},
                        {title:'状态',field:'bannerStatus',resizable:true,fixed:true,width:220,},
                        {title:'日期',field:'bannerDate',resizable:true,fixed:true,width:150,},
                        {title:'Options',field:'options',resizable:true,width:180,fixed:true,
                            formatter:function (value, row, index) {
                                return "<a  class='delBanner' onclick=\"delBannerRow('"+row.bannerId+"')\" data-options=\"iconCls:'icon-remove',plain:true,\">删除</a>&nbsp;&nbsp;" +
                                    "<a class='editBanner' onclick=\"editBanner('"+row.bannerId+"','"+row.bannerImgPath+"')\"  data-options=\"iconCls:'icon-edit',plain:true,\">更新</a>";
                            },

                        },
                    ]],
                    onLoadSuccess:function(id){
                      $(".delBanner").linkbutton();
                      $(".editBanner").linkbutton();
                    },
                    view: detailview,
                    detailFormatter: function(rowIndex, rowData){
                        return '<table><tr>' +
                            '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/'+rowData.bannerImgPath+'" style="height:50px;"></td>' +
                            '<td style="border:0">' +
                            '<p>Attribute: ' + rowData.bannerTitle + '</p>' +
                            '<p>Status: ' + rowData.bannerStatus + '</p>' +
                            '</td>' +
                            '</tr></table>';
                    }
                });
            });
    //delete
            function delBannerRow(id){
                console.log(id);
                $.post("${pageContext.request.contextPath}/banner/remove","id="+id,function(result){
                    console.log("============sss================");
                    //这儿的success 和后端的 key一样即可，必须一样
                    if(result.success){
                        console.log("============if================");
                        $("#bannerTable").datagrid('reload');
                        $.messager.show({title:'提示信息',msg:"删除成功"});
                    }else{
                        $("#bannerTable").datagrid('reload');
                        $.messager.show({title:'错误信息',msg:result.message});

                    }
                });

            }
//edit
        function editBanner(id,path){
            $("#updateBannerDialog").dialog({
                href:'${pageContext.request.contextPath}/back/banner/edit.jsp?id='+id+"&bannerImgPath="+path,
                width:500,
                height:400,
                resizable:true,
                buttons:[
                    {iconCls:'icon-edit',text:'edit',
                        handler:function(){
                            $("#editBannerForm").form('submit',{
                               url:'${pageContext.request.contextPath}/banner/modify',
                               success:function(result){
                                   $.messager.show({title:'提示信息',msg:'修改成功',});
                                   $("#updateBannerDialog").dialog('close');

                                  $("#bannerTable").datagrid('reload');
                               } ,
                            });
                        },
                    },
                    {iconCls:'icon-remove',text:'close',
                    handler:function(){
                        $("#updateBannerDialog").dialog('close');
                    }}

                ],

            });
        }
//save
            function saveBanner(id){
                $("#saveBannerDialog").dialog({
                    href:'${pageContext.request.contextPath}/back/banner/save.jsp',
                    width:500,
                    height:400,
                    resizable:true,
                    buttons:[
                        {iconCls:'icon-save',text:'add',
                            handler:function(){
                                $("#saveBannerForm").form('submit',{
                                    url:'${pageContext.request.contextPath}/banner/add',
                                    success:function(result){
                                        $.messager.show({title:'提示信息',msg:'保存成功',});
                                        $("#saveBannerDialog").dialog('close');

                                        $("#bannerTable").datagrid('reload');
                                    } ,
                                });
                            },
                        },
                        {iconCls:'icon-remove',text:'close',
                            handler:function(){
                                $("#saveBannerDialog").dialog('close');
                            }}
                    ],

                });
            }


  //delete more
            function delMoreRows(){

                var rows=$("#bannerTable").datagrid('getSelections');
                if(rows.length<=0){
                    $.messager.show({title:'提示',msg:'至少选中一行！'});
                }else{
                    //设置一个空的数组存放
                    var ids=[];
                    for(var i=0;i<rows.length;i++) {
                        //把接收的id填充到rows中
                        console.log(rows[i].bannerId);
                        ids.push(rows[i].bannerId);
                    }
                    console.log(ids);
                    $.ajax({
                        url:'${pageContext.request.contextPath}/banner/deleteMore',
                        type:"POST",
                        traditional:true,//传递数据类型的数据时必须设置这个属性为true
                        data:{id:ids},
                        success:function (result) {
                            //消息提示
                            $.messager.show({title:'提示',msg:"删除成功!!!"});
                            //刷新datagrid
                            $("#bannerTable").datagrid('reload');
                        },
                        error:function () {
                            //消息提示
                            $.messager.show({title:'提示',msg:"删除失败!!!"});
                            //刷新datagrid
                            $("#bannerTable").datagrid('reload');
                        }
                    })
                }
            }
    </script>
<table id="bannerTable" class="easyui-datagrid"></table>
<%--修改banner的对话框--%>
<div  id="updateBannerDialog"></div>
<%--工具栏--%>
<div id="bannerToolbar">
    <a href="#" class="easyui-linkbutton" onclick="delMoreRows()" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
    <a href="#" onclick="saveBanner()" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">添加</a>
</div>
<div id="saveBannerDialog"></div>

