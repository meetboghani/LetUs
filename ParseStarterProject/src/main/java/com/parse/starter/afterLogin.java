package com.parse.starter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.parse.ParseUser;

public class afterLogin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView home_img;
    ImageView profile;
    ImageView add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        home_img=findViewById(R.id.menu_img);
        profile= (ImageView) findViewById(R.id.profileImg);
        add=findViewById(R.id.Add_icon);



        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.Navigation_View);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(afterLogin.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        add.setOnClickListener(this);
        navigationDrawer();

    }

    private void navigationDrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        home_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else{
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });



        animateNavigationDrawer();
    }

    public void animateNavigationDrawer(){


    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.nav_logout: {
                ParseUser.logOut();
                Intent intent = new Intent(afterLogin.this, loginActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.nav_add: {
                Intent intent = new Intent(afterLogin.this, userReqActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.nav_profile:
            {
                Intent intent=new Intent(afterLogin.this,ProfileActivity.class);
                startActivity(intent);
                break;
            }

        }

        return true;
    }



    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.Add_icon){
            Intent intent=new Intent(afterLogin.this,userReqActivity.class);
            startActivity(intent);

        }
    }
}