<%--
  Created by IntelliJ IDEA.
  User: LIUTH2
  Date: 7/10/14
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
        <form action="/upload" method="post" enctype="multipart/form-data">
            用户名<input type="text" name="name"><br>
            文件  <input type="file" name="files"><br>
            <input type="submit" value="提交">
        </form>
  </body>
</html>