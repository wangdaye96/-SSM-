<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<form class="form-horizontal form-label-left" method="post" action="insert" onsubmit="return checkAll()">

    <span class="section">新增顾客退货信息</span>

    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">订单id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="orderId" name="orderId" class="form-control input-small input-sm " value=""  type="text"><span id="demo1" style="color: red;"></span><span>${customerReturnGoodsError}</span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">商品id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsId" name="goodsId" class="form-control input-small input-sm "  value=""  type="text" onblur="checkGoodsId()"><span id="demo3" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >商品名称<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsName" name="goodsName" class="form-control col-md-7 col-xs-5" value="" onblur="checkName()" type="text" ><span id="demo2" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >售价 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsPrice" name="goodsPrice" class="form-control col-md-7 col-xs-5" value=""  type="number" onblur="checkgoodsPrice()"
                   onkeyup="total()"><span id="demo5" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >数量 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="number" name="number" class="form-control col-md-7 col-xs-5" value=""  type="text" onblur="checkNumber()"><span id="demo4" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >总价 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="totalPrice" name="totalPrice" class="form-control col-md-7 col-xs-5" placeholder="自动计算" type="number" onblur="total()" >
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >退货日期<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="returnDate"  name="returnDate" class="form-control col-md-7 col-xs-5" value="<fmt:formatDate pattern="yyyy-MM-dd" value=""/>" type="date" >
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >退货原因<span ></span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="reason" name="reason" class="form-control col-md-7 col-xs-5" value=""  type="text" >
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >备注<span ></span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="remarks" name="remarks" class="form-control col-md-7 col-xs-5" value=""  type="text" >
        </div>
    </div>
    <a onclick="javascript:history.back(-1);" class=" text-left btn btn-default  " role="button">返回上页</a>
    <button type="submit" id="submit" class="btn btn-primary text-center  col-md-offset-4 col-lg-offset-4col-xl-offset-4" >添加</button>
</form>
<div class="clearfix"></div>
<%@include file="common/foot.jsp"%>
<script>
    /*  校验商品名称*/
    function checkName(){
        let name=document.getElementById('goodsName').value;
        if(name){
            document.getElementById("demo2").innerHTML=" ";
            return true;
        }else{
            document.getElementById("demo2").innerHTML="请输入商品名称！";
            document.getElementById('goodsName').focus();
            return false;
        }
    }


    /*判断输入的id是不是数字  */
    function checkGoodsId()
    {
        let num = document.getElementById('goodsId').value;
        if( num )
        {
            if( !isNaN( num ) )
            {
                document.getElementById("demo3").innerHTML=" ";
                return true;
            }else{
                document.getElementById("demo3").innerHTML="请输入正确的商品id！";
                document.getElementById('goodsId').value="";
                document.getElementById('goodsId').focus();
                return false;
            }
        }
        else{
            document.getElementById("demo3").innerHTML="请输入商品id！";
            document.getElementById('goodsId').focus();
            return false;
        }
    }
    function checkNumber()
    {
        var num = document.getElementById('number').value;
        if( num )
        {
            if( !isNaN( num ) )
            {
                document.getElementById("demo4").innerHTML=" ";
                return true;
            }else{
                document.getElementById("demo4").innerHTML="请输入正确的商品数量！";
                document.getElementById('number').value="";
                document.getElementById('number').focus();
                return false;
            }
        }
        else{
            document.getElementById("demo4").innerHTML="请输入商品数量！";
            document.getElementById('number').focus();
            return false;
        }
    }
    function checkgoodsPrice()
    {
        let num = document.getElementById('goodsPrice').value;
        if( num )
        {
            if( !isNaN( num ) )
            {
                document.getElementById("demo5").innerHTML=" ";
                return true;
            }else{
                document.getElementById("demo5").innerHTML="请输入正确的售价！";
                document.getElementById('goodsPrice').value="";
                document.getElementById('goodsPrice').focus();
                return false;
            }
        }
        else{
            document.getElementById("demo5").innerHTML="请输入售价！";
            document.getElementById('goodsPrice').focus();
            return false;
        }
    }
    /*  算总价*/
    function total(){
        let num=document.getElementById('number').value;
        let price=document.getElementById('goodsPrice').value;
        let sum=  parseFloat(num*price);
        document.getElementById('totalPrice').value=sum;
    }
    /* 校验整个表单 */
    function checkAll(){
        let goodsPrice=checkgoodsPrice();
        let name = checkName();
        let goodsId=checkGoodsId();
        let num=checkNumber();

        if(goodsPrice&&name&&goodsId&&num){
            alert("添加中");
            return true;
        }else{
            alert("添加失败，请重新填写数据");
            return false;
        }
    }
</script>
<script src="${pageContext.request.contextPath}/staticResource/local_js/addCustomerReturnGoods.js"></script>