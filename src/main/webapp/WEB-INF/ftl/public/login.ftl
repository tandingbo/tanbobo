<!DOCTYPE html>
<html lang="en">
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8"/>
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
    <script type="text/javascript" src="/tanbobo/resources/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/tanbobo/resources/js/des.js"></script>
    <script>
        function getResult() {
            //待加密字符串
            var str = $("#str").text();
            //第一个参数必须；第二个、第三个参数可选
            var key1 = $("#key1").text();
            var key2 = $("#key2").text();
            var key3 = $("#key3").text();
            //加密方法
            var enResult = strEnc(str, key1, key2, key3);
            //解密方法
            var deResult = strDec(enResult, key1, key2, key3);
            //展示结果
            $("#enStr").text(enResult);
            $("#dnStr").text(deResult);
        }
    </script>

<#--<link rel="shortcut icon" href="app/img/favicon.ico" />-->
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body>
<div>登录</div>
<input type="button" value="获取加密结果与解密结果" onclick="getResult()"/>
<table>
    <tr>
        <td align="left">字符串：</td>
        <td><span id="str">admin</span></td>
    </tr>
    <tr>
        <td>加密key：</td>
        <td>key1=<span id="key1">1</span>;key2=<span id="key2">2</span>;key3=<span id="key3">3</span></td>
    </tr>
    <tr>
        <td align="left">加密结果：</td>
        <td align="left"><label id="enStr"></label></td>
    </tr>
    <tr>
        <td align="left">解密结果：</td>
        <td align="left"><label id="dnStr"></label></td>
    </tr>
    <table>
</body>
</html>