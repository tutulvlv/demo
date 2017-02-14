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

            <div class="container-fluid" style="height:100%">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <!-- <h1 class="page-header"> 取货员管理</h1> -->
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="${basepath }/admin/adminlist.action">订单管理</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> 取货员列表
                            </li>
                        </ol>
                        
                       
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>姓名</th>
                                        <th>手机号</th>
                                        <th>备注</th>
                                        <th>修改</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${pickList}" var="pickList">
                                    <tr>
                                        <td>${pickList.pickid}</td>
                                        <td>${pickList.pickname}</td>
                                        <td>${pickList.picktel}</td>
                                        <td>${pickList.pickdet}</td>
                                        <td><a href="${basepath }/view/backtop/admin_setpick.jsp?method=updatePick&pickid=${pickList.pickid}&pickname=${pickList.pickname}&picktel=${pickList.picktel}&pickdet=${pickList.pickdet}">修改</a>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                
                <div align="right">
                       <a href="${basepath }/view/backtop/admin_setpick.jsp?method=insertPick" class="btn btn-primary btn-sm active" role="button">新增取货人</a>
                </div>
                
                <!-- 分页 -->
                <div style="float:left;width:100%;text-align:center">
				<ul class="pagination">
					<c:if test="${requestScope.pager.hasFirst==true}">
						<li><a href="${basepath }/pick/getAll.action?currentPage=1">首页</a></li>
					</c:if>
					
					<c:if test="${requestScope.pager.hasFirst==false}">
						<li class="disabled"><a href="javascript:void(0)">首页</a>
						</li>
					</c:if>
					
					<c:if test="${requestScope.pager.hasPrevious==true}">
						<li><a
							href="${basepath }/pick/getAll.action?currentPage=${requestScope.pager.currentPage-1}">
								上一页 </a></li>
					</c:if>
					
					<c:if test="${requestScope.pager.hasPrevious==false}">
						<li class="disabled"><a
							href="javascript:void(0)">
								上一页 </a></li>
					</c:if>
					
					<c:if test="${requestScope.pager.hasNext==true}">
						<li><a
							href="${basepath }/pick/getAll.action?currentPage=${requestScope.pager.currentPage+1}">
								下一页 </a></li>
					</c:if>
					
					<c:if test="${requestScope.pager.hasNext==false}">
						<li class="disabled"><a
							href="javascript:void(0)">
								下一页 </a></li>
					</c:if>
					
					<c:if test="${requestScope.pager.hasLast==true}">
						<li><a
							href="${basepath }/pick/getAll.action?currentPage=${requestScope.pager.totalPage}">
								尾页 </a></li>
					</c:if>
					
					<c:if test="${requestScope.pager.hasNext==false}">
						<li class="disabled"><a
							href="javascript:void(0)">
								尾页 </a></li>
					</c:if>
				</ul>
				<br> 当前第
				${requestScope.pager.currentPage}
				页，总共
				${requestScope.pager.totalPage}
				页
			</div>	
            </div>
        </div>
    </div>
</body></html>