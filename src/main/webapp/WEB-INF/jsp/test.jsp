<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>购买产品测试</title>
        <script src="https://code.jquery.com/jquery-3.2.0.js"></script>
        <script>
            //模拟五万人同时抢购
            for(var i=1;i<=300;i++){
                var params={
                    userId: i,
                    productId: 1,
                    quantity: 1
                };

                //通过post请求后端
                $.post("./purchase",params,function (result) {
                    console.log(result.message);
                });
            }

        </script>
    </head>

    <body>
    <h1>抢购产品测试</h1>
    </body>
</html>