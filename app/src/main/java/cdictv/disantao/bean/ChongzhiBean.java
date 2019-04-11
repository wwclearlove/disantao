package cdictv.disantao.bean;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ChongzhiBean")
public class ChongzhiBean  {

    @DatabaseField(columnName = "cid")
    public String cid;
    @DatabaseField(columnName = "cnum")
    public String cnum;
    @DatabaseField(columnName = "cmoney")
    public String cmoney;
    @DatabaseField(columnName = "ctime")
    public String ctime;
}
