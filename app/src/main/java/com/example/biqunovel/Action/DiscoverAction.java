package com.example.biqunovel.Action;

import android.content.Context;

import com.example.biqunovel.Config.Config;
import com.example.biqunovel.Jsoup.HtmlParserUtil;
import com.example.biqunovel.Model.IndexModel;
import com.example.biqunovel.Model.RankModel;
import com.example.biqunovel.R;
import com.example.biqunovel.listener.ActionCallBack;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/05/28 11:28
 * desc   :
 */
public class DiscoverAction {


    public static List<IndexModel> getIndexModel() {
        List<IndexModel> list = new ArrayList<>();
        list.add(new IndexModel(1, "玄幻奇幻", Config.WUXIA_TOTAL));
        list.add(new IndexModel(2, "武侠仙侠", Config.WUXIA_TOTAL));
        list.add(new IndexModel(3, "都市言情", Config.DOUSHI_TOTAL));
        list.add(new IndexModel(4, "历史军事", Config.LISHI_TOTAL));
        list.add(new IndexModel(5, "科幻灵异", Config.KEHUAN_TOTAL));
        list.add(new IndexModel(6, "网游竞技", Config.WANGYOU_TOTAL));
        list.add(new IndexModel(7, "女生频道", Config.GIRL_TOTAL));
        list.add(new IndexModel(7, "完本小说", Config.END_TOTAL));
        return list;
    }

    public static List<RankModel> sortRankDate(List<RankModel> list, String type) {
        List<RankModel> temList = new ArrayList<>();
        for (RankModel rankModel : list) {
            if (rankModel.getType().equals(type)) {
                temList.add(rankModel);
            }
        }
        return temList;
    }


    public static void searchRankDate(final Context context, final String url, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<RankModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<RankModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.getRankDate(url));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<RankModel>>() {
            @Override
            public void accept(@NonNull List<RankModel> models) throws Exception {
                if (models != null && models.size() != 0) {
                    callBack.ok(models);
                } else {
                    callBack.failed("没有数据");
                }
            }
        });
    }
}
