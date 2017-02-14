<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basepath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
  <title>查询码结果页</title>

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
      <h1><small>提交码</small></h1>
    </div>
    <div class="login-content ">
      <div class="form">
          <div align="center">
              ${requestScope.subnumAndPwd}
            </div>
      </div>
    </div>
  </div>
</div>


</body>

</html>
