package cn.gaoyuexiang.lolheros.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by kbyyd on 2016/7/7.
 */
public class HeroPagerAdapter extends PagerAdapter {

    private List<Bitmap> bitmaps;
    private Context context;

    public HeroPagerAdapter(List<Bitmap> bitmaps, Context context) {
        this.bitmaps = bitmaps;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bitmaps.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = new ImageView(context);
        iv.setImageBitmap(bitmaps.get(position));
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
