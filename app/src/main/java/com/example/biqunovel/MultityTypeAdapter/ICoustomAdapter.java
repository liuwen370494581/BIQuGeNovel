package com.example.biqunovel.MultityTypeAdapter;

import android.support.v7.widget.RecyclerView;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/12 16:36
 * desc   :
 */
public interface ICoustomAdapter {

    void onViewAttachedToWindow(RecyclerView.ViewHolder holder, int postion);
}
