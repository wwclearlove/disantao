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
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import cdictv.disantao.R;
import cdictv.disantao.bean.UserBean;
import cdictv.disantao.okhttp.MyCall;
import cdictv.disantao.okhttp.ShowOkhpttp;
import cdictv.disantao.util.Sputil;
import cdictv.disantao.util.ZhengzeUtil;

public class Loginactivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_user;
    private EditText et_password;
    private TextView reginst;
    private TextView wangji;
    private Button login;
    private String user;
    private String password;
    private ProgressDialog mProgressDialog;
    private UserBean mUserBean;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        initView();
        if(Sputil.getBoolean("fially",true)) {
            return;
        }else {
             Toast.makeText(getApplicationContext(),"自动登录",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Loginactivity.this,
                    MainActivity.class));
        }
    }

    private void getStringNamePass() {
        user = et_user.getText().toString().trim();
        password = et_password.getText().toString().trim();
    }

    private void initView() {


        back = (ImageView) findViewById(R.id.back);

        et_user = (EditText) findViewById(R.id.et_user);
        et_password = (EditText) findViewById(R.id.et_password);
        reginst = (TextView) findViewById(R.id.reginst);
        wangji = (TextView) findViewById(R.id.wangji);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(this);
       reginst.setOnClickListener(this);
       wangji.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                loginmain();
                break;
            case R.id.reginst:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id. wangji:
                startActivity(new Intent(this,WangjiActivity.class));
                break;
        }
    }

    private void loginmain() {
        getStringNamePass();
        Log.d("TAG", "loginmain: "+user+"-"+password);
        if (TextUtils.isEmpty(user)) {
            Toast.makeText(this,
                    "账户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this,
                    "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!user.matches(ZhengzeUtil.UERZJ)) {
            Toast.makeText(this,
                    "用户名请输入为字母首位且4-8位数字字母", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.matches(ZhengzeUtil.PWDZJ)) {
            Toast.makeText(this,
                    "密码请输入不能以0开头切6-12位的数字",
                    Toast.LENGTH_SHORT).show();
            return;
        }
       loginin();

    }

    private void loginin() {
        mProgressDialog = ProgressDialog.show(
                this, "提示", "正在请求");
        ShowOkhpttp.login(user, password, new MyCall() {
            @Override
            public void success(String json) {
                Log.d("===", json);
                try {
                    Gson gson = new Gson();
                    mUserBean = gson.fromJson(json, UserBean.class);
                    Log.d("+=",mUserBean.data.username);
                    Toast.makeText(Loginactivity.this, "登录成功", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Loginactivity.this,
                            MainActivity.class));
                    Sputil.putString("name", mUserBean.data.username);
                    Sputil.putBoolean("fially", false);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(Loginactivity.this, "用户名或密码错", Toast.LENGTH_LONG).show();
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
}



