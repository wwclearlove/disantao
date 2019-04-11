package cdictv.disantao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cdictv.disantao.R;
import cdictv.disantao.bean.CarWeiZhangBean;
import cdictv.disantao.okhttp.MyCall;
import cdictv.disantao.okhttp.ShowOkhpttp;

public class CarWeizahngActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText weizhang_edittext;
    private Button weizhang_query;

    Gson gson = new Gson();
    List<CarWeiZhangBean> beans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_weizahng);
        initView();
    }

    private void initView() {
        weizhang_edittext = (EditText) findViewById(R.id.weizhang_edittext);
        weizhang_query = (Button) findViewById(R.id.weizhang_query);

        weizhang_query.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.weizhang_query:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String edittext = weizhang_edittext.getText().toString().trim();
        if (TextUtils.isEmpty(edittext)) {
            Toast.makeText(this, "车牌号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        initRequest(edittext);

        // TODO validate success, do something
    }

    private void initRequest(String edittext) {
        ShowOkhpttp.showCarChepai(edittext, "https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/chepai", new MyCall() {
            @Override
            public void success(String json) {
                try {
                    CarWeiZhangBean bean = gson.fromJson(json, CarWeiZhangBean.class);
                    Intent intent = new Intent(CarWeizahngActivity.this,CarjieguoActivity.class);
                    beans.add(bean);
                    intent.putExtra("bean", (Serializable) beans);
                    startActivity(intent);
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void filed(String msg) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
