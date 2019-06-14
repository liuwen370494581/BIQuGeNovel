package com.example.biqunovel.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.biqunovel.Model.BookModel;
import com.example.biqunovel.R;
import com.hejunlin.superindicatorlibray.CircleIndicator;
import com.hejunlin.superindicatorlibray.LoopViewPager;

import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/13 16:37
 * desc   :
 */
public class BookTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int BANNER_VIEW_TYPE = 0;
    private final static int RANK_VIEW_TYPE = 1;
    private final static int NEW_LIST_VIEW_TYPE = 2;
    private final static int END_VIEW_TYPE = 3;
    private Context mContext;

    private List<BookModel> coverModelList;
    private List<BookModel> rankModelList;
    private List<BookModel> newModelList;

    public BookTypeAdapter(Context mContext, List<BookModel> coverModelList, List<BookModel> rankModelList, List<BookModel> newModelList) {
        this.mContext = mContext;
        this.coverModelList = coverModelList;
        this.rankModelList = rankModelList;
        this.newModelList = newModelList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER_VIEW_TYPE;
        } else if (position == 1) {
            return RANK_VIEW_TYPE;
        } else if (position == 2) {
            return NEW_LIST_VIEW_TYPE;
        } else {
            return END_VIEW_TYPE;
        }
    }

    public void updateCoverList(List<BookModel> list) {
        if (isListNotEmpty(list)) {
            this.coverModelList = list;
        } else {
            coverModelList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateRankList(List<BookModel> list) {
        if (isListNotEmpty(list)) {
            this.rankModelList = list;
        } else {
            rankModelList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateNewList(List<BookModel> list) {
        if (isListNotEmpty(list)) {
            this.newModelList = list;
        } else {
            newModelList.clear();
        }
        notifyDataSetChanged();
    }


    private static boolean isListNotEmpty(List list) {
        return list != null && !list.isEmpty();
    }

    private View getView(int view) {
        View view1 = View.inflate(mContext, view, null);
        return view1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        if (viewType == BANNER_VIEW_TYPE) {
            view = getView(R.layout.head_banner);
            BannerHolder holder = new BannerHolder(view);
            return holder;
        } else if (viewType == RANK_VIEW_TYPE) {
            view = getView(R.layout.layout_new_list);
            return new RankHolder(view);
        } else if (viewType == NEW_LIST_VIEW_TYPE) {
            view = getView(R.layout.layout_new_list);
            return new NewListHolder(view);
        } else {
            view = getView(R.layout.layout_end_list);
            return new EndHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof BannerHolder) {
            BannerHolder bannerHolder = (BannerHolder) viewHolder;
            setBanner(mContext, bannerHolder);
        } else if (viewHolder instanceof RankHolder) {
            RankHolder rankHolder = (RankHolder) viewHolder;
            CommAdapter mAdapter = new CommAdapter(rankHolder.mRecyclerView, R.layout.item_view_b);
            mAdapter.setData(rankModelList);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            rankHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            rankHolder.mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(3, 6, true));
            rankHolder.mRecyclerView.setAdapter(mAdapter);
            if (rankModelList.size() > 0) {
                rankHolder.ReHead.setVisibility(View.VISIBLE);
                rankHolder.tvType.setText("玄幻奇幻点击榜");
            }
        } else if (viewHolder instanceof NewListHolder) {
            NewListHolder newListHolder = (NewListHolder) viewHolder;
            CommAdapter commAdapter = new CommAdapter(newListHolder.mRecyclerView, R.layout.item_view_a);
            commAdapter.setData(newModelList);
            newListHolder.mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            newListHolder.mRecyclerView.setAdapter(commAdapter);
            if (newModelList.size() > 0) {
                newListHolder.ReHead.setVisibility(View.VISIBLE);
                newListHolder.tvType.setText("玄幻奇幻最新更新列表");
            }
        } else if (viewHolder instanceof EndHolder) {

        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    private void setBanner(Context context, BannerHolder channelHolder) {
        BannerAdapter mBannerAdapter = new BannerAdapter(context, coverModelList);
        channelHolder.viewpager.setAdapter(mBannerAdapter);
        channelHolder.viewpager.setLooperPic(true);
        channelHolder.indicator.setViewPager(channelHolder.viewpager);
    }

    private static class CommAdapter extends BGARecyclerViewAdapter<BookModel> {

        public CommAdapter(RecyclerView recyclerView, int defaultItemLayoutId) {
            super(recyclerView, defaultItemLayoutId);
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, BookModel model) {
            if (model.getBookNewChapters() != null) {
                helper.setText(R.id.id_booK_new_chapter, model.getBookNewChapters());
            }

            if (model.getBookUpdateDate() != null) {
                helper.setText(R.id.id_book_date, model.getBookUpdateDate());
            }
//            if (model.getBookType() != null) {
//                helper.setText(R.id.id_book_type, model.getBookType());
//            }
            if (model.getBookName() != null) {
                helper.setText(R.id.id_book_name, model.getBookName());
            }
            if (model.getBookAuthor() != null) {
                helper.setText(R.id.id_book_author, model.getBookAuthor());
            }

        }
    }


    public static class BannerHolder extends RecyclerView.ViewHolder {
        LoopViewPager viewpager; //头部banner
        CircleIndicator indicator;//头部banner

        public BannerHolder(View itemView) {
            super(itemView);
            viewpager = (LoopViewPager) itemView.findViewById(R.id.viewpager);
            indicator = (CircleIndicator) itemView.findViewById(R.id.indicator);
        }
    }


    public static class RankHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;


        public RankHolder(@NonNull View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);

        }

    }

    public static class NewListHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public NewListHolder(@NonNull View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class EndHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private LinearLayout lyItem;

        public EndHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_name);
            lyItem = (LinearLayout) itemView.findViewById(R.id.id_item_layout);
        }
    }
}
