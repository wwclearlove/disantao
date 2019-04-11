package cdictv.disantao.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cdictv.disantao.R;
import cdictv.disantao.adatper.HongLvdnegAdapter;
import cdictv.disantao.bean.HongLvdengBean;
import cdictv.disantao.okhttp.MyCall;
import cdictv.disantao.okhttp.ShowOkhpttp;

public class HongLvDengActivity extends AppCompatActivity {

    private Spinner honglv_spinner;
    private ListView honglv_listview;
    int position;
    List<HongLvdengBean.DataBean> list = new ArrayList<>();
    HongLvdnegAdapter adapter;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hong_lv_deng);
        initView();
        initReuest();

        honglv_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(adapter != null){
                    selectDeng(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initReuest() {
        final ProgressDialog dialog = ProgressDialog.show(HongLvDengActivity.this,"请稍候","正在请求...");
        ShowOkhpttp.show("https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/lamplist", new MyCall() {
            @Override
            public void success(String json) {
                try {
                    HongLvdengBean bean = gson.fromJson(json,HongLvdengBean.class);
                    list.addAll(bean.data);
                    adapter = new HongLvdnegAdapter(HongLvDengActivity.this,list);
                    selectDeng(0);
                    honglv_listview.setAdapter(adapter);
                    dialog.dismiss();
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void filed(String msg) {

            }
        });


    }

    private void selectDeng(int position) {
        switch (position){
            case 0:
                Collections.sort(list, new Comparator<HongLvdengBean.DataBean>() {
                    @Override
                    public int compare(HongLvdengBean.DataBean o1, HongLvdengBean.DataBean o2) {
                        return o1.id - o2.id;
                    }
                });
                break;
            case 1:
                Collections.sort(list, new Comparator<HongLvdengBean.DataBean>() {
                    @Override
                    public int compare(HongLvdengBean.DataBean o1, HongLvdengBean.DataBean o2) {
                        return o2.id - o1.id;
                    }
                });
                break;
            case 2:
                Collections.sort(list, new Comparator<HongLvdengBean.DataBean>() {
                    @Override
                    public int compare(HongLvdengBean.DataBean o1, HongLvdengBean.DataBean o2) {
                        return o1.red - o2.red;
                    }
                });
                break;
            case 3:
                Collections.sort(list, new Comparator<HongLvdengBean.DataBean>() {
                    @Override
                    public int compare(HongLvdengBean.DataBean o1, HongLvdengBean.DataBean o2) {
                        return o2.red - o1.red;
                    }
                });
                break;
            case 4:
                Collections.sort(list, new Comparator<HongLvdengBean.DataBean>() {
                    @Override
                    public int compare(HongLvdengBean.DataBean o1, HongLvdengBean.DataBean o2) {
                        return o1.yellow - o2.yellow;
                    }
                });
                break;
            case 5:
                Collections.sort(list, new Comparator<HongLvdengBean.DataBean>() {
                    @Override
                    public int compare(HongLvdengBean.DataBean o1, HongLvdengBean.DataBean o2) {
                        return o2.yellow - o1.yellow;
                    }
                });
                break;
            case 6:
                Collections.sort(list, new Comparator<HongLvdengBean.DataBean>() {
                    @Override
                    public int compare(HongLvdengBean.DataBean o1, HongLvdengBean.DataBean o2) {
                        return o1.green - o2.green;
                    }
                });
                break;
            case 7:
                Collections.sort(list, new Comparator<HongLvdengBean.DataBean>() {
                    @Override
                    public int compare(HongLvdengBean.DataBean o1, HongLvdengBean.DataBean o2) {
                        return o2.green - o1.green;
                    }
                });
                break;
        }
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        honglv_spinner = (Spinner) findViewById(R.id.honglv_spinner);
        honglv_listview = (ListView) findViewById(R.id.honglv_listview);
    }
}
