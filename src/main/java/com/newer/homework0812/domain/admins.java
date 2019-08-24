package com.newer.homework0812.domain;
/**
 * 实体类，登录用户表
 */

import java.io.Serializable;
import java.util.Date;

public class admins implements Serializable {
    private static final long serialVersionUID = -6708364227073361006L;
    private Integer aid;//编号
    private String aname;//用户名
    private String pwd;//密码
    private Integer state;//状态
    private String email;//邮箱
    private Date LASTPASSWORDRESETDATE ;//登录时间
    private Integer aexist;//是否停用
    private Date login_time;//登录时间
    private Integer doid;//医生外键
    private String by1;//备用1
    private  Integer by2;//备用2

    public admins(Integer aid, String aname, String pwd, Integer state, String email, Date LASTPASSWORDRESETDATE, Integer aexist, Date login_time, Integer doid, String by1, Integer by2) {
        this.aid = aid;
        this.aname = aname;
        this.pwd = pwd;
        this.state = state;
        this.email = email;
        this.LASTPASSWORDRESETDATE = LASTPASSWORDRESETDATE;
        this.aexist = aexist;
        this.login_time = login_time;
        this.doid = doid;
        this.by1 = by1;
        this.by2 = by2;
    }

    public admins() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLASTPASSWORDRESETDATE() {
        return LASTPASSWORDRESETDATE;
    }

    public void setLASTPASSWORDRESETDATE(Date LASTPASSWORDRESETDATE) {
        this.LASTPASSWORDRESETDATE = LASTPASSWORDRESETDATE;
    }

    public Integer getAexist() {
        return aexist;
    }

    public void setAexist(Integer aexist) {
        this.aexist = aexist;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public Integer getDoid() {
        return doid;
    }

    public void setDoid(Integer doid) {
        this.doid = doid;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }

    public Integer getBy2() {
        return by2;
    }

    public void setBy2(Integer by2) {
        this.by2 = by2;
    }

    @Override
    public String toString() {
        return "admins{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", state=" + state +
                ", email='" + email + '\'' +
                ", LASTPASSWORDRESETDATE=" + LASTPASSWORDRESETDATE +
                ", aexist=" + aexist +
                ", login_time=" + login_time +
                ", doid=" + doid +
                ", by1='" + by1 + '\'' +
                ", by2=" + by2 +
                '}';
    }
}
