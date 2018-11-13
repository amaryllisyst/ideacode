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
    <form id="addChapterForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style=margin-top:20px;">
            路径：<input   id="path" name="upload" class="easyui-filebox" />
            <input  type="hidden" name="album.albumId" value="${param.selectId}"/>
        </div>


    </form>
</div>









