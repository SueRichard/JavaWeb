function checkUsername() {
	var name = $("#username").val();
	if (name == "" || name == null) {
		$("#usernameInfo").html("密码不可为空").css("color", "red");
		return false;
	}
	return true;
}

function checkPwd() {
	var pwd = $("#userpwd1").val();
	if (pwd == "" || pwd == null) {
		$("#userpwd1Info").html("密码不可为空").css("color", "red");
		return false;
	}
	return true;
}

function checkPwd2() {
	var pwd = $("#userpwd2").val();
	if (pwd == "" || pwd == null) {
		$("#userpwd2Info").html("确认密码不可为空").css("color", "red");
		return false;
	}
	return true;
}

$(function() {
	$("#username").blur(function() {
		checkUsername();
	});

	$("#userpwd1").blur(function() {
		checkPwd();
	});
	$("#userpwd2").blur(function() {
		checkPwd2();
	});

	$("#register").submit(function() {
		return checkUsername() && checkPwd() && checkPwd2();
	});
});
