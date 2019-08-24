package com.newer.homework0812.mapper;


import com.newer.homework0812.domain.admins;
import com.newer.homework0812.domain.cards;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface adminMapper {
    /**
     * 根据用户输入的用户名和密码查询用户表
     * @param aname
     * @param pwd
     * @return
     */
    @Select("select aid,aname,pwd from admins where aname=#{aname} and pwd=#{pwd}")
    public admins getAdmins(@Param("aname") String aname, @Param("pwd") String pwd);

    /**
     * 根据用户名修改登录时间
     * @param login_time
     * @param aname
     * @return
     */
    @Update("update admins set login_time=#{login_time} where aname=#{aname}")
    public  int updAdmins(@Param("login_time")Date login_time,
                            @Param("aname") String aname);

    @Select("select * from cards")
    public List<cards> selectCards();

    @Update("update cards set pname=#{pname},gender=#{gender},phone=#{phone},idcard=#{idcard},pwd=#{pwd},doexist=#{doexist},newdate=#{newdate} where cid=#{cid}")
    public int updCard(cards c);

    @Insert("insert into cards(pname,gender,phone,idcard,pwd,doexist,ramaining,newdate) value(#{pname},#{gender},#{phone},#{idcard},#{pwd},#{doexist},#{ramaining},#{newdate})")
    public int addCard(cards c);

    @Select("select * from cards where cid = #{cid}")
    public cards selectByCid(int cid);

    @Select("select * from admins where aid = #{aid}")
    public admins selectByAid(int aid);
    @Update("update admins set aname=#{aname},pwd=#{pwd},state=#{state},email=#{email},LASTPASSWORDRESETDATE=#{LASTPASSWORDRESETDATE},aexist=#{aexist},login_time=#{login_time},doid=#{doid},by1=#{by1},by2=#{by2} where aid=#{aid}")
    public int updAdmin(admins a);
}
