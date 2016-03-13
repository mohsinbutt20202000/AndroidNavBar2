package mohsin.com.androidnavbar2;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    String[] titles = {"Business Event", "Institute Event", "Birthday Event","Prayer Time","Family Time","Sports Time","Others",
            "Bussiness","shoping location","home location"};

    private CharSequence mTitle;
    private CharSequence mDrawerTitle;
    private Button btn1;
    CustomAdapter adapter;
    List<ItemObject> listViewItems;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar topToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = mDrawerTitle = getTitle();




        topToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);
        topToolBar.setLogoDescription(getResources().getString(R.string.logo_desc));
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.drawer_list);


        listViewItems = new ArrayList<ItemObject>();


    listViewItems.add(new ItemObject("Business Event", R.mipmap.businessevent));
    listViewItems.add(new ItemObject("Institute Event", R.mipmap.institutionevent));
    listViewItems.add(new ItemObject("Birthday Event", R.mipmap.birthdayevent));
    listViewItems.add(new ItemObject("Prayer Time", R.mipmap.namaz));
    listViewItems.add(new ItemObject("Family Time", R.mipmap.familyevent));
    listViewItems.add(new ItemObject("Sports Time", R.mipmap.sportsevent));
    listViewItems.add(new ItemObject("Others", R.mipmap.others));


  /*  listViewItems.add(new ItemObject("Others", R.mipmap.institutionevent));
    listViewItems.add(new ItemObject("Others", R.mipmap.businessevent));
    listViewItems.add(new ItemObject("Others", R.mipmap.institutionevent));*/




        adapter = new CustomAdapter(this, listViewItems);
        mDrawerList.setAdapter(adapter);


        mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            public boolean onOptionsItemSelected(MenuItem item) {
                if (item != null && item.getItemId() == android.R.id.home) {
                    if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                        mDrawerLayout.closeDrawer(Gravity.RIGHT);
                    } else {
                        mDrawerLayout.openDrawer(Gravity.RIGHT);
                    }
                }
                return false;
            }

            // Called when a drawer has settled in a completely closed state.
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
                mDrawerLayout.computeScroll();
               mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /// Called when a drawer has settled in a completely open state.
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mDrawerTitle);

                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        // Set the drawer toggle as the DrawerListener
       // mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.setDrawerIndicatorEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               // selectItemFragment(position);
                selectItem(position);
                
            }

        });
    }

public void TimebaseEvent(View v){

        if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
            mDrawerLayout.closeDrawer(mDrawerList);
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
        } else {
            mDrawerLayout.openDrawer(mDrawerList);

        }
}
    public void LocationbaseEvent(View v){

         if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
            mDrawerLayout.closeDrawer(mDrawerList);
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
        } else {
            mDrawerLayout.openDrawer(mDrawerList);

        }
    }

    private void selectItem(int position){




        setTitle(titles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
        if(position<7) {
            Intent intent = new Intent(this, Business1.class);
            intent.putExtra("position", position);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, LocationBaedEvent.class);
            intent.putExtra("position", position);
            startActivity(intent);
        }
    }

/* private void selectItemFragment(int position) {

        Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (position) {
            default:
            case 0:
                fragment = new DefaultFragment();
                break;
            case 1:
                Intent intent =new Intent(this ,Business1.class);
                intent.putExtra("position",position);
                startActivity(intent);
                break;
            case 2:
                fragment = new DefaultFragment();
                break;
           case 3:
                fragment = new DefaultFragment();
                break;
            case 4:
                fragment= new DefaultFragment();
                break;
            case 5:
                fragment = new DefaultFragment();
                break;
            case 6:
                fragment= new DefaultFragment();
                break;

        }

        fragmentManager.beginTransaction().replace(R.id.main_fragment_container, fragment).commit();

        mDrawerList.setItemChecked(position, true);
        setTitle(titles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }*/

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
       // mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
       /* if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }


}