package com.newer.homework0812.domain;

import java.io.Serializable;
import java.util.List;

public class BookDeparts implements Serializable {
    private static final long serialVersionUID = 676005925299677554L;
    private String dname;//科室名称
    private  List<Integer> countList;

    public BookDeparts() {
    }

    public BookDeparts(String dname, List<Integer> countList) {

        this.dname = dname;
        this.countList = countList;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Integer> getCountList() {
        return countList;
    }

    public void setCountList(List<Integer> countList) {
        this.countList = countList;
    }

    @Override
    public String toString() {
        return "BookDeparts{" +
                "dname='" + dname + '\'' +
                ", countList=" + countList +
                '}';
    }
}
