package com.example.biqunovel.listener;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/04 11:36
 * desc   : 设计模式之单一职责模式  一个接口负责一个功能的实现
 */
public interface OnCommItemListener {

    void onItemAClick(Object object);

    void onItemBClick(Object object);

    void onTotalClick();

    void onMonthClick();

    void onWeekClick();

    void onRetryClick();


}
