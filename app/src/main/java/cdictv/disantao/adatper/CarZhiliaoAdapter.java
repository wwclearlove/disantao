package cdictv.disantao.adatper;

import android.content.Context;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cdictv.disantao.R;
import cdictv.disantao.bean.CarWeiZhangBean;

public class CarZhiliaoAdapter extends BaseAdapter {

    Context context;
    List<CarWeiZhangBean> beanList;
    ListView listView;

    private TextView zhiliaoChepai;
    private TextView zhiliaoWeizhang;
    private TextView zhiliaoFakuan;
    private ImageView zhiliaoJia;

    WeiZhangAdapter adapter;

    public CarZhiliaoAdapter(Context context, List<CarWeiZhangBean> beanList,ListView listView) {
        this.context = context;
        this.beanList = beanList;
        this.listView = listView;
    }

    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.carzhiliao_item,parent,false);
        }



        zhiliaoChepai = (TextView) convertView.findViewById(R.id.zhiliao_chepai);
        zhiliaoWeizhang = (TextView) convertView.findViewById(R.id.zhiliao_weizhang);
        zhiliaoFakuan = (TextView) convertView.findViewById(R.id.zhiliao_fakuan);
        zhiliaoJia = (ImageView) convertView.findViewById(R.id.zhiliao_jia);
        LinearLayout layout =  convertView.findViewById(R.id.zhiliao_carcader);
        layout.setTag(position);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = (int) v.getTag();

                adapter = new WeiZhangAdapter(context,beanList.get(i).data.xiangqing);
                listView.setAdapter(adapter);
            }
        });
        zhiliaoJia.setTag(position);
//
//
        zhiliaoJia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = (int) v.getTag();
                beanList.remove(i);
                if(beanList.size() == 0){
                    adapter =  new WeiZhangAdapter(context,new ArrayList<CarWeiZhangBean.DataBean.XiangqingBean>());
                    listView.setAdapter(adapter);
                }
                notifyDataSetChanged();
                adapter.notifyDataSetChanged();
            }
        });

        zhiliaoChepai.setText(beanList.get(position).data.chepai);
        zhiliaoWeizhang.setText(beanList.get(position).data.weichuli);
        zhiliaoFakuan.setText("扣"+beanList.get(position).data.koufen+"分       罚款"+beanList.get(position).data.fankuan+"元");

        if(adapter == null ){
            adapter = new WeiZhangAdapter(context,beanList.get(0).data.xiangqing);
            listView.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }


        return convertView;
    }
}
