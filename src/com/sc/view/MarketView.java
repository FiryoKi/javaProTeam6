package com.sc.view;

import com.sc.po.Good;
import com.sc.service.GoodService;
import com.sc.util.InputUtil;

import java.util.List;

//超市会员管理系统主界面
public class MarketView {


    public static void main(String[] args) {

        System.out.println("请选择：1.查询并兑换可兑换物品\t2.新增可兑换商品\t3.删除可兑换商品\t4.修改可兑换商品\t5.返回主页面");
        System.out.println("请输入你要操作的选项：");
        int i=InputUtil.getInt();
        switch(i) {
            case 1:
                selectAll();
                System.out.println("请选择你想兑换的物品：");
                String GoodName = InputUtil.getString();
                System.out.println("请选择要兑换的数目：");
                int Number=InputUtil.getInt();
                Good g = new Good();
                g.setGoodName(GoodName);
                Good good = gs.Exchange(g);
                if (good != null && GoodName.equals(good.getGoodName()) && good.getNumber()>=Number) {
                    System.out.println("兑换成功！");
                    Number -= good.getNumber();
                    good.setGoodName(GoodName);
                    good.setNumber(Number);
                    boolean flag = gs.updateNumber(GoodName, Number);
                } else {
                    System.out.println("兑换失败");
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
static GoodService gs=new GoodService();
//查询所有
public static void selectAll() {
        List<Good> good=gs.selectAll();
        for(Good g:good) {
        System.out.println("商品编号\t商品名称\t兑换所需积分\t商品数量");
        System.out.println(g.getGid()+"\t"+g.getGoodName()+"\t"+g.getNeedPoint()+"\t"+g.getNumber());
        }
        }
//新增物品
public static void add() {
        System.out.println("请输入要添加的物品名称：");
        String GoodName= InputUtil.getString();
        System.out.println("请输入要添加的所需兑换积分：");
        int NeedPoint=InputUtil.getInt();
        System.out.println("请输入要添加的物品数量：");
        int Number=InputUtil.getInt();
        Good g=new Good();
        g.setGoodName(GoodName);
        g.setNeedPoint(NeedPoint);
        g.setNumber(Number);
        boolean flag=gs.add(g);
        if(flag) {
        System.out.println("添加成功！");
        }
        }
//更新物品
public static void update() {
        System.out.println("请输入要更新的物品名称");
        String GoodName=InputUtil.getString();
        System.out.println("请输入要更新的所需兑换积分：");
        int NeedPoint=InputUtil.getInt();
        System.out.println("请输入要更新的物品数量：");
        int Number=InputUtil.getInt();
        Good g=new Good();
        g.setGoodName(GoodName);
        g.setNeedPoint(NeedPoint);
        g.setNumber(Number);
        boolean flag=gs.update(g);
        if(flag) {
        System.out.println("更新成功！");
        }
        }
//删除物品信息
public static void delete() {
        System.out.println("请输入要删除的的物品编号");
        int Gid=InputUtil.getInt();
        boolean flag=gs.delete(Gid);
        if(flag) {
        System.out.println("更新成功！");
        }

    }
}
