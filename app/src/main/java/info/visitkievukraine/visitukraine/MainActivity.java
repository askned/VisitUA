package info.visitkievukraine.visitukraine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById
    DrawerLayout drawerLayout;

    @ViewById
    ListView left_drawer;



    ActionBarDrawerToggle drawerToggle;




    @AfterViews
    void ready() {
        FacebookSdk.sdkInitialize(getApplicationContext());

        String[] navigationData = new String[]{
                getString(R.string.aboutus), getString(R.string.curenccyConvet), getString(R.string.metromap), getString(R.string.usefull), getString(R.string.kievmap), getString(R.string.razgovornik), getString(R.string.marshruty), getString(R.string.beforArrive)};
        ArrayAdapter<String> navigationDrawerAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, navigationData);
        left_drawer.setAdapter(navigationDrawerAdapter);
        left_drawer.setOnItemClickListener(new DrawerItemClickListener());


        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(drawerToggle);

        getFragmentManager().beginTransaction().replace(R.id.content_frame, new AboutUsFragment_()).commit();




    }
    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);

    }


    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }



    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    left_drawer.setItemChecked(position, true);
                    drawerLayout.closeDrawer(left_drawer);
                    setTitle(getString(R.string.aboutus));
                    getFragmentManager().beginTransaction().replace(R.id.content_frame, AboutUsFragment_.builder().build()).commit();
                    break;

                case 1:
                    left_drawer.setItemChecked(position, true);
                    drawerLayout.closeDrawer(left_drawer);
                    setTitle(getString(R.string.curenccyConvet));
                    getFragmentManager().beginTransaction().replace(R.id.content_frame, NbuFragment_.builder().build()).commit();
                    break;
                case 2:
                    left_drawer.setItemChecked(position, true);
                    drawerLayout.closeDrawer(left_drawer);
                    setTitle(getString(R.string.metrokiev));
                    getFragmentManager().beginTransaction().replace(R.id.content_frame, MetroFragment_.builder().build()).commit();
                    break;
                case 3:

                    left_drawer.setItemChecked(position, true);
                    drawerLayout.closeDrawer(left_drawer);
                    setTitle(getString(R.string.usefull));
                    getFragmentManager().beginTransaction().replace(R.id.content_frame, UsefullNumberFragment_.builder().build()).commit();
                    break;

                case 4:

                    left_drawer.setItemChecked(position, true);
                    drawerLayout.closeDrawer(left_drawer);
                    setTitle(getString(R.string.kievmap));

                    getFragmentManager().beginTransaction().replace(R.id.content_frame, MapFragment_.builder().build()).commit();
                    break;

                case 5:

                    left_drawer.setItemChecked(position, true);
                    drawerLayout.closeDrawer(left_drawer);
                    setTitle(getString(R.string.razgovornik));
                    getFragmentManager().beginTransaction().replace(R.id.content_frame, PhraseFragment_.builder().build()).commit();
                    break;

                case 6:

                    left_drawer.setItemChecked(position, true);
                    drawerLayout.closeDrawer(left_drawer);
                    setTitle(getString(R.string.marshruty));
                    getFragmentManager().beginTransaction().replace(R.id.content_frame, WillBeFragment_.builder().build()).commit();
                    break;

                case 7:

                    left_drawer.setItemChecked(position, true);
                    drawerLayout.closeDrawer(left_drawer);
                    setTitle(getString(R.string.beforArrive));

                    //   getFragmentManager().beginTransaction().replace(R.id.content_frame, BeforVisitFragment_.builder().build()).commit();
                    Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

}
