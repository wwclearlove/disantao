package cdictv.disantao;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    public static Context INSTANSE;
    @Override
    public void onCreate() {
        super.onCreate();
        INSTANSE=this;
    }
}
