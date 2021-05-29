<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp" %>
<form class="form-horizontal form-label-left" method="post" action="update" name="form" onsubmit="return checkAll()">

    <span class="section">修改类别信息</span>

    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">类别id<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="goodsTypeId" name="goodsTypeId" class="form-control col-md-7 col-xs-5"
                   value="${type.goodsTypeId}" type="text" readonly="readonly">
        </div>
    </div>
    <div class="item form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-5">商品类型<span>*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-5">
            <input id="typeName" name="typeName" class="form-control col-md-7 col-xs-5" value="${type.typeName}"
                   onblur="check()" type="text"><span id="demo1" style="color: red;"></span>
        </div>
    </div>
    <a href="${pageContext.request.contextPath }/goodsType/getAllGoodsType" class=" text-left btn btn-default  "
       role="button">返回上页</a>
    <button type="submit" class="btn btn-primary text-center  col-md-offset-4 col-lg-offset-4 col-xl-offset-4">修改
    </button>
</form>
<div class="clearfix"></div>
<%@include file="common/foot.jsp" %>
<script>
    /*  校验商品类型名称*/
    function check() {
        let name = document.getElementById('typeName').value;
        if (name) {
            if (isNaN(name)) {
                document.getElementById("demo1").innerHTML = " ";
                return true
            } else {
                document.getElementById("demo1").innerHTML = "请输入商品类型名称！";
                return false;
            }
        } else {
            document.getElementById("demo1").innerHTML = "请输入商品类型名称！";
            return false;
        }
    }

    /* 校验整个表单 */
    function checkAll() {
        let name = check();
        if (name) {
            alert("修改类名成功");
            return true;
        } else {
            alert("修改失败，请重新填写数据");
            return false;
        }
    }
</script>