package cdictv.disantao.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cdictv.disantao.R;
import cdictv.disantao.adatper.Gridadatper;
import cdictv.disantao.bean.ChongzhiBean;
import cdictv.disantao.bean.WdyeBean;
import cdictv.disantao.database.DataBaseHelp;
import cdictv.disantao.util.Sputil;

public class WdyeFragment extends Fragment {
    private ImageView back;
    private EditText etUser;
    private Button queding;
    private Button quxiao;
    private Context mContext;
    private View mView;
    Dao mDao;
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
            public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
                    View inflate=LayoutInflater.from(mContext).inflate(R.layout.cq_layout,null);
              final AlertDialog alertDialog=  new AlertDialog.Builder(mContext).setView(inflate).show();
                back = inflate. findViewById(R.id.back);
                etUser = inflate. findViewById(R.id.et_user);
                queding = inflate. findViewById(R.id.queding);
                quxiao = inflate. findViewById(R.id.quxiao);
                queding.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                     String  zhi= etUser.getText().toString().trim();
                     if(TextUtils.isEmpty(zhi)){
                         Toast.makeText(mContext,"请重新输入",Toast.LENGTH_LONG).show();
                         return;
                     }
                     if(Integer.parseInt(zhi)==0){
                         Toast.makeText(mContext,"请重新输入",Toast.LENGTH_LONG).show();
                        return;
                     }
                        try {
                            mDao= DataBaseHelp.getDataBase(mContext).getDao(ChongzhiBean.class);
                            ChongzhiBean bean=new ChongzhiBean();
                            bean.cnum=zhi;
                            bean.cmoney=mBeanlist.get(position).menoy;
                            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            bean.ctime=simpleDateFormat.format(new Date());
                            mDao.create(bean);
                            Toast.makeText(mContext,"充值成功",Toast.LENGTH_LONG).show();
                            mBeanlist.get(position).menoy= Integer.parseInt(mBeanlist.get(position).menoy)+Integer.parseInt(zhi)+"";
                            mGridadatper.notifyDataSetChanged();
                            alertDialog.dismiss();
                     } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
                quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

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
