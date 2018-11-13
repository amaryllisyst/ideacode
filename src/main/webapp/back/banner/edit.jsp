<%--
  Created by IntelliJ IDEA.
  User: 杨少婷
  Date: 2018/10/26
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script>
    $(function(){
        console.log("${param.id}");
        $("#editBannerForm").form('load','${pageContext.request.contextPath}/banner/queryOne?id=${param.id}');
    });

</script>
<div style="text-align:center">
    <form id="editBannerForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="bannerId" class="easyui-textbox"  value="${param.id}"/>
        <div style=margin-top:50px;">
            标题：<input  name="bannerTitle" class="easyui-textbox"/>
        </div>
        <div style=margin-top:50px;">
            <input  type="hidden"  name="originalUpload" value="${param.bannerImgPath}"/>
            路径：<input  name="upload" class="easyui-filebox"/>
        </div>

        <div style=margin-top:50px;">
            描述：<input  name="bannerDesc" class="easyui-textbox"/>
        </div>

        <div style=margin-top:50px;">
            状态：<input  name="bannerStatus" class="easyui-textbox"/>
        </div>
        <div style=margin-top:70px;">
            日期：<input  name="bannerDate" class="easyui-datebox"/>
        </div>


    </form>
</div>








