package cdictv.disantao.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import cdictv.disantao.bean.ChongzhiBean;

public class DataBaseHelp extends OrmLiteSqliteOpenHelper {

    private  static  DataBaseHelp dataBaseHelp;

    private DataBaseHelp(Context context) {
        super(context, "disantian.db", null, 1);
    }

    public static  DataBaseHelp getDataBase(Context context){
        if(dataBaseHelp == null){
            dataBaseHelp = new DataBaseHelp(context);
        }
        return dataBaseHelp;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, ChongzhiBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
