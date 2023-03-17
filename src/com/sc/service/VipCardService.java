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
    //修改方法
    public boolean updatePassword(VipCard v){
        int i=vipd.updatePassword(v);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
}
