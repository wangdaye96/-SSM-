<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>超市商品管理系统</title>
<head>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/staticResource/css/bootstrap.min.css"/>
    <link type="text/css" href="${pageContext.request.contextPath}/staticResource/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/staticResource/css/font-awesome.min.css"/>
</head>
<style>
    .bg {
        background:url(${pageContext.request.contextPath}/staticResource/img/1.jpg) no-repeat center;
        background-size:cover;
    }
</style>
<body class="bg">
<div class="container" style="margin-top: 200px">
    <div class="col-md-12">
        <h1 class="text-center" style="color: white">超市商品管理系统 <i class="fa fa-shopping-cart"></i></h1>
    </div>
    <div class="col-md-12">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="text-center">
                <a href="admin/login" class="btn btn-link" style="text-decoration: none">
                    <h3 style="color: white"><i class="fa fa-user"></i> <i class="fa fa-arrow-right"></i>管理员入口</h3>
                </a>
            </div>
        </div>
    </div>
    <div class="col-md-12">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="text-center">
                <a href="staff/login" class="btn btn-link" style="text-decoration: none">
                    <h3 style="color: white"><i class="fa fa-users"></i> <i class="fa fa-arrow-right"></i>普通员工入口</h3>
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
