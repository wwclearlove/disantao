package cdictv.disantao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import cdictv.disantao.R;
import cdictv.disantao.util.Sputil;

public class WangjiActivity extends AppCompatActivity {
    private Button tijiao;
    private EditText et_user;
    private EditText et_youxiang;
    private ImageView back;
    private String mUser;
    private String mYouxiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wangji);
        initView();
    }

    private void initView() {
        tijiao = (Button) findViewById(R.id.tijiao);
        back = (ImageView) findViewById(R.id.back);
        et_user = (EditText) findViewById(R.id.et_user);
        et_youxiang = (EditText) findViewById(R.id.et_youxiang);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(WangjiActivity.this,Loginactivity.class));
            }
        });
        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
                if (TextUtils.isEmpty(mUser)) {
                    Toast.makeText(WangjiActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mYouxiang)) {
                    Toast.makeText(WangjiActivity.this, "请输入邮箱", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Sputil.getString("youxiang","").equals(mYouxiang)&&Sputil.getString("zhuce","").equals(mUser)){
                     Toast.makeText(WangjiActivity.this,"用户名为"+Sputil.getString("zhuce","")
                             +"密码为"+Sputil.getString("mima",""),Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(new Intent(WangjiActivity.this,Loginactivity.class));
                }else {
                    Toast.makeText(WangjiActivity.this, "找回失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void submit() {
        // validate
        mUser = et_user.getText().toString().trim();


        mYouxiang = et_youxiang.getText().toString().trim();


        // TODO validate success, do something


    }
}
