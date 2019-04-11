package cdictv.disantao.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import cdictv.disantao.R;
import cdictv.disantao.adatper.Gridadatper;
import cdictv.disantao.bean.WdyeBean;
import cdictv.disantao.util.Sputil;

public class WdyeFragment extends Fragment {
    private Context mContext;
    private View mView;
    private GridView grideviwe;
    List<WdyeBean > mBeanlist;
    private Gridadatper mGridadatper;
    private Handler mHandler=new Handler();
    private Runnable mRunnable =new Runnable() {
        @Override
        public void run() {
            mHandler.postDelayed(this,5000);
                mGridadatper.notifyDataSetChanged();

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext=container.getContext();
        mBeanlist=new ArrayList<>();
        mView = LayoutInflater.from(mContext).inflate(R.layout.wdye_layout,null);
        grideviwe = mView.findViewById(R.id.grideviwe);
        getdata();
        mGridadatper = new Gridadatper(mBeanlist,mContext);
        grideviwe.setAdapter(mGridadatper);
        grideviwe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    View inflate=LayoutInflater.from(mContext).inflate(R.layout.cq_layout,null);
                new AlertDialog.Builder(mContext).setView(inflate).show();

            }
        });
        return mView;
    }

    @Override
    public void onStop() {
        super.onStop();
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    public void onStart() {
        super.onStart();
        mHandler.postDelayed(mRunnable,5000);
    }

    private void getdata() {
        mBeanlist.clear();
        WdyeBean bean1=new WdyeBean();
        bean1.chename="1号小车";
        bean1.menoy= Sputil.getString("1号","0");
        WdyeBean bean2=new WdyeBean();
        bean2.chename="2号小车";
        bean2.menoy= Sputil.getString("2号","0");
        WdyeBean bean3=new WdyeBean();
        bean3.chename="3号小车";
        bean3.menoy= Sputil.getString("3号","0");
        WdyeBean bean4=new WdyeBean();
        bean4.chename="4号小车";
        bean4.menoy= Sputil.getString("4号","0");
        mBeanlist.add(bean1);
        mBeanlist.add(bean2);
        mBeanlist.add(bean3);
        mBeanlist.add(bean4);
    }
}
