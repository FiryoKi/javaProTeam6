package com.sc.view;


import com.sc.po.VipCard;

import com.sc.service.impl.VipCardServiceImpl;
import com.sc.util.InputUtil;

/**
 * 会员登录界面
 * @author 6组
 */
public class VipView {
    VipCardServiceImpl vcs = new VipCardServiceImpl();
    int j = 1;

    public int getJ() {
        return j;
    }

    public void vipView(String card,String name) {
        System.out.println("****会员界面****");
        while (true) {
            System.out.println("请选择：" +
                    "1.兑换商品\t" +
                    "2.查询剩余积分\t" +
                    "3.修改密码\t" +
                    "4.返回上一级");
            System.out.println("请输入你要操作的选项：");
            int i = InputUtil.getInt();
            switch (i) {
                case 1:
                    ExchangeView exchangeView = new ExchangeView();
                    exchangeView.vipExchange();
                    break;
                case 2:
                    //需要获取到登录对象的卡号
                    /**
                     * Q：获取不到登录会员的卡号-----已解决（修改形参为卡号传递）
                     */
                    System.out.println("剩余积分为：" + vcs.selectPointsByCard(card));
                    break;

                case 3:
                    System.out.println("请输入您的用户名：");
                    String name1 = InputUtil.getString();
                    System.out.println("请输入需要修改的用户密码：");
                    String password1 = InputUtil.getString();
                    // 将获取到的值存储到对象中
                    VipCard v1 = new VipCard();
                    v1.setName(name);
                    v1.setPassword(password1);
                    boolean flag = vcs.updatePassword(v1);
                    if (flag == true && name1.equals(name)) {
                        System.out.println("修改成功！");

                    } else {
                        System.out.println("修改失败！");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("没有该选项，请重新选择！！");
                    break;
            }
        }
    }
}
