package cdictv.disantao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cdictv.disantao.R;
import cdictv.disantao.util.Sputil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    TextPaint paint = textView.getPaint();
//paint.setFakeBoldText(true);
    private ImageView left_menu;
    private TextView title;
    private TextView zhuxiao;
    private RelativeLayout tool_bar;
    private ImageView top_bac;
    private LinearLayout cheliangweizhang;
    private LinearLayout person;
    private LinearLayout redlvdeng;
    private LinearLayout zhsz;
    private LinearLayout lukuangchaxun;
    private LinearLayout wodezuojia;
    private LinearLayout wdjt;
    private LinearLayout yule;
    private LinearLayout navigation_view;
    private DrawerLayout drawer_yout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Sputil.getBoolean("diyi",true)){
            Sputil.putString("1号","100");
            Sputil.putString("2号","100");
            Sputil.putString("3号","100");
            Sputil.putString("4号","80");
        }else {
            Sputil.putBoolean("diyi",false);
        }
        initView();
    }

    private void initView() {
        left_menu = (ImageView) findViewById(R.id.left_menu);
        title = (TextView) findViewById(R.id.title);
        zhuxiao = (TextView) findViewById(R.id.zhuxiao);
        tool_bar = (RelativeLayout) findViewById(R.id.tool_bar);
        top_bac = (ImageView) findViewById(R.id.top_bac);
        cheliangweizhang = (LinearLayout) findViewById(R.id.cheliangweizhang);
        person = (LinearLayout) findViewById(R.id.person);
        redlvdeng = (LinearLayout) findViewById(R.id.redlvdeng);
        zhsz = (LinearLayout) findViewById(R.id.zhsz);
        lukuangchaxun = (LinearLayout) findViewById(R.id.lukuangchaxun);
        wodezuojia = (LinearLayout) findViewById(R.id.wodezuojia);
        wdjt = (LinearLayout) findViewById(R.id.wdjt);
        yule = (LinearLayout) findViewById(R.id.yule);
        navigation_view = (LinearLayout) findViewById(R.id.navigation_view);
        drawer_yout = (DrawerLayout) findViewById(R.id.drawer_yout);

        left_menu.setOnClickListener(this);
        cheliangweizhang.setOnClickListener(this);
        person.setOnClickListener(this);
        redlvdeng.setOnClickListener(this);
        zhsz.setOnClickListener(this);
        lukuangchaxun.setOnClickListener(this);
        wodezuojia.setOnClickListener(this);
        wdjt.setOnClickListener(this);
        yule.setOnClickListener(this);
        zhuxiao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_menu:
                if(drawer_yout.isDrawerOpen(Gravity.LEFT)){
                    drawer_yout.closeDrawer(Gravity.LEFT);
                }else {
                    drawer_yout.openDrawer(Gravity.LEFT);
                }
                break;
            case R.id.zhuxiao:
                finish();
                Sputil.putBoolean("fially", true);
                startActivity(new Intent(this,Loginactivity.class));
                break;
            case R.id.cheliangweizhang:
                startActivity(new Intent(MainActivity.this,CarWeizahngActivity.class));
                break;
            case R.id.person:

                break;
            case R.id.redlvdeng:
                startActivity(new Intent(MainActivity.this,HongLvDengActivity.class));
                break;
            case R.id.zhsz:

                break;
            case R.id.lukuangchaxun:

                break;
            case R.id.wodezuojia:
                startActivity(new Intent(this,WodezjActivity.class));
                break;
            case R.id.wdjt:

                break;
            case R.id.yule:
                startActivity(new Intent(MainActivity.this,NewsActivity.class));
                break;
        }
    }
}
