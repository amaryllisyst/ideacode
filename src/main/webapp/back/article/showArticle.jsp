<%--
  Created by IntelliJ IDEA.
  User: 杨少婷
  Date: 2018/10/26
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<style>
    .guruToolbar{
        position: absolute;
        top:30px;
        left:70px;
    }
</style>
    <script type="text/javascript">
        $(function(){
            $("#articleTable").edatagrid({
                autoSave:true,
                url:'${pageContext.request.contextPath}/article/findAll',
                saveUrl:'${pageContext.request.contextPath}/article/add',
            updateUrl:'${pageContext.request.contextPath}/article/update',
            destroyUrl:'${pageContext.request.contextPath}/article/delete',
                fit:true,
        })
            $('#articleTable').edatagrid('disableEditing');
        });
        function addArticle(){
            $('#articleTable').edatagrid('addRow');

        }
        function editArticle(){

            $('#articleTable').edatagrid('enableEditing');
        }
        function saveArticle(){
            $('#articleTable').edatagrid('saveRow');
            $('#articleTable').edatagrid('disable+Editing');

        }

    </script>

<table id="articleTable" style="width:100%;height:100%"
       title="Article"
       singleSelect="true">
<thead>
    <tr>
        <th field="articleId" width="240" editor="{type:'validatebox',options:{required:true}}">ID</th>
        <th field="articleTitle" width="240" editor="text">标题</th>
        <th field="articleImgPath" width="270" align="right" editor="{type:'numberbox',options:{precision:1}}">头像</th>
        <th field="articleContent" width="290" align="right" editor="numberbox">内容</th>
        <th field="articlePulishDate" width="240" editor="text">日期</th>
    </tr>
    </thead>

</table>

<div class="guruToolbar">
    <a href="#" class="easyui-linkbutton" onclick="addArticle()" data-options="iconCls:'icon-remove',plain:true">添加</a>
    <a href="#" onclick="editArticle()" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">修改</a>
    <a href="#" onclick="saveArticle()" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">保存</a>
</div>

