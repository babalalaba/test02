package com.newer.homework0812.domain;

import java.io.Serializable;
import java.util.List;

public class BookDepartsCount implements Serializable {
    private static final long serialVersionUID = 3044910500267549762L;
    private List<String> times;
    private List<BookDeparts> bookDepartsList;

    public BookDepartsCount() {
    }

    public BookDepartsCount(List<String> times, List<BookDeparts> bookDepartsList) {
        this.times = times;
        this.bookDepartsList = bookDepartsList;
    }

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    public List<BookDeparts> getBookDepartsList() {
        return bookDepartsList;
    }

    public void setBookDepartsList(List<BookDeparts> bookDepartsList) {
        this.bookDepartsList = bookDepartsList;
    }

    @Override
    public String toString() {
        return "BookDepartsCount{" +
                "times=" + times +
                ", bookDepartsList=" + bookDepartsList +
                '}';
    }
}
