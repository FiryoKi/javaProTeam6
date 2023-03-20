package com.sc.service;

import com.sc.po.Admin;
import com.sc.po.VipCard;

import java.util.List;

/**
 * @author 6组
 * @className AdminService
 * @date 2023/3/20/9:21
 **/
public interface AdminService {
    /**
     * @param admin
     * @return
     */
    public Admin login(Admin admin);

    /**
     * @param card
     * @param points
     * @return
     */

    public Boolean addPoints(String card, int points);

    /**
     * @return
     */

    public List<VipCard> allVip();

    /**
     * 根据卡号查询积分
     *
     * @param card
     * @return
     */
    public int selectPoints(String card);

}
