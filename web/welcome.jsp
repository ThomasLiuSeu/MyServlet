<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <%--<link rel="stylesheet" type="text/css" href="js/ext/css/ext-all.css" />--%>
    <%--<script type="text/javascript" src="js/ext/ext-base.js"></script>--%>
    <%--<script type="text/javascript" src="js/ext/ext-all.js"></script>--%>
    <script type="text/javascript" src="./js/allBiz.js"></script>
    <script>

        Ext.onReady(function() {
            var myWin = new Ext.Window({
                height : 100,
                width : 100,
                title : 'Welcome',
                items : [{
                    xtype : 'button',
                    value : 'Test',
                    text : 'OK!',
                    handler : function(a, b, c) {
                        var aaa = 123;
                    }
                }]
            })
            Ext.Msg.confirm("Really","Think again", function(comp, event) {
                if(event) {
                    myWin.show();
                }
            })
//            new Ext.Viewport({
//                layout : 'fit',
//                height : 100,
//                width : 100,
//                items : [{
//                    title : '123'
//                }]
//            })

        })
    </script>
</head>
<body>
<form>
</form>
</body>
</html>