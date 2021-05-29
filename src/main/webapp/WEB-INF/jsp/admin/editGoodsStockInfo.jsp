<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/head.jsp"%>
<form class="form-horizontal form-label-left" method="post" action="update" onsubmit="return checkAll()">

    <span class="section">修改库存信息</span>

    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">商品id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsId" name="goodsId" class="form-control input-small input-sm "  value="${goodsStock.goodsId}" readonly="readonly" type="text" >
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >名称<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsName" name="goodsName" class="form-control col-md-7 col-xs-5" value="${goodsStock.goodsName}" readonly="readonly" type="text" >
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >库存数量<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="number" name="number" class="form-control col-md-7 col-xs-5" value="${goodsStock.number}">
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >进货数量<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="inputNumber" name="inputNumber" class="form-control col-md-7 col-xs-5" value=""  onblur="checknum()"><span id="demo4" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >备注<span ></span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="remarks" name="remarks" class="form-control col-md-7 col-xs-5" value="${goodsStock.remarks}"  type="text" >
        </div>
    </div>
    <a onclick="javascript:history.back(-1);" class=" text-left btn btn-default  " role="button">返回上页</a>
    <button type="submit" class="btn btn-primary text-center  col-md-offset-4 col-lg-offset-4col-xl-offset-4" >进货</button>
</form>
<div class="clearfix"></div>
<%@include file="common/foot.jsp"%>
<script>
    function checknum()
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
                document.getElementById('num').value="";
                document.getElementById('num').focus();
                return false;
            }
        }
        else{
            document.getElementById("demo4").innerHTML="请输入商品数量！";
            document.getElementById('num').focus();
            return false;
        }
    }
    /* 校验整个表单 */
    function checkAll(){
        let num=checknum();
        if(num){
            alert("进货成功");
            return true;
        }else{
            alert("进货失败，请重新填写数据");
            return false;
        }
    }
</script>