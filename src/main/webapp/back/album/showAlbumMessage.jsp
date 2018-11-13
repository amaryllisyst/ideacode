<%--
  Created by IntelliJ IDEA.
  User: 杨少婷
  Date: 2018/11/1
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function(){
        console.log("${param.id}");
        $("#showAlbumMessageForm").form('load','${pageContext.request.contextPath}/album/findOne?id=${param.id}');
    });

</script>

<div style="text-align:center">
    <form id="showAlbumMessageForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style=margin-top:30px;">
            标题：<input  name="title" class="easyui-textbox" data-options="readonly:true,"/>
        </div>
        <div style=margin-top:20px;">
            日期：<input  name="albumPublishDate" class="easyui-textbox" data-options="readonly:true,"/>
        </div>
        <div style=margin-top:20px;">
            封面: <img id="imgPath"  src=""/>
        </div>
        <div style=margin-top:20px;">
            星级: <input  name="albumStar" class="easyui-textbox" data-options="readonly:true,"/>
        </div>
        <div style=margin-top:20px;">
            作者: <input  name="albumAuthor" class="easyui-textbox" data-options="readonly:true,"/>
        </div>
        <div style=margin-top:20px;">
            播音员: <input  name="albumBroadCast" class="easyui-textbox" data-options="readonly:true,"/>
        </div>
        <div style=margin-top:20px;">
            简介: <input  name="albumBrief" class="easyui-textbox" data-options="readonly:true,"/>
        </div>

    </form>
</div>
