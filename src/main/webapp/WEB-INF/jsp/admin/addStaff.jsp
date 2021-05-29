<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<form class="form-horizontal form-label-left"  method="post" action="insertStaff" onsubmit="return checkall()" >

    <span class="section">添加员工</span>

    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">员工id<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="staffId" name="staffId" class="form-control input-small input-sm "  value=""  type="text"  ><span>${insertStaffError}</span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >姓名<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="staffName" name="staffName" class="form-control col-md-7 col-xs-5" value=""  type="text" onblur="checkname()" ><span id="demo1" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >身份证 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="idcard" name="idcard" class="form-control col-md-7 col-xs-5" value=""  type="text" onblur="checkcard()" ><span id="demo2" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >性别 <span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="sex" name="sex" class="form-control col-md-7 col-xs-5" value=""  type="text"  >
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >电话<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="tel" name="tel" class="form-control col-md-7 col-xs-5"  value="" type="text" onblur="checktel()" >   <span id="demo3" style="color: red;"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >身份类型<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="identity" name="identity" class="form-control col-md-7 col-xs-5"  value="" type="text"  >
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5" >密码<span >*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="password" name="password" class="form-control col-md-7 col-xs-5" value=""  type="text" placeholder="请填写密码"  ><span id="tishi" style="color: red"></span>
        </div>
    </div>

    <a onclick="javascript:history.back(-1);" class=" text-left btn btn-default  " role="button">返回上页</a>
    <button type="submit" id="button" class="btn btn-primary text-center  col-md-offset-4 col-lg-offset-4col-xl-offset-4" >添加</button>
</form>
<div class="clearfix"></div>
<%@include file="common/foot.jsp"%>
<script type="text/javascript">
    function checkname(){
        var name= document.getElementById('staffname').value;
        var regName =/^[\u4e00-\u9fa5]{2,4}$/;
        if(!regName.test(name)){
            document.getElementById("demo1").innerHTML="请输入正确的姓名！";
            return false;
        }
        else{
            document.getElementById("demo1").innerHTML=" ";
            return true;
        }
    }
    function checkcard(){
        var card= document.getElementById('card').value;
        var regIdNo = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        if(!regIdNo.test(card)){
            document.getElementById("demo2").innerHTML="请输入正确的身份证！";
            return false;
        }
        else{
            document.getElementById("demo2").innerHTML=" ";
            return true;
        }
    }
    function checktel()
    {
        var tel= document.getElementById('tel').value;
        var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;//手机号码
        var isMob= /^0?1[3|4|5|8][0-9]\d{8}$/;// 座机格式
        if(isMob.test(tel)||isPhone.test(tel)){
            document.getElementById("demo3").innerHTML=" ";
            return true;
        }
        else{
            document.getElementById("demo3").innerHTML="请输入正确的电话 ";
            return false;
        }
    }
    function checkPassword() {
        var pwd = document.getElementById("password").value;
        if(pwd)
        {
            document.getElementById("tishi").innerHTML=" ";
            document.getElementById("button").disabled = false;
        }
        else {
            document.getElementById("tishi").innerHTML="请输入密码";
            document.getElementById("button").disabled = true;
        }
    }
    /* 验证整个表单 */
    function checkall(){
        var name=checkname();
        var tel=checktel();
        var card=checkcard();
        if(name&&tel&&card){
            alert("添加中");
            return true;
        }else{
            alert("添加失败");
            return false;
        }
    }
</script>