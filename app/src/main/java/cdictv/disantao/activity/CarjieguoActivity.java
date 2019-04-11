package cdictv.disantao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cdictv.disantao.R;
import cdictv.disantao.adatper.CarZhiliaoAdapter;
import cdictv.disantao.bean.CarWeiZhangBean;

public class CarjieguoActivity extends AppCompatActivity {

    Intent intent;
    List<CarWeiZhangBean> list = new ArrayList<>();
    CarZhiliaoAdapter adapter;
    private ListView carjie_zhiliao;
    private ListView carjie_weizhang;
    ImageView carjie_jia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carjieguo);
        initView();
        carjie_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CarjieguoActivity.this,CarWeizahngActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        intent = getIntent();
        list.addAll((Collection<? extends CarWeiZhangBean>) intent.getSerializableExtra("bean"));
        adapter = new CarZhiliaoAdapter(CarjieguoActivity.this,list,carjie_weizhang);
        carjie_zhiliao.setAdapter(adapter);
    }

    private void initView() {
        carjie_zhiliao = (ListView) findViewById(R.id.carjie_zhiliao);
        carjie_weizhang = (ListView) findViewById(R.id.carjie_weizhang);
        carjie_jia = (ImageView) findViewById(R.id.carjie_jia);
    }
}
