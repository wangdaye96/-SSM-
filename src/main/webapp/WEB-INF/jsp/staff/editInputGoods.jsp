<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<form class="form-horizontal form-label-left" method="post" action="update" onsubmit="return checkAll()">

    <span class="section">修改进货信息</span>

    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">订单id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="inputId" name="inputId" class="form-control input-small input-sm " value="${inputGoods.inputId}"  type="text" readonly="readonly">
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">商品id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsId" name="goodsId" class="form-control input-small input-sm "  value="${inputGoods.goodsId}"  type="text"><span id="demo3" style="color: red;" readonly></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >名称<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsName" name="goodsName" class="form-control col-md-7 col-xs-5" value="${inputGoods.goodsName}" type="text" ><span id="demo2" style="color: red;" readonly></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >数量 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="number" name="number" class="form-control col-md-7 col-xs-5" value="${inputGoods.number}"  type="text" onblur="checkNumber()"><span id="demo4" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >进货日期<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="inputDate"  name="inputDate" class="form-control col-md-7 col-xs-5" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${inputGoods.inputDate}"/>" type="date">
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >备注<span ></span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="remarks" name="remarks" class="form-control col-md-7 col-xs-5" value="${inputGoods.remarks}"  type="text" >
        </div>
    </div>
    <a href="${pageContext.request.contextPath }/inputGoods/getAllInputGoods" class=" text-left btn btn-default" role="button">返回上页</a>
    <button type="submit" class="btn btn-primary text-center  col-md-offset-4 col-lg-offset-4col-xl-offset-4" >修改</button>
</form>
<div class="clearfix"></div>
<%@include file="common/foot.jsp"%>
<script>
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
        let num=checknum();
        if(num){
            alert("修改成功");
            return true;
        }else{
            alert("修改失败，请重新填写数据");
            return false;
        }
    }
</script>
