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

    <title>客户信息控制页面</title>

    <!-- Bootstrap Core CSS -->
    <link href="${basepath}/view/backtop/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${basepath}/view/backtop/css/sb-admin.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="${basepath}/view/backtop/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<!-- jQuery -->
    <script src="${basepath }/view/backtop/js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="${basepath }/view/backtop/js/bootstrap.min.js"></script>
</head>

<body>
    <div id="wrapper">
    <jsp:include page="admin_index.jsp"></jsp:include>
    <div id="page-wrapper">

            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-6">
                        <!-- <h1 class="page-header"> 账号管理</h1> -->
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="${basepath }/admin/adminlist.action">账号管理</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> 客户信息管理
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <div class="row" style="height:86%">
                    <div class="col-lg-6" >
                        <form role="form" action="${basepath}/user/updateUser.action">
                            <div class="form-group" >
                                <label>编号</label>
                               <input class="form-control" disabled="disabled"  placeholder="编号不可设置" value="${param.userid }">
                                <!-- <p class="help-block">Example block-level help text here.</p> -->
                            </div>
                            
                            <div class="form-group" hidden="hidden">
                                <label>编号</label>
                               <input class="form-control"   placeholder="编号不可设置" name="userid" value="${param.userid }">
                                <!-- <p class="help-block">Example block-level help text here.</p> -->
                            </div>
                            
                            <div class="form-group">
                                <label>客户姓名</label>
                                <input class="form-control" placeholder="请输入姓名" name="username" value="${param.username }">
                            </div>
                            <!-- <div class="form-group"> <label>File input</label> <input type="file"></div> -->
                            <div class="form-group">
                                <label>客户手机号</label>
                                <input class="form-control" placeholder="请输入手机号" name="usertel" value="${param.usertel }">
                            </div>
                            
                            <div class="form-group">
                                <label>客户密码</label>
                                <input class="form-control" placeholder="请输入密码" name="password" value="${param.password}"></textarea>
                            </div>
                            <div class="form-group">
                                <label>客户公司名</label>
                                <input class="form-control" placeholder="请输入公司名" name="comname" value="${param.comname}"></textarea>
                            </div>
                            <div class="form-group">
                                <label>公司类型</label>
                                <input class="form-control" placeholder="请输入公司类型" name="comtype" value="${param.comntype}"></textarea>
                            </div>
                            <div class="form-group" align="center">
                            	<button type="submit" class="btn btn-primary " >提交</button>
                            </div>
                           <!--  <button type="reset" class="btn btn-default">Reset Button</button> -->
                        </form>
                    </div>
                    
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
    </div>
</body></html>