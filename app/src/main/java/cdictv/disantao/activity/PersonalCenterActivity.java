package cdictv.disantao.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import cdictv.disantao.R;
import cdictv.disantao.adatper.PersonListAdapter;
import cdictv.disantao.bean.PersonListBean;
import cdictv.disantao.okhttp.MyCall;
import cdictv.disantao.okhttp.ShowOkhpttp;
import cdictv.disantao.util.Sputil;

public class PersonalCenterActivity extends AppCompatActivity {
    private ImageButton back;
    private TextView username;
    private TextView name;
    private TextView sex;
    private TextView phone;
    private TextView idcard;
    private TextView time;
    private ListView list;
    private PersonListAdapter personListAdapter;
    private AlertDialog dialog;
    private String url = "https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/geren";
    private PersonListBean.DataBean data;
    private List<PersonListBean.DataBean.CarBean> car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);
        init();
        getData();


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

                    PersonListBean personListBean = new Gson().fromJson(json, PersonListBean.class);
                    data = personListBean.getData();
                    car = data.getCar();
                    setData();
                    setAdapter();
                } catch (Exception e) {
                    dialog.dismiss();
                    Toast.makeText(PersonalCenterActivity.this, "加载成失败！！！", Toast.LENGTH_SHORT)
                            .show();
                }
                dialog.dismiss();
            }

            @Override
            public void filed(String msg) {
                dialog.dismiss();
                Toast.makeText(PersonalCenterActivity.this, "加载成失败！！！", Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }

    private void setData() {
        username.setText("用户名：" + Sputil.getString("name", "null"));
        name.setText("姓名：" + data.getName());
        sex.setText("性别：" + data.getSex());
        phone.setText("手机：" + data.getPhone());
        String idcard = data.getIdcard();
        String substring1 = idcard.substring(0, 6);
        String s = "*********";
        String substring2 = idcard.substring(14, 17);
        this.idcard.setText("身份证号：" + substring1 + s + substring2);
        time.setText("注册时间：" + data.getCreatetime());


    }

    private void setAdapter() {
        personListAdapter = new PersonListAdapter(car);
        list.setAdapter(personListAdapter);
    }

    private void init() {
        back = (ImageButton) findViewById(R.id.back);
        username = (TextView) findViewById(R.id.username);
        name = (TextView) findViewById(R.id.name);
        sex = (TextView) findViewById(R.id.sex);
        phone = (TextView) findViewById(R.id.phone);
        idcard = (TextView) findViewById(R.id.idcard);
        time = (TextView) findViewById(R.id.time);
        list = (ListView) findViewById(R.id.list);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (dialog != null) {
            dialog.dismiss();
        }
    }


}
