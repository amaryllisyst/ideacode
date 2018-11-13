<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<html>
<body>
<form method="post" action="${pageContext.request.contextPath}/banner/add" enctype="multipart/form-data">
    <input type="file" name="upload"/><br/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>