<%--
  Created by IntelliJ IDEA.
  User: hanle
  Date: 06/03/2021
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		<title>下载页面</title>
	</head>
	<body>
		<div class="container">
			<p>
			<h3 id="title">资源正在下载，请耐心等待。。。</h3>
			</p>
			<div id="progressbar" class="progress progress-striped active">
				<div id="nowProgress" class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60"
					aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
					<span id="nowValue"></span>
				</div>
			</div>

		</div>
	</body>
</html>
<script type="text/javascript">
	var width = 0;
	var interval;

	function progress() {
		if (width < 101) {
			$("#nowProgress").css("width", width + "%");
			width++;
			// console.log(width);
			$("#nowValue").text((width - 1) + "%已完成");
		} else {
			$("#nowValue").text("下载完成");
			$("#title").text("恭喜您，下载成功！");
			$("#progressbar").removeClass("active");
			clearInterval(interval);
			// alert("下载已完成！");
		}
	}
	$(function() {
		interval = setInterval("progress()", 100);

	});
</script>
