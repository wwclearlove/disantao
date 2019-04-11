package cdictv.disantao.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cdictv.disantao.R;
import cdictv.disantao.activity.CarWeizahngActivity;
import cdictv.disantao.bean.CarWeiZhangBean;

public class WeiZhangAdapter extends BaseAdapter {

    Context context;
    List<CarWeiZhangBean.DataBean.XiangqingBean> list;

    private TextView weizhangTime;
    private TextView weizhangJieguo;
    private TextView weizhangLu;
    private TextView weizhangYuanying;
    private TextView weizhangFakuan;


    public WeiZhangAdapter(Context context, List<CarWeiZhangBean.DataBean.XiangqingBean> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.weizhang_item,parent,false);
        }

        weizhangTime = (TextView) convertView.findViewById(R.id.weizhang_time);
        weizhangJieguo = (TextView) convertView.findViewById(R.id.weizhang_jieguo);
        weizhangLu = (TextView) convertView.findViewById(R.id.weizhang_lu);
        weizhangYuanying = (TextView) convertView.findViewById(R.id.weizhang_yuanying);
        weizhangFakuan = (TextView) convertView.findViewById(R.id.weizhang_fakuan);


        weizhangTime.setText(list.get(position).time);
        weizhangJieguo.setText(list.get(position).state);
        weizhangLu.setText(list.get(position).luduan);
        weizhangYuanying.setText(list.get(position).yuanyin);
        weizhangFakuan.setText("扣分："+list.get(position).koufen+"0分       罚款："+list.get(position).fakuan+"元");



        return convertView;
    }
}
