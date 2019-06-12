package com.example.biqunovel.MultityTypeAdapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/12 16:34
 * desc   :
 */
public abstract class MultiItemView<T> {

    private final List<MultiItemView<T>> list;

    public MultiItemView() {
        list = new ArrayList<>();
    }

    @NonNull
    public abstract @LayoutRes
    int getLayoutId();

    public abstract void onBindViewHolder(@NonNull ViewHolder holder, @NonNull T item, int position);

    public boolean isForViewType(T item, int postion) {
        return true;
    }

    public MultiItemView<T> addChildeItemView(MultiItemView<T> multiItemView) {
        list.add(multiItemView);
        return this;
    }

    public boolean haveChild() {
        if (list.isEmpty())
            return false;
        else
            return true;
    }

    public List<MultiItemView<T>> getChildList() {
        return list;
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder){}

    public int getMaxRecycleCount(){
        return 5;
    }
}
