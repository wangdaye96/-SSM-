package com.wang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wang.pojo.Staff;
import com.wang.service.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    StaffServiceImpl staffServiceImpl;

    @RequestMapping("/login")
    public String login(){
        return "staff/staffLogin";
    }

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam(name = "staffId") Integer staffId, @RequestParam(name = "pwd") String pwd, HttpSession session, HttpServletRequest request){
        Staff staff = staffServiceImpl.getStaff(staffId, pwd);
        if (staff!=null){
            session.setAttribute("user",staff);
            request.removeAttribute("error");
            return "redirect:check/main";
        }else {
            request.setAttribute("error", "账号,密码不匹配");
            return "staff/staffLogin";
        }
    }

    @RequestMapping("check/main")
    public String main(HttpSession session){
        //验证是否有session信息，防止非法登录，没有就跳转到登录页面
        if (session.getAttribute("user")!=null){
            return "staff/main";
        }
        return "staff/staffLogin";
    }

    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
        //退出清除session
        session.removeAttribute("user");
        session.invalidate();
        return "staff/staffLogin";
    }

    @RequestMapping("/getStaffById")
    public String getStaffById(int staffId, Model model){
        model.addAttribute("staff",staffServiceImpl.selectByPrimaryKey(staffId));
        return "staff/staffInfo";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(int staffId,Model model){
        model.addAttribute("staff",staffServiceImpl.selectByPrimaryKey(staffId));
        return "staff/checkPassword";
    }

    @RequestMapping("/update")
    public String update(Staff staff){
        if (staffServiceImpl.updateByPrimaryKeySelective(staff)){
            return "redirect:staff/login";
        }
        return null;
    }

    @RequestMapping("/checkPassword")
    public String checkPassword(@RequestParam(name = "password") String password,HttpSession session,Model model){
        Staff staff = (Staff) session.getAttribute("user");
        if (staff.getPassword().equals(password)){
            model.addAttribute("staff",staffServiceImpl.selectByPrimaryKey(staff.getStaffId()));
            session.removeAttribute("passwordError");
            return "staff/editStaff";
        }else {
            session.setAttribute("passwordError","密码错误，请重新输入");
            return "staff/checkPassword";
        }
    }
}
