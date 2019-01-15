package com.gipl.addremovefragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Creted by User on 10-Jan-19
 */
public class PageAdapter extends FragmentPagerAdapter {

    private int nCount = 1;

    PageAdapter(FragmentManager fm) {
        super(fm);
    }

    int addNextFragment() {
        nCount++;
        notifyDataSetChanged();
        return nCount + 1;
    }

    void removeFragment() {
        nCount--;
        notifyDataSetChanged();

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new SampleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SampleFragment.KEY, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return nCount;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
//        if (nCount == 1)
            return POSITION_NONE;
//        else {
//            return POSITION_UNCHANGED;
//        }
    }


}
