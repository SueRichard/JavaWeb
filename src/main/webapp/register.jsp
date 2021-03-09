<%--
  Created by IntelliJ IDEA.
  User: hanle
  Date: 09/03/2021
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="css/register.css" />
		<script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/register.js" type="text/javascript" charset="utf-8"></script>
		<title>注册</title>
	</head>
	<body>
		<div class="bgimg">
			<div class="container">
				<div class="mytop">
					<h2>注册用户</h2>
				</div>
				<form id="register" action="/register" method="post" role="form" class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-lg-2">用户名：</label>
						<div class="col-lg-6">
							<input class="form-control" type="text" name="username" id="username" value=""
								placeholder="请输入用户名" />
						</div>
						<div class="col-lg-4">
							<span id="usernameInfo">
								提示信息
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-2">密码：</label>
						<div class="col-lg-6">
							<input class="form-control" type="password" name="userpwd1" id="userpwd1" value=""
								placeholder="请输入密码" />
						</div>
						<div class="col-lg-4">
							<span id="userpwd1Info">
								提示信息
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-2">确认密码：</label>
						<div class="col-lg-6">
							<input class="form-control" type="password" name="userpwd2" id="userpwd2" value=""
								placeholder="请再次输入密码" />
						</div>
						<div class="col-lg-4">
							<span id="userpwd2Info">
								提示信息
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-2">角色：</label>
						<div class="col-lg-6">
							<select class="form-control">
								<option value="-1">请选择角色</option>
								<option value="1">普通用户</option>
								<option value="2">管理员</option>
							</select>
						</div>
						<div class="col-lg-4">
							<span>

							</span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-8 col-lg-1">
							<button type="submit" class="btn btn-info">注册</button>
						</div>
						<div class="col-lg-2">
							<button type="reset" class="btn btn-primary">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="" class="footer">
			&copy;版权所有sue 2021
		</div>
	</body>
</html>
<script type="text/javascript">
	$(function() {
		$("#username").blur(function() {
			var name = $(this).val();
			$.post("/checkUsername", "username="+name, function(rs) {
				if (rs=="可用") {
					$("#usernameInfo").html(rs).css("color", "springgreen");
				} else {
					$("#usernameInfo").html(rs).css("color", "red");
				}

			})
		});
	});
</script>
