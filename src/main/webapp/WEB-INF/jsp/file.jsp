<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
<form action="/ " method="post" enctype="multipart/form-data">
    <label>upload picture </label>
    <input type="file" name="file"/>
    <input type="submit" value="upload"/>
</form>
<p th:text="'picture model ！, ' + ${name} + '!'">${name}</p>
hello
<p>图片:</p>
<img src="${filename}"/>
bottom
</body>
</html>