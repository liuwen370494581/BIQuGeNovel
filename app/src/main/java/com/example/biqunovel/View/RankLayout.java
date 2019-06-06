package com.example.biqunovel.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
    private RelativeLayout mLayout;
    private RankBAdapter mAdapterB;
    private OnCommItemListener mListener;
    private TextView tvTotal, tvMonth, tvWeek;
    private Button mBtnRetry;


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
        mLayout = (RelativeLayout) findViewById(R.id.id_right_layout);
        mBtnRetry = (Button) findViewById(R.id.id_btn_retry);
        tvTotal = findViewById(R.id.id_total);
        tvMonth = findViewById(R.id.id_month);
        tvWeek = findViewById(R.id.id_week);

        LinearLayoutManager linearLayoutManagerA = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager linearLayoutManagerB = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        mRightRecyclerView.setLayoutManager(linearLayoutManagerA);
        mLeftRecyclerView.setLayoutManager(linearLayoutManagerB);
        mAdapterA = new RankAAdapter(mLeftRecyclerView);
        mAdapterB = new RankBAdapter(mRightRecyclerView);
        mAdapterA.setData(DiscoverAction.setIndexModel());
        mLeftRecyclerView.setAdapter(mAdapterA);
        mRightRecyclerView.setAdapter(mAdapterB);
        setListener();
        setRankTextBgAndColor(1);
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
                setRankTextBgAndColor(3);
            }
        });

        tvMonth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onMonthClick();
                setRankTextBgAndColor(2);
            }
        });

        tvTotal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onTotalClick();
                setRankTextBgAndColor(1);
            }
        });

        mBtnRetry.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onRetryClick();
            }
        });
    }

    private void setRankTextBgAndColor(int position) {
        switch (position) {
            case 1:
                tvTotal.setTextColor(ContextCompat.getColor(mContext, R.color.white));
                tvTotal.setBackgroundResource(R.drawable.btn_rank_bg_blue);
                tvMonth.setBackgroundResource(R.drawable.btn_rank_bg);
                tvMonth.setTextColor(ContextCompat.getColor(mContext, R.color.text_color_33));
                tvWeek.setBackgroundResource(R.drawable.btn_rank_bg);
                tvWeek.setTextColor(ContextCompat.getColor(mContext, R.color.text_color_33));
                break;
            case 2:
                tvMonth.setTextColor(ContextCompat.getColor(mContext, R.color.white));
                tvMonth.setBackgroundResource(R.drawable.btn_rank_bg_blue);
                tvTotal.setBackgroundResource(R.drawable.btn_rank_bg);
                tvTotal.setTextColor(ContextCompat.getColor(mContext, R.color.text_color_33));
                tvWeek.setBackgroundResource(R.drawable.btn_rank_bg);
                tvWeek.setTextColor(ContextCompat.getColor(mContext, R.color.text_color_33));
                break;
            case 3:
                tvWeek.setTextColor(ContextCompat.getColor(mContext, R.color.white));
                tvWeek.setBackgroundResource(R.drawable.btn_rank_bg_blue);
                tvMonth.setBackgroundResource(R.drawable.btn_rank_bg);
                tvMonth.setTextColor(ContextCompat.getColor(mContext, R.color.text_color_33));
                tvTotal.setBackgroundResource(R.drawable.btn_rank_bg);
                tvTotal.setTextColor(ContextCompat.getColor(mContext, R.color.text_color_33));
                break;
        }
    }


    private static class RankAAdapter extends BGARecyclerViewAdapter<IndexModel> {

        private int mPosition = 1;

        private RankAAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_rank_a);
        }

        public void setIndexSelect(int index) {
            this.mPosition = index;
            notifyDataSetChanged();
        }

        public int getmPosition() {
            return mPosition;
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, IndexModel model) {
            helper.getTextView(R.id.id_book_type).setText(model.getBookType());
            if (model.getIndex() == mPosition) {
                helper.getView(R.id.id_liner_layout).setBackgroundResource(R.drawable.btn_rank_bg_blue);
                helper.getTextView(R.id.id_book_type).setTextColor(ContextCompat.getColor(mContext, R.color.white));
            } else {
                helper.getView(R.id.id_liner_layout).setBackgroundResource(R.drawable.btn_rank_bg);
                helper.getTextView(R.id.id_book_type).setTextColor(ContextCompat.getColor(mContext, R.color.text_color_33));
            }
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


    //===============================公共方法===============================//
    public void setRightVisible(boolean flag) {
        mLayout.setVisibility(flag ? VISIBLE : GONE);
    }

    public void setBtnRetryVisible(boolean flag) {
        mBtnRetry.setVisibility(flag ? VISIBLE : GONE);
    }

    public void updateRankDate(List<RankModel> list) {
        mAdapterB.setData(list);
    }

    public void setIndexSelect(int index) {
        mAdapterA.setIndexSelect(index);
    }

    public int getIndexSelect() {
        return mAdapterA.getmPosition();
    }

    public void clearRankTextBgAndColor() {
        setRankTextBgAndColor(1);
    }

    public void setListener(OnCommItemListener listener) {
        this.mListener = listener;
    }


}


