<%--
  Created by IntelliJ IDEA.
  User: hanle
  Date: 02/03/2021
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/login.js" type="text/javascript" charset="utf-8"></script>
    <title>登录</title>
</head>
<body>
<div class="bgimg">

</div>
<div class="loginDiv">
    <div class="loginBox">
        <form id="loginInfo" action="/login" method="post" role="form">
            <div class="form-group">
                <label for="username" class="control-label">用户名：</label><br>
                <input class="form-control" type="text" name="username" id="username" value=""
                       style="margin-left: 30px;width: 300px;" placeholder="请输入用户名"/>
            </div>
            <div class="form-group">
                <label for="userpwd" class="control-label">密码：</label><br>
                <input class="form-control" type="password" name="userpwd" id="userpwd" value=""
                       style="margin-left: 30px;width: 300px;" placeholder="请输入密码"/>
            </div>
            <div class="forgot">
                <a href="#">忘记密码？</a>
            </div>
            <br>
            <div class="form-group remember">
                <input class="" type="checkbox" name="" value=""/>&nbsp;记住我
                <button class="form-control btn btn-info" style="width: 60px;margin-left: 230px;" type="submit" name="">
                    登录
                </button>
            </div>

        </form>
    </div>
</div>
<div id="" class="footer">
    &copy;版权所有sue 2021
</div>
</body>
</html>
