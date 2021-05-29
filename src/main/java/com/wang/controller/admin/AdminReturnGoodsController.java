package com.wang.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.pojo.GoodsStock;
import com.wang.pojo.ReturnGoods;
import com.wang.pojo.ReturnGoodsExample;
import com.wang.service.GoodsStockServiceImpl;
import com.wang.service.InputGoodsServiceImpl;
import com.wang.service.ReturnGoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/adminReturnGoods")
public class AdminReturnGoodsController {
    @Autowired
    private ReturnGoodsServiceImpl returnGoodsServiceImpl;
    @Autowired
    private InputGoodsServiceImpl inputGoodsServiceImpl;
    @Autowired
    private GoodsStockServiceImpl goodsStockServiceImplService;

    //	获取所有退货信息
    @RequestMapping("/getAllReturnGoods")
    public String getAllReturnGoods(ModelMap model,
                                    @RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn
    ) {
        ReturnGoodsExample returnGoodsExample = new ReturnGoodsExample();
        returnGoodsExample.setOrderByClause("return_date DESC");
        PageHelper.startPage(pn, 8);
        List<ReturnGoods> returnGoods = returnGoodsServiceImpl.selectByExample(returnGoodsExample);
        PageInfo<ReturnGoods> pageInfo = new PageInfo<ReturnGoods>(returnGoods);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/getAllReturnGoods";
    }

    //	按条件获取所有进货信息
    @RequestMapping("/getReturnGoodsByCondition")
    public String getReturnGoodsByCondition(Model model, @RequestParam(value = "goodsId", required = false) Integer goodsId,
                                            @RequestParam(value = "returnId", required = false) String returnId, @RequestParam(value = "goodsName", required = false) String goodsName,
                                            @RequestParam(value = "returnDate", required = false) String returnDate, @RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn
    ) {
        if (goodsId == null && returnId == "" && goodsName == "" && returnDate == "") {
            return "redirect:/adminReturnGoods/getAllReturnGoods";
        }
        PageHelper.startPage(pn, 100);
        List<ReturnGoods> returnGoods = returnGoodsServiceImpl.getReturnGoodsByCondition(goodsId, returnId, goodsName, returnDate);
        PageInfo<ReturnGoods> pageInfo = new PageInfo<ReturnGoods>(returnGoods);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/getReturnGoodsByCondition";
    }

    //修改
    @RequestMapping("/edit")
    public String edit(ReturnGoods returnGoods,Model model){
        model.addAttribute("returnGoods", returnGoodsServiceImpl.selectByPrimaryKey(returnGoods.getReturnId()));
        return "admin/editReturnGoods";
    }

    //修改
    @RequestMapping("/update")
    public String update(ReturnGoods returnGoods,Model model){
        if(returnGoodsServiceImpl.updateByPrimaryKeySelective(returnGoods)) {
            returnGoods=returnGoodsServiceImpl.selectByPrimaryKey(returnGoods.getReturnId());
            model.addAttribute("returnGoods", returnGoods);
            return "redirect:/adminReturnGoods/getAllReturnGoods";
        }
        return null;
    }

    //删除
    @RequestMapping("/delete")
    public String delete(String returnId,HttpServletRequest request,Model model){
        returnGoodsServiceImpl.deleteByPrimaryKey(returnId);
        return "redirect:/adminReturnGoods/getAllReturnGoods";
    }

    //  跳转到增加页面
    @RequestMapping("/toAdd")
    public String toAdd (){
        return "admin/addReturnGoods";
    }

    //	根据id查询单个信息
    @RequestMapping("/getOneReturnGoods")
    @ResponseBody
    public ReturnGoods getOneReturnGoods(String returnId,HttpServletRequest request,Model model){
        ReturnGoods returnGoods=new ReturnGoods();
        returnGoods= returnGoodsServiceImpl.selectByPrimaryKey(returnId);
        return returnGoods;
    }

    @RequestMapping("/insert")
    public String insert (ReturnGoods returnGoods,HttpServletRequest request){
        if(null==inputGoodsServiceImpl.selectByPrimaryKey(returnGoods.getReturnId())) {
            request.removeAttribute("rrr");
            GoodsStock goodsStock=new GoodsStock();
            goodsStock.setGoodsId(returnGoods.getGoodsId());
            int i=goodsStockServiceImplService.selectByPrimaryKey(returnGoods.getGoodsId()).getNumber()-returnGoods.getNumber();
            goodsStock.setNumber(i);
            if (i>=0){
                request.removeAttribute("ReturnNumberError");
                returnGoodsServiceImpl.insert(returnGoods);
                goodsStockServiceImplService.updateByPrimaryKeySelective(goodsStock);
                return "redirect:/adminReturnGoods/getAllReturnGoods";
            }else {
                request.setAttribute("ReturnNumberError","库存不足，还有"+goodsStockServiceImplService.selectByPrimaryKey(returnGoods.getGoodsId()).getNumber());
                return "admin/addReturnGoods";
            }
        }else {
            request.setAttribute("rrr","新增失败，该id已存在");
            return "admin/addReturnGoods";
        }
    }

    @InitBinder
    protected void init(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
