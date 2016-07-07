package cn.gaoyuexiang.lolheros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.gaoyuexiang.lolheros.modle.Hero;
import cn.gaoyuexiang.lolheros.modle.HttpResult;
import cn.gaoyuexiang.lolheros.service.DataTask;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private HttpResult httpData = new HttpResult();
    private final String url = "http://lol.data.shiwan.com/lolHeros/?filter=&type=free";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        downloadData();
    }

    private void downloadData() {
        new DataTask(new DataTask.Callback() {
            @Override
            public void callback(String result) {
                try {
                    JSONObject object = new JSONObject(result);
                    httpData.setErrorCode(object.getInt("error_code"));
                    List<Hero> heros = new ArrayList<>();
                    JSONArray arr = object.getJSONArray("result");
                    for (int i = 0; i < arr.length(); i++) {
                        Hero hero = new Hero();
                        JSONObject obj = arr.getJSONObject(i);
                        hero.setId(obj.getString("id"));
                        hero.setNameC(obj.getString("name_c"));
                        hero.setTitle(obj.getString("title"));
                        hero.setImg(obj.getString("img"));
                        hero.setTags(obj.getString("tags"));
                        heros.add(hero);
                    }
                    httpData.setHeros(heros);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).execute(url);
    }
}
