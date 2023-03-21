package com.sc.view;


import com.sc.po.VipCard;

import com.sc.service.impl.AdminServiceImpl;
import com.sc.service.impl.VipCardServiceImpl;
import com.sc.util.DateUtil;
import com.sc.util.InputUtil;

import java.util.Calendar;
import java.util.List;


/**
 * 管理员界面
 */
public class AdminView {
    AdminServiceImpl adminService = new AdminServiceImpl();
    VipCardServiceImpl vipCardService = new VipCardServiceImpl();
    /**
    定义一个int变量j用来做返回上一级跳转
     */
    int j = 1;
    public int getJ() {
        return j;
    }

    public void adminView() {
        while (true){
            System.out.println("****管理界面****");
            System.out.println("请选择：" +
                    "1.注册开卡\t" +
                    "2.修改会员密码\t" +
                    "3.会员积分累计\t" +
                    "4.查询剩余积分\t" +
                    "5.查看所有会员信息\t" +
                    "6.管理积分兑换商品\t" +
                    "7.返回上一级");
            System.out.println("请输入你要操作的选项：");
            int i = InputUtil.getInt();
            switch (i) {
                case 1:
                    addVipCard();
                    break;
                case 2:
                    System.out.println("请输入用户名：");
                    String name1 = InputUtil.getString();
                    System.out.println("请输入需要修改的用户密码：");
                    String password1 = InputUtil.getString();
                    // 将获取到的值存储到对象中
                    VipCard v1 = new VipCard();
                    v1.setName(name1);
                    v1.setPassword(password1);
                    boolean flag = vipCardService.updatePassword(v1);
                    if (flag == true && name1.equals(name1)) {
                        System.out.println("修改成功！");

                    } else {
                        System.out.println("修改失败！");
                    }
                    break;
                case 3:
                    addPoints();
                    break;
                case 4:
                    selectPoints();
                    break;
                case 5:
                    selectAllVip();
                    break;
                case 6:
                    ExchangeView exchangeView = new ExchangeView();
                    exchangeView.adminExchange();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("没有该选项，请重新选择！！");
                    break;

            }
        }

    }

    //开卡
    public void addVipCard() {
        System.out.println("\n========== 添加会员 ==========");
        System.out.print("请输入会员姓名：");
        String name = InputUtil.getString();
        System.out.print("请输入会员密码：");
        String password = InputUtil.getString();
        Calendar now = Calendar.getInstance();
        /**
            日期+随机数生成六位卡号
         */
        String card;
        //获取当前日期
        String day =String.valueOf(now.get(Calendar.DAY_OF_MONTH));
        //生成四位随机数
        String random =String.valueOf((int)(Math.random()*(9999-1000+1))+1000);
        card = day+random;
        //开卡日期
        String now1 = DateUtil.dateToString(now.getTime());
        // 调用服务层的 addVipCard() 方法添加新的会员卡信息
        VipCard vipCard = new VipCard(name,password,card,now1);
        boolean success = adminService.addVipCard(vipCard);
        if (success) {
            System.out.println("添加新会员成功！");
        } else {
            System.out.println("添加新会员失败！");
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
    public void selectPoints(){
        System.out.println("请输入要查询的卡号");
        String card=InputUtil.getString();
        int points=adminService.selectPoints(card);
        System.out.println("积分为"+points);
    }
}
