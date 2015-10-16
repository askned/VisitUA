package info.visitkievukraine.visitukraine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @ViewById
    Toolbar toolbar;

    @ViewById
    DrawerLayout drawerLayout;


    @ViewById
    android.support.design.widget.FloatingActionButton fab;

    @AfterViews
    void ready() {
        FacebookSdk.sdkInitialize(getApplicationContext());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        getFragmentManager().beginTransaction().replace(R.id.content_frame, new AboutUsFragment_()).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

        AppEventsLogger.activateApp(this);

    }


    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        fab.setVisibility(View.INVISIBLE);
        int id = item.getItemId();

        if (id == R.id.nav_aboutus) {
            setTitle(getString(R.string.aboutus));
            getFragmentManager().beginTransaction().replace(R.id.content_frame, AboutUsFragment_.builder().build()).commit();
            fab.setVisibility(View.VISIBLE);
            // Handle the camera action
        } else if (id == R.id.nav_beforArrive) {
            Intent intent = new Intent(MainActivity.this, ScrollingActivity_.class);
            startActivity(intent);
            setTitle(getString(R.string.beforArrive));
        } else if (id == R.id.nav_curenccyConvet) {
            setTitle(getString(R.string.curenccyConvet));
                    getFragmentManager().beginTransaction().replace(R.id.content_frame, NbuFragment_.builder().build()).commit();

        } else if (id == R.id.nav_metromap) {
            setTitle(getString(R.string.metrokiev));
                    getFragmentManager().beginTransaction().replace(R.id.content_frame, MetroFragment_.builder().build()).commit();

        } else if (id == R.id.nav_usefull) {
            setTitle(getString(R.string.usefull));
            getFragmentManager().beginTransaction().replace(R.id.content_frame, UsefullNumberFragment_.builder().build()).commit();

        } else if (id == R.id.nav_kievmap) {
            setTitle(getString(R.string.kievmap));
                    getFragmentManager().beginTransaction().replace(R.id.content_frame, MapFragment_.builder().build()).commit();

        } else if (id == R.id.nav_razgovornik) {
            setTitle(getString(R.string.razgovornik));
            getFragmentManager().beginTransaction().replace(R.id.content_frame, PhraseFragment_.builder().build()).commit();

        } else if (id == R.id.nav_marshruty) {
            setTitle(getString(R.string.marshruty));
            getFragmentManager().beginTransaction().replace(R.id.content_frame, MapItemFragment_.builder().build()).commit();

    }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {getString(R.string.emailsend)};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subdject));
        emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_text));

        startActivity(Intent.createChooser(emailIntent,
                getString(R.string.send_mail)));
    }


    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
    }

    public void onClickTopTen(View view) {
        getFragmentManager().beginTransaction().replace(R.id.content_frame, TopTenFragment_.builder().build()).commit();

    }
}

