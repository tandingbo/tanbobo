<!DOCTYPE html>
<html lang="en">
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8" />
    <title>tanbobo</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <meta name="MobileOptimized" content="320">

    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <!-- END GLOBAL MANDATORY STYLES -->

    <!-- BEGIN THEME STYLES -->
    <!-- END THEME STYLES -->

    <#--<link rel="shortcut icon" href="app/img/favicon.ico" />-->
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body>
    <div>首页</div>
    <div>
        <input id="password" value="tanbobo">
        <input id="singin" value="登录" type="button">
    </div>
</body>
<script type="text/javascript" src="/tanbobo/resources/js/security.js"></script>
<script type="text/javascript" src="/tanbobo/resources/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#singin").click(function(){
            var modulus = "tanbobo";
            var exponent = "1234567890qwertyuiop";
            var key = RSAUtils.getKeyPair(exponent, '', modulus);
            var pwd1 = $("#password").val();
            pwd1 = encodeURIComponent(pwd1);//进行编码
            var password = RSAUtils.encryptedString(key, pwd1);
            alert(password);
        });
    });
</script>
</html>