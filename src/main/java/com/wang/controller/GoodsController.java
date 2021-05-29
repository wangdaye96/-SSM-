package com.wang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.pojo.Goods;
import com.wang.pojo.GoodsStock;
import com.wang.service.GoodsServiceImpl;
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
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsServiceImpl goodsServiceImpl;
    @Autowired
    private GoodsStockServiceImpl goodsStockService;

    //	获取所有商品信息
    @RequestMapping("/getAllGoodsList")
    public String getAllGoodsList(ModelMap model,
                          @RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn
    ) {
        PageHelper.startPage(pn, 8);
        List<Goods> goods = goodsServiceImpl.selectByExample(null);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(goods);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/getAllGoodsList";
    }

    //编辑商品
    @RequestMapping("/editGoods")
    public String editProduct(Goods goods, Model model){
        model.addAttribute("goods",goodsServiceImpl.selectByPrimaryKey(goods.getGoodsId()));
        return "staff/editGoods";
    }

    //更新商品
    @RequestMapping("/updateGoods")
    public String updateGoods(Goods goods,Model model){
        if(goodsServiceImpl.updateByPrimaryKeySelective(goods)) {
            goods=goodsServiceImpl.selectByPrimaryKey(goods.getGoodsId());
            model.addAttribute("goods", goods);
            return "redirect:/goods/getAllGoodsList";
        }
        return null;
    }

    //	根据id查询单个商品信息
    @RequestMapping("/getGoodsById")
    public String getGoodsById(Integer goodsId, HttpServletRequest request, Model model) {
        request.setAttribute("goods", goodsServiceImpl.selectByPrimaryKey(goodsId));
        model.addAttribute("goods", goodsServiceImpl.selectByPrimaryKey(goodsId));
        return "staff/getGoodsById";
    }

    //删除商品
    @RequestMapping("/deleteGoods")
    public String deleteGoods(Integer goodsId) {
        goodsServiceImpl.deleteByPrimaryKey(goodsId);
        return "redirect:/goods/getAllGoodsList";
    }

    //根据条件查询
    @RequestMapping("/getGoodsByCondition")
    public String getGoodsByCondition(Model model, @RequestParam(value = "goodsId", required = false) Integer goodsId,
                              @RequestParam(value = "supName", required = false) String supName, @RequestParam(value = "goodsName", required = false) String goodsName,
                              @RequestParam(value = "goodsType", required = false) String goodsType, @RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn
    ) {
        if (goodsId==null && supName=="" && goodsType=="" && goodsName==""){
            return "redirect:/goods/getAllGoodsList";
        }
        PageHelper.startPage(pn, 100);
        List<Goods> goods = goodsServiceImpl.getGoodsByCondition(goodsId, supName, goodsName, goodsType);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(goods);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/getGoodsByCondition";
    }

    //  跳转到增加页面
    @RequestMapping("/toAddGoods")
    public String toAddGoods() {
        return "staff/addGoods";
    }

    @RequestMapping("/insertGoods")
    public String insertGoods(Goods goods, HttpServletRequest request) {
        if (null == goodsServiceImpl.selectByPrimaryKey(goods.getGoodsId())) {
            goodsServiceImpl.insert(goods);
            request.removeAttribute("GoodsMsg");
            GoodsStock goodsStock=new GoodsStock();
            goodsStock.setGoodsId(goods.getGoodsId());
            goodsStock.setGoodsName(goods.getGoodsName());
            goodsStock.setNumber(0);
            goodsStock.setRemarks("");
            goodsStockService.insert(goodsStock);
            return "redirect:/goods/getAllGoodsList";
        } else {
            request.setAttribute("GoodsMsg", "新增失败，系统中存在该id的商品，请重新输入！");
            return "staff/addGoods";
        }
    }

    @InitBinder
    protected void init(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
