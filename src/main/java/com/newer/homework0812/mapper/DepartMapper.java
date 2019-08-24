package com.newer.homework0812.mapper;

import com.newer.homework0812.domain.Departs;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepartMapper {
    @Select("select deid,dename,deexist from departs")
    public List<Departs> findAll();
}
