package com.example.biqunovel.MultityTypeAdapter.Sticky;

import android.support.v7.widget.RecyclerView;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/12 16:54
 * desc   :
 */
public interface StickyHeaderAdapter<T extends RecyclerView.ViewHolder> {


    boolean isHeader(int position);
}
