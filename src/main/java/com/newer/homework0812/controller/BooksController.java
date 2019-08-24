package com.newer.homework0812.controller;

import com.newer.homework0812.domain.BookDeparts;
import com.newer.homework0812.domain.BookDepartsCount;
import com.newer.homework0812.domain.Departs;
import com.newer.homework0812.service.BooksService;
import com.newer.homework0812.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BooksController {
    @Autowired
    private DepartService departService;
    @Autowired
    private BooksService booksService;

    @GetMapping("/drawTable")
    public ResponseEntity<?> drawTable(){
        List<String> timesList=new ArrayList<>();
        List<BookDeparts> bookDepartsList=new ArrayList<>();
        timesList.add("今天");
        timesList.add("昨天");
        timesList.add("本周");
        timesList.add("本月");
        timesList.add("本季度");
        List<Departs> Departslist=departService.findAll();
        for (Departs departs:Departslist){
            String dename=departs.getDename();
            int today=booksService.getToday(departs.getDeid());
            int Yesterday=booksService.getYesterday(departs.getDeid());
            int week=booksService.getWeek(departs.getDeid());
            int month=booksService.getMonth(departs.getDeid());
            int quarter=booksService.getQuarter(departs.getDeid());
            List<Integer> countList=new ArrayList<>();
            countList.add(today);
            countList.add(Yesterday);
            countList.add(week);
            countList.add(month);
            countList.add(quarter);
            bookDepartsList.add(new BookDeparts(dename,countList));
        }
        return new ResponseEntity<>(new BookDepartsCount(timesList,bookDepartsList),HttpStatus.OK);
    }
    @GetMapping("/darwPic")
    public ResponseEntity<?> darwPic(){
        List<Map<String,Object>> list=new ArrayList<>();
        List<Departs> departsList=departService.findAll();
        for (Departs departs:departsList){
            Map<String,Object> map=new HashMap<>();
            map.put("name",departs.getDename());
            map.put("y",booksService.getQuarter(departs.getDeid()));
            map.put("drilldown",departs.getDename());
            list.add(map);
        }
        return  new ResponseEntity<>(list,HttpStatus.OK);
    }
}
