package com.example.biqunovel.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.biqunovel.Adapter.BookTypeAdapter;
import com.example.biqunovel.Model.BookModel;
import com.example.biqunovel.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/13 15:09
 * desc   :
 */
public class BookTypeView extends FrameLayout {


    private RecyclerView mRecyclerView;
    private Context mContext;
    private BookTypeAdapter mAdapter;
    private List<BookModel> coverList = new ArrayList<>();
    private List<BookModel> rankList = new ArrayList<>();
    private List<BookModel> newList = new ArrayList<>();

    public BookTypeView(@NonNull Context context) {
        super(context);
        init(context);
    }


    public BookTypeView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        View layoutView = LayoutInflater.from(context).inflate(R.layout.layout_book_type_view, null);
        addView(layoutView);
        mRecyclerView = findViewById(R.id.layout_book_type_recycler_view);
        mAdapter = new BookTypeAdapter(mContext, coverList, rankList, newList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);
    }


    //====================================公共方法==============================================
    public void setDateCoverList(List<BookModel> list) {
        mAdapter.updateCoverList(list);
    }

    public void setDateRankList(List<BookModel> list) {
        mAdapter.updateRankList(list);
    }

    public void setDateNewList(List<BookModel> list) {
        mAdapter.updateNewList(list);
    }

}
