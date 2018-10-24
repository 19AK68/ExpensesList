package com.ak.user.expenseslist;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.ak.user.expenseslist.Adapter.CustomExpandableListAdapter;
import com.ak.user.expenseslist.Helper.FragmentNavigationManager;
import com.ak.user.expenseslist.Interface.NavigationManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity
{

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private String[] items;

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> lstTitle;
    private Map<String,List<String>> lstChild;
    private NavigationManager navigationManager;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init view

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();
        expandableListView = (ExpandableListView)findViewById(R.id.navList);
        navigationManager = FragmentNavigationManager.getmInstance(this);

        initItems();

        View listHeaderView = getLayoutInflater().inflate(R.layout.nav_header,null,false);
        expandableListView.addHeaderView(listHeaderView);

        genData();

        addDrawersItem();
        setupDrawers();

    }

    private void setupDrawers()
    {
       mDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
       {
           @Override
           public void onDrawerOpened(View drawerView)
           {
               super.onDrawerOpened(drawerView);
               getSupportActionBar().setTitle("AK");
               invalidateOptionsMenu();
           }

           @Override
           public void onDrawerClosed(View drawerView)
           {
               super.onDrawerClosed(drawerView);
               getSupportActionBar().setTitle(mActivityTitle);
               invalidateOptionsMenu();

           }
       };

       mDrawerToggle.setDrawerIndicatorEnabled(true);
       drawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void addDrawersItem()
    {

        expandableListAdapter = new CustomExpandableListAdapter(this,lstTitle,lstChild);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPos) {
                getSupportActionBar().setTitle(lstTitle.get(groupPos).toString()); //Set toolbar when open menu
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPos)
            {
                    getSupportActionBar().setTitle("AK");
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View v, int groupPos, int childPos, long l)
            {
                //Change fragment  when click on item
                String selectedItem = ((List)(lstChild.get(lstTitle.get(groupPos)))).get(childPos).toString();
                getSupportActionBar().setTitle(selectedItem);

                if(items[0].equals(lstTitle.get(groupPos)))
                {
                    navigationManager.showFragment(selectedItem);
                }
                else
                    throw new IllegalArgumentException("No supported fragnent");

                drawerLayout.closeDrawer(GravityCompat.START);


                return false;
            }
        });


    }

    private void genData()
    {
        List<String> title = Arrays.asList("Android Programing","Xamarin Programing","iOS Programing" );
        List<String> childitem = Arrays.asList("Beginner","Intermediate","Advanced","Professional");

        lstChild = new TreeMap<>();
        lstChild.put(title.get(0),childitem);
        lstChild.put(title.get(1),childitem);
        lstChild.put(title.get(2),childitem);

        lstTitle = new ArrayList<>(lstChild.keySet());


    }

    private void initItems()
    {
        items = new String[] {"Android Programing","Xamarin Programing","iOS Programing"};
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        return super.onOptionsItemSelected(item);
    }
}
