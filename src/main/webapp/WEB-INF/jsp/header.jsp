<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>测试获取头参数</title>
        <script src="https://code.jquery.com/jquery-3.2.0.js"></script>
        <script>
            $(function () {

                $.post({
                    url: "./user",
                    headers: {id: '1'},
                    success: function (result) {
                        console.log(result);
                    }
                });
            })

        </script>
</html>