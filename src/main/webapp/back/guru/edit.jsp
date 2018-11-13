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
        $("#editGuruForm").form('load','${pageContext.request.contextPath}/guru/findOne?id=${param.id}');
    });

</script>
<div style="text-align:center">
    <form id="editGuruForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="guruId" class="easyui-textbox"  value="${param.id}"/>

        <div style="margin-top:30px;">
            名字：<input  name="guruName" class="easyui-textbox"/>
        </div>
        <div style="margin-top:30px;">
            <input  type="hidden"  name="originalUpload" value="${param.avatar}"/>
            头像：<input  name="upload" value="${param.avatar}" class="easyui-filebox"/>
        </div>
        <div style="margin-top:30px;color: #c4c4c4;">
           <span style="color: #c4c4c4;">性别：</span> <input id="grey" name="guruGender"  class="easyui-textbox" data-options="readonly:true"/>
        </div>


    </form>
</div>








