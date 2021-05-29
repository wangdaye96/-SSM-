<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<div class="clearfix"></div>
<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title row">
            <h2>客户信息列表 </h2>
            <div class="clearfix"></div>
        </div>
        <!-- 按钮 -->
        <div class="row">
            <form class="form-inline" action="getCustomerByCondition" method="post">
			                      <span class="row">
			                       <div class="form-group">
								    <label >客户id:</label>
								    <input type="text" class="form-control" id="custId" name="custId" onblur="checkCustId()">
								  </div>
								  <div class="form-group">
								    <label >客户姓名:</label>
								    <input type="text" class="form-control" id="custName" name="custName">
								  </div>
								  <button class="btn btn-primary" type="submit">查询</button><span id="demo" style="color: red"></span>
								  <a href="${pageContext.request.contextPath }/customer/toAdd" class="btn btn-primary " role="button">新增</a>
								  </span>

            </form>
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
                                <a href="${pageContext.request.contextPath }/customer/editCustomer?custId=${customer.custId}" class="btn btn-primary btn-xs">修改</a>
                                <a onclick="del(${customer.custId})"  class= "btn btn-danger btn-xs" aria-label="Left Align" role="button">删除</a>
                            </th>
                        </tr>
                    </c:forEach>
                </table>
            </div>


            <!-- 显示分页信息 -->
            <div class="row">
                <!--分页文字信息  -->
                <div class="col-md-6">当前 ${pageInfo.pageNum }页,总${pageInfo.pages }
                    页,总 ${pageInfo.total } 条记录</div>
                <!-- 分页条信息 -->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li><a href="${pageContext.request.contextPath }/customer/getAllCustomer?pn=1">首页</a></li>
                            <c:if test="${pageInfo.hasPreviousPage }">
                                <li><a href="${pageContext.request.contextPath }/customer/getAllCustomer?pn=${pageInfo.pageNum-1}"
                                       aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                                </a></li>
                            </c:if>

                            <c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
                                <c:if test="${page_Num == pageInfo.pageNum }">
                                    <li class="active"><a href="#">${page_Num }</a></li>
                                </c:if>
                                <c:if test="${page_Num != pageInfo.pageNum }">
                                    <li><a href="${pageContext.request.contextPath }/customer/getAllCustomer?pn=${page_Num }">${page_Num }</a></li>
                                </c:if>

                            </c:forEach>
                            <c:if test="${pageInfo.hasNextPage }">
                                <li><a href="${pageContext.request.contextPath }/customer/getAllCustomer?pn=${pageInfo.pageNum+1 }"
                                       aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                                </a></li>
                            </c:if>
                            <li><a href="${pageContext.request.contextPath }/customer/getAllCustomer?pn=${pageInfo.pages}">末页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>

        </div>
    </div>
</div>
<%@include file="common/foot.jsp"%>
<script type="text/javascript">
    function del(id) {
        let message=confirm("是否确认要删除?");
        if (message==true) {
            // 确认时做的操作 var
            window.location.href="${pageContext.request.contextPath }/customer/delete?custId="+id;
            alert("删除成功");
        } else {
            // 取消时做的操作
            alert("删除失败");
        }
    }

    function checkCustId() {
        let num = document.getElementById('custId').value;
        if( num )
        {
            if( !isNaN( num ) )
            {
                document.getElementById("demo").innerHTML=" ";
                return true;
            }else{
                document.getElementById("demo").innerHTML="请输入正确的id！";
                document.getElementById('custId').value="";
                document.getElementById('custId').focus();
                return false;
            }
        }
    }
</script>