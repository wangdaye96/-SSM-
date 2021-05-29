package com.wang.controller.admin;


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
@RequestMapping("/adminSupplier")
public class AdminSupplierController {
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
        return "admin/getAllSupplierInfo";
    }

    //按条件查询
    @RequestMapping("/getSupplierByCondition")
    public String getSupplierByCondition(@RequestParam(value = "supId", required = false) Integer supId, @RequestParam(value = "supName", required = false) String supName,
                                         @RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn, HttpServletRequest request, Model model) {
        if (supId == null && supName == "") {
            return "redirect:/adminSupplier/getAllSupplierInfo";
        }
        PageHelper.startPage(pn, 100);
        List<Supplier> suppliers = supplierServiceImpl.getSupplierByCondition(supId, supName);
        PageInfo<Supplier> pageInfo = new PageInfo<Supplier>(suppliers);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/getSupplierByCondition";
    }

    //删除
    @RequestMapping("/delete")
    public String delete(Integer supId) {
        supplierServiceImpl.deleteByPrimaryKey(supId);
        return "redirect:/adminSupplier/getAllSupplierInfo";
    }

    //跳转到修改页面
    @RequestMapping("/editSupplier")
    public String editProduct(Supplier supplier,HttpServletRequest request,Model model){
        model.addAttribute("supply", supplierServiceImpl.selectByPrimaryKey(supplier.getSupId()));
        return "admin/editSupplier";
    }

    //修改
    @RequestMapping("/updateSupplier")
    public String update(Supplier supplier,HttpServletRequest request,Model model){
        if(supplierServiceImpl.updateByPrimaryKeySelective(supplier)) {
            supplier=supplierServiceImpl.selectByPrimaryKey(supplier.getSupId());
            model.addAttribute("supplier", supplier);
            return "redirect:/adminSupplier/getAllSupplierInfo";
        }
        return null;
    }

    //跳转到增加页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "admin/addSupplier";
    }

    @RequestMapping("/insert")
    public String insert(Supplier supplier,HttpServletRequest request,Model model){
        if(null==supplierServiceImpl.selectByPrimaryKey(supplier.getSupId())) {
            request.removeAttribute("SupplierError");
            supplierServiceImpl.insert(supplier);
        }else {
            request.setAttribute("SupplierError","id已存在");
            return "admin/addSupplier";
        }
        return "redirect:/adminSupplier/getAllSupplierInfo";
    }
}
