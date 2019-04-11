package cdictv.disantao.okhttp;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cdictv.disantao.App;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpiApi {
    private static OkHttpClient mOkHttpClient = new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS
    ).writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build();
    private static Handler sHandler = new Handler(Looper.getMainLooper());

    public static void request(final Request request, final MyCall myCall) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                sHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        myCall.filed(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String s = response.body().string().trim();
                sHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (TextUtils.isEmpty(s)) {
                            Toast.makeText(App.INSTANSE, "请求数据为空", Toast.LENGTH_LONG).show();
                        }else {
                            myCall.success(s);
                        }
                    }
                });
        }
    });
}
}
