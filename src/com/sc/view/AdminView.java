package com.sc.view;

import com.sc.util.InputUtil;
/**
 * 管理员界面
 */
public class AdminView {
    public void adminView(){
        System.out.println("管理界面");
        System.out.println("请选择：" +
                "1.注册开卡" +
                "2.修改密码" +
                "3.积分累计" +
                "4.查询剩余积分" +
                "5.查看所有会员信息" +
                "6.管理积分兑换商品" +
                "7.退出");
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
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            default:
                System.out.println("没有该选项，请重新选择！！");
                break;

        }
    }
}
