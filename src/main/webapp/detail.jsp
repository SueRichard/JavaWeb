<%--
  Created by IntelliJ IDEA.
  User: hanle
  Date: 06/03/2021
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="css/detail.css" />
		<script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/detail.js" type="text/javascript" charset="utf-8"></script>
		<title>课程详情</title>
	</head>
	<body>
		<div class="container">
			<h2>课程详情</h2>
			<p>课程名：${course.name}</p>
			<p>课程价格：￥${course.price}</p>
			<p>课程简介：${course.info}</p>
			<p>课程参与人数：${course.num}人</p>
			<p>课程课时：${course.period}</p>
			<p>课程开始时间：
				<fmt:formatDate value="${course.startTime}" pattern="yyyy-MM-dd" />
			</p>
			<p>课程结束时间：
				<fmt:formatDate value="${course.endTime}" pattern="yyyy-MM-dd" />
			</p>
			<p style="text-align: right;">
				<a href="/download?courseId=${course.id}">视频资料下载</a>
			</p>
			<hr color="deeppink" style="height: 2px;" />
			<%--  方法一：   ${fn:length(criticisms)==0}--%>
			<%--    方法二：--%>
			<c:if test="${criticisms.size()==0}">
				<p style="padding-left: 100px;font-size: 16px;">暂无用户评论,快来分享你的想法吧！</p>
			</c:if>
			<c:forEach items="${criticisms}" var="criticism" varStatus="index">
				<!--评论start-->
				<div class="criticism">
					<div class="profile-left">
						<img src="img/profile.jpg" class="img-circle" width="60px" height="60px">
					</div>
					<div class="content-body">
						<div class="col-lg-10">
							<p><span>${criticism.userName}</span>于
								<fmt:formatDate value="${criticism.time}" pattern="yyyy-MM-dd HH:mm:ss" />
							</p>
							<span>${criticism.content}</span>
						</div>

						<div class="col-lg-2" id="likes">
							<img id="likeImg" src="img/colorlessHand.png" width="70px" height="70px"
								onclick="switchPicture(${criticism.id})">
							<span id="likeNumber">${criticism.likesNumber}</span>
						</div>
						<%--                    ${criticism.peopleNumber}--%>
						<%--                此方法繁琐，已放弃start--%>
						<%--                <c:choose>--%>
						<%--                    <c:when test="${criticism.likes>0}">--%>
						<%--                        <div class="col-lg-2">--%>
						<%--                            <span><a href=""><img src="img/hand.png" width="70px"--%>
						<%--                                                  height="70px"></a>${criticism.likes}</span>--%>
						<%--                        </div>--%>
						<%--                    </c:when>--%>
						<%--                    <c:otherwise>--%>
						<%--                        <div class="col-lg-2">--%>
						<%--                            <span><a href=""><img src="img/colorlessHand.png" width="70px"--%>
						<%--                                                  height="70px"></a>${criticism.likes}</span>--%>
						<%--                        </div>--%>
						<%--                    </c:otherwise>--%>
						<%--                </c:choose>--%>
						<%--                此方法繁琐，已放弃end--%>
					</div>
					<c:if test="${criticism.userId==sessionScope.id}">
						<div class="del clear">
							<a href="/delCriticism?cid=${criticism.id}&&curriculumId=${criticism.curriculumId}"
								class="btn btn-sm btn-danger">删除</a>
						</div>
					</c:if>
				</div>
				<!--评论end-->
				<c:if test="${index.count ge 1 && !index.last}">
					<hr>
				</c:if>
			</c:forEach>
			<hr color="deeppink" style="height: 2px;" />
			<form action="/addCriticism" method="get" role="form" class="form-horizontal">
				<input type="hidden" value="${course.id}" name="curriculumId">
				<div class="form-group">
					<label class="control-label col-sm-1">你的看法:</label>
					<div class="col-sm-10">
						<textarea rows="10" cols="50" class="form-control" name="criticism">
					</textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-10 col-sm-2">
						<input type="submit" value="提交" class="btn btn-primary" />
						<input type="reset" value="重置" class="btn" />
					</div>
				</div>
			</form>
			<span class="glyphicon glyphicon-home"></span>
			<a href="/queryAll">回到课程目录页</a>
		</div>
	</body>
</html>
