package cdictv.disantao.adatper;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.List;

public class WdzjAtatper extends FragmentPagerAdapter{
    private List<Fragment> mFragments;
    private Context mContext;
    public WdzjAtatper(FragmentManager fm, List<Fragment> fragments, Context context) {
        super(fm);
        mFragments = fragments;
        mContext = context;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
