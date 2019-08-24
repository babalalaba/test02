package com.newer.homework0812.service;

import com.newer.homework0812.domain.Departs;
import com.newer.homework0812.mapper.DepartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartService {
    @Autowired
    private DepartMapper departMapper;

    public List<Departs> findAll(){
        return departMapper.findAll();
    }
}
