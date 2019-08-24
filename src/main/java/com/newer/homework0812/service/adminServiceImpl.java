package com.newer.homework0812.service;


import com.newer.homework0812.domain.admins;
import com.newer.homework0812.domain.cards;
import com.newer.homework0812.mapper.adminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class adminServiceImpl implements adminService{
   @Autowired
    private adminMapper am;
    @Override
    public admins getAdmins(String aname, String pwd) {
        return am.getAdmins(aname,pwd);
    }

    @Override
    public int updAdmins(Date login_time, String aname) {
        return am.updAdmins(login_time,aname);
    }

    @Override
    public List<cards> selectCards() {
        return am.selectCards();
    }

    @Override
    public int updCard(cards c) {
        return am.updCard(c);
    }

    @Override
    public int addCard(cards c) {
        return  am.addCard(c);
    }

    @Override
    public cards selectByCid(int cid) {
        return am.selectByCid(cid);
    }

    @Override
    public admins selectByAid(int aid) {
        return am.selectByAid(aid);
    }

    @Override
    public int updAdmin(admins a) {
        return am.updAdmin(a);
    }
}
