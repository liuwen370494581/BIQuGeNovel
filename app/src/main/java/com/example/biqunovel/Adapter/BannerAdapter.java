package com.example.biqunovel.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.biqunovel.Model.BookModel;
import com.example.biqunovel.R;
import com.example.biqunovel.Utils.GlideUtils;

import java.util.List;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/06/13 17:12
 * desc   :
 */
public class BannerAdapter extends PagerAdapter {

    // private int mSize;
    private Context mActivity;
    // private float mImageCorner = -1F;
    private List<BookModel> mList;

    public BannerAdapter(Context activity, List<BookModel> list) {
        mActivity = activity;
        mList = list;
    }

    public void updateList(List<BookModel> list) {
        if (list.size() != 0) {
               mList = list;
            notifyDataSetChanged();
        }
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup view, int position, @NonNull Object object) {
        view.removeView((View) object);
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View view = LayoutInflater.from(mActivity.getApplicationContext()).inflate(R.layout.recommend_page_item, container, false);
        if (mList.size() != 0) {
            BookModel model = mList.get(position);
            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            TextView textView = (TextView) view.findViewById(R.id.image_desc);
            textView.setText(model.getBooKDesc());
            GlideUtils.loadImage(imageView, model.getBookImg(), R.mipmap.ic_default_cover, R.mipmap.ic_default_cover);
            Bitmap image = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            Bitmap newimage = getRoundCornerImage(image, 50);
            ImageView imageView2 = new ImageView(view.getContext());
            imageView2.setImageBitmap(newimage);
            container.addView(view);
            //监听事件
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent intent = new Intent(mActivity, WebActivity.class);
//                    intent.putExtra(Config.INTENT_COMM_MODEL, mList.get(position));
//                    intent.putExtra(Config.INTENT_BBS_URL, Config.BAO_FENG_URL_2 + mList.get(position).getCoverVideoUrl());
//                    mActivity.startActivity(intent);
                }
            });
            return view;
        }
        return view;
    }


    public Bitmap getRoundCornerImage(Bitmap bitmap, int roundPixels) {
        Bitmap roundConcerImage = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(roundConcerImage);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, roundPixels, roundPixels, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, null, rect, paint);
        return roundConcerImage;
    }
}
