package cdictv.disantao.okhttp;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

public class ShowOkhpttp {
    public static void show(String uri,MyCall myCall){
        RequestBody body= new FormBody.Builder()
                .build();
        Request request=new Request.Builder()
                .post(body).url(uri)
                .build();
        OkhttpiApi.request(request,myCall);
    }

    public static void showCarChepai(String chepai,String uri,MyCall myCall){
        RequestBody body= new FormBody.Builder().add("chepai",chepai)
                .build();
        Request request=new Request.Builder()
                .post(body).url(uri)
                .build();
        OkhttpiApi.request(request,myCall);
    }

    public static void showGet(String uri,MyCall myCall){
        Request request=new Request.Builder().url(uri)
                .build();
        OkhttpiApi.request(request,myCall);
    }

}
