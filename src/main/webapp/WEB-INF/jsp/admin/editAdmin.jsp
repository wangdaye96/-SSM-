<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<div class="col-md-12">
    <h3 class="text-center" style="color: darkviolet">个人信息</h3>
</div>
<form class="form-horizontal form-label-left" method="post" action="update" onsubmit="return checkAll()">
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">管理员id<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="adminId" name="adminId" class="form-control input-small input-sm "
                   value="${admin.adminId}" type="text" readonly>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">姓名<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="adminName" name="adminName" class="form-control col-md-7 col-xs-5"
                   value="${admin.adminName}" type="text" onblur="checkName()"><span id="demo1"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">身份证 <span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="idcard" name="idcard" class="form-control col-md-7 col-xs-5" value="${admin.idcard}"
                   type="text" onblur="checkIdCard()"><span id="demo2" style="color: red"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">性别 <span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="sex" name="sex" class="form-control col-md-7 col-xs-5" value="${admin.sex}" type="text">
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">电话<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="tel" name="tel" class="form-control col-md-7 col-xs-5" value="${admin.tel}" type="text"
                   onblur="checkTel()"> <span id="demo3" style="color: red"></span>
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">身份类型<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="identity" name="identity" class="form-control col-md-7 col-xs-5"
                   value="${admin.identity}" type="text">
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">密码<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="password" name="password" class="form-control col-md-7 col-xs-5"
                   value="${admin.password}" type="password" placeholder="请填写密码">
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">密码<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="password2" name="password2" class="form-control col-md-7 col-xs-5" type="password"
                   placeholder="请再次填写密码" onkeyup="validate()"><span id="tip"></span>
        </div>
    </div>
    <div class="col-md-12">
        <div class="text-center">
            <button type="submit" id="button"
                    class="btn btn-primary"><i
                    class="fa fa-edit"></i>修改
            </button>
        </div>
    </div>
    <div class="col-md-12">
        <div class="text-center">
            <a onclick="javascript:history.back(-1);" class=" text-left btn btn-default  " role="button"
               style="text-decoration: none"><i class="fa fa-rotate-left"></i> 返回上页</a>
        </div>
    </div>
</form>
<%@include file="common/foot.jsp" %>
<script type="text/javascript">
    function checkName() {
        let name = document.getElementById('adminName').value;
        let regName = /^[\u4e00-\u9fa5]{2,4}$/;
        if (!regName.test(name)) {
            document.getElementById("demo1").innerHTML = "请输入正确的姓名！";
            return false;
        } else {
            document.getElementById("demo1").innerHTML = " ";
            return true;
        }
    }

    function checkIdCard() {
        let card = document.getElementById('idcard').value;
        let regIdNo = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        if (!regIdNo.test(card)) {
            document.getElementById("demo2").innerHTML = "请输入正确的身份证！";
            return false;
        } else {
            document.getElementById("demo2").innerHTML = " ";
            return true;
        }
    }

    function checkTel() {
        let tel = document.getElementById('tel').value;
        let isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;//手机号码
        let isMob = /^0?1[3|4|5|8][0-9]\d{8}$/;// 座机格式
        if (isMob.test(tel) || isPhone.test(tel)) {
            document.getElementById("demo3").innerHTML = " ";
            return true;
        } else {
            document.getElementById("demo3").innerHTML = "请输入正确的电话 ";
            return false;
        }
    }

    function validate() {
        let pwd1 = document.getElementById("password").value;
        let pwd2 = document.getElementById("password2").value;

        if (pwd1 === pwd2) {
            document.getElementById("tip").innerHTML = "<font color='green'>两次密码相同</font>";
            document.getElementById("button").disabled = false;
        } else {
            document.getElementById("tip").innerHTML = "<font color='red'>两次密码不相同</font>";
            document.getElementById("button").disabled = true;
        }
    }

    /* 验证整个表单 */
    function checkAll() {
        let name = checkName();
        let tel = checkTel();
        let card = checkIdCard();
        if (name && tel && card) {
            alert("修改成功,请重新登录");
            return true;
        } else {
            alert("修改失败，请重新填写数据");
            return false;
        }
    }
</script>