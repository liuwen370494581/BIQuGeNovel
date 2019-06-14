package com.example.biqunovel.Jsoup;

import android.util.Log;

import com.example.biqunovel.Config.Config;
import com.example.biqunovel.Model.BookModel;
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


    /**
     * 获取排行榜的数据
     *
     * @param url
     * @return
     */
    public static List<RankModel> getRankDate(String url) {
        List<RankModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.topbooks").select("li");
            int i = 0;
            for (Element element : elements) {
                RankModel rankModel = new RankModel();
                setBookType(i, rankModel);
                rankModel.setBookName(element.select("a").text());
                rankModel.setBookDate(element.select("span.hits").text());
                rankModel.setBookUrl(element.select("a").attr("href"));
                rankModel.setBookRankNum(element.select("span.num").text());
                list.add(rankModel);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 设置排行类型
     *
     * @param i
     * @param rankModel
     */
    private static void setBookType(int i, RankModel rankModel) {
        if (i + 1 <= 15) {
            rankModel.setType(Config.XUANHUAN_TOTAL);
        } else if (i + 1 >= 15 && i + 1 <= 30) {
            rankModel.setType(Config.XUANHUAN_MONTH);
        } else if (i + 1 >= 30 && i + 1 <= 45) {
            rankModel.setType(Config.XUANHUAN_WEEK);
        } else if (i + 1 >= 45 && i + 1 <= 60) {
            rankModel.setType(Config.WUXIA_TOTAL);
        } else if (i + 1 >= 60 && i + 1 <= 75) {
            rankModel.setType(Config.WUXIA_MONTH);
        } else if (i + 1 >= 75 && i + 1 <= 90) {
            rankModel.setType(Config.WUXIA_WEEK);
        } else if (i + 1 >= 90 && i + 1 <= 105) {
            rankModel.setType(Config.DOUSHI_TOTAL);
        } else if (i + 1 >= 105 && i + 1 <= 120) {
            rankModel.setType(Config.DOUSHI_MONTH);
        } else if (i + 1 >= 110 && i + 1 <= 135) {
            rankModel.setType(Config.DOUSHI_WEEK);
        } else if (i + 1 >= 135 && i + 1 <= 150) {
            rankModel.setType(Config.LISHI_TOTAL);
        } else if (i + 1 >= 150 && i + 1 <= 165) {
            rankModel.setType(Config.LISHI_MONTH);
        } else if (i + 1 >= 165 && i + 1 <= 180) {
            rankModel.setType(Config.LISHI_WEEK);
        } else if (i + 1 >= 180 && i + 1 <= 195) {
            rankModel.setType(Config.KEHUAN_TOTAL);
        } else if (i + 1 >= 195 && i + 1 <= 210) {
            rankModel.setType(Config.KEHUAN_MONTH);
        } else if (i + 1 >= 210 && i + 1 <= 225) {
            rankModel.setType(Config.KEHUAN_WEEK);
        } else if (i + 1 >= 225 && i + 1 <= 240) {
            rankModel.setType(Config.WANGYOU_TOTAL);
        } else if (i + 1 >= 240 && i + 1 <= 255) {
            rankModel.setType(Config.WANGYOU_MONTH);
        } else if (i + 1 >= 255 && i + 1 <= 270) {
            rankModel.setType(Config.WANGYOU_WEEK);
        } else if (i + 1 >= 270 && i + 1 <= 285) {
            rankModel.setType(Config.GIRL_TOTAL);
        } else if (i + 1 >= 285 && i + 1 <= 300) {
            rankModel.setType(Config.GIRL_MONTH);
        } else if (i + 1 >= 300 && i + 1 <= 315) {
            rankModel.setType(Config.GIRL_WEEK);
        } else if (i + 1 >= 315 && i + 1 <= 330) {
            rankModel.setType(Config.END_TOTAL);
        } else if (i + 1 >= 330 && i + 1 <= 345) {
            rankModel.setType(Config.END_MONTH);
        } else if (i + 1 >= 345 && i + 1 <= 360) {
            rankModel.setType(Config.END_WEEK);
        }
    }


    /**
     * 获取首页封面数据
     *
     * @param url
     * @return
     */
    public static List<BookModel> getMainDate(String url) {
        List<BookModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.item");
            for (Element element : elements) {
                BookModel model = new BookModel();
                model.setBookUrl(Config.BIQuUrl + element.select("a").attr("href"));
                model.setBookImg(Config.BIQuUrl + element.select("a").select("img").attr("src"));
                model.setBookName(element.select("a").select("img").attr("alt"));
                model.setBookAuthor(element.select("dl").select("span").text());
                model.setBooKDesc(element.select("dl").select("dd").text());
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取各种书籍类型更新列表
     *
     * @param url
     * @return
     */
    public static List<BookModel> getMainNewList(String url) {
        List<BookModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.l").select("li");
            for (Element element : elements) {
                BookModel model = new BookModel();
                model.setBookType(element.select("span.s1").text());
                model.setBookUrl(Config.BIQuUrl + element.select("span.s2").select("a").attr("href"));
                //model.setBookImg(Config.BIQuUrl + element.select("a").select("img").attr("src"));
                model.setBookName(element.select("span.s2").select("a").text());

                model.setBookNewChaptersUrl(Config.BIQuUrl + element.select("span.s3").select("a").attr("href"));
                model.setBookNewChapters(element.select("span.s3").select("a").text());
                model.setBookAuthor(element.select("span.s4").text());
                model.setBookUpdateDate(element.select("span.s5").text());
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取点击最高的数据
     *
     * @param url
     * @return
     */
    public static List<BookModel> getMainRankList(String url) {
        List<BookModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.r").select("li");
            for (Element element : elements) {
                BookModel model = new BookModel();
                model.setBookType(element.select("span.s1").text());
                model.setBookUrl(Config.BIQuUrl + element.select("span.s2").select("a").attr("href"));
                //model.setBookImg(Config.BIQuUrl + element.select("a").select("img").attr("src"));
                model.setBookName(element.select("span.s2").select("a").text());
                model.setBookAuthor(element.select("span.s5").text());
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
