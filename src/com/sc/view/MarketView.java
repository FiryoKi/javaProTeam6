package com.sc.view;

import com.sc.po.VipCard;
import com.sc.service.VipCardService;
import com.sc.util.InputUtil;

//超市会员管理系统主界面
public class MarketView {


    static VipCardService vs=new VipCardService();
    public static void main(String[] args) {
        int count=1;
        while(count<4){
            System.out.println("欢迎");
            System.out.println("用户名：");
            String name=InputUtil.getString();

            System.out.println("密码：");
            String password=InputUtil.getString();
            VipCard v=new VipCard();
            v.setName(name);
            v.setPassword(password);
            VipCard vip=vs.login(v);

            if(vip!=null&&name.equals(vip.getName())&&password.equals(vip.getPassword())){
                System.out.println("恭喜"+vip.getName()+"登录成功！");
                System.out.println("请选择：1.兑换商品\t2.修改密码\t3.查询剩余积分\t0.退出");
                int n=InputUtil.getInt();
                switch(n) {
                    case 1:

                        break;
                    case 2:

                        updatePassword();
                        break;
                    case 3:
                        break;
                    case 0:
                        break;
                }
            }	else{
                System.out.println("登录失败，请重新登录。");
                count++;
            }
        }
    }
    public static void updatePassword(){



        System.out.println("请输入需要修改的用户密码：");
        String password= InputUtil.getString();
        //将获取到的值存储到对象中
        VipCard v=new VipCard();

        v.setPassword(password);
        boolean flag=vs.updatePassword(v);
        if(flag){
            System.out.println("修改成功！");
        }else {
            System.out.println("修改失败！");
        }
    }
}
