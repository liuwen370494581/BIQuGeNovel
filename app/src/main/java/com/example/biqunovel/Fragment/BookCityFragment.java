package com.example.biqunovel.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.biqunovel.Action.DiscoverAction;
import com.example.biqunovel.Base.BaseFragment;
import com.example.biqunovel.Config.Config;
import com.example.biqunovel.Model.IndexModel;
import com.example.biqunovel.Model.RankModel;
import com.example.biqunovel.R;
import com.example.biqunovel.Utils.PromptDialogUtils;
import com.example.biqunovel.Utils.ToastUtils;
import com.example.biqunovel.View.RankLayout;
import com.example.biqunovel.listener.ActionCallBack;
import com.example.biqunovel.listener.OnCommItemListener;

import java.util.ArrayList;
import java.util.List;


/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/11/12 15:20
 * desc   :
 */

public class BookCityFragment extends BaseFragment {


    private RankLayout mRankLayout;
    private List<RankModel> rankModelList = new ArrayList<>();

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
        ((TextView) view.findViewById(R.id.title)).setText("排行榜");
        mRankLayout = (RankLayout) view.findViewById(R.id.id_rank_layout);
        loadDate();
        setListener();
    }

    private void loadDate() {
        PromptDialogUtils.getInstance().showPromptDialog("加载数据中");
        DiscoverAction.searchRankDate(getActivity(), "https://www.biquge.tw/nweph.html", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                PromptDialogUtils.getInstance().hidePromptDialog();
                mRankLayout.setRightVisible(true);
                rankModelList = (List<RankModel>) object;
                mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.XUANHUAN_TOTAL));
                mRankLayout.setBtnRetryVisible(false);

            }

            @Override
            public void failed(Object object) {
                PromptDialogUtils.getInstance().hidePromptDialog();
                ToastUtils.showCenterToast(getFragmentContext(), object.toString());
                mRankLayout.setBtnRetryVisible(true);
            }
        });
    }

    private void setListener() {
        mRankLayout.setListener(new OnCommItemListener() {
            @Override
            public void onItemClick(Object object) {
                IndexModel temModel = (IndexModel) object;
                mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, temModel.getBookTypeDes()));
                mRankLayout.setIndexSelect(temModel.getIndex());
                mRankLayout.clearRankTextBgAndColor();
            }

            @Override
            public void onTotalClick() {
                clickItemRank(1);

            }

            @Override
            public void onMonthClick() {
                clickItemRank(2);

            }

            @Override
            public void onWeekClick() {
                clickItemRank(3);
            }

            @Override
            public void onRetryClick() {
                loadDate();
            }
        });

    }

    private void clickItemRank(int choose) {
        int temDex = mRankLayout.getIndexSelect();
        IndexModel indexModel = DiscoverAction.getIndexModel(temDex);
        switch (choose) {
            case 1:
                //总榜
                switch (indexModel.getBookType()) {
                    case Config.XUANHUAN:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.XUANHUAN_TOTAL));
                        break;
                    case Config.WUXIAN:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.WUXIA_TOTAL));
                        break;
                    case Config.DOUSHI:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.DOUSHI_TOTAL));
                        break;
                    case Config.LISHI:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.LISHI_TOTAL));
                        break;
                    case Config.KEHUAN:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.KEHUAN_TOTAL));
                        break;
                    case Config.WANGYOU:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.WANGYOU_TOTAL));
                        break;
                    case Config.GIRL:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.GIRL_TOTAL));
                        break;
                    case Config.END:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.END_TOTAL));
                        break;

                }
                break;

            case 2:
                //月榜
                switch (indexModel.getBookType()) {
                    case Config.XUANHUAN:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.XUANHUAN_MONTH));
                        break;
                    case Config.WUXIAN:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.WUXIA_MONTH));
                        break;
                    case Config.DOUSHI:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.DOUSHI_MONTH));
                        break;
                    case Config.LISHI:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.LISHI_MONTH));
                        break;
                    case Config.KEHUAN:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.KEHUAN_MONTH));
                        break;
                    case Config.WANGYOU:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.WANGYOU_MONTH));
                        break;
                    case Config.GIRL:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.GIRL_MONTH));
                        break;
                    case Config.END:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.END_MONTH));
                        break;

                }
                break;

            case 3:
                //周榜
                switch (indexModel.getBookType()) {
                    case Config.XUANHUAN:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.XUANHUAN_WEEK));
                        break;
                    case Config.WUXIAN:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.WUXIA_WEEK));
                        break;
                    case Config.DOUSHI:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.DOUSHI_WEEK));
                        break;
                    case Config.LISHI:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.LISHI_WEEK));
                        break;
                    case Config.KEHUAN:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.KEHUAN_WEEK));
                        break;
                    case Config.WANGYOU:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.WANGYOU_WEEK));
                        break;
                    case Config.GIRL:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.GIRL_WEEK));
                        break;
                    case Config.END:
                        mRankLayout.updateRankDate(DiscoverAction.sortRankDate(rankModelList, Config.END_WEEK));
                        break;
                }
                break;
        }

    }


}
