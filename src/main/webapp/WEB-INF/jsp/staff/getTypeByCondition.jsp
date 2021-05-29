<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<div class="clearfix"></div>
<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title row">
            <h2>查询商品类型信息结果 </h2>
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
                        <th>类名id</th>
                        <th>类别名称</th>
                        <th>操作</th>
                    </tr>

                    <c:forEach items="${pageInfo.list}" var="type">
                        <tr>
                            <th>${type.goodsTypeId}</th>
                            <th>${type.typeName}</th>
                            <th>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-xs btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        编辑 <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="${pageContext.request.contextPath }/goodsType/toUpdate?goodsTypeId=${type.goodsTypeId}">修改</a></li>
                                    </ul>
                                </div>
                                <a href="${pageContext.request.contextPath }/goodsType/delete?goodsTypeId=${type.goodsTypeId}"  class="btn btn-danger btn-xs" aria-label="Left Align" role="button">删除</a>
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
        <a href="${pageContext.request.contextPath }/goodsType/getAllGoodsType" class=" text-left btn btn-default  " role="button">返回上页</a>
    </div>
</div>
<%@include file="common/foot.jsp"%>