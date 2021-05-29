<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<form class="form-horizontal form-label-left" method="post" action="updateCustomer" onsubmit="return checkall()">

    <span class="section">修改客户信息</span>

    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >客户id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="custId" name="custId"  class="form-control col-md-7 col-xs-5" value="${customer.custId}" readonly="readonly" type="text" ><span id="demo1" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >客户姓名<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="custName"  name="custName" class="form-control col-md-7 col-xs-5"  value="${customer.custName}" type="text" onblur="checkname()"><span id="demo2" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >客户电话<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="tel"  name="tel" class="form-control col-md-7 col-xs-5"  value="${customer.tel}" type="text" onblur="checktel()"><span id="demo3" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >负责人<span ></span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="person"  name="person" class="form-control col-md-7 col-xs-5"  value="${customer.person}" type="text" >
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >地址<span ></span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="address"  name="address" class="form-control col-md-7 col-xs-5"  value="${customer.address}" type="text" >
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >邮箱<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="emali"  name="emali" class="form-control col-md-7 col-xs-5"  value="${customer.emali}" type="text" onblur="checkemail()"><span id="demo4" style="color: red;"></span>
        </div>
    </div>
    <a href="${pageContext.request.contextPath }/adminCustomer/getAllCustomer" class=" text-left btn btn-default  " role="button">返回上页</a>
    <button type="submit" class="btn btn-primary text-center  col-md-offset-4 col-lg-offset-4col-xl-offset-4" >修改</button>
</form>
<div class="clearfix"></div>
<%@include file="common/foot.jsp"%>
<script type="text/javascript">
    /*  校验商品名称*/
    function checkname(){
        let name = document.getElementById('custName').value;
        if(name==""){
            /*    alert("请输入商品名称！"); */
            document.getElementById("demo2").innerHTML="请输入客户名称！";
            return false;
        }
        else {
            document.getElementById("demo2").innerHTML=" ";
            return true
        }
    }
    /* 验证电话号码 */
    function checktel()
    {
        let tel= document.getElementById('tel').value;
        let isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;//手机号码
        let isMob= /^0?1[3|4|5|8][0-9]\d{8}$/;// 座机格式
        if(isMob.test(tel)||isPhone.test(tel)){
            document.getElementById("demo3").innerHTML=" ";
            return true;
        }
        else{
            document.getElementById("demo3").innerHTML="请输入正确的电话 ";
            return false;
        }

    }

    /* 验证邮箱 */
    function checkemail()
    {
        let temp = document.getElementById("emali").value;
        let reg = new RegExp("^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$");
        if(temp == ""){
            document.getElementById("demo4").innerHTML="请输入正确的邮箱 ";
        }else if(!reg.test(temp)){
            document.getElementById("demo4").innerHTML="请输入正确的邮箱 ";
            return false;
        }else{
            document.getElementById("demo4").innerHTML=" ";
            return true;
        }
    }
    /* 验证整个表单 */
    function checkall(){
        let name=checkname();
        let tel=checktel();
        let email=checkemail();
        if(name&&tel&&email){
            alert("修改中");
            return true;
        }else{
            alert("修改失败，请重新填写数据");
            return false;
        }
    }
</script>