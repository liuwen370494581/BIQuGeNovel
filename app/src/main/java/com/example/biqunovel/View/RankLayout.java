package com.example.biqunovel.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.biqunovel.Action.DiscoverAction;
import com.example.biqunovel.Model.IndexModel;
import com.example.biqunovel.Model.RankModel;
import com.example.biqunovel.R;
import com.example.biqunovel.listener.OnCommItemListener;

import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGADivider;
import cn.bingoogolapple.androidcommon.adapter.BGAOnRVItemClickListener;
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
    private LinearLayout mLayout;
    private RankBAdapter mAdapterB;
    private OnCommItemListener mListener;
    private TextView tvTotal, tvMonth, tvWeek;


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
        mLayout = (LinearLayout) findViewById(R.id.id_right_layout);
        tvTotal = findViewById(R.id.id_total);
        tvMonth = findViewById(R.id.id_month);
        tvWeek = findViewById(R.id.id_week);

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
        setListener();
    }

    private void setListener() {
        mAdapterA.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
            @Override
            public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                mListener.onItemClick(mAdapterA.getData().get(position));
            }
        });

        tvWeek.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onWeekClick();
            }
        });

        tvMonth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onMonthClick();
            }
        });

        tvTotal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onTotalClick();
            }
        });
    }


    private static class RankAAdapter extends BGARecyclerViewAdapter<IndexModel> {

        private RankAAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_rank_a);
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, IndexModel model) {
            helper.getTextView(R.id.id_book_type).setText(model.getBookType());
        }
    }

    private static class RankBAdapter extends BGARecyclerViewAdapter<RankModel> {

        private RankBAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_rank_b);
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, RankModel model) {
            helper.getTextView(R.id.id_book_name).setText(model.getBookName());
            helper.getTextView(R.id.id_mum).setText(model.getBookRankNum());
            helper.getTextView(R.id.id_book_date).setText(model.getBookDate());
        }
    }


    //===============================公共方法===============================
    public void setRightVisible() {
        mLayout.setVisibility(VISIBLE);
    }

    public void updateRankDate(List<RankModel> list) {
        mAdapterB.setData(list);
    }

    public void setListener(OnCommItemListener listener) {
        this.mListener = listener;
    }

}


