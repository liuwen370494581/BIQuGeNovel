package com.example.biqunovel.Adapter;

import android.support.annotation.NonNull;

import com.example.biqunovel.Model.BookModel;
import com.example.biqunovel.MultityTypeAdapter.MultiItemView;
import com.example.biqunovel.MultityTypeAdapter.ViewHolder;
import com.example.biqunovel.R;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/12 17:30
 * desc   :
 */
public class ItemViewA extends MultiItemView<BookModel> {
    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.item_view_a;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BookModel item, int position) {

    }
}
