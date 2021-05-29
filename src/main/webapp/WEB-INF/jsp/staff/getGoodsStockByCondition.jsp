<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<div class="clearfix"></div>
<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title row">
            <h2>库存信息查询结果列表 </h2>
            <div class="clearfix"></div>
        </div>
        <div class="row">
            <div class="x_content">
                <table id="datatable" class="table table-striped table-bordered table-hover">
                    <tr>
                        <th>商品id</th>
                        <th>名称</th>
                        <th>数量</th>
                        <th>备注</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="goodsStock">
                        <tr>
                            <th>${goodsStock.goodsId}</th>
                            <th>${goodsStock.goodsName}</th>
                            <th>${goodsStock.number}</th>
                            <th>${goodsStock.remarks}</th>
                            <th>
                                <a href="${pageContext.request.contextPath}/goodsStock/goodsStockWithGoods?goodsId=${goodsStock.goodsId}"
                                   class="btn btn-success  btn-xs">查看</a>
                                <a href="${pageContext.request.contextPath}/goodsStock/toUpdate?goodsId=${goodsStock.goodsId}" class="btn btn-primary btn-xs">进货</a>
                                <a onclick="del(${goodsStock.goodsId})"  class="btn btn-danger btn-xs" aria-label="Left Align" role="button">删除</a>
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

        </div>
        <a href="${pageContext.request.contextPath }/goodsStock/getAllGoodsStock" class=" text-left btn btn-default  " role="button">返回上页</a>
    </div>
</div>
<%@include file="common/foot.jsp"%>
<script type="text/javascript">
    function del(id) {
        let message=confirm("是否确认要删除?");
        if (message==true) {
            // 确认时做的操作
            window.location.href="${pageContext.request.contextPath}/goodsStock/delete?goodsId="+id;
            alert("删除中");
        } else {
            // 取消时做的操作
            alert("删除失败");
        }
    }
</script>