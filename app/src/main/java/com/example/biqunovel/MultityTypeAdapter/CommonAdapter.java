package com.example.biqunovel.MultityTypeAdapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/12 16:44
 * desc   :
 */
public abstract class CommonAdapter<T> extends MultiTypeAdapter {
    Context mContext;
    @LayoutRes
    int layoutId;


    public CommonAdapter(Context context, Class<? extends T> clazz, @LayoutRes final int layoutId) {
        super();
        mContext = context;
        this.layoutId = layoutId;
        register(clazz, new MultiItemView<T>() {

            @NonNull
            @Override
            public int getLayoutId() {
                return layoutId;
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull T item, int position) {
                convert(holder, item, position);
            }
        });
    }

    public CommonAdapter(Context context, Class<? extends T> clazz, @LayoutRes final int layoutId,final int maxRecyclerCount) {
        super();
        mContext = context;
        this.layoutId = layoutId;
        register(clazz, new MultiItemView<T>() {

            @NonNull
            @Override
            public int getLayoutId() {
                return layoutId;
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull T item, int position) {
                convert(holder, item, position);
            }

            @Override
            public int getMaxRecycleCount() {
                return maxRecyclerCount;
            }
        });
    }
    protected abstract void convert(ViewHolder holder, T t, int position);
}
