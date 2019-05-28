package com.example.biqunovel.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.biqunovel.Action.DiscoverAction;
import com.example.biqunovel.Base.BaseFragment;
import com.example.biqunovel.Model.RankModel;
import com.example.biqunovel.R;
import com.example.biqunovel.View.RankLayout;
import com.example.biqunovel.listener.ActionCallBack;

import java.util.List;


/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/11/12 15:20
 * desc   :
 */

public class BookCityFragment extends BaseFragment {


    private RankLayout mRankLayout;

    @Override
    public void initData() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_city, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        ((TextView) view.findViewById(R.id.title)).setText("发现");
        mRankLayout = (RankLayout) view.findViewById(R.id.id_rank_layout);
        loadDate();

    }

    private void loadDate() {
        DiscoverAction.searchCoverData(getActivity(), "https://www.biquge.tw/nweph.html", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                List<RankModel> temList = (List<RankModel>) object;
                mRankLayout.updateRankDate(temList);
            }

            @Override
            public void failed(Object object) {

            }
        });
    }


}
