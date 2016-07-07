package cn.gaoyuexiang.lolheros.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import cn.gaoyuexiang.lolheros.service.ImgTask;

/**
 * Created by kbyyd on 2016/7/7.
 */
public class HeroPagerAdapter extends PagerAdapter {

    private List<String> heros;
    private Context context;

    public HeroPagerAdapter(List<String> heros, Context context) {
        this.heros = heros;
        this.context = context;
    }

    @Override
    public int getCount() {
        return heros.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final ImageView iv = new ImageView(context);
        new ImgTask(new ImgTask.Callback() {
            @Override
            public void callback(Bitmap result) {
                iv.setImageBitmap(result);
            }
        }).execute(heros.get(position));
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
