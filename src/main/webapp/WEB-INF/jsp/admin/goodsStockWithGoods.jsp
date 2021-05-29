<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp" %>
<form class="form-horizontal form-label-left" novalidate>

    <span class="section">库存信息</span>

    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">商品id<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsId" class="form-control input-small input-sm " value="${goodsStock.goodsId}" type="text"
                   readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">名称<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsName" class="form-control col-md-7 col-xs-5" value="${goodsStock.goodsName}" type="text"
                   readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">售价 <span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsPrice" class="form-control col-md-7 col-xs-5" value="${goodsStock.goods.goodsPrice}"
                   type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">进价 <span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="inputPrice" class="form-control col-md-7 col-xs-5" value="${goodsStock.goods.inputPrice}"
                   type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">生产日期<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="productDate" class="form-control col-md-7 col-xs-5"
                   value="<fmt:formatDate pattern="yyyy-MM-dd" value="${goodsStock.goods.productDate}"/>" type="text"
                   readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">过期时间<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="expiryDate" class="form-control col-md-7 col-xs-5"
                   value="<fmt:formatDate pattern="yyyy-MM-dd" value="${goodsStock.goods.expiryDate}"/>" type="text"
                   readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">供应商名称<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="supName" class="form-control col-md-7 col-xs-5" value="${goodsStock.goods.supName}" type="text"
                   readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">商品类型<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsType" class="form-control col-md-7 col-xs-5" value="${goodsStock.goods.goodsType}"
                   type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">数量<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="number" class="form-control col-md-7 col-xs-5" value="${goodsStock.number}" type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">计件方式<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="unit" class="form-control col-md-7 col-xs-5" value="${goodsStock.goods.unit}" type="text"
                   readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">备注<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="remarks" class="form-control col-md-7 col-xs-5" value="${goodsStock.remarks}" type="text"
                   readonly>
        </div>
    </div>
    <div class="col-md-12 text-center">
        <a onclick="javascript:history.back(-1);" class=" text-left btn btn-default  " role="button">返回上页</a>
    </div>

</form>
<div class="clearfix"></div>
<%@include file="common/foot.jsp" %>