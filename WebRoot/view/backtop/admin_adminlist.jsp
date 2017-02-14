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
    <!-- Bootstrap Core CSS -->
    <link href="${basepath}/view/backtop/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${basepath}/view/backtop/css/sb-admin.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="${basepath}/view/backtop/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- jQuery -->
    <script src="${basepath}/view/backtop/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${basepath}/view/backtop/js/bootstrap.min.js"></script>
</head>

<body>
    <div id="wrapper">
    <jsp:include page="admin_index.jsp"></jsp:include>
	<div id="page-wrapper">
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                       <!--  <h1 class="page-header"> 管理员管理</h1> -->
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="${basepath }/admin/adminlist.action">订单管理</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> 管理员管理
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>管理员姓名</th>
                                        <th>最近登录时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${adminList}" var="adminList">
                                    <tr>
                                        <td>${adminList.admin_id}</td>
                                        <td>${adminList.admin_name}</td>
                                        <td>${adminList.login_time}</td>
                                        <td><a href="${basepath}/view/backtop/admin_setadmin.jsp?method=updateAdmin&admin_id=${adminList.admin_id}&admin_name=${adminList.admin_name}&admin_pwd=${adminList.admin_pwd}">修改</a>
                                        <a href="${basepath}/admin/deleteAdmin.action?admin_id=${adminList.admin_id}">删除</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <a href="${basepath}/view/backtop/admin_setadmin.jsp?method=addAdmin">添加管理员</a>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>

</body></html>