package com.example.biqunovel.Fragment.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biqunovel.Base.BaseFragment;
import com.example.biqunovel.R;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/10 15:26
 * desc   :
 */
public class KeHuanFragment extends BaseFragment {
    @Override
    public void initData() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ke_huan, container, false);
        init();
        initView(view);
        setListener();
        return view;
    }



    private void init() {
    }

    public void setListener() {

    }

    private void initView(View view) {
    }
}
