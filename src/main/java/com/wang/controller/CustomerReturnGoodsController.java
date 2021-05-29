package com.wang.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.pojo.CustomerReturnGoods;
import com.wang.pojo.CustomerReturnGoodsExample;
import com.wang.pojo.GoodsStock;
import com.wang.service.CustomerReturnGoodsServiceImpl;
import com.wang.service.GoodsStockServiceImpl;
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
@RequestMapping("/CustomerReturnGoods")
public class CustomerReturnGoodsController {
    @Autowired
    private CustomerReturnGoodsServiceImpl customerReturnGoodsServiceImpl;
    @Autowired
    private GoodsStockServiceImpl goodsStockServiceImpl;

    //	获取所有退货信息
    @RequestMapping("getAllCustomerReturnGoodsInfo")
    public String getAllCustomerReturnGoodsInfo(ModelMap model,
                                                @RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn
    ) {
        PageHelper.startPage(pn, 4);
        CustomerReturnGoodsExample customerReturnGoodsExample = new CustomerReturnGoodsExample();
        customerReturnGoodsExample.setOrderByClause("return_date DESC");
        List<CustomerReturnGoods> customerReturnGoods = customerReturnGoodsServiceImpl.selectByExample(customerReturnGoodsExample);
        PageInfo<CustomerReturnGoods> pageInfo = new PageInfo<CustomerReturnGoods>(customerReturnGoods);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/getAllCustomerReturnGoodsInfo";
    }

    //删除
    @RequestMapping("/delete")
    public String delete(String orderId) {
        customerReturnGoodsServiceImpl.deleteByPrimaryKey(orderId);
        return "redirect:/CustomerReturnGoods/getAllCustomerReturnGoodsInfo";
    }

    //按条件获取所有进货信息
    @RequestMapping("getCustomerReturnGoodsByCondition")
    public String getCustomerReturnGoodsByCondition(HttpServletRequest request, Model model, @RequestParam(value = "goodsId", required = false) Integer goodsId,
                                                    @RequestParam(value = "orderId", required = false) String orderId, @RequestParam(value = "goodsName", required = false) String goodsName,
                                                    @RequestParam(value = "returnDate", required = false) String returnDate, @RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn
    ) {
        if (goodsId == null && orderId == "" && returnDate == "" && goodsName == "") {
            return "redirect:/CustomerReturnGoods/getAllCustomerReturnGoodsInfo";
        }
        PageHelper.startPage(pn, 100);
        List<CustomerReturnGoods> customerReturnGoods = customerReturnGoodsServiceImpl.getCustomerReturnGoodsByCondition(goodsId, orderId, goodsName, returnDate);
        PageInfo<CustomerReturnGoods> pageInfo = new PageInfo<CustomerReturnGoods>(customerReturnGoods);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/getCustomerReturnGoodsByCondition";
    }

    //  跳转到增加页面
    @RequestMapping("/toAdd")
    public String toAdd () {
        return "staff/addCustomerReturnGoods";
    }

    //新增
    @RequestMapping("/insert")
    public String insert (CustomerReturnGoods	customerReturnGoods,HttpServletRequest request,Model model){
        if(null==customerReturnGoodsServiceImpl.selectByPrimaryKey(customerReturnGoods.getOrderId())) {
            request.removeAttribute("customerReturnGoodsError");
            GoodsStock goodsStock=goodsStockServiceImpl.selectByPrimaryKey(customerReturnGoods.getGoodsId());
            goodsStock.setNumber((goodsStock.getNumber()+customerReturnGoods.getNumber()));
            customerReturnGoodsServiceImpl.insert(customerReturnGoods);
            goodsStockServiceImpl.updateByPrimaryKeySelective(goodsStock);
            return "redirect:/CustomerReturnGoods/getAllCustomerReturnGoodsInfo";
        }else {
           request.setAttribute("customerReturnGoodsError","新增失败,该订单id已存在");
           return "staff/addCustomerReturnGoods";
        }
    }

    @InitBinder
    protected void init(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
