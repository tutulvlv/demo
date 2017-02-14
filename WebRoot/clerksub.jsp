<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basepath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<title>验货提交页</title>

<link rel="stylesheet" type="text/css" href="${basepath}/css/bootstrap.min.css" />
<script type="text/javascript" src="${basepath}/js/jquery-3.1.1.js"></script>
<style type="text/css">
html,body {
	height: 100%;
}
.box {
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6699FF', endColorstr='#6699FF'); /*  IE */
	background-image:linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-o-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-moz-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-webkit-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-ms-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	
	margin: 0 auto;
	position: relative;
	width: 100%;
	height: 100%;
}
.login-box {
	width: 100%;
	max-width:500px;
	height: 400px;
	position: absolute;
	top: 50%;

	margin-top: -200px;
	/*设置负值，为要定位子盒子的一半高度*/
	
}
@media screen and (min-width:500px){
	.login-box {
		left: 50%;
		/*设置负值，为要定位子盒子的一半宽度*/
		margin-left: -250px;
	}
}	

.form {
	width: 100%;
	max-width:500px;
	height: 275px;
	margin: 25px auto 0px auto;
	padding-top: 25px;
}	
.login-content {
	height: 400px;
	width: 100%;
	max-width:500px;
	background-color: rgba(255, 250, 2550, .6);
	float: left;
}		
	
	
.input-group {
	margin: 0px 0px 30px 0px !important;
}
.form-control,
.input-group {
	height: 30px;
}

.form-group {
	margin-bottom: 0px !important;
}
.login-title {
	padding: 20px 10px;
	background-color: rgba(0, 0, 0, .6);
}
.login-title h1 {
	margin-top: 10px !important;
}
.login-title small {
	color: #fff;
}

.link p {
	line-height: 20px;
	margin-top: 30px;
}
.btn-sm {
	padding: 8px 24px !important;
	font-size: 16px !important;
}
</style>

</head>

<body>
<div class="box">
		<div class="login-box">
			<div class="login-title text-center">
				<h1><small>验货提交</small></h1>
			</div>
			<div class="login-content ">
			<div class="form">
			<form action="clerk/clerksub.action" method="post" enctype="multipart/form-data">
			<input type="hidden" name="orderitemid" value="${param.orderitemid}"/>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class=""></span>总数量</span>
							<input type="text" id="weight" name="quantity" class="form-control" placeholder="箱子或袋子总数量"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class=""></span>总重量</span>
							<input type="text" id="weight" name="weight" class="form-control" placeholder="重量"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class=""></span>总价格</span>
							<input type="text" id="price" name="price" class="form-control" placeholder="总价格"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class=""></span>照片</span>
							<input type="file" id="subimg" name="orderimg" class="form-control" placeholder="照片"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class=""></span>详情</span>
							<input type="text" id="indet" name="indet" class="form-control" placeholder="详情"/>
						</div>
					</div>
				</div>
				<div class="form-group form-actions">
					<div class="col-xs-4 col-xs-offset-4 ">
						<button id="but" type="submit" class="btn btn-sm btn-info"><span class=""> 提交</span></button>
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$("form").submit(function(){
		var re = /^[0-9]+.?[0-9]*$/;
		//获取文本框的中内容
		var quantity = $(":text[name='quantity']").val();
		var weight = $(":text[name='weight']").val();
		var price = $(":text[name='price']").val();
		//去二边的空格
		quantity = $.trim(quantity);
		weight = $.trim(weight);
		price = $.trim(price);
		//如果没有填内容
		if(quantity.length==0||weight.length==0||price.length==0){
			alert("基本信息不能为空！！！");
			return false;
		}
		if(!re.test(quantity)||!re.test(weight)||!(price)){
			alert("数量，重量或价格必须为数字！！！");
			return false;
		}
		return true;
	});
</script>

</body>

</html>