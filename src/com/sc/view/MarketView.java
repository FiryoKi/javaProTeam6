package com.sc.view;
import com.sc.po.Admin;
import com.sc.po.VipCard;
import com.sc.util.InputUtil;

/**
 * 超市会员管理系统主界面
 * @author 6组
 */
public class MarketView {

    public static void main(String[] args) {
        System.out.println("***欢迎来到超市会员管理系统***");
        while(true){
            System.out.println("****请选择：1.管理员登录\t2.会员登录\t0.退出系统****");
            int op1 = InputUtil.getInt();
            //管理员登录-跳转管理员管理界面AdminView
            if (op1 == 1) {
                LoginView loginView1 = new LoginView();
                Admin a = new Admin();
                AdminView adminView = new AdminView();
                boolean f1 = loginView1.AdminLogin(a);
                if(f1) {
                    adminView.adminView();
                }
            }
            //会员登录-跳转会员管理页面
            if (op1 == 2) {
                LoginView loginView2 = new LoginView();
                VipView vipView = new VipView();
                VipCard v = new VipCard();
                boolean f2 = loginView2.VipLogin(v);
                if(f2){
                    vipView.vipView(v);
                }
            }
            if(op1==0){
                System.out.println("退出超市会员管理系统");
                System.exit(0);
            }
            else {
                System.out.println("没有此选项，请重新选择！！");
            }
        }


    }
}
