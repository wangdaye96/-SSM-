<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<div class="clearfix"></div>
<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title row">
            <h2>客户退货信息列表 </h2>
            <div class="clearfix"></div>
        </div>
        <!-- 按钮 -->
        <div class="row">
            <div class="x_content">
                <table id="datatable" class="table table-striped table-bordered table-hover">
                    <tr>
                        <th>退货单id</th>
                        <th>商品id</th>
                        <th>商品名称</th>
                        <th>商品售价</th>
                        <th>数量</th>
                        <th>商品总价</th>
                        <th>退货日期</th>
                        <th>退货原因</th>
                        <th>备注</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="returnGoods">
                        <tr>
                            <th>${returnGoods.orderId}</th>
                            <th>${returnGoods.goodsId}</th>
                            <th>${returnGoods.goodsName}</th>
                            <th>${returnGoods.goodsPrice}</th>
                            <th>${returnGoods.number}</th>
                            <th>${returnGoods.totalPrice}</th>
                            <th><fmt:formatDate pattern="yyyy-MM-dd" value="${returnGoods.returnDate}"/></th>
                            <th>${returnGoods.reason}</th>
                            <th>${returnGoods.remarks}</th>
                            <th>
                                <a onclick="del(${returnGoods.orderId})" class="btn btn-danger btn-xs" aria-label="Left Align" role="button">删除</a>
                            </th>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <!-- 显示分页信息 -->
        <div class="row">
            <!--分页文字信息  -->
            <div class="col-md-6">当前 ${pageInfo.pageNum }页,总${pageInfo.pages }
                页,总 ${pageInfo.total } 条记录</div>
            <!-- 分页条信息 -->
            <a onclick="javascript:history.back(-1);" class=" text-left btn btn-default  " role="button">返回上页</a>
        </div>

    </div>
</div>
<%@include file="common/foot.jsp"%>
<script type="text/javascript">
    function del(id) {
        let message=confirm("是否确认要删除?");
        if (message==true) {
            // 确认时做的操作 var
            window.location.href="${pageContext.request.contextPath }/CustomerReturnGoods/delete?orderId="+id;
            alert("删除成功");
        } else {
            // 取消时做的操作
            alert("删除失败");
        }
    }
</script>