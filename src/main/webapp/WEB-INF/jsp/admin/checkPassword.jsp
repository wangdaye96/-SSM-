<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<div class="container">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <h1 class="text-center" style="color: #28a4c9">密码 <i class="fa fa-check-circle-o"> </i>验证</h1>
    </div>
</div>
<div class="container">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <form action="checkPassword" method="post" class="text-center">
            <i class="fa fa-lock"></i> 密码:<input type="password" name="password" placeholder="请输入密码"/><br>
            <span class="text-center" style="color: red;font-size: 20px">${passwordError}</span><br>
            <a onclick="javascript:history.back(-1);" class=" text-left btn btn-default  " role="button"><i class="fa fa-rotate-left"></i>返回上页</a>
            <button type="submit" style="color: blue" class="text-center"><i class="fa fa-hand-pointer-o"></i> 确定</button>
        </form>
    </div>
</div>
<%@include file="common/foot.jsp"%>