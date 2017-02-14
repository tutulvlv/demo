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

    <title>小呆料</title>

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

            <div class="container-fluid" >

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <!-- <h1 class="page-header"> 取货员管理</h1> -->
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="${basepath }/admin/adminlist.action">订单管理</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> 业务员列表
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6" >
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>姓名</th>
                                        <th>手机号</th>
                                        <th>修改</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${clerkList}" var="clerkList">
                                    <tr>
                                        <td>${clerkList.clerkid}</td>
                                        <td>${clerkList.clerkname}</td>
                                        <td>${clerkList.clerktel}</td>
                                        <td><a href="${basepath }/view/backtop/admin_setclerk.jsp?method=updateClerk&clerkid=${clerkList.clerkid}&clerkname=${clerkList.clerkname}&clerktel=${clerkList.clerktel}">修改</a>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    
                </div>
                 <div align="right">
                       <a href="${basepath }/view/backtop/admin_setclerk.jsp?method=insertClerk" class="btn btn-primary btn-sm active" role="button">新增取货人</a>
                </div>
            </div>
        </div>
    </div>
</body></html>