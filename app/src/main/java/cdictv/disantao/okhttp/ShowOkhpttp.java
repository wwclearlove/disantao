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


    public static  void login(String name, String password, MyCall myCall) {
        RequestBody body = new FormBody.Builder()
                .add("username",name)
                .add("password", password)
                .build();
        Request request = new Request.Builder()
                .url("https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/login")
                .post(body)
                .build();
        OkhttpiApi.request(request,myCall);
    }
    public static  void regist(String name, String password, String emial,MyCall myCall) {
        RequestBody body = new FormBody.Builder()
                .add("username",name)
                .add("password", password)
                .add("email",emial)
                .build();
        Request request = new Request.Builder()
                .url("https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/login")
                .post(body)
                .build();
        OkhttpiApi.request(request,myCall);
    }

}
