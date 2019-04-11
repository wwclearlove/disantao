package cdictv.disantao.adatper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import cdictv.disantao.R;
import cdictv.disantao.App;
import cdictv.disantao.bean.PersonListBean;

public class PersonListAdapter extends BaseAdapter {
    private List<PersonListBean.DataBean.CarBean> car;

    public PersonListAdapter(List<PersonListBean.DataBean.CarBean> car) {
        this.car = car;
    }

    @Override
    public int getCount() {
        return car.size();
    }

    @Override
    public Object getItem(int position) {
        return car.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            //convertView=View.inflate(App.INSTANSE,R.layout.person_list_layout,null);
            convertView= LayoutInflater.from(App.INSTANSE).inflate(R.layout.person_list_layout,parent,false);
        }

        TextView viewById = convertView.findViewById(R.id.chepai);
        viewById.setText(car.get(position).getChepai());

        return convertView;
    }
}
