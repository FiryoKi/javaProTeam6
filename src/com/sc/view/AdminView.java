package com.sc.view;


import com.sc.po.VipCard;
import com.sc.service.AdminService;
import com.sc.service.VipCardService;
import com.sc.util.InputUtil;

import java.util.List;


/**
 * 管理员界面
 */
public class AdminView {
    AdminService adminService = new AdminService();
    VipCardService vipCardService = new VipCardService();
    public void adminView() {
        System.out.println("管理界面");
        System.out.println("请选择：" +
                "1.注册开卡\t" +
                "2.修改密码\t" +
                "3.积分累计\t" +
                "4.查询剩余积分\t" +
                "5.查看所有会员信息\t" +
                "6.管理积分兑换商品\t" +
                "7.退出");
        System.out.println("请输入你要操作的选项：");
        int i = InputUtil.getInt();
        switch (i) {
            case 1:
                break;
            case 2:

                break;
            case 3:
                addPoints();
                break;
            case 4:

                break;
            case 5:
                selectAllVip();
                break;
            case 6:

                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("没有该选项，请重新选择！！");
                break;

        }
    }

    /**
     * 积分累计
     */
    public void addPoints() {
        System.out.println("请输入会员卡号");
        String card = InputUtil.getString();
        System.out.println("请输入添加的积分");
        int points = InputUtil.getInt();

        Boolean i = adminService.addPoints(card, points);
        if (i) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    /**
     * 查看所有会员信息
     */
    public void selectAllVip() {
        System.out.println("会员信息：");
        List<VipCard> vc = adminService.allVip();
        System.out.println("序号  姓名  密码      卡号  积分  开卡日期");
        for (VipCard v:vc) {
            System.out.println(v.getCid()+"\t"+v.getName()+"\t"+v.getPassword()+"\t"+v.getCard()
                    +"\t"+v.getPoint()+"    "+v.getCdate());
        }
        /*
                Boolean i = adminService.allVip();
        if (i) {
            System.out.println("查询成功");
        } else {
            System.out.println("查询失败");
        }
         */

    }
}
