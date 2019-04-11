package cdictv.disantao.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cdictv.disantao.R;
import cdictv.disantao.bean.HongLvdengBean;

public class HongLvdnegAdapter extends BaseAdapter {

    Context context;
    List<HongLvdengBean.DataBean> lvdengBeans;

    private TextView hongLukoou;
    private TextView hongRed;
    private TextView hongYellow;
    private TextView hongGreend;



    public HongLvdnegAdapter(Context context, List<HongLvdengBean.DataBean> lvdengBeans) {
        this.context = context;
        this.lvdengBeans = lvdengBeans;
    }

    @Override
    public int getCount() {
        return lvdengBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return lvdengBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.honglvdeng_itme,parent,false);
        }


        hongLukoou = (TextView) convertView.findViewById(R.id.hong_lukoou);
        hongRed = (TextView) convertView.findViewById(R.id.hong_red);
        hongYellow = (TextView) convertView.findViewById(R.id.hong_yellow);
        hongGreend = (TextView) convertView.findViewById(R.id.hong_greend);

        hongLukoou.setText(lvdengBeans.get(position).id+"");
        hongRed.setText(lvdengBeans.get(position).red+"");
        hongYellow.setText(lvdengBeans.get(position).yellow+"");
        hongGreend.setText(lvdengBeans.get(position).green+"");

        return convertView;
    }
}
