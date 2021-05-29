package com.wang.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.pojo.Supplier;
import com.wang.service.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierServiceImpl supplierServiceImpl;

    //查询所有
    @RequestMapping("/getAllSupplierInfo")
    public String getAllSupplierInfo(ModelMap model,
                                     @RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn
    ) {
        PageHelper.startPage(pn, 8);
        List<Supplier> suppliers = supplierServiceImpl.selectByExample(null);
        PageInfo<Supplier> pageInfo = new PageInfo<Supplier>(suppliers);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/getAllSupplierInfo";
    }

    //按条件查询
    @RequestMapping("/getSupplierByCondition")
    public String getSupplierByCondition(@RequestParam(value = "supId", required = false) Integer supId, @RequestParam(value = "supName", required = false) String supName,
                                         @RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn, HttpServletRequest request, Model model) {
        if (supId == null && supName == "") {
            return "redirect:/supplier/getAllSupplierInfo";
        }
        PageHelper.startPage(pn, 100);
        List<Supplier> suppliers = supplierServiceImpl.getSupplierByCondition(supId, supName);
        PageInfo<Supplier> pageInfo = new PageInfo<Supplier>(suppliers);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/getSupplierByCondition";
    }

    //删除
    @RequestMapping("/delete")
    public String delete(Integer supId) {
        supplierServiceImpl.deleteByPrimaryKey(supId);
        return "redirect:/supplier/getAllSupplierInfo";
    }

    //跳转到修改页面
    @RequestMapping("/editSupplier")
    public String editProduct(Supplier supplier,HttpServletRequest request,Model model){
        model.addAttribute("supply", supplierServiceImpl.selectByPrimaryKey(supplier.getSupId()));
        return "staff/editSupplier";
    }

    //修改
    @RequestMapping("/updateSupplier")
    public String update(Supplier supplier,HttpServletRequest request,Model model){
        if(supplierServiceImpl.updateByPrimaryKeySelective(supplier)) {
            supplier=supplierServiceImpl.selectByPrimaryKey(supplier.getSupId());
            model.addAttribute("supplier", supplier);
            return "redirect:/supplier/getAllSupplierInfo";
        }
        return null;
    }

    //跳转到增加页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "staff/addSupplier";
    }

    @RequestMapping("/insert")
    public String insert(Supplier supplier,HttpServletRequest request,Model model){
        if(null==supplierServiceImpl.selectByPrimaryKey(supplier.getSupId())) {
            request.removeAttribute("SupplierError");
            supplierServiceImpl.insert(supplier);
        }else {
            request.setAttribute("SupplierError","id已存在");
            return "staff/addSupplier";
        }
        return "redirect:/supplier/getAllSupplierInfo";
    }
}
