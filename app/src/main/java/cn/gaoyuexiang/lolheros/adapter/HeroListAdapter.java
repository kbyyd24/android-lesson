package cn.gaoyuexiang.lolheros.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.gaoyuexiang.lolheros.R;
import cn.gaoyuexiang.lolheros.modle.Hero;
import cn.gaoyuexiang.lolheros.service.ImgTask;

/**
 * Created by kbyyd on 2016/7/7.
 */
public class HeroListAdapter extends BaseAdapter {

    private Context context;
    private List<Hero> heros;

    public HeroListAdapter(Context context, List<Hero> heros) {
        this.context = context;
        this.heros = heros;
    }

    @Override
    public int getCount() {
return heros.size();
    }

    @Override
    public Object getItem(int position) {
        return heros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = convertView == null ?
                LayoutInflater.from(context).inflate(R.layout.item_01, parent, false) : convertView;
        ImageView picture = (ImageView) convertView.findViewById(R.id.iv);
        TextView name = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tags = (TextView) convertView.findViewById(R.id.tv_tag);

        Hero hero = heros.get(position);

        name.setText(hero.getNameC() + '-' + hero.getTitle());
        tags.setText(hero.getTags());

        if (hero.getImg().length() > 0)
            new ImgTask(picture).execute(hero.getImg());

        return convertView;
    }
}
