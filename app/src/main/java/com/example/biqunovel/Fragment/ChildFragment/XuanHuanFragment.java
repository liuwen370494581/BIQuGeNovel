package com.example.biqunovel.Fragment.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biqunovel.Action.DiscoverAction;
import com.example.biqunovel.Base.BaseFragment;
import com.example.biqunovel.Config.Config;
import com.example.biqunovel.Model.BookModel;
import com.example.biqunovel.R;
import com.example.biqunovel.Utils.PromptDialogUtils;
import com.example.biqunovel.View.BookTypeView;
import com.example.biqunovel.View.promptlibrary.PromptDialog;
import com.example.biqunovel.listener.ActionCallBack;

import java.util.List;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/10 15:24
 * desc   : 玄幻奇幻
 */
public class XuanHuanFragment extends BaseFragment {


    private BookTypeView mBookTypeView;

    @Override
    public void initData() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_xuan_huan, container, false);
        initView(view);
        init();
        setListener();
        return view;
    }


    private void init() {
        DiscoverAction.searchMainNewList(getFragmentContext(), String.format(Config.B_TYPE_URL, "1"), new ActionCallBack() {
            @Override
            public void ok(Object object) {
                List<BookModel> temList = (List<BookModel>) object;
                mBookTypeView.setDateNewList(temList);
            }

            @Override
            public void failed(Object object) {
            }
        });

        DiscoverAction.searchMainRankList(getFragmentContext(), String.format(Config.B_TYPE_URL, "1"), new ActionCallBack() {
            @Override
            public void ok(Object object) {
                List<BookModel> temList = (List<BookModel>) object;
                mBookTypeView.setDateRankList(temList);
            }

            @Override
            public void failed(Object object) {
            }
        });

        DiscoverAction.searchMainData(getFragmentContext(), String.format(Config.B_TYPE_URL, "1"), new ActionCallBack() {
            @Override
            public void ok(Object object) {
                List<BookModel> temList = (List<BookModel>) object;
                mBookTypeView.setDateCoverList(temList);
            }

            @Override
            public void failed(Object object) {
            }
        });
    }


    public void setListener() {


    }

    private void initView(View view) {
        mBookTypeView = (BookTypeView) view.findViewById(R.id.id_book_type_view);
    }
}
