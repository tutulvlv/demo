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
	<script type="text/javascript">
		var old_clerkid;
		var old_pickid;
		$(function(){
			$("select[name='clerkid']").on('click', function (e) {
				old_clerkid=$(this).val();
			});
			$("select[name='pickid']").on('click', function (e) {
				old_pickid=$(this).val();
			});
			$("select[name='clerkid']").on('change', function (e) {
				var clerkname=$(this).find("option:selected").text();
				var re=confirm("确定要分配给"+clerkname+"吗？");
				if(re){
					var clerkid=$(this).val();
					
					var orderitemid=$(this).parent().parent().children().first().text().trim();
					$.ajax({
					   type: "POST",
					   url: "/demo/admin/setClerk.action",
					   data: "orderitemid="+orderitemid+"&clerkid="+clerkid,
					   success: function(msg){
					     alert("分配成功！！");
					   }
					});
				}else{
					$(this).val(old_clerkid);
				}
			});
			$("select[name='pickid']").on('change', function (e) {
				var pickname=$(this).find("option:selected").text();
				var re=confirm("确定要分配给"+pickname+"吗？");
				if(re){
					var pickid=$(this).val();
					
					var orderitemid=$(this).parent().parent().children().first().text().trim();
					$.ajax({
					   type: "POST",
					   url: "/demo/admin/setPick.action",
					   data: "orderitemid="+orderitemid+"&pickid="+pickid,
					   success: function(msg){
					     alert("分配成功！！");
					   }
					});	
				}else{
					$(this).val(old_pickid);
				}
			});
		});
	
		function setPay(orderitemid){
			var re=confirm("确定要付款吗？");
			if(re){
				$.ajax({
				   type: "POST",
				   url: "/demo/admin/setPay.action",
				   data: "orderitemid="+orderitemid,
				   success: function(msg){
					   alert( "付款成功！！" );
					   location.reload(true);
				   }
				});
				
			}
		}
		
		function deleteOrder(orderitemid){
			var re=confirm("确定要删除吗？");
			if(re){
				$.ajax({
				   type: "POST",
				   url: "/demo/admin/deleteOrder.action",
				   data: "orderitemid="+orderitemid,
				   success: function(msg){
					   alert( "delete  " +msg);
					   location.reload(true);
				   }
				});
			}
		}
</script>
</head>

<body>
    <div id="wrapper">
    <jsp:include page="admin_index.jsp"></jsp:include>
	<div id="page-wrapper">
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="${basepath }/admin/adminlist.action">订单管理</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i>订单搜索结果
                            </li>
                        </ol>
                    </div>
                    <form action="${basepath }/admin/getOrderListByCom.action" method="post">
						<div style="float:left;width:150px">
							<input type="text" name="comname" class="form-control"
								placeholder="公司、客户、手机号" required>
						</div>
						<div style="float:left;">
							<button type="submit" class="btn btn btn-primary">搜索订单</button>
						</div>
					</form>
                </div>
                <!-- /.row -->
		<div class="table-responsive">
			<table class="table">
				<tr>
					<th style="position: absolute; margin-left: 0px; background-color: white; width: 50px;">编号</th>
					<th style="position: absolute; margin-left: 50px; background-color: white; width: 100px;">订单公司名</th>
					<th style="padding-left: 150px;">订单客户名</th>
					<th>手机号</th>
					<th>业务员名称</th>
					<th>验货状态</th>
					<th>取货人</th>
					<th>取货状态</th>
					<th>入库提交</th>
					<th>付款状态</th>
					<th>删除</th>
				</tr>
				<c:forEach items="${orderList}" var="orderList">
					<tr>
						<td style="position: absolute; margin-left: 0px; background-color: white; width: 50px;">
							${orderList.orderitemid}</td>
						<td style="position: absolute; margin-left: 50px; background-color: white; width: 100px; ">
							${orderList.comname}</td>
						<td style="padding-left: 150px;">${orderList.username}</td>
						<td>${orderList.usertel}</td>
						<td><select name="clerkid">
								<%-- <c:if test="${empty orderList.clerkid}">  --%>
									<option selected="selected" value="0">请分配业务员</option>
								<%-- </c:if> --%>
								<c:forEach items="${clerkList}" var="clerkList">
									<c:if test="${orderList.clerkid == clerkList.clerkid}">
										<option selected="selected" value="${clerkList.clerkid}">${clerkList.clerkname}</option>
									</c:if> 
									 <c:if test="${orderList.clerkid != clerkList.clerkid}">
										<option value="${clerkList.clerkid}">${clerkList.clerkname}</option>
									</c:if> 
								</c:forEach>
						</select>
						</td>
						<td><c:if test="${orderList.instatus == 0}">
							未验货
						</c:if>
						<c:if test="${orderList.instatus == 1}">
							${orderList.subtime}
						</c:if></td>
						<td><select name="pickid">
								<%-- <c:if test="${empty orderList.pickid}">  --%>
								 	<option selected="selected" value="0">请分配取货员</option>
							<%--	</c:if> --%>
								<c:forEach items="${pickList}" var="pickList">
									<c:if test="${orderList.pickid == pickList.pickid}"> 
										<option selected="selected" value="${pickList.pickid}">${pickList.pickname}</option>
									</c:if>
									<c:if test="${orderList.pickid != pickList.pickid}">
										<option value="${pickList.pickid}">${pickList.pickname}</option>
									</c:if>
								</c:forEach>
						</select></td>
						<td><c:if test="${orderList.pickstatus == 0}">
							未取货
						</c:if>
						<c:if test="${orderList.pickstatus == 1}">
							${orderList.picktime}
						</c:if></td>
						<td><c:if test="${orderList.putstatus == 0}">
							<a href="/demo/put.jsp?orderitemid=${orderList.orderitemid}&quantity=${orderList.quantity}&weight=${orderList.weight}&orderimg=${orderList.orderimg}">确认入库</a>
						</c:if>
						<c:if test="${orderList.putstatus == 1}">
							已入库
						</c:if></td>
						<td>
						<c:if test="${orderList.paystatus == 0}">
							<a href="javascript:setPay(${orderList.orderitemid})">确认付款</a>
						</c:if>
						<c:if test="${orderList.paystatus == 1}">
							已付款
						</c:if></td>
						<td><a href="javascript:deleteOrder(${orderList.orderitemid})">删除订单</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div style="float:left;width:100%;text-align:center">
				<ul class="pagination">
					<c:if test="${requestScope.pager.hasFirst==true}">
						<li><a href="getOrderListByCom.action?currentPage=1">首页</a></li>
					</c:if>
					
					<c:if test="${requestScope.pager.hasFirst==false}">
						<li class="disabled"><a href="javascript:void(0)">首页</a></li>
					</c:if>
					
					<c:if test="${requestScope.pager.hasPrevious==true}">
						<li><a href="getOrderListByCom.action?currentPage=${requestScope.pager.currentPage-1}">上一页 </a></li>
					</c:if>
					
					<c:if test="${requestScope.pager.hasPrevious==false}">
						<li class="disabled"><a href="javascript:void(0)">上一页 </a></li>
					</c:if>
					
					<c:if test="${requestScope.pager.hasNext==true}">
						<li><a href="getOrderListByCom.action?currentPage=${requestScope.pager.currentPage+1}">下一页 </a></li>
					</c:if>
					
					<c:if test="${requestScope.pager.hasNext==false}">
						<li class="disabled"><a href="javascript:void(0)">下一页 </a></li>
					</c:if>
					
					<c:if test="${requestScope.pager.hasLast==true}">
						<li><a href="getOrderListByCom.action?currentPage=${requestScope.pager.totalPage}">尾页 </a></li>
					</c:if>
					
					<c:if test="${requestScope.pager.hasNext==false}">
						<li class="disabled"><a href="javascript:void(0)">尾页 </a></li>
					</c:if>
				</ul>
				<br> 当前第${requestScope.pager.currentPage}页，总共${requestScope.pager.totalPage}页
			</div>	
	</div>
            </div>
        </div>
</body>
</html>