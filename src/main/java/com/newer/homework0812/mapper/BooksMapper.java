package com.newer.homework0812.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BooksMapper {
    @Select("select count(snum) from registration r,bookable b,doctors do,departs de where r.bid=b.bid and do.doid=b.doid and de.deid=do.deid and de.deid=#{deid} and to_days(bdate) = to_days(now())")
    public int getToday(@Param("deid") Integer deid);
    @Select("select count(snum) from registration r,bookable b,doctors do, departs de where r.bid=b.bid and do.doid=b.doid and de.deid=do.deid and de.deid=#{deid} and to_days(now()) - to_days(bdate) = 1")
    public int gatYesterday(@Param("deid") Integer deid);
    @Select("select count(snum) from registration r,bookable b,doctors do, departs de where r.bid=b.bid and do.doid=b.doid and de.deid=do.deid and de.deid=#{deid} and YEARWEEK(date_format(bdate,'%Y-%m-%d')) = YEARWEEK(now())")
    public int getWeek(@Param("deid") Integer deid);
    @Select("select count(snum) from registration r,bookable b,doctors do, departs de where r.bid=b.bid and do.doid=b.doid and de.deid=do.deid and de.deid=#{deid} and date_format(bdate,'%Y%m') = date_format(curdate(),'%Y%m')")
    public int getMonth(@Param("deid") Integer deid);
    @Select("select count(snum) from registration r,bookable b,doctors do, departs de where r.bid=b.bid and do.doid=b.doid and de.deid=do.deid and de.deid=#{deid} and QUARTER(bdate)=QUARTER(now())")
    public int getQuarter(@Param("deid") Integer deid);
}
