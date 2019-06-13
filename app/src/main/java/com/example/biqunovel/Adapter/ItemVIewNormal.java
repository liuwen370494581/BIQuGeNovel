package com.example.biqunovel.Adapter;

import android.support.annotation.NonNull;
import android.widget.TextView;

import com.example.biqunovel.MultityTypeAdapter.MultiItemView;
import com.example.biqunovel.MultityTypeAdapter.ViewHolder;
import com.example.biqunovel.R;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/12 17:23
 * desc   :
 */
public class ItemVIewNormal extends MultiItemView<String> {

    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.item_view_string;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull String item, int position) {
        holder.setText(R.id.item_id_tv_type, item);
    }
}
