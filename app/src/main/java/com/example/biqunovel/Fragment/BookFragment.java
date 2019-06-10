package com.example.biqunovel.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.biqunovel.Action.DiscoverAction;
import com.example.biqunovel.Base.BaseFragment;
import com.example.biqunovel.EventBus.BindEventBus;
import com.example.biqunovel.Model.RankModel;
import com.example.biqunovel.R;
import com.example.biqunovel.Utils.PromptDialogUtils;
import com.example.biqunovel.Utils.ToastUtils;
import com.example.biqunovel.listener.ActionCallBack;

import java.util.List;


/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/11/12 15:20
 * desc   : 书架
 */
public class BookFragment extends BaseFragment {
    private Button btn;


    @Override
    public void initData() {
        loadDate();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        btn = view.findViewById(R.id.id_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiscoverAction.searchMainData(getFragmentContext(), "https://www.biquge.tw", new ActionCallBack() {
                    @Override
                    public void ok(Object object) {

                    }

                    @Override
                    public void failed(Object object) {

                    }
                });
            }
        });

    }

    private void loadDate() {


    }


}
