package com.wang.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.pojo.Customer;
import com.wang.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    //查询所有
    @RequestMapping("/getAllCustomer")
    public String getAllCustomer(ModelMap model,
                                 @RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn
    ) {
        PageHelper.startPage(pn, 8);
        List<Customer> customers = customerService.selectByExample(null);
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(customers);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/getAllCustomer";

    }

    //根据条件查询
    @RequestMapping("getCustomerByCondition")
    public String getCustomerByCondition(@RequestParam(value = "custId", required = false) Integer custId, @RequestParam(value = "custName", required = false) String custName,
                                         @RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn, HttpServletRequest request, Model model
    ) {
        if (custId == null && custName == ""){
            return "redirect:/customer/getAllCustomer";
        }
            PageHelper.startPage(pn, 100);
        List<Customer> customers = customerService.getCustomerByCondition(custId, custName);
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(customers);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/getCustomerByCondition";
    }

    //删除
    @RequestMapping("/delete")
    public String delete(Integer custId) {
        customerService.deleteByPrimaryKey(custId);
        return "redirect:/customer/getAllCustomer";
    }

    //新增
    @RequestMapping("/insert")
    public String insert(Customer customer,HttpServletRequest request){
        if(null==customerService.selectByPrimaryKey(customer.getCustId())) {
            request.removeAttribute("CustomerError");
            customerService.insert(customer);
        }else {
            request.setAttribute("CustomerError","id已存在");
            return "staff/addCustomer";
        }
        return "redirect:/customer/getAllCustomer";
    }

    //跳转到增加页面
    @RequestMapping("/toAdd")
    public String toAddCustomer(){
        return "staff/addCustomer";
    }

    //跳转到修改页面
    @RequestMapping("/editCustomer")
    public String editCustomer(Customer customer,HttpServletRequest request,Model model){
        model.addAttribute("customer", customerService.selectByPrimaryKey(customer.getCustId()));
        return "staff/editCustomer";
    }

    //修改
    @RequestMapping("/updateCustomer")
    public String update(Customer customer,Model model){
        if(customerService.updateByPrimaryKeySelective(customer)) {
            customer=customerService.selectByPrimaryKey(customer.getCustId());
            model.addAttribute("customer", customer);
            return "redirect:/customer/getAllCustomer";
        }
        return null;
    }

}
