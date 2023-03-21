package com.sc.service.impl;

import com.sc.dao.PowerDao;
import com.sc.po.Power;

public class PowerServiceImpl {
    public Power selectPower(String power){
        PowerDao powerDao = new PowerDao();
        Power p = powerDao.selectPower(power);
        if(p!=null){
            return p;
        }
        return null;
    }
}
