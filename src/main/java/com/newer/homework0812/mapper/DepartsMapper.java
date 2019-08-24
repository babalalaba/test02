package com.newer.homework0812.mapper;

import com.newer.homework0812.domain.Departs;
import org.apache.ibatis.annotations.*;

import java.util.List;

@CacheNamespace(implementation = com.newer.homework0812.config.RedisCache.class)
public interface DepartsMapper {
    @Select("select * from departs")
    public List<Departs> findAll();
    @Select("select * from departs where deid=#{deid}")
    public Departs findAllById(int deid);
    @Update("update departs set dename=#{dename},intro=#{intro},deexist=#{deexist},by1=#{by1} where deid=#{deid}")
    public int updDep(Departs d);
    @Insert("insert into departs(deid,dename,intro,deexist,by1,by2) value(#{deid},#{dename},#{intro},#{deexist},#{by1},#{by2})")
    public int addDep(Departs d);
    @Delete("delete from departs where deid=#{deid}")
    public int delDep(int deid);
}
