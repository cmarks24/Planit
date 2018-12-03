package christian.planitappwdrawer;

import android.os.Bundle;
import android.content.Context;
import android.view.LayoutInflater;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import christian.planitappwdrawer.GroupSchedule;

public class GroupSchedule extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentPersonalSchedule.OnFragmentInteractionListener,
        FragmentEditEvent.OnFragmentInteractionListener, FragmentHomePage.OnFragmentInteractionListener,
        FragmentGroupPage.OnFragmentInteractionListener, FragmentAccountInfo.OnFragmentInteractionListener,
        FragmentGroupSchedule.OnFragmentInteractionListener {

    public static Class fragmentClass = null;
    final Context context = this;
    private Button button;
    private EditText result;
    private Button leave;
    private Button del;
    private Button del1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_schedule);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragmentClass = null;
        Fragment fragment = null;
        fragmentClass = FragmentGroupSchedule.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Going to Add Events", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.group_schedule, menu);
        return true;
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass = null;
        if (id == R.id.nav_home_page) {
            fragmentClass = FragmentHomePage.class;
        } else if (id == R.id.nav_personal_schedule) {
            fragmentClass = FragmentPersonalSchedule.class;
        } else if (id == R.id.nav_create_event) {
            fragmentClass = FragmentEditEvent.class;
            FragmentHomePage.boo = true;
        } else if (id == R.id.nav_groups_page) {
            fragmentClass = FragmentGroupPage.class;
        } else if (id == R.id.nav_account_info) {
            fragmentClass = FragmentAccountInfo.class;
        } else if (id == R.id.nav_log_out) {
            fragmentClass = FragmentLogIn.class;
        } else if (id == R.id.btnNavGrpSch){
            fragmentClass = FragmentGroupSchedule.class;
        } else if (id == R.id.fab){
            fragmentClass = FragmentEditEvent.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
