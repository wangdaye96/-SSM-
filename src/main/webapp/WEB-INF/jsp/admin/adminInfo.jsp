<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<div class="col-md-12">
    <h3 class="text-center" style="color: darkviolet">个人信息</h3>
</div>
<form class="form-horizontal form-label-left" novalidate>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">管理员id<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="adminId" class="form-control input-small input-sm " value="${admin.adminId}" type="text"
                   readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">姓名<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="adminName" class="form-control col-md-7 col-xs-5" value="${admin.adminName}" type="text"
                   readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">身份证 <span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="idcard" class="form-control col-md-7 col-xs-5" value="${admin.idcard}" type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">性别 <span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="sex" class="form-control col-md-7 col-xs-5" value="${admin.sex}" type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">电话<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="tel" class="form-control col-md-7 col-xs-5" value="${admin.tel}" type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">身份类型<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="identity" class="form-control col-md-7 col-xs-5" value="${admin.identity}" type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">密码<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="password" class="form-control col-md-7 col-xs-5" value="${admin.password}" type="password"
                   readonly>
        </div>
    </div>
    <div class="col-md-12">
        <div class="text-center">
            <a href="${pageContext.request.contextPath }/admin/toUpdate?staffId=${admin.adminId}"
               class="text-center btn btn-primary" role="button" style="text-decoration: none"><i
                    class="fa fa-edit"></i> 修改</a>
        </div>
    </div>
    <div class="col-md-12">
        <div class="text-center">
            <a onclick="javascript:history.back(-1);" class=" text-left btn btn-default  " role="button"
               style="text-decoration: none"><i class="fa fa-rotate-left"></i> 返回上页</a>
        </div>
    </div>
</form>
<div class="clearfix"></div>
<%@include file="common/foot.jsp"%>

