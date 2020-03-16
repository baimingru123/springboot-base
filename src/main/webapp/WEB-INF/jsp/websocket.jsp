<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>测试WebSocket</title>
        <script src="https://code.jquery.com/jquery-3.2.0.js"></script>
    <script src="./../js/websocket.js"></script>
    </head>

    <body>
        测试一下WebSocket站点吧
        <br/>
        <input id="message" type="text">
        <input id="context" type="text">
        <button onclick="sendMessage()">发送消息</button>
        <button onclick="closeWebSocket()">关闭WebSocket连接</button>
    </body>
</html>