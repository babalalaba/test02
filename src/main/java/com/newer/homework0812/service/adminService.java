package com.newer.homework0812.service;

import com.newer.homework0812.domain.admins;
import com.newer.homework0812.domain.cards;


import java.util.Date;
import java.util.List;

public interface adminService {
    /**
     * 根据用户名和密码查找用户
     * @param aname
     * @param pwd
     * @return
     */
    public admins getAdmins(String aname, String pwd);

    /**
     *
     * @param login_time
     * @param aname
     * @return
     */
    public int updAdmins(Date login_time,String aname);

    public List<cards> selectCards();

    public int updCard(cards c);

    public int addCard(cards c);

    public cards selectByCid(int cid);

    public admins selectByAid(int aid);

    public int updAdmin(admins a);
}
