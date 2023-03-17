package com.sc.view;


import com.sc.util.InputUtil;

/**
 * 会员登录界面
 */
public class VipView {
    public void adminView(){
        System.out.println("会员界面");
        System.out.println("请选择：" +
                "1.兑换商品" +
                "2.查询剩余积分" +
                "3.修改密码" +
                "4.退出");
        System.out.println("请输入你要操作的选项：");
        int i= InputUtil.getInt();
        switch(i) {
            case 1:
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("没有该选项，请重新选择！！");
                break;

        }
    }
}
