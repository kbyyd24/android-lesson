package cn.gaoyuexiang.lolheros.service;

import android.os.AsyncTask;

import cn.gaoyuexiang.lolheros.util.HttpUtil;

/**
 * Created by kbyyd on 2016/7/7.
 */
public class DataTask extends AsyncTask<String, Integer, String> {

    private Callback callback;

    public DataTask(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(String... params) {
        return HttpUtil.downloadData(params[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        callback.callback(result);
    }

    public static interface Callback {
        void callback(String result);
    }
}
