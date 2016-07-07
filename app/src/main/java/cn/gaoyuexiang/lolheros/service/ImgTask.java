package cn.gaoyuexiang.lolheros.service;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import cn.gaoyuexiang.lolheros.util.HttpUtil;

/**
 * Created by kbyyd on 2016/7/7.
 */
public class ImgTask extends AsyncTask<String, Void, Bitmap> {

    private ImageView picture;

    public ImgTask(ImageView picture) {
        this.picture = picture;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        return HttpUtil.downloadImg(params[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        picture.setImageBitmap(bitmap);
    }
}
