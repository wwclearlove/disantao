package cdictv.disantao.adatper;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import cdictv.disantao.R;
import cdictv.disantao.bean.WdyeBean;

public class Gridadatper extends BaseAdapter {
    List<WdyeBean> mBeanlist;
    private Context mContext;
    private View mView;
    private RelativeLayout layout;
    private TextView tvChe;
    private TextView zhaungtai;
    private TextView tvValue;
    public Gridadatper(List<WdyeBean> beanlist, Context context) {
        mBeanlist = beanlist;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mBeanlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mBeanlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WdyeBean bean=mBeanlist.get(position);
        if(convertView==null){
            mView = LayoutInflater.from(mContext).inflate(R.layout.wdye_item,null);
        }else {
            mView=convertView;
        }
        initview();
        tvChe.setText(bean.chename);

        tvValue.setText(bean.menoy);
        if(Integer.parseInt(bean.menoy)<100){
            layout.setBackgroundColor(Color.parseColor("#fb190d"));
            zhaungtai.setText("警告");
        }else {
            layout.setBackgroundColor(Color.parseColor("#29fb0d"));
            zhaungtai.setText("正常");
        }
        return mView;
    }

    private void initview() {
        layout = mView. findViewById(R.id.layout);
        tvChe = mView.  findViewById(R.id.tv_che);
        zhaungtai = mView. findViewById(R.id.zhaungtai);
        tvValue = mView.  findViewById(R.id.tv_value);

    }
}
