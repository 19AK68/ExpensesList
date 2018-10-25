package com.ak.user.expenseslist.Helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ak.user.expenseslist.BuildConfig;
import com.ak.user.expenseslist.FragmentContent.FragmentContent;
import com.ak.user.expenseslist.Interface.NavigationManager;
import com.ak.user.expenseslist.MainActivity;
import com.ak.user.expenseslist.R;

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
        showFragment(FragmentContent.newInstance(title),false);
    }

    public void showFragment(Fragment fragmentContent, boolean b)
    {
        FragmentManager fm = fragmentManager;
        FragmentTransaction ft = fm.beginTransaction().replace(R.id.container,fragmentContent);
        ft.addToBackStack(null);
        if(b || !BuildConfig.DEBUG)
        {
            ft.commitAllowingStateLoss();
        }
        else
            ft.commit();

        fm.executePendingTransactions();
    }
}
