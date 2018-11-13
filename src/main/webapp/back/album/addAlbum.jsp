<%--
  Created by IntelliJ IDEA.
  User: 杨少婷
  Date: 2018/10/31
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script>
</script>
<div style="text-align:center">
    <form id="addAlbumForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style=margin-top:30px;">
            标题：<input  name="title" class="easyui-textbox"/>
        </div>
        <div style=margin-top:20px;">
            封面：<input  name="upload" class="easyui-filebox"/>
        </div>
        <div style=margin-top:20px;">
            星级: <input  name="albumStar" class="easyui-textbox" data-options="prompt:'请输入数字评分',invalidMessage:'please enter number',validType:'number',"/>
        </div>
        <div style=margin-top:20px;">
            作者: <input  name="albumAuthor" class="easyui-textbox"/>
        </div>
        <div style=margin-top:20px;">
            播音员: <input  name="albumBroadCast" class="easyui-textbox"/>
        </div>
        <div style=margin-top:20px;">
            简介: <input  name="albumBrief" class="easyui-textbox"/>
        </div>

    </form>
</div>









