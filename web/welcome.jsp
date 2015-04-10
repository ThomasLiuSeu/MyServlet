<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="jawr" uri="http://jawr.net/tags"%>--%>
<html>
<head>
    <title>Welcome</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/ge1doot.js"></script>
    <script type="text/javascript" src="js/imageTransform3D.js"></script>
    <script type="text/javascript" src="js/jQuery/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" type="text/css" href="css/slider-wb.css"/>

    <link rel="stylesheet" type="text/css" href="js/ext/css/ext-all.css"/>
    <script type="text/javascript" src="js/ext/ext-base.js"></script>
    <script type="text/javascript" src="js/ext/ext-all.js"></script>
    <script type="text/javascript" src="js/firstTimeLogin.js"></script>
    <%--<script type="text/javascript" src="./js/allBiz.js"></script>--%>
    <%--<script type="text/javascript" src="./js/index.js"></script>--%>
    <script>
        Ext.onReady(function () {
            var win = new com.oocl.ir4.sps.web.js.firstTimeLogin();
            win.show();
        })
    </script>
</head>
<body oncontextmenu='return false' ondragstart='return false'>
<canvas style="cursor: move;" height="933" width="1920" id="canvas">你的浏览器不支持HTML5画布技术，请使用谷歌浏览器。</canvas>
<div style="position: absolute; top: 20px; right: 20px;"></div>
</body>
</html>