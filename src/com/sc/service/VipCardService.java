package com.sc.service;

import com.sc.po.VipCard;

/**
 * @author ltlrl
 * @className VipCardService
 * @date 2023/3/20/9:23
 **/
public interface VipCardService {
    public VipCard login(VipCard vip) ;

    /**
     * 修改密码方法
     * @param v
     * @return
     */
    public boolean updatePassword(VipCard v);

    /**
     * 修改兑换后的积分
     * @param point
     * @param card
     * @return
     */
    public boolean updatePoint(int point,String card) ;

    /**
     * 根据卡号查询积分
     * @param card
     * @return
     */
    public int  selectPointsByCard(String card);
}
