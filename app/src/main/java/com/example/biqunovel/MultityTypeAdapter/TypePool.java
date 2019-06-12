package com.example.biqunovel.MultityTypeAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/12 16:33
 * desc   :
 */
public class TypePool {


    private @NonNull
    final Map<Class<?>, CopyOnWriteArrayList<MultiItemView>> calss2ItemViewMap;
    final Map<Integer, MultiItemView> itemViewType2itemViewMap;
    final Map<MultiItemView, Integer> itemViewMap2itemViewType;
    final Map<Integer, Integer> itemViewType2RecyclerCount;

    public TypePool() {
        calss2ItemViewMap = new ConcurrentHashMap<>();
        itemViewType2itemViewMap = new ConcurrentHashMap<>();
        itemViewMap2itemViewType = new ConcurrentHashMap<>();
        itemViewType2RecyclerCount = new ConcurrentHashMap<>();
    }

    public <T> void register(@NonNull Class<? extends T> clazz, @NonNull MultiItemView<T> multiItemView) {
        CopyOnWriteArrayList<MultiItemView> list = calss2ItemViewMap.get(clazz);
        if (list == null) {
            list = new CopyOnWriteArrayList<>();
        }
        int size = itemViewType2itemViewMap.size();
        if (multiItemView.haveChild()) {
            list.addAll(multiItemView.getChildList());

            for (MultiItemView<T> tMultiItemView : multiItemView.getChildList()) {
                itemViewType2itemViewMap.put(size, tMultiItemView);
                itemViewMap2itemViewType.put(tMultiItemView, size);
                size++;
            }
        } else {
            list.add(multiItemView);
            itemViewType2itemViewMap.put(size, multiItemView);
            itemViewMap2itemViewType.put(multiItemView, size);
        }
        calss2ItemViewMap.put(clazz, list);
    }

    public <T> int getItemViewType(@NonNull T item,int position) {

        Class<?> clazz = item.getClass();
        CopyOnWriteArrayList<MultiItemView> list = calss2ItemViewMap.get(clazz);
        for (MultiItemView multiItemView : list) {
            if (multiItemView.isForViewType(item, position)) {
                return itemViewMap2itemViewType.get(multiItemView);
            }
        }
        return -1;
    }

    public MultiItemView getMultiItemView(int itemViewType) {
        return itemViewType2itemViewMap.get(itemViewType);
    }

    public void setMaxRecycledViews(ViewGroup recyclerView, int itemType) {
        if (!itemViewType2RecyclerCount.containsKey(itemType)) {
            MultiItemView multiItemView = itemViewType2itemViewMap.get(itemType);
            itemViewType2RecyclerCount.put(itemType, multiItemView.getMaxRecycleCount());
            ((RecyclerView) recyclerView).getRecycledViewPool().setMaxRecycledViews(itemType, multiItemView.getMaxRecycleCount());
        }
    }
}
