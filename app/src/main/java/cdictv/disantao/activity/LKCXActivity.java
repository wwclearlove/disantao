package cdictv.disantao.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cdictv.disantao.R;
import cdictv.disantao.bean.LKCXBean;
import cdictv.disantao.okhttp.MyCall;
import cdictv.disantao.okhttp.ShowOkhpttp;

public class LKCXActivity extends AppCompatActivity {
    private ImageButton back;
    private TextView pm;
    private TextView wd;
    private TextView sd;
    private TextView road1;
    private TextView road2;
    private TextView road3;
    private View color1;
    private View color2;
    private View color3;
    private String url = "https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/lukuangxinxi";
    private LKCXBean.DataBean data;
    private List<LKCXBean.DataBean.LukuangBean> lukuang;
    private Handler handler=new Handler(Looper.getMainLooper());
    private String[] str = new String[]{"通畅", "较通畅", "拥挤", "堵塞", "爆表"};
    private String[] colors = new String[]{"#0ebd12", "#98ed1f", "#ffff01", "#ff0103", "#4c060e"};
    private AlertDialog dialog;
    private Timer timer=new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lkcx);
        init();
        getData();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        getData();
                    }
                });
            }
        },3000,3000);
    }

    private void getData() {
        dialog = new ProgressDialog.Builder(this)
                .setTitle("提示")
                .setMessage("正在加载中...")
                .show();

        ShowOkhpttp.show(url, new MyCall() {
            @Override
            public void success(String json) {
                try {
                    Log.e("", "success: " + json);
                    LKCXBean lkcxBean = new Gson().fromJson(json, LKCXBean.class);
                    data = lkcxBean.getData();
                    lukuang = data.getLukuang();
                    setData();
                } catch (Exception e) {
                    dialog.dismiss();
                    Toast.makeText(LKCXActivity.this, "加载成失败！！！", Toast.LENGTH_SHORT)
                            .show();
                }
                dialog.dismiss();
            }

            @Override
            public void filed(String msg) {
                dialog.dismiss();
                Toast.makeText(LKCXActivity.this, "加载成失败！！！", Toast.LENGTH_SHORT)
                        .show();
            }
        });


    }

    private void setData() {
        pm.setText("PM2.5：" + data.getPm());
        wd.setText("温   度：" + data.getWendu());
        sd.setText("湿   度：" + data.getShidu());

        for (LKCXBean.DataBean.LukuangBean l : lukuang) {
            switch (l.getId()) {
                case 1:
                    road1.setText("1号道路：" + str[l.getState()-1]);
                    color1.setBackgroundColor(Color.parseColor(colors[l.getState()-1]));
                    break;
                case 2:
                    road2.setText("2号道路：" + str[l.getState()-1]);
                    color2.setBackgroundColor(Color.parseColor(colors[l.getState()-1]));
                    break;
                case 3:
                    road3.setText("3号道路：" + str[l.getState()-1]);
                    color3.setBackgroundColor(Color.parseColor(colors[l.getState()-1]));
                    break;
            }
        }
    }

    private void init() {
        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        pm = (TextView) findViewById(R.id.pm);
        wd = (TextView) findViewById(R.id.wd);
        sd = (TextView) findViewById(R.id.sd);


        road1 = (TextView) findViewById(R.id.road1);
        road2 = (TextView) findViewById(R.id.road2);
        road3 = (TextView) findViewById(R.id.road3);
        color1 = (View) findViewById(R.id.color1);
        color2 = (View) findViewById(R.id.color2);
        color3 = (View) findViewById(R.id.color3);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dialog!=null){
            dialog.dismiss();
        }
        timer.cancel();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(dialog!=null){
            dialog.dismiss();
        }
        timer.cancel();
    }
}
