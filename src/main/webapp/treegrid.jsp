<%--
  Created by IntelliJ IDEA.
  User: 杨少婷
  Date: 2018/10/31
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/easyui-lang-zh_CN.js"></script>
    <title>Title</title>
    <script>
        $(function(){
            $('#tt').treegrid({
                url:'get_data.php',
                idField:'id',
                treeField:'name',
                columns:[[
                    {title:'Task Name',field:'name',width:180},
                    {field:'persons',title:'Persons',width:60,align:'right'},
                    {field:'begin',title:'Begin Date',width:80},
                    {field:'end',title:'End Date',width:80}
                ]]
            });
        })

    </script>
</head>
<body>
<table id="tt" style="width:600px;height:400px"></table>
</body>
</html>
