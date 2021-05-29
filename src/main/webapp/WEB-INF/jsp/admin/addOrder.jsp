<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<form class="form-horizontal form-label-left" method="post" action="insert" onsubmit="return checkall()">

    <span class="section">新增订单</span>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">订单id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="orderId" name="orderId" class="form-control input-small input-sm "  value="${order.orderId}"  type="text"><span>${insertOrder}</span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">商品id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsId"  name="goodsId" class="form-control input-small input-sm "  value="${order.goodsId}"  type="text"  onblur="checkgoodsId()"><span id="demo2" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >商品名称<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsName" name="goodsName" class="form-control col-md-7 col-xs-5" value="${order.goodsName}"  type="text" onblur="checkgoodsName()" ><span id="demo3" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >售价 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsPrice" name="goodsPrice" class="form-control col-md-7 col-xs-5" value="${order.goodsPrice}"  type="number" onblur="checkgoodsPrice()"
                   onkeyup="total()"><span id="demo4" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >数量<span >*</span><span>${NumberError}</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="number" name="number" class="form-control col-md-7 col-xs-5" value="${order.number}"  type="number" onkeyup="total()" onblur="checknum()"><span id="demo5" style="color: red;"></span><span>${NumberError}</span>
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
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >订单日期 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="orderDate" name="orderDate" class="form-control col-md-7 col-xs-5" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${order.orderDate}"/>" type="date">
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">客户id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="custId"  name="custId" class="form-control input-small input-sm "  value="${order.custId}"  type="text" onblur="checkcusid()" ><span id="demo6" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >客户名称<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="custName" name="custName" class="form-control col-md-7 col-xs-5" value="${order.custName}"  type="text" onblur="checkcusname()" ><span id="demo7" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >备注<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="remarks" name="remarks" class="form-control col-md-7 col-xs-5" value="${order.remarks}"  type="text"  >
        </div>
    </div>
    <a onclick="javascript:history.back(-1);" class=" text-left btn btn-default  " role="button">返回上页</a>
    <button type="submit" class="btn btn-primary text-center  col-md-offset-4 col-lg-offset-4col-xl-offset-4" >新增</button>
</form>
<div class="clearfix"></div>
<%@include file="common/foot.jsp"%>
<script type="text/javascript">
    /* 验证商品id */
    function checkgoodsId()
    {
        let num = document.getElementById('goodsId').value;
        if( num )
        {
            if( !isNaN( num ) )
            {
                document.getElementById("demo2").innerHTML=" ";
                return true;
            }else{
                document.getElementById("demo2").innerHTML="请输入正确的商品id！";
                document.getElementById('goodsId').value="";
                document.getElementById('goodsId').focus();
                return false;
            }
        }
        else{
            document.getElementById("demo2").innerHTML="请输入商品id！";
            document.getElementById('goodsId').focus();
            return false;
        }
    }
    /*  校验商品名称*/
    function checkgoodsName(){
        let name = document.getElementById('goodsName').value;
        if(name==""){
            /*    alert("请输入商品名称！"); */
            document.getElementById("demo3").innerHTML="请输入商品名称！";
            return false;
        }
        else {
            document.getElementById("demo3").innerHTML=" ";
            return true
        }
    }
    /*  验证价格*/
    function checkgoodsPrice()
    {
        let num = document.getElementById('goodsPrice').value;
        if( num )
        {
            if( !isNaN( num ) )
            {
                document.getElementById("demo4").innerHTML=" ";
                return true;
            }else{
                document.getElementById("demo4").innerHTML="请输入正确的售价！";
                document.getElementById('goodsPrice').value="";
                document.getElementById('goodsPrice').focus();
                return false;
            }
        }
        else{
            document.getElementById("demo4").innerHTML="请输入售价！";
            document.getElementById('goodsPrice').focus();
            return false;
        }
    }
    /*  验证数量*/
    function checknum()
    {
        var num = document.getElementById('num').value;
        if( num )
        {
            if( !isNaN( num ) )
            {
                document.getElementById("demo5").innerHTML=" ";
                return true;
            }else{
                document.getElementById("demo5").innerHTML="请输入正确的数量！";
                document.getElementById('num').value="";
                document.getElementById('num').focus();
                return false;
            }
        }
        else{
            document.getElementById("demo5").innerHTML="请输入商品数量！";
            document.getElementById('num').focus();
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
    /* 验证客户id */
    function checkcusid()
    {
        let num = document.getElementById('custId').value;
        if( num )
        {
            if( !isNaN( num ) )
            {
                document.getElementById("demo6").innerHTML=" ";
                return true;
            }else{
                document.getElementById("demo6").innerHTML="请输入正确的客户id！";
                document.getElementById('custId').value="";
                document.getElementById('custId').focus();
                return false;
            }
        }
        else{
            document.getElementById("demo6").innerHTML="请输入客户id！";
            document.getElementById('custId').focus();
            return false;
        }
    }
    /*  校验客户名称*/
    function checkcusname(){
        let name = document.getElementById('custName').value;
        if(name==""){
            document.getElementById("demo7").innerHTML="请输入客户名称！";
            return false;
        }
        else {
            document.getElementById("demo7").innerHTML=" ";
            return true
        }
    }
    /* 验证整个表单 */
    function checkall(){
        var proid=checkgoodsId();
        var pname=checkgoodsName();
        var price=checkgoodsPrice();
        var num=checknum();
        var cusid=checkcusid();
        var cusname=checkcusname();
        if(proid&&pname&&price&&num&&cusid&&cusname){
            alert("新增成功");
            return true;
        }else{
            alert("新增失败，请重新填写数据");
            return false;
        }
    }
</script>
<script src="${pageContext.request.contextPath}/staticResource/local_js/addOrder.js"></script>