<%--
  Created by IntelliJ IDEA.
  User: hanle
  Date: 03/03/2021
  Time: 00:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<title>课程详情</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<style type="text/css">
			a {
				text-decoration: none;
				color: black;
			}

			a:hover {
				color: aqua;
				text-decoration: none;
			}

			td {
				text-align: center;
			}
		</style>
		<script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/curriculum.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<%--		${msg}--%>
		<!--添加id和name命名是c加字段名，c代表表名首字母-->
		<!--添加模态框start-->
		<div id="add" class="modal fade">
			<div class="modal-dialog">
				<form action="/addCurriculum" method="get" role="form" class="form-horizontal" autocomplete="on" id="addCurriculum">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">添加课程信息</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label for="cname" class="control-label col-lg-4">课程名：</label>
								<div class="col-lg-6">
									<input class="form-control" type="text" name="cname" id="cname" value="" required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="cprice" class="control-label col-lg-4">价格：</label>
								<div class="col-lg-6">
									<input class="form-control" type="text" name="cprice" id="cprice" value="" required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="cinfo" class="control-label col-lg-4">简介：</label>
								<div class="col-lg-6">
									<input class="form-control" type="text" name="cinfo" id="cinfo" value="" required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="cnum" class="control-label col-lg-4">参与人数：</label>
								<div class="col-lg-6">
									<input class="form-control" type="text" name="cnum" id="cnum" value="" required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="cperiod" class="control-label col-lg-4">课时数：</label>
								<div class="col-lg-6">
									<input class="form-control" type="text" name="cperiod" id="cperiod" value="" required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="cstartTime" class="control-label col-lg-4">开始时间：</label>
								<div class="col-lg-6">
									<input class="form-control" type="date" name="cstartTime" id="cstartTime" value="" required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="cendTime" class="control-label col-lg-4">结束时间：</label>
								<div class="col-lg-6">
									<input class="form-control" type="date" name="cendTime" id="cendTime" value="" required="required" />
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-success" value="添加" />
							<input type="reset" value="重置" class="btn btn-warning" />
						</div>
					</div>
				</form>
			</div>
		</div>
		<!--添加模态框end-->
		<!--修改id和name命名是cu加字段名，c代表表名首字母，u代表update-->
		<!--修改模态框start-->
		<div id="update" class="modal fade">
			<div class="modal-dialog">
				<form action="/update" method="get" role="form" class="form-horizontal" autocomplete="on" id="updateCurriculum">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">修改课程信息</h4>
						</div>
						<div class="modal-body">
<%--							<c:if test="${singleCourse!=null}">--%>
								<!--隐藏域-->
								<input type="hidden" name="cuid" id="cuid" value="" />
								<div class="form-group">
									<label for="cname" class="control-label col-lg-4">课程名：</label>
									<div class="col-lg-6">
										<input class="form-control" type="text" name="cuName" id="cuName" value="" required="required" />
									</div>
								</div>
								<div class="form-group">
									<label for="cprice" class="control-label col-lg-4">价格：</label>
									<div class="col-lg-6">
										<input class="form-control" type="text" name="cuPrice" id="cuPrice" value="" required="required" />
									</div>
								</div>
								<div class="form-group">
									<label for="cuInfo" class="control-label col-lg-4">简介：</label>
									<div class="col-lg-6">
										<input class="form-control" type="text" name="cuInfo" id="cuInfo" value="" required="required" />
									</div>
								</div>
								<div class="form-group">
									<label for="cnum" class="control-label col-lg-4">参与人数：</label>
									<div class="col-lg-6">
										<input class="form-control" type="text" name="cuNum" id="cuNum" value="" required="required" />
									</div>
								</div>
								<div class="form-group">
									<label for="cperiod" class="control-label col-lg-4">课时数：</label>
									<div class="col-lg-6">
										<input class="form-control" type="text" name="cuPeriod" id="cuPeriod" value="" required="required" />
									</div>
								</div>
								<div class="form-group">
									<label for="cstartTime" class="control-label col-lg-4">开始时间：</label>
									<div class="col-lg-6">
										<input class="form-control" type="date" name="cuStartTime" id="cuStartTime" value=""
										 required="required" />
									</div>
								</div>
								<div class="form-group">
									<label for="cendTime" class="control-label col-lg-4">结束时间：</label>
									<div class="col-lg-6">
										<input class="form-control" type="date" name="cuEndTime" id="cuEndTime" value=""
										 required="required" />
									</div>
								</div>
<%--							</c:if>--%>
						</div>

						<div class="modal-footer">
							<input type="submit" class="btn btn-primary" value="修改" />
							<input type="reset" value="重置" class="btn btn-warning" />
						</div>
					</div>
				</form>
			</div>
		</div>
		<!--修改模态框end-->
		<div class="table-responsive">
			<table class="table table-bordered table-striped table-hover table-condensed">
				<caption style="text-align: center;">
					<h3>课程详情</h3>
				</caption>
				<thead>
					<tr>
						<td>序号</td>
						<td>课程名</td>
						<td>课程价格</td>
						<td>课程简介</td>
						<td>参与课程人数</td>
						<td>课时数</td>
						<td>开始时间</td>
						<td>结束时间</td>
						<td colspan="2" style="text-align: center">操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${curricula}" var="curriculum" varStatus="index">
						<tr>
							<td>${index.count}</td>
							<td>${curriculum.name}</td>
							<td>${curriculum.price}</td>
							<td>${curriculum.info}</td>
							<td>${curriculum.num}</td>
							<td>${curriculum.period}</td>
							<td>
								<fmt:formatDate value="${curriculum.startTime}" pattern="yyyy-MM-dd" />
							</td>
							<td>
								<fmt:formatDate value="${curriculum.endTime}" pattern="yyyy-MM-dd" />
							</td>
							<td>
								<!-- <a href="" class="btn btn-info" name="update">修改</a> -->
<%--								href等号赋值不要加引号--%>
								<a href="" onclick="evaluation(this,${curriculum.id})" class="btn btn-warning" data-toggle="modal" data-target="#update">修改</a>
							</td>
							<td>
								<a href="javascript:deleteCheck(${curriculum.id})" class="btn btn-danger" name="delete">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="1">
							<a class="btn btn-success" data-toggle="modal" data-target="#add">添加</a>
						</td>
						<td colspan="9">更多课程即将开课，敬请期待。</td>
					</tr>
				</tfoot>
			</table>
		</div>

		<div class="container">
			<ul class="pager">
				<li class="disabled previous"><a href="#">首页</a></li>
				<li class="disabled"><a href="#">上一页</a></li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">下一页</a></li>
				<li class="next"><a href="#">末页</a></li>
			</ul>
		</div>
		<div id="copy" align="center">
			&copy;sue版权所有2021年3月3日20:25:48
		</div>
		<div id="logout" align="right">
			<a href="index.jsp" style="padding-right: 30px">退出</a>
		</div>
	</body>
</html>
