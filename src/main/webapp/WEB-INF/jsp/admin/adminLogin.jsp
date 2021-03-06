<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录页面</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/staticResource/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/staticResource/css/font-awesome.min.css"/>
</head>
<style>
    .bg {
        background:url(${pageContext.request.contextPath}/staticResource/img/1.jpg) no-repeat center;
        background-size:cover;
    }
</style>
<body class="bg">
<div class="container-fluid" style="margin-top: 200px">
    <div class="col-md-12">
        <h1 class="text-center" style="color: #337ab7">超市商品管理系统 <i class="fa fa-shopping-cart"></i></h1>
        <h2 class="text-center" style="color: #5cb85c">管理员 <i class="fa fa-user"></i> 入口</h2>
    </div>
</div>
<div class="container-fluid">
    <form action="doLogin" method="post">
        <div class="col-md-12">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="form-group">
                          <label for="adminId" style="color: blue"><i class="fa fa-user"></i> 用户名:</label>
                          <input type="text" class="form-control" id="adminId" name="adminId" placeholder="请输入管理员id"
                                 required>
                </div>
            </div>
        </div>
           
        <div class="col-md-12">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="form-group">
                          <label for="pwd" style="color: blue"><i class="fa fa-lock"></i> 密码:</label>
                          <input type="password" class="form-control" id="pwd" name="pwd" placeholder="请输入密码" required>
                </div>
            </div>
        </div>
        <div class="col-md-12">
            <div class="text-center">
                <span style="font-size: 20px">${error}</span>
            </div>
        </div>
        <div class="col-md-12">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="col-md-4">
                    <button type="submit" class="btn btn-primary"><i class="fa fa-sign-in"></i> 登 录</button>
                </div>
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <button type="reset" class="btn btn-danger"><i class="fa fa-circle-o-notch"></i> 重 填</button>
                </div>
            </div>
        </div>
         
    </form>
</div>
<div class="container">
    <div class="col-md-12">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <a href="${pageContext.request.contextPath}/index.jsp" style="text-decoration: none">
                <h3 class="text-center" style="background-color: #fff42b">返回到首页面</h3>
            </a>
        </div>
    </div>
</div>
<div class="clearfix"></div>
</body>
</html>
