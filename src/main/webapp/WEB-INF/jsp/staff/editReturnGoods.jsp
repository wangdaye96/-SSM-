<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<form class="form-horizontal form-label-left" method="post" action="update" onsubmit="return checkAll()">

    <span class="section">修改退货信息</span>

    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">订单id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="returnId" name="returnId" class="form-control input-small input-sm " value="${returnGoods.returnId}"  type="text" readonly="readonly">
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">商品id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsId" name="goodsId" class="form-control input-small input-sm "  value="${returnGoods.goodsId}"  type="text" onblur="checkgoodsId"><span id="demo3" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >名称<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsName" name="goodsName" class="form-control col-md-7 col-xs-5" value="${returnGoods.goodsName}" onblur="checkName()" type="text" ><span id="demo2" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >数量 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="number" name="number" class="form-control col-md-7 col-xs-5" value="${returnGoods.number}"  type="text" onblur="checkNumber()"><span id="demo4" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >进货日期<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="inputDate"  name="inputDate" class="form-control col-md-7 col-xs-5" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${returnGoods.inputDate}"/>" type="date" >
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >退货货日期<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="returnDate"  name="returnDate" class="form-control col-md-7 col-xs-5" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${returnGoods.returnDate}"/>" type="date" >
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >退货原因 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="reason" name="reason" class="form-control col-md-7 col-xs-5" value="${returnGoods.reason}"  type="text">
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >备注<span ></span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="remarks" name="remarks" class="form-control col-md-7 col-xs-5" value="${returnGoods.remarks}"  type="text" >
        </div>
    </div>
    <a href="${pageContext.request.contextPath }/returnGoods/getAllReturnGoods" class=" text-left btn btn-default" role="button">返回上页</a>
    <button type="submit" class="btn btn-primary text-center  col-md-offset-4 col-lg-offset-4col-xl-offset-4" >修改</button>
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
    function checkgoodsId()
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
        let num = document.getElementById('number').value;
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
    /* 校验整个表单 */
    function checkAll(){
        let name = checkName();
        let goodsId=checkgoodsId();
        let num=checkName();

        if(name&&goodsId&&num){
            alert("修改成功");
            return true;
        }else{
            alert("修改失败，请重新填写数据");
            return false;
        }
    }
</script>