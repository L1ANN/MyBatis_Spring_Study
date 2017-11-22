<%--
  Created by IntelliJ IDEA.
  User: L1ANN
  Date: 2017/11/21
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json测试</title>
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        //请求json，响应json
        function requestJson(){
            $.ajax({
                url:"${pageContext.request.contextPath}/requestJson.action",
                type:"post",
                contentType:"application/json;charset=utf-8",
                data:'{"name":"手机","price":1999}',
                success:function(data){
                    alert(data.name);
                }
            });
        }

        function responseJson(){
            $.ajax({
                url:"${pageContext.request.contextPath}/responseJson.action",
                type:"post",
                data:"name=手机&price=1999",
                success:function(data){
                    alert(data.name);
                }
            });
        }
    </script>
</head>
<body>
<input type="button" value="请求json响应json" onclick="requestJson()"/>
<input type="button" value="请求key/vale响应json" onclick="responseJson()"/>
</body>
</html>
