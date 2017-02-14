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
    <title>业务员详情控制</title>
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

            <div class="container-fluid" style="height:100%">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-6">
                        <!-- <h1 class="page-header">账号管理</h1> -->
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="${basepath }/admin/adminlist.action">订单列表</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> 业务员详情控制
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">
                        <form role="form" action="${basepath }/clerk/${param.method }.action">
                            <div class="form-group">
                                <label>业务员编号</label>
                                <input class="form-control" disabled="disabled"  placeholder="编号不可设置" value="${param.clerkid }">
                                <!-- <p class="help-block">Example block-level help text here.</p> -->
                            </div>
							
							<div class="form-group" hidden="hidden">
                                <label>业务员编号</label>
                                <input class="form-control"  placeholder="编号不可设置" name="clerkid" value="${param.clerkid }">
                                <!-- <p class="help-block">Example block-level help text here.</p> -->
                            </div>
                            
                            <div class="form-group">
                                <label>业务员姓名</label>
                                <input class="form-control" placeholder="请输入业务员姓名" name="clerkname" value="${param.clerkname }">
                            </div>

                           <!--  <div class="form-group"> <label>File input</label> <input type="file">  </div> -->

                            <div class="form-group">
                                <label>业务员手机号</label>
                                <input class="form-control" placeholder="请输入业务员手机号" name="clerktel" value="${param.clerktel }"></input>
                            </div>
							
							<div align="center">
							 	<button type="submit" class="btn btn-primary" >提交</button>
							</div>
                            <!-- <button type="reset" class="btn btn-default">Reset Button</button> -->
                        </form>

                    </div>
                    
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
    </div>
</body></html>