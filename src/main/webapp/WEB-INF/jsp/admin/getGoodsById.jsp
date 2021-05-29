<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<form class="form-horizontal form-label-left" novalidate>

    <span class="section">商品信息</span>

    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">商品id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsId" class="form-control input-small input-sm "  value="${goods.goodsId}"  type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >名称<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsName" class="form-control col-md-7 col-xs-5" value="${goods.goodsName}"  type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >售价 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsPrice" class="form-control col-md-7 col-xs-5" value="${goods.goodsPrice}"  type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >进价 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="inputPrice" class="form-control col-md-7 col-xs-5" value="${goods.inputPrice}"  type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >生产日期<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="productDate" class="form-control col-md-7 col-xs-5" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${goods.productDate}"/>" type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >过期时间<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="expiryDate" class="form-control col-md-7 col-xs-5"  value="<fmt:formatDate pattern="yyyy-MM-dd" value="${goods.expiryDate}"/>" type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >供应商名称<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="supName" class="form-control col-md-7 col-xs-5" value="${goods.supName}"  type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >商品类型<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="Type" class="form-control col-md-7 col-xs-5"  value="${goods.goodsType}" type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >计件方式<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="unit" class="form-control col-md-7 col-xs-5" value="${goods.unit}"  type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >备注<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="remarks" class="form-control col-md-7 col-xs-5" value="${goods.remarks}"  type="text" readonly>
        </div>
    </div>

    <a href="${pageContext.request.contextPath }/adminGoods/getAllGoodsList" class="text-left btn btn-default  " role="button">返回上页</a>
    <a href="${pageContext.request.contextPath }/adminGoods/editGoods?goodsId=${goods.goodsId}" class=" text-center btn btn-primary  col-md-offset-4 col-lg-offset-4col-xl-offset-4" role="button">修改</a>

</form>
<div class="clearfix"></div>
<%@include file="common/foot.jsp"%>