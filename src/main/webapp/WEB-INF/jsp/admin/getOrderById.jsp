<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<form class="form-horizontal form-label-left" novalidate>

    <span class="section">订单信息</span>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">订单id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="orderId" class="form-control input-small input-sm "  value="${order.orderId}"  type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">商品id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsId" class="form-control input-small input-sm "  value="${order.goodsId}"  type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >商品名称<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsName" class="form-control col-md-7 col-xs-5" value="${order.goodsName}"  type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >售价 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsPrice" class="form-control col-md-7 col-xs-5" value="${order.goodsPrice}"  type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >数量<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="number" class="form-control col-md-7 col-xs-5" value="${order.number}"  type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >总价 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="totalPrice" class="form-control col-md-7 col-xs-5" value="${order.totalPrice}"  type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >订单日期 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="order_date" class="form-control col-md-7 col-xs-5" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${order.orderDate}"/>"  type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >客户id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="custId" class="form-control col-md-7 col-xs-5" value="${order.custId}" type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >客户名称 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="custName" class="form-control col-md-7 col-xs-5" value="${order.custName}"  type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >备注<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="remarks" class="form-control col-md-7 col-xs-5" value="${order.remarks}"  type="text" readonly>
        </div>
    </div>

    <a href="${pageContext.request.contextPath }/adminOrder/getAllOrderInfo" class=" text-left btn btn-default  " role="button">返回上页</a>
    <a href="${pageContext.request.contextPath }/adminOrder/editOrder?orderId=${order.orderId}" class=" text-center btn btn-primary  col-md-offset-4 col-lg-offset-4col-xl-offset-4" role="button">修改</a>

</form>
<div class="clearfix"></div>
<%@include file="common/foot.jsp"%>