<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<script>
    $(function () {
        $("#albumtable").treegrid({
            url:'${pagecontext.request.contextpath}/album/findall',
            fit:true,
            fitcloumns:true,
            loadmsg:'正在加载.....',
            method:'post',
            checkbox:true,
            animate:true,
            striped:true,
            toolbar:'#albumtoobar',
            align:'center',
            idfield:'id',//id名必须一样       id数据不能一样   不然没有收缩效果 也没有选中行的效果
            treefield:'title',//两个实体类的名字必须一样   这儿：以title为树干
            columns:[[
                {title:'名字',field:'title',width:150},
                {title:'章节大小',field:'chaptersize',width:100},
                {title:'章节时长',field:'chapterduration',width:200},
                {title:'下载路径',field:'chapterdownloadpath',width:300},
                {title:'发布时间',field:'chapteruploaddate',width:220},
                {title:'tu',field:'albumconverpath',width:220},
            ]]
        });
    });


 //添加专辑
    function addalbum() {
            $("#addalbumdialog").dialog({
            buttons:[{
                text:'保存',
                iconcls:'icon-save',
                handler:function () {
                    $("#addalbumform").form('submit',{
                        url:'${pagecontext.request.contextpath}/album/add',
                        success:function (data) {
                            var result = $.parsejson(data);
                            if (result.success){
                                $.messager.show({title:'提示',msg:'添加成功'});
                                $("#addalbumdialog").dialog('close');
                                $("#albumtable").datagrid('reload');
                            } else{
                                $.messager.show({title:'提示',msg:result.message});
                                $("#addalbumdialog").dialog('close');
                                $("#albumtable").datagrid('reload');
                            }


                        }
                    });
                }
            },{
                text:'取消',
                iconcls:'icon-cancel',
                handler:function () {
                    $("#addalbumdialog").dialog('close');
                }
            }]
        });

    }

 //添加章节
    function addchapter() {
        var select=$("#albumtable").treegrid('getselected');
        if (select != null) {
            console.log("-----if(select!=null)  and  level！=1----" + $("#albumtable").treegrid('getselected').id);
            var selectid = $("#albumtable").treegrid('getselected').id;
            var level = $("#albumtable").treegrid('getlevel', selectid);
                            if(level==1){
                                console.log("---if(level==1)----");
                                                $("#addchapterdialog").dialog({
                                                    href:'${pagecontext.request.contextpath}/back/album/addchapter.jsp?selectid='+selectid,
                                                    buttons:[{
                                                        text:'保存',
                                                        iconcls:'icon-save',
                                                        handler:function () {
                                                            $("#addchapterform").form('submit',{
                                                                url:'${pagecontext.request.contextpath}/chapter/add',
                                                                success:function (data) {
                                                                    var result = $.parsejson(data);
                                                                    if ($.parsejson(data).success){
                                                                        $.messager.show({title:'提示',msg:'添加成功'});
                                                                        $("#addchapterdialog").dialog('close');
                                                                        $("#albumtable").datagrid('reload');
                                                                    } else{
                                                                        $.messager.show({title:'提示',msg:result.message});
                                                                        $("#addchapterdialog").dialog('close');
                                                                        $("#albumtable").datagrid('reload');
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    },{
                                                        text:'取消',
                                                        iconcls:'icon-cancel',
                                                        handler:function () {
                                                            $("#addchapterdialog").dialog('close');
                                                        }
                                                    }]
                                                });
                            }else{
                                $.messager.show({title:'提示',msg:'请选择要添加的专辑，必须是专辑！'});
                            }
            }else{//最外边的if
                $.messager.show({title:'提示',msg:'请选择要添加的专辑！'});
            }

    }



    function showalbummessage() {
        var select=$("#albumtable").treegrid('getselected');
        if(select!=null){
            var selectid = $("#albumtable").treegrid('getselected').id;
            var level = $("#albumtable").treegrid('getlevel', selectid);
            if(level==1) {
                console.log("----select.chapterdownloadpath--------1--"+select.albumconverpath);
                $("#imgpath").prop("src","1.jpg");
                    $("#showalbumdialog").dialog({
                        href:'${pagecontext.request.contextpath}/back/album/showalbummessage.jsp?id='+selectid,
                        width:500,
                        height:400,
                        resizable:true,
                        buttons:[
                            {iconcls:'icon-remove',text:'close',
                                handler:function(){
                                    $("#showalbumdialog").dialog('close');
                                }}

                        ],
                    });
                console.log("----select.chapterdownloadpath--------2--"+select.albumconverpath);
                $("#imgpath").prop("src",select.albumconverpath);
            }else{
                $.messager.show({title:'提示',msg:'请选择所要查看的专辑！'});
            }

        }else{
            $.messager.show({title:'提示',msg:'请选择所要查看的专辑！'});
        }

    }




 //下载音频
    function downloadchapter() {
        var select=$("#albumtable").treegrid('getselected');
        if(select==null || select=="" || typeof(select)==undefined || $("#albumtable").treegrid('getlevel', select.id)==1){
            $.messager.show({title:'提示',msg:'请选中所要下载的专辑！'});
       }else{
            var selecttitle=$("#albumtable").treegrid('getselected').title;
                console.log(selecttitle+"yyyyyyyyyyyyyyyyyyyyyyyyyy");
                location.href="${pagecontext.request.contextpath}/chapter/download?filename="+selecttitle;
       }

    }

</script>
<table id="albumTable"></table>
<%--添加工具按钮--%>
<div id="albumTooBar">
    <a href="javascript:;" onclick="showAlbumMessage()" class="easyui-linkbutton" data-options="iconCls:'icon-tip',text:'专辑详情'"></a>
    <a href="javascript:;" onclick="addAlbum()" class="easyui-linkbutton" data-options="iconCls:'icon-save',text:'添加专辑'"></a>
    <a href="javascript:;" onclick="addChapter()" class="easyui-linkbutton" data-options="iconCls:'icon-save',text:'添加章节'"></a>
    <a href="javascript:;" onclick="downloadChapter()" class="easyui-linkbutton" data-options="iconCls:'icon-large-picture',text:'下载音频'"></a>
</div>
<%--专辑详情的对话框--%>
<div id="showAlbumDialog"></div>
<%--添加专辑所弹出的对话框--%>
<div id="addAlbumDialog" data-options="href:'${pageContext.request.contextPath}/back/album/addAlbum.jsp',iconCls:'icon-save',title:'添加专辑...',width:400,height:400"></div>
<%--添加章节所弹出的对话框--%>
<div id="addChapterDialog" data-options="iconCls:'icon-save',title:'添加章节...',width:400,height:400"></div>
