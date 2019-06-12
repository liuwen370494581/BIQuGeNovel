package com.example.biqunovel.MultityTypeAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/12 16:36
 * desc   :
 */
public interface OnItemClickListener<T> {

    void onItemClick(View view, RecyclerView.ViewHolder holder, T t, int position);

    boolean onItemLongClick(View view,  RecyclerView.ViewHolder holder,T t,  int position);
}
