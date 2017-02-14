<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basepath" value="${pageContext.request.contextPath}"></c:set>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>账号管理</title>

    <!-- Bootstrap Core CSS -->
    <link href="${basepath}/view/backtop/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${basepath}/view/backtop/css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${basepath}/view/backtop/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	<!-- jQuery -->
    <script src="${basepath}/view/backtop/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="view/backtop/js/bootstrap.min.js"></script>
</head>

<body>
    <div id="wrapper">
    <jsp:include page="user_index.jsp"></jsp:include>
    <div id="page-wrapper">

            <div class="container-fluid" style="height:100%">

                <!-- Page Heading -->
                <!-- <div class="row" >
                    <div class="col-lg-6" >
                        <h1 class="page-header"> 账号管理 </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">订单列表</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> 账号管理
                            </li>
                        </ol>
                    </div>
                </div> -->
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">

                        <form role="form" action="${basepath}/user/updateUser.action" method="post">
							<input type="hidden" name="role" value="user"/>
							<input type="hidden" name="userid" value="${user.userid}"/>
                            <div class="form-group">
                                <label>用户名</label>
                                <input class="form-control" name="username" value="${user.username}" placeholder="此处可以修改账号名称">
                                <!-- <p class="help-block">Example block-level help text here.</p> -->
                            </div>

                            <div class="form-group">
                                <label>密码</label>
                                <input class="form-control" name="password" value="${user.password}"  placeholder="此处可以修改密码">
                            </div>

                            <div class="form-group">
                                <label>手机号</label>
                                <input class="form-control" name="usertel" value="${user.usertel}" placeholder="此处可以修改手机号">
                            </div>

                            <div class="form-group">
                                <label>提交码</label>
                                <input class="form-control" name="subnum" value="${user.subnum}" placeholder="此处可以修改提交码">
                            </div>

                            <div class="form-group">
                                <label>公司名称</label>
                                <input class="form-control" name="comname" value="${user.comname}" placeholder="此处可以修改所属公司名称">
                            </div>
							
							<div class="form-group" align="center">
                                <button type="submit" class="btn btn-primary">修改</button>
                            <!-- <button type="reset" class="btn btn-default">Reset Button</button> -->
                            </div>

                        </form>

                    </div>
                    
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
    </div>
</body></html>