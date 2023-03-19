package com.sc.service;

import com.sc.dao.VipCardDao;
import com.sc.po.VipCard;

public class VipCardService {
    VipCardDao vipd=new VipCardDao();

    public VipCard login(VipCard vip) {
        VipCard v=vipd.login(vip);
        if(v!=null) {
            return v;
        }
        return null;
    }
    //修改密码方法
    public boolean updatePassword(VipCard v){
        int i=vipd.updatePassword(v);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
    //修改兑换后的积分
    public boolean updatePoint(int point,String card) {
        int i= vipd.updatePoint(point, card);
        if(i>0) {
            return true;
        }else {
            return false;
        }
    }
    //根据卡号查询积分
    public int  selecPointsByCard(String card){
        int i=vipd.selectPointsByCard(card);
        return i;
    }

}
