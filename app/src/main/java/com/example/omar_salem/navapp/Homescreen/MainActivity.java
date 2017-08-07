package com.example.omar_salem.navapp.Homescreen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.omar_salem.navapp.Books.Cs;
import com.example.omar_salem.navapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ClickListener {
    private Toolbar toolbar;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Datamodel> data;
    public static boolean isActive() {
        return active;
    }

    static boolean active = false;

    @Override
    public void onStart() {
        super.onStart();
        active = true;
        Toast.makeText(this,"Welcome in M Activity ",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        active = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CreatingToolBar();

        DrawLayOutOnScreen();
        recyclerView = (RecyclerView) findViewById(R.id.rec_id);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        data=new ArrayList<Datamodel>();
        for (int i=0;i<Mydata.desc.length;i++){
            data.add( new Datamodel(
                    Mydata.head[i],
                    Mydata.desc[i],
                    Mydata.image[i]

            ));
        }
        adapter=new Myadapter(data,getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void itemClicked(View view, int position) {

        if(position==1)
        {
            Intent intent = new Intent(MainActivity.this, Cs.class);
            intent.putExtra("ItemPosition", position);
            startActivity(intent);
        }
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.cs_video) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=k6U-i4gXkLM&t=4s")));
        } else if (id == R.id.is_video) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=XxRtJrb62Cg")));

        } else if (id == R.id.it_video) {

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=V6zJi8CU7Tk")));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

   private void CreatingToolBar(){

        toolbar = (Toolbar) findViewById(R.id.toolbar);
       toolbar.setTitle("HasebatBooks");
        setSupportActionBar(toolbar);
    }
    private void DrawLayOutOnScreen()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

}
