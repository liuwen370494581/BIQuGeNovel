package com.example.biqunovel.MultityTypeAdapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ViewGroup;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/12 16:38
 * desc   :
 */
public class WrapperUtils {


    public interface SpanSizeCallback
    {
        int getSpanSize(GridLayoutManager layoutManager , GridLayoutManager.SpanSizeLookup oldLookup, int position);
    }

    public static void onAttachedToRecyclerView(RecyclerView.Adapter innerAdapter, RecyclerView recyclerView, final SpanSizeCallback callback)
    {
        innerAdapter.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager)
        {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();

            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup()
            {
                @Override
                public int getSpanSize(int position)
                {
                    return callback.getSpanSize(gridLayoutManager, spanSizeLookup, position);
                }
            });
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    public static void setFullSpan(RecyclerView.ViewHolder holder)
    {
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();

        if (lp != null
                && lp instanceof StaggeredGridLayoutManager.LayoutParams)
        {

            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;

            p.setFullSpan(true);
        }
    }
}
