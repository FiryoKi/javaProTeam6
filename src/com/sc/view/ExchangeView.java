package com.sc.view;
import com.sc.po.Good;
import com.sc.po.VipCard;
import com.sc.service.GoodService;
import com.sc.service.impl.GoodServiceImpl;
import com.sc.service.impl.VipCardServiceImpl;
import com.sc.util.InputUtil;

import java.util.List;

/**
 * 积分兑换方法整合
 * @author 6组
 */

public class ExchangeView {

    GoodService gs=new GoodServiceImpl();
    VipCardServiceImpl vs=new VipCardServiceImpl();
    public void adminExchange(){
        System.out.println("请选择：1.查询并兑换可兑换物品\t2.新增可兑换商品\t3.删除可兑换商品\t4.修改可兑换商品\t5.返回主页面");
        System.out.println("请输入你要操作的选项：");
        int i = InputUtil.getInt();
        switch (i) {

           //兑换有一点问题目前3.19
            case 1:
                System.out.println("请输入卡号：");
                String card = InputUtil.getString();
                VipCard v=new VipCard();
                v.setCard(card);
                VipCard vipcard=vs.selectCard(card);
                if (vipcard!=null&&card.equals(vipcard.getCard())) {
                    selectAll();
                    System.out.println("请选择你想兑换的物品名称：");
                    String GoodName = InputUtil.getString();
                    System.out.println("请选择要兑换的数目：");
                    int Number = InputUtil.getInt();
                    int points = vs.selectPointsByCard(card);
                    Good g = new Good();
                    g.setGoodName(GoodName);
                    Good good = gs.exchange(g);
                    if (good != null && GoodName.equals(good.getGoodName()) && good.getNumber() >= Number && points >= good.getNeedPoint()) {
                        System.out.println("兑换成功！");
                        Number = good.getNumber() - Number;
                        g.setGoodName(GoodName);
                        g.setNumber(Number);
                        boolean flag = gs.updateNumber(GoodName, Number);
                        points -= good.getNeedPoint();
                        v.setPoint(points);
                        v.setCard(card);
                        boolean flag1 = vs.updatePoint(points, card);
                    } else {
                        System.out.println("商品名错误或商品数目少于所需数目或所需积分不足，因此兑换失败");
                    }
                } else {
                    System.out.println("卡号错误！");
                }
                break;
            case 2:
                selectAll();
                add();
                break;
            case 3:
                selectAll();
                delete();
                break;
            case 4:
                selectAll();
                update();
                break;
            case 5:
                break;
            default:
                System.out.println("没有该选项，请重新选择！！");
                break;

        }

    }
    public void vipExchange(){
        System.out.println("***请选择：1.查询并兑换可兑换物品\t2.返回主页面***");
        System.out.println("请输入你要操作的选项：");
        int op = InputUtil.getInt();
        switch (op) {
            case 1:
                System.out.println("请输入卡号：");
                String card = InputUtil.getString();
                VipCard v=new VipCard();
                v.setCard(card);
                VipCard vipcard=vs.selectCard(card);
                if (vipcard!=null&&card.equals(vipcard.getCard())) {
                    selectAll();
                    System.out.println("请选择你想兑换的物品名称：");
                    String GoodName = InputUtil.getString();
                    System.out.println("请选择要兑换的数目：");
                    int Number = InputUtil.getInt();
                    int points = vs.selectPointsByCard(card);
                    Good g = new Good();
                    g.setGoodName(GoodName);
                    Good good = gs.exchange(g);
                    if (good != null && GoodName.equals(good.getGoodName()) && good.getNumber() >= Number && points >= good.getNeedPoint()) {
                        System.out.println("兑换成功！");
                        Number = good.getNumber() - Number;
                        g.setGoodName(GoodName);
                        g.setNumber(Number);
                        boolean flag = gs.updateNumber(GoodName, Number);
                        points -= good.getNeedPoint();
                        v.setPoint(points);
                        v.setCard(card);
                        boolean flag1 = vs.updatePoint(points, card);
                    } else {
                        System.out.println("商品名错误或商品数目少于所需数目或所需积分不足，因此兑换失败");
                    }
                } else {
                    System.out.println("卡号错误！");
                }
                break;
            case 2:
                break;
            default:
                System.out.println("没有该选项，请重新选择！！");
                break;

        }
    }

    /**
     * 查询所有
     */
    public void selectAll() {
        List<Good> good=gs.selectAll();
        for(Good g:good) {
            System.out.println("商品编号\t商品名称\t兑换所需积分\t商品数量");
            System.out.println("  "+g.getGid()+"         "+g.getGoodName()+"        "+g.getNeedPoint()+"           "+g.getNumber());
        }
    }
    /**
     *   新增物品
     */
    public void add() {
        System.out.println("请输入要添加的物品名称：");
        String goodName = InputUtil.getString();
        System.out.println("请输入要添加的所需兑换积分：");
        int needPoint =InputUtil.getInt();
        System.out.println("请输入要添加的物品数量：");
        int number =InputUtil.getInt();
        Good g=new Good();
        g.setGoodName(goodName);
        g.setNeedPoint(needPoint);
        g.setNumber(number);
        boolean flag=gs.add(g);
        if(flag) {
            System.out.println("添加成功！");
        }
    }
    /**
     *
     * 更新物品
     */
    public void update() {
        System.out.println("请输入要更新的物品名称");
        String goodName =InputUtil.getString();
        System.out.println("请输入要更新的所需兑换积分：");
        int needPoint =InputUtil.getInt();
        System.out.println("请输入要更新的物品数量：");
        int number =InputUtil.getInt();
        Good g=new Good();
        g.setGoodName(goodName);
        g.setNeedPoint(needPoint);
        g.setNumber(number);
        boolean flag=gs.update(g);
        if(flag) {
            System.out.println("更新成功！");
        }
    }
    /**
     *
     * 删除物品信息
     */
    public void delete() {
        System.out.println("请输入要删除的的物品编号");
        int gid=InputUtil.getInt();
        boolean flag=gs.delete(gid);
        if(flag) {
            System.out.println("删除成功！");
        }

    }

}
