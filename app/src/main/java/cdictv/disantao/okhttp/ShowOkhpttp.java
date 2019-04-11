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
}
