package com.wang.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.pojo.Type;
import com.wang.service.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/adminGoodsType")
public class AdminGoodsTypeController {
    @Autowired
    private TypeServiceImpl typeServiceImpl;

//    查询所有
    @RequestMapping("/getAllGoodsType")
    public String getAllGoodsType(ModelMap model,
                         @RequestParam(defaultValue="1",required=true,value="pn") Integer pn
    ) {
        PageHelper.startPage(pn, 8);
        List<Type> types= typeServiceImpl.selectByExample(null);
        PageInfo<Type> pageInfo=new PageInfo<Type>(types);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/getAllGoodsType";
    }

    //根据条件查询
    @RequestMapping("/getTypeByCondition")
    public String getTypeByCondition(@RequestParam(value="name",required=false)String name, @RequestParam(value="TypeId",required=false)Integer TypeId,
                              @RequestParam(defaultValue="1",required=true,value="pn") Integer pn, HttpServletRequest request, Model model
    ) {
        if (TypeId==null && name==""){
            return "redirect:/adminGoodsType/getAllGoodsType";
        }
        PageHelper.startPage(pn, 100);
        List<Type> types= typeServiceImpl.getTypeByCondition(TypeId,name);
        PageInfo<Type> pageInfo=new PageInfo<Type>(types);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/getTypeByCondition";

    }

    //  跳转到修改页面
    @RequestMapping("/toUpdate")
    public String editProduct(Type type,HttpServletRequest request,Model model){
        model.addAttribute("type", typeServiceImpl.selectByPrimaryKey(type.getGoodsTypeId()));
        return "admin/editType";
    }

    //    修改类别
    @RequestMapping("/update")
    public String update(Type type,Model model){
        if(typeServiceImpl.updateByPrimaryKey(type)) {
            type=typeServiceImpl.selectByPrimaryKey(type.getGoodsTypeId());
            model.addAttribute("type", type);
            return "redirect:/adminGoodsType/getAllGoodsType";
        }
        return null;
    }

//    删除
    @RequestMapping("/delete")
    public String delete(Integer goodsTypeId) {
        typeServiceImpl.deleteByPrimaryKey(goodsTypeId);
        return "redirect:/adminGoodsType/getAllGoodsType";
    }

    @RequestMapping("/insert")
    public String insert(Type type,HttpServletRequest request){
        if(null==typeServiceImpl.selectByPrimaryKey(type.getGoodsTypeId())) {
            request.removeAttribute("insertTypeError");
            typeServiceImpl.insert(type);
        }else {
            request.setAttribute("insertTypeError","新增失败，该id已存在");
        }
        return "redirect:/adminGoodsType/getAllGoodsType";
    }
}
