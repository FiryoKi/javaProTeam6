package com.sc.view;

import com.sc.dao.VipCardDao;
import com.sc.util.InputUtil;
/**
 * 管理员界面
 */
public class AdminView {
    VipCardDao vipCardDao=new VipCardDao();
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

    /**
     * 积分累计
     */
    public void addPoints(){
        System.out.println("请输入会员卡号");
        String card=InputUtil.getString();
        System.out.println("请输入添加的积分");
        int points=InputUtil.getInt();
        vipCardDao.addPoints(card, points);
    }
    /**
     * 查看所有会员信息
     */
    public void selectAllVip(){

    }
}
