package com.ieeecs.arcs20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;
    private ImageView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        button = findViewById(R.id.drawer_button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        if(savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_Home);
            button.setImageResource(R.drawable.ic_sort);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_Home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                button.setImageResource(R.drawable.ic_sort);
                break;
            case R.id.nav_workshop:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new WorkshopFragment()).commit();
                button.setImageResource(R.drawable.ic_sort_white);
                break;
            case R.id.nav_hackbattle:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new hackbattleFragment()).commit();
                button.setImageResource(R.drawable.ic_sort_white);
                break;
            case R.id.nav_timeline:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentTimeLine()).commit();
                button.setImageResource(R.drawable.ic_sort);
                break;
            case R.id.nav_developers:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DevelopersFragment()).commit();
                button.setImageResource(R.drawable.ic_sort);
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();
                button.setImageResource(R.drawable.ic_sort_white);

                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void  onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
