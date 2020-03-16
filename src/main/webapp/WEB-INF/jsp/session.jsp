<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>测试session</title>
    </head>

    <body>
       <%
        //session记录数据
           session.setAttribute("id",1L);
           //转发URL
           response.sendRedirect("/session/test");
       %>
    </body>
</html>