<%--
  Created by IntelliJ IDEA.
  User: hanle
  Date: 06/03/2021
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="css/recharge.css" />
	<script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
	<title>充值</title>
</head>
<body>
<div class="container">
	<div class="row">
		<!--顶部logo start-->
		<div class="bg">

		</div>
		<!--顶部logo end-->
	</div>
	<form action="/recharge" method="get" role="form">
		<div class="row">
			<div class="play col-xs-10 col-sm-10 col-md-10 col-lg-10">
				<div class="form-group">
					<h4>充值金额（1元=100积分）</h4>
					<div class="number_amount">
						<label>￥</label>
						<input  type="number" name="amount" id="amount" value="" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="play col-xs-10 col-sm-10 col-md-10 col-lg-10">
				<p class="col-xs-3 col-sm-3 col-md-3 col-lg-3">10</p>
				<p class="col-xs-3 col-sm-3 col-md-3 col-lg-3">20</p>
				<p class="col-xs-3 col-sm-3 col-md-3 col-lg-3">50</p>
				<br>
				<p class="col-xs-3 col-sm-3 col-md-3 col-lg-3">80</p>
				<p class="col-xs-3 col-sm-3 col-md-3 col-lg-3">100</p>
				<p class="col-xs-3 col-sm-3 col-md-3 col-lg-3">150</p>
			</div>
		</div>
		<div class="row">
			<button type="submit" class="btn btn-block btn-primary">充值</button>
		</div>
	</form>
</div>

</body>
</html>
<script>
	var $amountInput = $('[type="number"]');
	var amount = '';
	var $getId = $('[type="hidden"]');
	var getparse = ParaMeter();
	$getId.val(getparse.id);
	$(".row p").off("click").on("click", function() {
		amount = $(this).text();
		if (!$(this).hasClass('active')) {
			$(this).addClass('active').siblings().removeClass('active');
			$amountInput.val(amount);
		} else {
			$(this).removeClass('active');
			$amountInput.val('');
		}
	})
	$amountInput.on('input propertychange', function() {
		if ($(this).val() > 5000) {
			$('#exampleModal').modal('show')
		}
		if ($(this).val() !== $('.row p.active').text()) {
			$('.row p').removeClass('active');
		}
	})
	$('#exampleModal').on('hidden.bs.modal', function(e) {
		$amountInput.val(5000);
	})

	function ParaMeter() {
		var obj = {};
		var arr = location.href.substring(location.href.lastIndexOf('?') + 1).split("&");
		for (var i = 0; i < arr.length; i++) {
			var aa = arr[i].split("=");
			obj[aa[0]] = aa[1];
		}
		return obj;
	}
</script>


