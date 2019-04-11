package cdictv.disantao.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import cdictv.disantao.App;
import cdictv.disantao.R;
import cdictv.disantao.bean.UserBean;
import cdictv.disantao.okhttp.MyCall;
import cdictv.disantao.okhttp.ShowOkhpttp;
import cdictv.disantao.util.Sputil;
import cdictv.disantao.util.ZhengzeUtil;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView back;
    private EditText et_user;
    private EditText et_youxiang;
    private EditText et_password1;
    private EditText et_password2;
    private Button tijiao;
    private String mUser;
    private String mYouxiang;
    private String mPassword1;
    private String mPassword2;
    private ProgressDialog mProgressDialog;
    public UserBean mUserBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {


        back = (ImageView) findViewById(R.id.back);

        et_user = (EditText) findViewById(R.id.et_user);
        et_youxiang = (EditText) findViewById(R.id.et_youxiang);
        et_password1 = (EditText) findViewById(R.id.et_password1);
        et_password2 = (EditText) findViewById(R.id.et_password2);
        tijiao = (Button) findViewById(R.id.tijiao);

        tijiao.setOnClickListener(this);
       back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tijiao:
                regist();
            case R.id.back:
                finish();
                startActivity(new Intent(RegisterActivity.this, Loginactivity.class));
                break;
        }
    }

    private void regist() {
        submit();
        if (TextUtils.isEmpty(mUser)) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(mYouxiang)) {
            Toast.makeText(this, "请输入邮箱", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(mPassword1)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(mPassword2)) {
            Toast.makeText(this, "请确密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!mPassword1.equals(mPassword2)){
            et_password1.setText("");
            et_password2.setText("");
            Toast.makeText(this, "两次密码输入不同，请重新输入", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!mUser.matches(ZhengzeUtil.UERZJ)) {
            Toast.makeText(this,
                    "用户名请输入为字母首位且4-8位数字字母", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!mPassword2.matches(ZhengzeUtil.PWDZJ)) {
            Toast.makeText(this,
                    "密码请输入不能以0开头切6-12位的数字",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        mProgressDialog = ProgressDialog.show(
                this, "提示", "正在请求");
        ShowOkhpttp.regist(mUser, mPassword1,mYouxiang, new MyCall() {
            @Override
            public void success(String json) {
                Log.d("===", json);
                try {
                    Gson gson = new Gson();
                    mUserBean = gson.fromJson(json, UserBean.class);
                    Log.d("+=",mUserBean.data.username);
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegisterActivity.this, Loginactivity.class));
                    Sputil.putString("youxiang",mYouxiang);
                    Sputil.putString("zhuce",mUser);
                    Sputil.putString("mima",mPassword1);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(App.INSTANSE, "注册失败", Toast.LENGTH_LONG).show();
                } finally {
                    mProgressDialog.dismiss();
                }
            }

            @Override
            public void filed(String msg) {
                mProgressDialog.dismiss();
            }

        });

    }

    private void submit() {

        mUser = et_user.getText().toString().trim();

        mYouxiang = et_youxiang.getText().toString().trim();

        mPassword1 = et_password1.getText().toString().trim();


        mPassword2 = et_password2.getText().toString().trim();

    }
}
