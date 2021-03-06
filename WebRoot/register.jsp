<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basepath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<title>小呆料</title>

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
	height: 300px;
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
	height: 40px;
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
				<h1><small>客户注册</small></h1>
			</div>
			<div class="login-content ">
			<div class="form">
			<form action="user/register.action" method="post">
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class=""></span>姓&nbsp;名</span>
							<input type="text" id="username" name="username" class="form-control" placeholder="用户名"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class=""></span>手机号</span>
							<input type="text" id="text" name="usertel" class="form-control" placeholder="手机号"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class=""></span>公司名称</span>
							<input type="text" name="comname" class="form-control" placeholder="公司全称"/>
						</div>
					</div>
				</div>
				<div class="form-group form-actions">
					<div class="col-xs-4 col-xs-offset-4 ">
						<button id="but" type="submit" class="btn btn-sm btn-info"><span class=""></span> 注册</button>
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
</div>
</div>

<script type="text/javascript">
	//检测是否为中文，true表示是中文，false表示非中文
	function isChinese(str){
		if(/^[\u3220-\uFA29]{2,4}$/.test(str)){
			return true;
		}else{
			return false;
		}
	}
</script>

<script type="text/javascript">
	//检测是否为中文，true表示是中文，false表示非中文
	function checkMobile(sMobile){
		if(!(/^[1][3578][0-9]{9}$/.test(sMobile))){
			alert("不是完整的11位手机号或者正确的手机号前七位");
			return true;
		}else{
			return false;
		}
	}
</script>

<script type="text/javascript">
	$("form").submit(function(){
		var flag = false;
		//获取文本框的中内容
		var username = $(":text").first().val();
		var telnum = $(":text[name='usertel']").val();
		//去二边的空格
		username = $.trim(username);
		telnum = $.trim(telnum);
		//如果没有填内容
		if(username.length == 0 || telnum.length == 0){
			alert("用户名 和 手机号 必填");
			//将光标定位于文本框中
			$(":text").first().focus();
			//清空文本框中的内容
			$(":text").first().val("");
		}else{
			//调用方法
			flag = isChinese(username);
			flags = checkMobile(telnum);
			//如果不是中文
			if(!flag){
				alert("用户名必须填中文");
				//将光标定位于文本框中
				$(":text").first().focus();
				//清空文本框中的内容
				$(":text").first().val("");
			}else if(flags){
				//将光标定位于文本框中
				$(":text ").last().focus();
				//清空文本框中的内容
				$(":text").last().val("");
				flag=false;
			}
		}
		return flag;
	});
</script>
</body>

</html>