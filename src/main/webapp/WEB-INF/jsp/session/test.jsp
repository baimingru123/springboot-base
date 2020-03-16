<%@ page import="com.example.springbootbase.chapter10_mvc.pojo.User" %>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>测试@SessionAttributes</title>
    </head>

    <body>
       <%
        //从session中获取数据
           User user=(User)session.getAttribute("user");
           Long id=(Long)session.getAttribute("id_new");
           //展示数据
           out.print("<br>user_name="+user.getUserName());
           out.println("<br>id="+id);
       %>
    </body>
</html>