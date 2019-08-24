package com.newer.homework0812.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class cards implements Serializable {
    private static final long serialVersionUID = -4613394414011477625L;

    private int cid;
    private String pname;
    private String gender;
    private String phone;
    private String idcard;
    private String pwd;
    private double ramaining;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date newdate;
    private int doexist;

    public cards() {
    }

    public cards(int cid, String pname, String gender, String phone, String idcard, String pwd, double ramaining, Date newdate, int doexist) {
        this.cid = cid;
        this.pname = pname;
        this.gender = gender;
        this.phone = phone;
        this.idcard = idcard;
        this.pwd = pwd;
        this.ramaining = ramaining;
        this.newdate = newdate;
        this.doexist = doexist;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getRamaining() {
        return ramaining;
    }

    public void setRamaining(double ramaining) {
        this.ramaining = ramaining;
    }

    public Date getNewdate() {
        return newdate;
    }

    public void setNewdate(Date newdate) {
        this.newdate = newdate;
    }

    public int getDoexist() {
        return doexist;
    }

    public void setDoexist(int doexist) {
        this.doexist = doexist;
    }

    @Override
    public String toString() {
        return "cards{" +
                "cid=" + cid +
                ", pname='" + pname + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", idcard='" + idcard + '\'' +
                ", pwd='" + pwd + '\'' +
                ", ramaining=" + ramaining +
                ", newdate=" + newdate +
                ", doexist=" + doexist +
                '}';
    }
}
