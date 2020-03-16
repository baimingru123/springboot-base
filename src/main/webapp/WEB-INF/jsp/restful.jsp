<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>测试restful</title>
        <script src="https://code.jquery.com/jquery-3.2.0.js"></script>
        <script>
            $(function () {
                var params={
                    'userName': 'user_name_new_1',
                    'sexCode': 1,
                    'note': 'note_new_1'
                };
                    // $.post({
                    //     url: "./user",
                    //     contentType: "application/json",
                    //     data: JSON.stringify(params),
                    //     success: function (result) {
                    //         console.log(result);
                    //     }
                    // });

                // $.get("./user/1",function (result) {
                //     console.log(result);
                // });

                // $.get("./users/xx",function (result) {
                //     console.log(result);
                // });

                $.ajax({
                    url: "./user/1",
                    type: "PUT",
                    contentType: "application/json",
                    data: JSON.stringify(params),
                    success: function (result) {
                        console.log(result);
                    }
                });

            })

        </script>
    </head>
    <body>
        <h1>测试restful下的请求</h1>
    </body>
</html>