package com.example.biqunovel.Model;

import java.io.Serializable;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/06 17:42
 * desc   :
 */
public class BookModel implements Serializable {


    private long id;
    private String  bookUrl;
    private String bookImg;
    private String bookAuthor;
    private String bookName;
    private String booKDesc;

    public BookModel() {
    }

    public BookModel(long id, String bookUrl, String bookImg, String bookAuthor, String bookName) {
        this.id = id;
        this.bookUrl = bookUrl;
        this.bookImg = bookImg;
        this.bookAuthor = bookAuthor;
        this.bookName = bookName;
    }

    public String getBooKDesc() {
        return booKDesc;
    }

    public void setBooKDesc(String booKDesc) {
        this.booKDesc = booKDesc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
