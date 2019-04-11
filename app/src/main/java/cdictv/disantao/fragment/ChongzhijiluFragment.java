package cdictv.disantao.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import cdictv.disantao.R;
import cdictv.disantao.adatper.ChongzhiAdapter;
import cdictv.disantao.bean.ChongzhiBean;
import cdictv.disantao.database.DataBaseHelp;

public class ChongzhijiluFragment extends Fragment {
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = container.getContext();
        View view = View.inflate(context, R.layout.chongzhijilu_fragment,null);
        ListView listView = view.findViewById(R.id.chongzhi_listview);
        try {
            Dao dao = DataBaseHelp.getDataBase(context).getDao(ChongzhiBean.class);
            List<ChongzhiBean> list = dao.queryForAll();
//            Log.d("da", "onCreateView: "+list.get(0).cnum);
            ChongzhiAdapter adapter = new ChongzhiAdapter(context,list);
            listView.setAdapter(adapter);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return view;
    }
}
