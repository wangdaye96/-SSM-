package com.wang.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.pojo.Admin;
import com.wang.pojo.Staff;
import com.wang.service.AdminServiceImpl;
import com.wang.service.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminServiceImpl adminServiceImpl;
    @Autowired
    StaffServiceImpl staffServiceImpl;

    @RequestMapping("/login")
    public String login() {
        return "admin/adminLogin";
    }

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam(name = "adminId") String adminId,
                          @RequestParam(name = "pwd") String pwd,
                          HttpSession session, HttpServletRequest request) {
        Admin admin = adminServiceImpl.getAdmin(adminId, pwd);
        if (admin != null) {
            session.setAttribute("admin", admin);
            return "redirect:check/main";
        } else {
            request.setAttribute("error", "用户名,密码不匹配");
            return "admin/adminLogin";
        }
    }

    @RequestMapping("check/main")
    public String main(HttpSession session) {
        //验证是否有session信息，防止非法登录，没有就跳转到登录页面
        if (session.getAttribute("admin") != null) {
            return "admin/main";
        }
        return "admin/adminLogin";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        //退出清除session
        session.removeAttribute("admin");
        session.invalidate();
        return "admin/adminLogin";
    }

    @RequestMapping("/getAdminById")
    public String getAdminById(String adminId, Model model) {
        model.addAttribute("admin", adminServiceImpl.selectByPrimaryKey(adminId));
        return "admin/adminInfo";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(String adminId, Model model) {
        model.addAttribute("admin", adminServiceImpl.selectByPrimaryKey(adminId));
        return "admin/checkPassword";
    }

    @RequestMapping("/checkPassword")
    public String checkPassword(@RequestParam(name = "password") String password, HttpSession session, Model model) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin.getPassword().equals(password)) {
            model.addAttribute("admin", adminServiceImpl.selectByPrimaryKey(admin.getAdminId()));
            session.removeAttribute("passwordError");
            return "admin/editAdmin";
        } else {
            session.setAttribute("passwordError", "密码错误，请重新输入");
            return "admin/checkPassword";
        }
    }

    @RequestMapping("/update")
    public String update(Admin admin) {
        if (adminServiceImpl.updateByPrimaryKeySelective(admin)) {
            return "redirect:/admin/login";
        }
        return null;
    }

    //查询员工信息
    @RequestMapping("/adminGetAllStaff")
    public String adminGetAllStaffInfo(ModelMap model,
                                       @RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn
    ) {
        PageHelper.startPage(pn, 4);
        List<Staff> staffs = staffServiceImpl.selectByExample(null);
        PageInfo<Staff> pageInfo = new PageInfo<Staff>(staffs);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/adminGetAllStaffInfo";
    }

    //删除员工
    @RequestMapping("/delete")
    public String deleteStaff(Integer staffId) {
        staffServiceImpl.deleteByPrimaryKey(staffId);
        return "redirect:/admin/adminGetAllStaff";
    }

    //根据条件查询员工
    @RequestMapping("/getStaffByCondition")
    public String getStaffByCondition(@RequestParam(value = "staffName", required = false) String staffName, @RequestParam(value = "staffId", required = false) Integer staffId,
                                      @RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn, HttpServletRequest request, Model model
    ) {
        if (staffId == null && staffName == "") {
            return "redirect:/admin/adminGetAllStaff";
        }
        PageHelper.startPage(pn, 100);
        List<Staff> staffs = staffServiceImpl.getStaffByCondition(staffId, staffName);
        PageInfo<Staff> pageInfo = new PageInfo<Staff>(staffs);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/getStaffByCondition";
    }

    //跳转到修改员工信息页面
    @RequestMapping("/toUpdateStaff")
    public String editStaff(Staff staff, HttpServletRequest request, Model model) {
        model.addAttribute("staff", staffServiceImpl.selectByPrimaryKey(staff.getStaffId()));
        return "admin/editStaff";
    }

    //修改员工信息
    @RequestMapping("/updateStaff")
    public String updateStaff(Staff staff, HttpServletRequest request, Model model) {
        if (staffServiceImpl.updateByPrimaryKey(staff)) {
            staff = staffServiceImpl.selectByPrimaryKey(staff.getStaffId());
            model.addAttribute("staff", staff);
            return "redirect:/admin/adminGetAllStaff";
        }
        return null;
    }

    //跳转到增加页面
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "admin/addStaff";
    }

    //新增
    @RequestMapping("/insertStaff")
    public String insert(Staff staff, HttpServletRequest request, Model model) {
        if (null == staffServiceImpl.selectByPrimaryKey(staff.getStaffId())) {
            request.removeAttribute("insertStaffError");
            staffServiceImpl.insert(staff);
            return "redirect:/admin/adminGetAllStaff";
        } else {
            request.setAttribute("insertStaffError", "添加失败,该id已存在");
            return "admin/addStaff";
        }
    }

}
