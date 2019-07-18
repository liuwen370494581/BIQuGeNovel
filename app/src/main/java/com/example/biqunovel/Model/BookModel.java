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
    private String bookUrl;
    private String bookImg;
    private String bookAuthor;
    private String bookName;
    private String booKDesc;
    private String bookType;
    private String bookNewChaptersUrl;
    private String bookNewChapters;
    private String bookUpdateDate;
    private String type;

    public BookModel() {
    }

    public BookModel(long id, String bookUrl, String bookImg, String bookAuthor, String bookName) {
        this.id = id;
        this.bookUrl = bookUrl;
        this.bookImg = bookImg;
        this.bookAuthor = bookAuthor;
        this.bookName = bookName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBookUpdateDate() {
        return bookUpdateDate;
    }

    public void setBookUpdateDate(String bookUpdateDate) {
        this.bookUpdateDate = bookUpdateDate;
    }

    public String getBookNewChapters() {
        return bookNewChapters;
    }

    public void setBookNewChapters(String bookNewChapters) {
        this.bookNewChapters = bookNewChapters;
    }

    public String getBookType() {
        return bookType;
    }

    public String getBookNewChaptersUrl() {
        return bookNewChaptersUrl;
    }

    public void setBookNewChaptersUrl(String bookNewChapters) {
        this.bookNewChaptersUrl = bookNewChapters;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
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
