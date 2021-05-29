<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<form class="form-horizontal form-label-left" method="post" name="form" action="updateGoods" onsubmit="return checkAll()">

    <span class="section">修改商品信息</span>

    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">商品id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsId" name="goodsId" class="form-control input-small input-sm "  value="${goods.goodsId}"  type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >名称<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsName" name="goodsName" class="form-control col-md-7 col-xs-5" value="${goods.goodsName}"  type="text" onblur="check()"><span id="demo1"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >售价 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsPrice" name="goodsPrice" class="form-control col-md-7 col-xs-5" value="${goods.goodsPrice}"  type="text" onblur="ischeckNum()"><span id="demo2"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >进价 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="inputPrice"  name="inputPrice" class="form-control col-md-7 col-xs-5" value="${goods.inputPrice}"  type="text" onblur="ischeckinprice()">  <span id="demo3"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >生产日期<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="productDate"  name="productDate" class="form-control col-md-7 col-xs-5" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${goods.productDate}"/>" type="date" >
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >过期时间<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="expiryDate" name="expiryDate" class="form-control col-md-7 col-xs-5"  value="<fmt:formatDate pattern="yyyy-MM-dd" value="${goods.expiryDate}"/>" type="date">
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >供应商名称<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="supName" name="supName"  class="form-control col-md-7 col-xs-5" value="${goods.supName}"  type="text" >
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >商品类型<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsType"  name="goodsType" class="form-control col-md-7 col-xs-5"  value="${goods.goodsType}" type="text" >
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >计件方式<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="unit"  name="unit" class="form-control col-md-7 col-xs-5" value="${goods.unit}"  type="text" >
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >备注<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="remarks" name="remarks" class="form-control col-md-7 col-xs-5" value="${goods.remarks}"  type="text" >
        </div>
    </div>
    <a onclick="javascript:history.back(-1);" class=" text-left btn btn-default  " role="button">返回上页</a>
    <button type="submit" class="btn btn-primary text-center  col-md-offset-4 col-lg-offset-4 col-xl-offset-4" >修改	</button>
</form>
<div class="clearfix"></div>
<%@include file="common/foot.jsp"%>
<script>
    /*判断输入id是不是数字  */
    function checkid()
    {
        let num = document.getElementById('goodsId').value;
        if( num )
        {
            if( !isNaN( num ) )
            {
                document.getElementById("demo4").innerHTML=" ";
                return true;
            }else{
                document.getElementById("demo4").innerHTML="请输入正确的id！";
                document.getElementById('goodsId').value="";
                document.getElementById('goodsId').focus();
                return false;
            }
        }
        else{
            document.getElementById("demo4").innerHTML="请输入商品售价！";
            document.getElementById('goodsId').focus();
            return false;
        }
    }
    /*  校验商品名称*/
    function check(){
        if(document.getElementById("goodsName").value === ""){
            /*    alert("请输入商品名称！"); */
            document.getElementById("demo1").innerHTML="请输入商品名称！";
            return false;
        }
        else {
            document.getElementById("demo1").innerHTML=" ";
            return true
        }
    }
    /*判断输入的价格是不是数字  */
    function ischeckNum()
    {
        let num = document.getElementById('goodsPrice').value;
        if( num )
        {
            if( !isNaN( num ) )
            {
                document.getElementById("demo2").innerHTML=" ";
                return true;
            }else{
                document.getElementById("demo2").innerHTML="请输入正确的价格！";
                document.getElementById('goodsPrice').value="";
                document.getElementById('goodsPrice').focus();
                return false;
            }
        }
        else{
            document.getElementById("demo2").innerHTML="请输入商品售价！";
            document.getElementById('goodsPrice').focus();
            return false;
        }
    }
    function ischeckinprice()
    {
        let num = document.getElementById('inputPrice').value;
        if( num )
        {
            if( !isNaN( num ) )
            {
                document.getElementById("demo3").innerHTML=" ";
                return true;
                return true;
            }else{
                document.getElementById("demo3").innerHTML="请输入正确的价格！";
                document.getElementById('inputPrice').value="";
                document.getElementById('inputPrice').focus();
                return false;
            }
        }
        else{
            document.getElementById("demo3").innerHTML="请输入商品进价！";
            document.getElementById('inputPrice').focus();
            return false;
        }
    }
    /* 校验整个表单 */
    function checkAll(){
        let name = check();
        let price = ischeckNum();
        let inprice = ischeckinprice();

        if(price&&name&&inprice){
            alert("修改成功");
            return true;
        }else{
            alert("修改失败，请重新填写数据");
            return false;
        }
    }
</script>