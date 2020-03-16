<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>测试JSR-303</title>
        <script src="https://code.jquery.com/jquery-3.2.0.js"></script>
        <script>
            $(function () {
                //请求验证POJO
                var pojo={
                    id: null,
                    date: '2017-08-08',
                    doubleValue: 999999.09,
                    integer: 100,
                    range: 10000,
                    email: 'email',
                    size: 'adv1212',
                    regexp: 'a,b,c,d'
                };

                $.post({
                    url: "./validate",
                    contentType: "application/json",
                    data: JSON.stringify(pojo),
                    success: function (result) {
                        console.log(result);
                    }
                });
            })

        </script>
</html>