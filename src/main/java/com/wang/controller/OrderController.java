package com.wang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.pojo.GoodsStock;
import com.wang.pojo.Order;
import com.wang.pojo.OrderExample;
import com.wang.service.GoodsStockServiceImpl;
import com.wang.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderServiceImpl;
    @Autowired
    private GoodsStockServiceImpl goodsStockService;

//    查询所有
    @RequestMapping("/getAllOrderInfo")
    public String getAllOrderInfo(ModelMap model,
                             @RequestParam(defaultValue="1",required=true,value="pn") Integer pn) {
        PageHelper.startPage(pn, 8);
        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause("order_date DESC");
        List<Order> sales= orderServiceImpl.selectByExample(orderExample);
        PageInfo<Order> pageInfo=new PageInfo<Order>(sales);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/getAllOrderInfo";
    }

    //按条件
    @RequestMapping("getOrderByCondition")
    public String getOrderByCondition(HttpServletRequest request, Model model, @RequestParam(value="goodsId",required=false)Integer goodsId,
                              @RequestParam(value="custId",required=false)String  custId,@RequestParam(value="orderId",required=false)String  orderId, @RequestParam(value="goodsName",required=false)String goodsName,
                              @RequestParam(value="custName",required=false)String custName, @RequestParam(value="orderDate",required=false)String orderDate,@RequestParam(defaultValue="1",required=true,value="pn") Integer pn
    ) {
        if (custId=="" && goodsId==null && custName=="" && goodsName=="" && orderId=="" && orderDate==""){
            return "redirect:/order/getAllOrderInfo";
        }
        PageHelper.startPage(pn, 100);
        List<Order> order= orderServiceImpl.getOrderByCondition(goodsId, custId,orderId, goodsName, custName,orderDate);
        PageInfo<Order> pageInfo=new PageInfo<Order>(order);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/getOrderByCondition";
    }

    //查询单个
    @RequestMapping("/getOrderById")
    public String getOrderById(String orderId,HttpServletRequest request,Model model) {
        request.setAttribute("order", orderServiceImpl.selectByPrimaryKey(orderId));
        model.addAttribute("order",orderServiceImpl.selectByPrimaryKey(orderId));
        return "staff/getOrderById";
    }

    //删除
    @RequestMapping("/delete")
    public String delete(String orderId){
        orderServiceImpl.deleteByPrimaryKey(orderId);
        return "redirect:/order/getAllOrderInfo";
    }

    //跳转到修改页面
    @RequestMapping("/editOrder")
    public String editOrder(Order order,HttpServletRequest request,Model model){
        model.addAttribute("order", orderServiceImpl.selectByPrimaryKey(order.getOrderId()));
        return "staff/editOrder";
    }

    //修改
    @RequestMapping("/updateOrder")
    public String updateOrder(Order order,Model model){
        if(orderServiceImpl.updateByPrimaryKeySelective(order)) {
            order=orderServiceImpl.selectByPrimaryKey(order.getOrderId());
            model.addAttribute("order", order);
            return "redirect:/order/getAllOrderInfo";
        }
        return null;
    }

    //跳转到新增页面
    @RequestMapping("/toAddOrder")
    public String toAddOrder(){
        return "staff/addOrder";
    }

    //新增
    @RequestMapping("/insert")
    public String insert(Order order,HttpServletRequest request){
        if(null==orderServiceImpl.selectByPrimaryKey(order.getOrderId())) {
            request.removeAttribute("insertOrder");
            GoodsStock goodsStock=goodsStockService.selectByPrimaryKey(order.getGoodsId());
            if ((goodsStock.getNumber()-order.getNumber())>=0){
                request.removeAttribute("NumberError");
                goodsStock.setNumber((goodsStock.getNumber()-order.getNumber()));
                System.out.println(order.toString());
                orderServiceImpl.insert(order);
                goodsStockService.updateByPrimaryKeySelective(goodsStock);
                return "redirect:/order/getAllOrderInfo";
            }else {
                int i = goodsStock.getNumber();
                request.setAttribute("NumberError","库存不足,还剩："+i);
                return "staff/addOrder";
            }
        }else {
            request.setAttribute("insertOrder","新增失败，该id已存在");
            return "staff/addOrder";
        }

    }

    @InitBinder
    protected void init(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
