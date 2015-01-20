<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="jawr" uri="http://jawr.net/tags"%>--%>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="js/ext/css/ext-all.css" />
    <script type="text/javascript" src="js/ext/ext-base.js"></script>
    <script type="text/javascript" src="js/ext/ext-all.js"></script>
    <script type="text/javascript" src="js/firstTimeLogin.js"></script>
    <%--<script type="text/javascript" src="./js/allBiz.js"></script>--%>
    <%--<script type="text/javascript" src="./js/index.js"></script>--%>
    <script>
        Ext.onReady(function() {
            Ext.Msg.alert('aa', 'bb')
            var win = new com.oocl.ir4.sps.web.js.firstTimeLogin();
            win.show();
        })
    </script>
</head>
<body>
<form>
</form>
</body>
</html>