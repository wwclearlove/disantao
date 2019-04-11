package cdictv.disantao.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cdictv.disantao.R;
import cdictv.disantao.adatper.WdzjAtatper;
import cdictv.disantao.fragment.WdyeFragment;
import cdictv.disantao.util.Sputil;

public class WodezjActivity extends AppCompatActivity {
    private TextView name;
    private ViewPager view;
    private TextView wdye;
    private TextView yckz;
    private TextView cajl;
    private List<Fragment> mFragments;
    private WdzjAtatper mAtatper;
    private TextPaint mTextPaint1;
    private TextPaint mTextPaint2;
    private TextPaint mTextPaint3;
    private Paint textPaint2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wodezj);
        mFragments=new ArrayList<>();
        initView();
        getdata();
        getpaint();
        initerner();
    }

    private void getpaint() {
        mTextPaint1 = wdye.getPaint();
        mTextPaint2 = yckz.getPaint();
        mTextPaint3 = cajl.getPaint();
    }
    private void initerner() {
        wdye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextPaint1.setFakeBoldText(true);
                mTextPaint2.setFakeBoldText(false);
                mTextPaint3.setFakeBoldText(false);
                view.setCurrentItem(0);
            }
        });
        yckz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextPaint1.setFakeBoldText(false);
                mTextPaint2.setFakeBoldText(true);
                mTextPaint3.setFakeBoldText(false);
                view.setCurrentItem(1);
            }
        });
      cajl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextPaint1.setFakeBoldText(false);
                mTextPaint2.setFakeBoldText(true);
                mTextPaint3.setFakeBoldText(false);
                view.setCurrentItem(2);
            }
        });
    }

    private void getdata() {
        mFragments.add(new WdyeFragment());

        mAtatper.notifyDataSetChanged();
    }
    private void initView() {
        name = (TextView) findViewById(R.id.name);
        view = (ViewPager) findViewById(R.id.view);
        wdye = (TextView) findViewById(R.id.wdye);
        yckz = (TextView) findViewById(R.id.yckz);
        cajl = (TextView) findViewById(R.id.cajl);
        name.setText("当前用户"+Sputil.getString("name",""));
        mAtatper = new WdzjAtatper(getSupportFragmentManager(),mFragments,WodezjActivity.this);
        view.setAdapter(mAtatper);
    }
}
