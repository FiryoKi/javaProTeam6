package com.sc.view;

import com.sc.po.Admin;
import com.sc.po.VipCard;
import com.sc.service.impl.AdminServiceImpl;
import com.sc.service.impl.VipCardServiceImpl;
import com.sc.util.InputUtil;

/**
登录界面：分管理员登录和会员登录
 * @author 87798
 */
public class LoginView {
    //创建管理员逻辑层对象

    AdminServiceImpl adminService = new AdminServiceImpl();

    VipCardServiceImpl vipCardService = new VipCardServiceImpl(); // 创建会员逻辑层对象

    //用来获取登录会员的卡号
    public String card;
    public String name;
    public boolean adminLogin(Admin admin){
        boolean flag = false;
        System.out.println("*****管理员登录*****");
        System.out.println("请输入用户名：");
        String adminName = InputUtil.getString();
        System.out.println("请输入密码：");
        String password = InputUtil.getString();
        //创建Admin对象，存储输入的值
        Admin a = new Admin();
        a.setAdmin(adminName);
        a.setPassword(password);
        admin = adminService.login(a);
        if(a!=null&&adminName.equals(admin.getAdmin())&&password.equals(admin.getPassword())){
            System.out.println("恭喜"+admin.getAdmin()+"登录成功");
            flag = true;
        }else {
            System.out.println("登录失败");
        }
        return flag;
    }
    public boolean vipLogin(VipCard vipCard){
        boolean flag1 = false;
        int count=1;
        while(true){
            System.out.println("*****会员登录*****");
            System.out.println("请输入用户名：");
            name =  InputUtil.getString();
            System.out.println("请输入密码：");
            String password = InputUtil.getString();
            VipCard v=new VipCard();
            v.setName(name);
            v.setPassword(password);
            vipCard = vipCardService.login(v);

            if(vipCard!=null&&name.equals(vipCard.getName())&&password.equals(vipCard.getPassword())){
                System.out.println("恭喜"+vipCard.getName()+"登录成功！");
                //获取卡号
                setCard(vipCard.getCard());
                //获取姓名
                setName(vipCard.getName());
                flag1 = true;
                break;
            }	else{
                count++;
                System.out.println("登录失败，请重新登录。剩余次数："+(4-count));
            }if(count==4) {
                System.out.println("登录次数用完，系统退出");
                System.exit(0);
            }
        }
        return flag1;
    }
    public void setCard(String card) {
        this.card = card;
    }

    public String getCard() {
        return card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
