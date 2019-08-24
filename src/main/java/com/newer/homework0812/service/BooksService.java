package com.newer.homework0812.service;

import com.newer.homework0812.mapper.BooksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
    @Autowired
    private BooksMapper booksMapper;
    public int getToday(Integer deid){
        return booksMapper.getToday(deid);
    }
    public int getYesterday(Integer deid){
        return booksMapper.gatYesterday(deid);
    }
    public int getWeek(Integer deid){
        return booksMapper.getWeek(deid);
    }
    public int getMonth(Integer deid){
        return booksMapper.getMonth(deid);
    }
    public int getQuarter(Integer deid){
        return booksMapper.getQuarter(deid);
    }

}
