package cdictv.disantao.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cdictv.disantao.R;
import cdictv.disantao.bean.NewsBean;

public class NewsAdapter extends BaseAdapter {

    private TextView newsText;

    Context context;
    List<NewsBean.ResultBean.DataBean> list;


    public NewsAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
           convertView = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);
        }
        newsText = (TextView) convertView.findViewById(R.id.news_text);
        newsText.setText(list.get(position).title);


        return convertView;
    }
}
