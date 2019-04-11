package cdictv.disantao.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cdictv.disantao.R;
import cdictv.disantao.bean.ChongzhiBean;

public class ChongzhiAdapter extends BaseAdapter {

    Context context;
    List<ChongzhiBean> list;

    private TextView chongzhiId;
    private TextView chongzhiNum;
    private TextView chongzhiMoney;
    private TextView chongzhiTime;




    public ChongzhiAdapter(Context context, List<ChongzhiBean> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.chognzhi_item,parent,false);
        }
        chongzhiId = (TextView) convertView.findViewById(R.id.chongzhi_id);
        chongzhiNum = (TextView)  convertView.findViewById(R.id.chongzhi_num);
        chongzhiMoney = (TextView)  convertView.findViewById(R.id.chongzhi_money);
        chongzhiTime = (TextView)  convertView.findViewById(R.id.chongzhi_time);

        chongzhiId.setText(list.get(position).cid);
        chongzhiNum.setText(list.get(position).cnum);
        chongzhiMoney.setText(list.get(position).cmoney);
        chongzhiTime.setText(list.get(position).ctime);

        return convertView;
    }
}
