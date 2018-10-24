package com.ak.user.expenseslist.Helper;

import android.support.v4.app.FragmentManager;

import com.ak.user.expenseslist.Interface.NavigationManager;
import com.ak.user.expenseslist.MainActivity;

public class FragmentNavigationManager implements NavigationManager
{
    private static FragmentNavigationManager mInstance;

    private FragmentManager fragmentManager;
    private MainActivity mActivity;

    public static FragmentNavigationManager getmInstance(MainActivity mainActivity)
    {
        if(mInstance == null)
        {
            mInstance = new FragmentNavigationManager();

        }

        mInstance.configure(mainActivity);
        return mInstance;
    }

    private void configure(MainActivity mainActivity)
    {
        mActivity = mainActivity;
        fragmentManager = mainActivity.getSupportFragmentManager();
    }

    @Override
    public void showFragment(String title)
    {

    }
}
