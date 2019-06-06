package com.example.biqunovel.Model;

import java.io.Serializable;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/05/28 11:42
 * desc   :
 */
public class RankModel implements Serializable {

    private long id;
    private String bookRankNum;
    private String bookName;
    private String bookUrl;
    private String bookImgUrl;
    private String bookDate;
    private String type;





    public RankModel(long id, String bookRankNum, String bookName, String bookUrl, String bookImgUrl, String bookDate, String type) {
        this.id = id;
        this.bookRankNum = bookRankNum;
        this.bookName = bookName;
        this.bookUrl = bookUrl;
        this.bookImgUrl = bookImgUrl;
        this.bookDate = bookDate;
        this.type = type;
    }

    public String getBookRankNum() {
        return bookRankNum;
    }

    public void setBookRankNum(String bookRankNum) {
        this.bookRankNum = bookRankNum;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public RankModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getBookImgUrl() {
        return bookImgUrl;
    }

    public void setBookImgUrl(String bookImgUrl) {
        this.bookImgUrl = bookImgUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
