package com.sc.service;

import com.sc.dao.GoodDao;
import com.sc.po.Good;

import java.util.List;

/**
 * @author 6组
 * @className GoodService
 * @date 2023/3/20/9:23
 **/
public interface GoodService {
    GoodDao gd=new GoodDao();

    /**
     * 查询
     * @return
     */
    public List<Good> selectAll();

    /**
     * 兑换
     * @param good
     * @return
     */
    public Good exchange(Good good) ;

    /**
     * 修改兑换商品数量
     * @param goodName
     * @param number
     * @return
     */
    public boolean updateNumber(String goodName, int number);

    /**
     * 新增
     * @param g
     * @return
     */
    public boolean add(Good g) ;

    /**
     * 修改
     * @param g
     * @return
     */
    public boolean update(Good g);

    /**
     * 删除
     * @param gid
     * @return
     */
    public boolean delete(int gid);
}
