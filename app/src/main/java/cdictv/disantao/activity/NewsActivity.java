package cdictv.disantao.activity;

import android.app.Notification;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.List;

import cdictv.disantao.R;
import cdictv.disantao.adatper.NewsAdapter;
import cdictv.disantao.bean.NewsBean;
import cdictv.disantao.okhttp.MyCall;
import cdictv.disantao.okhttp.ShowOkhpttp;

public class NewsActivity extends AppCompatActivity {

    private ListView news_listview;
    NewsAdapter adapter;
    List<NewsBean.ResultBean.DataBean> list = new ArrayList<>();
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initView();
        inttRequsest();


    }

    private void inttRequsest() {
        final ProgressDialog dialog = ProgressDialog.show(NewsActivity.this,"请稍候","正在请求...");
        ShowOkhpttp.showGet("http://v.juhe.cn/toutiao/index?type=top&key=bb45f0a834d34863ed0ba8e4e58f8989", new MyCall() {
            @Override
            public void success(String json) {
                try {
                    Log.i("------", "success: "+json);
                    NewsBean bean = gson.fromJson(json, NewsBean.class);
                    list.addAll(bean.result.data);
                    adapter = new NewsAdapter(NewsActivity.this,list);
                    news_listview.setAdapter(adapter);
                    dialog.dismiss();
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void filed(String msg) {
                dialog.dismiss();
            }
        });
    }

    private void initView() {
        news_listview = (ListView) findViewById(R.id.news_listview);
    }
}
