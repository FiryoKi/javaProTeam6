package com.sc.service.impl;

import com.sc.dao.GoodDao;
import com.sc.po.Good;
import com.sc.service.GoodService;

import java.util.List;

/**
 * GoodService
 * @author 6组
 */
public class GoodServiceImpl implements GoodService {
    GoodDao gd=new GoodDao();
    /**
     * 查询
     */
    public List<Good>selectAll(){
        List<Good> good=gd.selectAll();
        if(good.size()!=0&&good!=null) {
            return good;
        }else {
            return null;
        }
    }
    /**
     * 兑换
     */
    public Good exchange(Good good) {
        Good g=gd.Exchange(good);
        if(g!=null) {
            return g;
        }else {
            return null;
        }
    }
    /**
     * 修改兑换商品数量
     */
    public boolean updateNumber(String goodName, int number) {
        int i= gd.updateNumber(goodName,number);
        if(i>0) {
            return true;
        }else {
            return false;
        }
    }
    /**
     * 新增
     */
    public boolean add(Good g) {
        int i=gd.add(g);
        if(i>0) {
            return true;
        }else {
            return false;
        }
    }
    /**
     * 修改
     */
    public boolean update(Good g) {
        int i=gd.update(g);
        if(i>0) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 删除
     */
    public boolean delete(int gid) {
        int i=gd.delete(gid);
        if(i>0) {
            return true;
        }else {
            return false;
        }
    }
}
