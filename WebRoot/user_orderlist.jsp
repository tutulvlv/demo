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
    <title>订单列表</title>

    <!-- Bootstrap Core CSS -->
    <link href="${basepath }/view/backtop/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${basepath }/view/backtop/css/sb-admin.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="${basepath }/view/backtop/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- jQuery -->
    <script src="${basepath }/view/backtop/js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="${basepath }/view/backtop/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    	$(function(){
	    	$("#suborder").on('click', function (e) {
				var usertel=$(":input[name='usertel']").val();
				var subnum=$(":input[name='subnum']").val();
				var re=confirm("确定提交订单吗？");
				if(re){
					$.ajax({
					   type: "POST",
					   url: "/demo/user/suborder.action",
					   data: "usertel="+usertel+"&subnum="+subnum,
					   success: function(msg){
					     alert("下单成功！！");
					     location.reload(true);
					   }
					});	
				}
			});
    	});
    </script>
</head>

<body>
    <div id="wrapper">
    <jsp:include page="user_index.jsp"></jsp:include>
    <div id="page-wrapper">
            <div class="container-fluid" style="height: 100%">
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                       <h3 class="page-header">订单列表</h3>
                       	<input type="hidden" name="usertel" value="${user.usertel}"/>
                       	<input type="hidden" name="subnum" value="${user.subnum}"/>
                    	<h4>${user.comname}<button id="suborder" class="btn btn-info">提交订单</button>
                    	</h4>
						<h4>${user.username}，提交码&nbsp${user.subnum}</h4>
                        
                       <%--  <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="${basepath }/user/getUserOrderList.action?userid=${param.userid}">订单列表</a>
                            </li>
                           <!--  <li class="active">
                                <i class="fa fa-table"></i> 订单列表
                            </li> -->
                        </ol> --%>
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <!-- <h2>订单列表</h2> -->
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>订单号</th>
                                        <th>下单时间</th>
                                        <th>验货状态</th>
                                        <th>金额</th>
                                        <th>取货状态</th>
                                        <th>付款状态</th>
                                    </tr>
                                </thead>
                                <tbody>
 									<c:forEach items="${orderList}" var="orderList" varStatus="status">
									<tr>
										<td>
											${orderList.orderitemid}</td>
										<td>
											${orderList.createtime}</td>
										
										<c:if test="${orderList.instatus == 0}">
											<td>未验货</td>
										</c:if>
										<c:if test="${orderList.instatus == 1}">
												<td>已验货</td>
										</c:if>	
										<td>
											${orderList.price}</td>
										
										<c:if test="${orderList.pickstatus == 0}">
											<td>未取货</td>
										</c:if>
										<c:if test="${orderList.pickstatus == 1}">
												<td>已取货</td>
										</c:if>		
										<td>
										<c:if test="${orderList.paystatus == 0}">
											未付款
										</c:if>
										<c:if test="${orderList.paystatus == 1}">
												已付款
										</c:if>
										</td>
									</tr>
									</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                	<div style="float:left;width:100%;text-align:center">
					<ul class="pagination">
						<c:if test="${requestScope.pager.hasFirst==true}">
							<li><a href="getUserOrderList.action?currentPage=1">首页</a></li>
						</c:if>
						<c:if test="${requestScope.pager.hasFirst==false}">
							<li class="disabled"><a href="javascript:void(0)">首页</a>
							</li>
						</c:if>
						<c:if test="${requestScope.pager.hasPrevious==true}">
							<li><a
								href="getUserOrderList.action?currentPage=${requestScope.pager.currentPage-1}">
									上一页 </a></li>
						</c:if>
						<c:if test="${requestScope.pager.hasPrevious==false}">
							<li class="disabled"><a
								href="javascript:void(0)">
									上一页 </a></li>
						</c:if>
						<c:if test="${requestScope.pager.hasNext==true}">
							<li><a
								href="getUserOrderList.action?currentPage=${requestScope.pager.currentPage+1}">
									下一页 </a></li>
						</c:if>
						<c:if test="${requestScope.pager.hasNext==false}">
							<li class="disabled"><a
								href="javascript:void(0)">
									下一页 </a></li>
						</c:if>
						<c:if test="${requestScope.pager.hasLast==true}">
							<li><a
								href="getUserOrderList.action?currentPage=${requestScope.pager.totalPage}">
									尾页 </a></li>
						</c:if>
						<c:if test="${requestScope.pager.hasNext==false}">
							<li class="disabled"><a
								href="javascript:void(0)">
									尾页 </a></li>
						</c:if>
					</ul>
				<br/> 当前第
				${requestScope.pager.currentPage}
				页，总共
				${requestScope.pager.totalPage}
				页
			</div>	
                
                </div>
            </div>
            <!-- /.container-fluid -->
        </div>
    </div>
</body></html>