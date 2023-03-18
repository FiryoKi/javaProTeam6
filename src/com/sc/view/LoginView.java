package com.sc.view;

import com.sc.po.Admin;
import com.sc.service.AdminService;
import com.sc.service.VipCardService;
import com.sc.util.InputUtil;

/**
登录界面：分管理员登录和会员登录
 */
public class LoginView {
    //创建管理员逻辑层对象
    AdminService adminService = new AdminService();
    //创建会员逻辑层对象
    VipCardService vipCardService = new VipCardService();

    public boolean AdminLogin(Admin admin){
        boolean flag = false;
        System.out.println("*****管理员登录*****");
        System.out.println("请输入用户名：");
        String adminname = InputUtil.getString();
        System.out.println("请输入密码：");
        String password = InputUtil.getString();
        //创建Admin对象，存储输入的值
        Admin a = new Admin();
        a.setAdmin(adminname);
        a.setPassword(password);
        admin = adminService.Login(a);
        if(a!=null&&adminname.equals(admin.getAdmin())&&password.equals(admin.getPassword())){
            System.out.println("恭喜"+admin.getAdmin()+"登录成功");
            flag = true;
        }else {
            System.out.println("登录失败");
        }
        return flag;
    }
    public boolean VipLogin(){
        boolean flag1 = false;
        System.out.println("*****会员登录*****");
        System.out.println("请输入用户名：");
        String adminname = InputUtil.getString();
        System.out.println("请输入密码：");
        String password = InputUtil.getString();
        return flag1;
    }
}
