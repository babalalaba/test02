package com.newer.homework0812;

import com.newer.homework0812.domain.Departs;
import com.newer.homework0812.mapper.DepartsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private DepartsMapper departsMapper;
    @Test
    public void contextLoads() {
    }
    @Test
    public void findAll(){
        List<Departs> list=departsMapper.findAll();
        System.out.println(list.toString());
    }
    @Test
    public void updDep(){
        Departs departs=departsMapper.findAllById(1);
        departs.setDename("一级内科");
        int count=departsMapper.updDep(departs);
        System.out.println("更新："+count);
    }
    @Test
    public void addDep(){
        Departs departs=new Departs(9,"心脏科","长沙一绝",1,null,null);
        int count=departsMapper.addDep(departs);
        System.out.println("增加："+count);
    }
    @Test
    public void delDep(){
        int count =departsMapper.delDep(9);
        System.out.println("删除："+count);
    }
}
