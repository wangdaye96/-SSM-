package com.wang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.pojo.InputGoods;
import com.wang.pojo.InputGoodsExample;
import com.wang.service.InputGoodsServiceImpl;
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
@RequestMapping("/inputGoods")
public class InputGoodsController {
    @Autowired
    private InputGoodsServiceImpl inputGoodsService;

    //	获取所有进货信息
    @RequestMapping("getAllInputGoods")
    public String getAllInputGoods(ModelMap model,
                          @RequestParam(defaultValue="1",required=true,value="pn") Integer pn
    ) {
        PageHelper.startPage(pn, 8);
        InputGoodsExample inputGoodsExample=new InputGoodsExample();
        inputGoodsExample.setOrderByClause("input_date DESC");
        List<InputGoods> inputGoods= inputGoodsService.selectByExample(inputGoodsExample);
        PageInfo<InputGoods> pageInfo=new PageInfo<InputGoods>(inputGoods);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/getAllInputGoods";
    }

    //修改
    @RequestMapping("editInputGoods")
    public String editInputGoods(InputGoods inputGoods,Model model){
        model.addAttribute("inputGoods", inputGoodsService.selectByPrimaryKey(inputGoods.getInputId()));
        return "staff/editInputGoods";
    }

    //	按条件获取所有进货信息
    @RequestMapping("getInputGoodsByCondition")
    public String getInputGoodsByCondition(HttpServletRequest request, Model model, @RequestParam(value="goodsId",required=false)Integer goodsId,
                                           @RequestParam(value="inputId",required=false)String inputId, @RequestParam(value="goodsName",required=false)String goodsName,
                                           @RequestParam(value="inputDate",required=false) String inputDate, @RequestParam(defaultValue="1",required=true,value="pn") Integer pn
    ) {
        if (inputId=="" && goodsId==null && goodsName=="" && inputDate==""){
            return "redirect:/inputGoods/getAllInputGoods";
        }
        PageHelper.startPage(pn, 100);
        List<InputGoods> inputGoods= inputGoodsService.getInputGoodsByCondition(goodsId, inputId, goodsName, inputDate);
        PageInfo<InputGoods> pageInfo=new PageInfo<InputGoods>(inputGoods);
        model.addAttribute("pageInfo", pageInfo);
        return "staff/getInputGoodsByCondition";
    }

    //更新
    @RequestMapping("update")
    public String update(InputGoods inputGoods,Model model){
        if(inputGoodsService.updateByPrimaryKeySelective(inputGoods)) {
            inputGoods=inputGoodsService.selectByPrimaryKey(inputGoods.getInputId());
            model.addAttribute("inputGoods", inputGoods);
            return "redirect:/inputGoods/getAllInputGoods";
        }
        return null;
    }

    //删除
    @RequestMapping("/delete")
    public String delete(String inputId,HttpServletRequest request,Model model){
        inputGoodsService.deleteByPrimaryKey(inputId);
        return "redirect:/inputGoods/getAllInputGoods";
    }

    @InitBinder
    protected void init(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
