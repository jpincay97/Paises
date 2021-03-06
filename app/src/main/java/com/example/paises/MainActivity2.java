package com.example.paises;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navView;
    private String pais="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setHomeAsUpIndicator(R.drawable.iconmenu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navView = (NavigationView)findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);

        TextView txtPais = (TextView)findViewById(R.id.lblPais);
        Bundle bundle = this.getIntent().getExtras();
        txtPais.setText(bundle.getString("pais"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        boolean fragmentTransaction = false;

        Fragment fragment = null;
        /*switch (menuItem.getItemId()) {
            case R.id.menu_seccion_1:
                fragment = new Fragment1();
                fragmentTransaction = true;
                break;
            case R.id.menu_seccion_2:
                fragment = new Fragment2();
                fragmentTransaction = true;
                break;
            case R.id.menu_seccion_3:
                fragment = new Fragment3();
                fragmentTransaction = true;
                break;

        }*/

        if(fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();

            menuItem.setChecked(true);
            getSupportActionBar().setTitle(menuItem.getTitle());
        }
        drawerLayout.closeDrawers();
        return true;

    }
}
