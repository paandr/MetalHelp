package com.gmail.gorbaserver.metalhelp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gmail.gorbaserver.metalhelp.classes.DBMetal;
import com.gmail.gorbaserver.metalhelp.tabletheory.ArmaturaFragment;
import com.gmail.gorbaserver.metalhelp.tabletheory.KrugFragment;
import com.gmail.gorbaserver.metalhelp.tabletheory.KvadratFragment;
import com.gmail.gorbaserver.metalhelp.tabletheory.ListFragment;
import com.gmail.gorbaserver.metalhelp.tabletheory.TableTheoryStartFragment;
import com.gmail.gorbaserver.metalhelp.tabletheory.TrubaProfilFragment;

public class TableTheoryActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DBMetal dbMetal;

    FragmentTransaction fragmentTransaction;

    private static final String KEY_ACTIONBAR_TITLE = "actionBarTitle";

    MenuItem prevPressedItem = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_theory);

        //
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        fab.setVisibility(View.GONE);

        //
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //
        // Build navigation menu
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        dbMetal = new DBMetal(this);
        dbMetal.open();


        // Hide header
        View v = navigationView.getHeaderView(0);
        v.setVisibility(View.GONE);

        //
    getSupportActionBar().setTitle("");
    fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.add(R.id.fragmentContainerTableTheory,new TableTheoryStartFragment()).commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_ACTIONBAR_TITLE, String.valueOf(getSupportActionBar().getTitle()));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String actionBarValue = savedInstanceState.getString(KEY_ACTIONBAR_TITLE);
        if (savedInstanceState != null && actionBarValue != null){
            getSupportActionBar().setTitle(actionBarValue);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbMetal.close();
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
        //getMenuInflater().inflate(R.menu.table_theory, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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

        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (item.getItemId()){
            case R.id.nav_armatura:
                getSupportActionBar().setTitle(getString(R.string.type_armatura));
                fragmentTransaction.replace(R.id.fragmentContainerTableTheory,new ArmaturaFragment());
                break;
            case R.id.nav_krug:
                getSupportActionBar().setTitle(getString(R.string.type_krug));
                fragmentTransaction.replace(R.id.fragmentContainerTableTheory,new KrugFragment());
                break;

            case R.id.nav_list:
                getSupportActionBar().setTitle(getString(R.string.type_list));
                fragmentTransaction.replace(R.id.fragmentContainerTableTheory,new ListFragment());
                break;

            case R.id.nav_truba_profilnaya:
                getSupportActionBar().setTitle(getString(R.string.type_truba_profilnaya));
                fragmentTransaction.replace(R.id.fragmentContainerTableTheory,new TrubaProfilFragment());
                break;
            case R.id.nav_kvadrat:
                getSupportActionBar().setTitle(getString(R.string.type_kvadrat));
                fragmentTransaction.replace(R.id.fragmentContainerTableTheory,new KvadratFragment());
                break;

            default:
                break;
        }

        fragmentTransaction.commit();


        //
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
