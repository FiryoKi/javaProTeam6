package com.sc.service.impl;

import com.sc.dao.VipCardDao;
import com.sc.po.VipCard;
import com.sc.service.VipCardService;


/**
 * @author 6组
 */
public class VipCardServiceImpl implements VipCardService {
    VipCardDao vipCardDao =new VipCardDao();

    public VipCard login(VipCard vip) {
        VipCard v= vipCardDao.login(vip);
        if(v!=null) {
            return v;
        }
        return null;
    }

    /**
     * 修改密码方法
     * @param v
     * @return
     */
    public boolean updatePassword(VipCard v){
        int i= vipCardDao.updatePassword(v);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
    /**
     *  修改兑换后的积分
     */
    public boolean updatePoint(int point,String card) {
        int i= vipCardDao.updatePoint(point, card);
        if(i>0) {
            return true;
        }else {
            return false;
        }
    }
    /**
     * 根据卡号查询积分
     */
    public int  selectPointsByCard(String card){
        int i= vipCardDao.selectPointsByCard(card);
        return i;
    }

    /**
     * 查询卡号
     * @param card
     * @return
     */
    public VipCard selectCard(String card){
        VipCard v=vipCardDao.selectCard(card);
        if(v!=null){
            return v;
        }
        return null;
    }
    
}
