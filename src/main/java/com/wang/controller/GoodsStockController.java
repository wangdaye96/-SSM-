package com.wang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.pojo.GoodsStock;
import com.wang.service.GoodsStockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/goodsStock")
public class GoodsStockController {
    @Autowired
    GoodsStockServiceImpl goodsStockServiceImpl;

    //获取库存信息
    @RequestMapping("/getAllGoodsStock")
    public String getAllGoodsStock(ModelMap model,
           @RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn) {
        PageHelper.startPage(pn, 8);
        List<GoodsStock> allGoodsStockInfo = goodsStockServiceImpl.getAllGoodsStockInfo();
        PageInfo<GoodsStock> pageInfo = new PageInfo(allGoodsStockInfo);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/goodsStockInfo";
    }

    //按条件获取库存信息
    @RequestMapping("/getAllGoodsStockInfoByCondition")
    public String getAllGoodsStockInfoByCondition(Model model,
           @RequestParam(value = "goodsId", required = false) Integer goodsId,
           @RequestParam(value = "goodsName", required = false) String goodsName,
           @RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn
    ) {
        if (goodsId==null && goodsName==""){
            return "redirect:/goodsStock/getAllGoodsStock";
        }
        PageHelper.startPage(pn, 100);
        List<GoodsStock> goodsStockInfo= goodsStockServiceImpl.getAllGoodsStockByCondition(goodsId,goodsName);
        PageInfo<GoodsStock> pageInfo=new PageInfo<GoodsStock>(goodsStockInfo);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/getGoodsStockByCondition";
    }

    //按id删除
    @RequestMapping("/delete")
    public String deleteById(Integer goodsId){
        goodsStockServiceImpl.deleteByPrimaryKey(goodsId);
        return "redirect:/goodsStock/getAllGoodsStock";
    }

    @RequestMapping("/goodsStockWithGoods")
    public String goodsStockWithGoods(Model model, HttpServletRequest request,@RequestParam(name="goodsId") Integer goodsId){
        GoodsStock goodsStock=goodsStockServiceImpl.goodsStockWithGoods(goodsId);
        request.setAttribute("goodsStock",goodsStock);
        model.addAttribute("goodsStock",goodsStock);
        return "staff/goodsStockWithGoods";
    }

    //  跳转到修改页面
    @RequestMapping("/toUpdate")
    public String editProduct(GoodsStock goodsStock,Model model){
        model.addAttribute("goodsStock", goodsStockServiceImpl.selectByPrimaryKey(goodsStock.getGoodsId()));
        return "staff/editGoodsStockInfo";
    }

    //    修改 进货

    @RequestMapping("/update")
    public String update(GoodsStock goodsStock,Model model,@RequestParam(name = "inputNumber") Integer inputNumber){
        if(goodsStockServiceImpl.update(goodsStock,inputNumber)) {
            goodsStock=goodsStockServiceImpl.selectByPrimaryKey(goodsStock.getGoodsId());
            model.addAttribute("goodsStock", goodsStock);
            return "redirect:/goodsStock/getAllGoodsStock";
        }
        return null;
    }

    //    库存预警
    @RequestMapping("/goodsStockWarning")
    public String goodsStockWarning(ModelMap model,
                                 @RequestParam(defaultValue="1",required=true,value="pn") Integer pn
    ) {
        PageHelper.startPage(pn, 8);
        List<GoodsStock> goodsStocks= goodsStockServiceImpl.goodsStockWarning();
        PageInfo<GoodsStock> pageInfo=new PageInfo<GoodsStock>(goodsStocks);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/goodsStockWarning";
    }

    //    临期产品
    @RequestMapping("/goodsStockDateWarning")
    public String goodsStockDateWarning(ModelMap model,
                                  @RequestParam(defaultValue="1",required=true,value="pn") Integer pn
    ) {
        PageHelper.startPage(pn, 8);
        List<GoodsStock> goodsStocks= goodsStockServiceImpl.goodsStockDateWarning();
        PageInfo<GoodsStock> pageInfo=new PageInfo<GoodsStock>(goodsStocks);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/goodsStockDateWarning";
    }

    //	根据id查询单个信息
    @RequestMapping("/getOneGoodsStock")
    @ResponseBody
    public GoodsStock getOneReturnGoods(Integer goodsId, HttpServletRequest request, Model model){
        GoodsStock goodsStock=new GoodsStock();
        goodsStock= goodsStockServiceImpl.selectByPrimaryKey(goodsId);
        return goodsStock;
    }
}
