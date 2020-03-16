<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>表单定义HTTP动作</title>
    </head>

    <body>
        <form method="post" action="./name" >
            <table>
                <tr>
                    <td>用户编号</td>
                    <td><input id="id" name="id" /></td>
                </tr>

                <tr>
                    <td>用户名称</td>
                    <td><input id="userName" name="userName"></td>
                </tr>

                <tr>
                    <td></td>
                    <td align="right">
                        <input id="submit" name="submit" type="submit"/>
                    </td>
                </tr>
            </table>
            <input type="hidden" id="_method" name="_method" value="PATCH"/>
        </form>
    </body>
</html>