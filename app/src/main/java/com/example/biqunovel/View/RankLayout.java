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

import com.example.biqunovel.Action.DiscoverAction;
import com.example.biqunovel.Model.IndexModel;
import com.example.biqunovel.Model.RankModel;
import com.example.biqunovel.R;

import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGADivider;
import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/05/28 14:10
 * desc   :
 */
public class RankLayout extends FrameLayout {

    private Context mContext;
    private RecyclerView mLeftRecyclerView;
    private RecyclerView mRightRecyclerView;
    private RankAAdapter mAdapterA;
    private RankBAdapter mAdapterB;


    public RankLayout(@NonNull Context context) {
        super(context);
        init(context);
    }

    public RankLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_rank, null);
        addView(view);
        mLeftRecyclerView = (RecyclerView) findViewById(R.id.id_left_recycler_view);
        mRightRecyclerView = (RecyclerView) findViewById(R.id.id_right_recycler_view);
        LinearLayoutManager linearLayoutManagerA = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager linearLayoutManagerB = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        mRightRecyclerView.setLayoutManager(linearLayoutManagerA);
        mLeftRecyclerView.setLayoutManager(linearLayoutManagerB);
        mRightRecyclerView.addItemDecoration(BGADivider.newShapeDivider());
        mLeftRecyclerView.addItemDecoration(BGADivider.newShapeDivider());
        mAdapterA = new RankAAdapter(mLeftRecyclerView);
        mAdapterB = new RankBAdapter(mRightRecyclerView);
        mAdapterA.setData(DiscoverAction.getIndexModel());
        mLeftRecyclerView.setAdapter(mAdapterA);
        mRightRecyclerView.setAdapter(mAdapterB);
    }

    public void updateRankDate(List<RankModel> list) {
        mAdapterB.setData(list);
    }


    private static class RankAAdapter extends BGARecyclerViewAdapter<IndexModel> {


        public RankAAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_rank_a);
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, IndexModel model) {
            helper.getTextView(R.id.id_book_type).setText(model.getBookType());
        }
    }

    private static class RankBAdapter extends BGARecyclerViewAdapter<RankModel> {


        public RankBAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_rank_b);
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, RankModel model) {
            helper.getTextView(R.id.id_book_name).setText(model.getBookName());
            helper.getTextView(R.id.id_mum).setText(model.getBookRankNum());
            helper.getTextView(R.id.id_book_date).setText(model.getBookDate());
        }
    }


}
