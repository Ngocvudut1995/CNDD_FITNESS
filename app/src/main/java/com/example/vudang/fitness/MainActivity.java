package com.example.vudang.fitness;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.vudang.fitness.Activity.FragmentDrawer;
import com.example.vudang.fitness.Activity.HomeFragment;
import com.example.vudang.fitness.Activity.ListExersiseFragment;
import com.example.vudang.fitness.Activity.ReminderFragment;
import com.example.vudang.fitness.Activity.SelectFragment;
import com.example.vudang.fitness.Activity.SettingFragment;
import com.example.vudang.fitness.Model.DBHandler;
import com.example.vudang.fitness.Model.MyApp;
import com.example.vudang.fitness.Model.Setting;

public class MainActivity extends AppCompatActivity  implements FragmentDrawer.FragmentDrawerListener{
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    MyApp myapp;
    boolean reminder = false;
    @Override
    protected void onStop() {
        DBHandler db = new DBHandler(this);
        Setting setting = myapp.getSetting();
        db.setSetting(setting);
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHandler db = new DBHandler(this);
        Intent intent = getIntent();
        if(intent.hasExtra("reminder"))
            this.reminder  = intent.getBooleanExtra("reminder",false);
        myapp = ((MyApp) getApplicationContext());
        myapp.setSetting(db.getSetting());
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        if(reminder == true){
            displayView(1);
        }else{
            displayView(0);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentByTag("fragBack") != null) {

        }
        else {
            super.onBackPressed();
            return;
        }
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            Toast.makeText(getApplicationContext(), "Test", Toast.LENGTH_LONG).show();
            Fragment frag = getSupportFragmentManager().findFragmentByTag("fragBack");
            FragmentTransaction transac = getSupportFragmentManager().beginTransaction().remove(frag);
            transac.commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Fragment fragment = null;
            fragment = new SettingFragment();
            String title = "Setting";
            if (fragment != null) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_body, fragment).addToBackStack("fragBack");
                fragmentTransaction.commit();
                // set the toolbar title
                getSupportActionBar().setTitle(title);
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }
    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                break;
            case 1:
                fragment = new SelectFragment();
                title = getString(R.string.title_exersise);
                break;
            case 3:
                fragment = new ReminderFragment();
                title = getString(R.string.title_reminder);
                break;
            case 2:
                fragment = new SettingFragment();
                title = getString(R.string.title_setting);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment).addToBackStack("fragBack");
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
}
