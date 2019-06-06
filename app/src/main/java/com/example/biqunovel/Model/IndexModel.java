package com.example.biqunovel.Model;

import java.io.Serializable;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/05/28 14:22
 * desc   :
 */
public class IndexModel implements Serializable {

    private int index;
    private String bookType;
    private String bookTypeDes;

    public IndexModel() {
    }

    public IndexModel(int index, String bookType) {
        this.index = index;
        this.bookType = bookType;
    }

    public IndexModel(int index, String bookType, String bookTypeDes) {
        this.index = index;
        this.bookType = bookType;
        this.bookTypeDes = bookTypeDes;
    }

    public String getBookTypeDes() {
        return bookTypeDes;
    }

    public void setBookTypeDes(String bookTypeDes) {
        this.bookTypeDes = bookTypeDes;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}
