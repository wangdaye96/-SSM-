<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<div id="dy"  style="height: 600px;width: 1100px;margin-top: 50px;margin-left:20px;background-color: white">
    <div id="mainChart" style="border: 1px solid white; width:100%; height:85%;"></div>
</div>
<div class="clearfix"></div>
<%@include file="common/foot.jsp"%>
<script type="text/javascript">
    //使用ajax加载数据
    $.ajax({
        method:'post',
        url:'${pageContext.request.contextPath}/adminOrder/echartsData',
        dataType:'json',
        success:function(data){
            initChat(data);
        }
    });
    function initChat(data){
        var myChart = echarts.init(document.getElementById('mainChart'));
        option = {
            title : {
                text: '销量比例统计',
                subtext: '内部数据',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: data
            },
            series : [
                {
                    name: '销量',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:data,
                    itemStyle: {
                        emphasis: {
                            // 阴影的大小
                            shadowBlur: 10,
                            // 阴影水平方向上的偏移
                            shadowOffsetX: 0,
                            // 阴影颜色
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        },
            myChart.setOption(option);
    };
</script>
<script src="${pageContext.request.contextPath}/staticResource/js/echarts.min.js"></script>