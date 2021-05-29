<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>超市商品管理系统</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/staticResource/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/staticResource/css/bootstrap-theme.css"/>
    <link rel="stylesheet" type="text/css"
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/staticResource/css/custom.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/staticResource/css/font-awesome.min.css"/>
</head>
<script type="text/javascript">
    function update(id) {
        window.location.href = "${pageContext.request.contextPath}/staff/toUpdate?staffId=" + id;
    }

    function get(id) {
        window.location.href = "${pageContext.request.contextPath}/staff/getStaffById?staffId=" + id;
    }
</script>
<body>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li>
                    <h4 style="color: white">超市商品管理系统 <i class="fa fa-shopping-cart"></i></h4>
                </li>
                <li class="dropdown pull-right">
                    <a data-toggle="dropdown" class="dropdown-toggle" style="color: white"><i class="fa fa-address-book"></i> 个人信息<strong
                            class="caret"></strong></a>
                    <ul class="dropdown-menu" style="width: auto">
                        <li>
                            <a onclick="get(${user.staffId})" style="text-decoration: none"><i
                                    class="fa fa-info-circle"></i> 基本信息</a>
                        </li>
                        <li>
                            <a onclick="update(${user.staffId})" style="text-decoration: none"><i
                                    class="fa fa-edit"></i> 修改资料</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="${pageContext.request.contextPath}/staff/logout" style="text-decoration: none"><i
                                    class="fa fa-sign-out"></i> 注销</a>
                        </li>
                    </ul>
                </li>
                <li class="pull-right">
                    <h4 style="color: white">欢迎<i class="fa fa-user" style="color: yellow"></i><span
                            style="color: white">${user.identity}</span><strong
                            style="color: white">${user.staffName}</strong>登录</h4>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="main_container">
    <div class="col-md-2 left_col">
        <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
                <a href="${pageContext.request.contextPath }/staff/check/main" class="site_title"><i
                        class="fa fa-home"></i> <span>Welcome!</span></a>
            </div>
            <div class="clearfix"></div>
            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                <div class="menu_section">
                    <ul class="nav side-menu">
                        <li><a><i class="fa fa-credit-card-alt"></i> 进货管理 <span
                                class="fa fa-chevron-down"></span></a>
                            <ul id="1" class="nav child_menu">
                                <li>
                                    <a href="${pageContext.request.contextPath}/inputGoods/getAllInputGoods">进货信息</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/returnGoods/getAllReturnGoods">退货信息</a>
                                </li>
                            </ul>
                        </li>
                        <li><a><i class="fa fa-edit"></i> 商品信息管理 <span
                                class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li><a href="${pageContext.request.contextPath}/goods/getAllGoodsList">商品信息</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/goodsType/getAllGoodsType">商品类别</a>
                                </li>
                            </ul>
                        </li>
                        <li><a><i class="fa fa-desktop"></i> 库存管理 <span
                                class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li>
                                    <a href="${pageContext.request.contextPath}/goodsStock/getAllGoodsStock">库存信息</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/goodsStock/goodsStockWarning">库存预警</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/goodsStock/goodsStockDateWarning">临期产品</a>
                                </li>
                            </ul>
                        </li>
                        <li><a><i class="fa fa-table"></i> 销售管理 <span
                                class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li>
                                    <a href="${pageContext.request.contextPath}/order/getAllOrderInfo">销售信息</a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/CustomerReturnGoods/getAllCustomerReturnGoodsInfo">顾客退货办理</a>
                                </li>
                            </ul>
                        </li>
                        <li><a><i class="fa fa-bar-chart-o"></i> 客户信息管理 <span
                                class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li>
                                    <a href="${pageContext.request.contextPath}/customer/getAllCustomer">客户信息</a>
                                </li>
                            </ul>
                        </li>
                        <li><a><i class="fa fa-clone"></i>供应商信息管理 <span
                                class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li>
                                    <a href="${pageContext.request.contextPath}/supplier/getAllSupplierInfo">供应商信息</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-10 right_col" style="background-color: white">