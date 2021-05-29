<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<div class="clearfix"></div>
<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title row">
            <h2>查询客戶信息结果 </h2>
            <div class="clearfix"></div>
        </div>
        <!-- 按钮 -->
        <div class="row">
            <div class="mid_center">
            </div>
        </div>
        <div class="row">
            <div class="x_content">
                <table id="datatable" class="table table-striped table-bordered table-hover">
                    <tr>
                        <th>客户id</th>
                        <th>客户姓名</th>
                        <th>客户电话</th>
                        <th>负责人</th>
                        <th>地址</th>
                        <th>邮箱</th>
                        <th>操作</th>
                    </tr>

                    <c:forEach items="${pageInfo.list}" var="customer">
                        <tr>
                            <th>${customer.custId}</th>
                            <th>${customer.custName}</th>
                            <th>${customer.tel}</th>
                            <th>${customer.person}</th>
                            <th>${customer.address}</th>
                            <th>${customer.emali}</th>
                            <th>
                                <a href="${pageContext.request.contextPath }/adminCustomer/editCustomer?custId=${customer.custId}" class="btn btn-primary btn-xs">修改</a>
                                <a onclick="del(${customer.custId})"  class= "btn btn-danger btn-xs" aria-label="Left Align" role="button">删除</a>
                            </th>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <!-- 显示分页信息 -->
        <div class="row">
            <!--分页文字信息  -->
            <div class="col-md-6"><%-- 当前 ${pageInfo.pageNum }页,总${pageInfo.pages }
								页, --%>总 ${pageInfo.total } 条记录</div>
        </div>
        <a href="${pageContext.request.contextPath }/adminCustomer/getAllCustomer" class=" text-left btn btn-default  " role="button">返回上页</a>
    </div>
</div>
<%@include file="common/foot.jsp"%>
<script type="text/javascript">
    function del(id) {
        let message=confirm("是否确认要删除?");
        if (message==true) {
            // 确认时做的操作 var
            window.location.href="${pageContext.request.contextPath }/adminCustomer/delete?custId="+id;
            alert("删除成功");
        } else {
            // 取消时做的操作
            alert("删除失败");
        }
    }
</script>