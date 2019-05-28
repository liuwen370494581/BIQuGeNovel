package com.example.biqunovel.Jsoup;

import android.util.Log;

import com.example.biqunovel.Model.RankModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/05/28 11:30
 * desc   :
 */
public class HtmlParserUtil {

    private static final String TAG = "HtmlParserUtil";

    public static List<RankModel> getRankDate(String url) {
        List<RankModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.topbooks").select("li");
            for (Element element : elements) {
                Log.e(TAG, "hits" + element.select("span.hits").text());
                Log.e(TAG, "num" + element.select("span.num").text());
                Log.e(TAG, "url" + element.select("a").attr("href"));
                Log.e(TAG, "title" + element.select("a").text());
                RankModel rankModel = new RankModel();
                rankModel.setBookName(element.select("a").text());
                rankModel.setBookDate(element.select("span.hits").text());
                rankModel.setBookUrl(element.select("a").attr("href"));
                rankModel.setBookRankNum(element.select("span.num").text());
                list.add(rankModel);
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
