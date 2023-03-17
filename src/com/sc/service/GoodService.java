package com.sc.service;

import com.sc.dao.GoodDao;
import com.sc.po.Good;

import java.util.List;

public class GoodService {
    GoodDao gd=new GoodDao();
    //查询
    public List<Good>selectAll(){
        List<Good> good=gd.selectAll();
        if(good.size()!=0&&good!=null) {
            return good;
        }else {
            return null;
        }
    }
    //兑换
    public Good Exchange(Good good) {
        Good g=gd.Exchange(good);
        if(g!=null) {
            return g;
        }else {
            return null;
        }
    }
    //修改兑换商品数量
    public boolean updateNumber(String GoodName,int Number) {
        int i= gd.updateNumber(GoodName,Number);
        if(i>0) {
            return true;
        }else {
            return false;
        }
    }
    //新增
    public boolean add(Good g) {
        int i=gd.add(g);
        if(i>0) {
            return true;
        }else {
            return false;
        }
    }
    //修改
    public boolean update(Good g) {
        int i=gd.update(g);
        if(i>0) {
            return true;
        }else {
            return false;
        }
    }
    //删除
    public boolean delete(int Gid) {
        int i=gd.delete(Gid);
        if(i>0) {
            return true;
        }else {
            return false;
        }
    }
}
