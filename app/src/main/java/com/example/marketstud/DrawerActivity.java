package com.example.marketstud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.marketstud.Fragments.Categories;
import com.example.marketstud.Fragments.Home;
import com.example.marketstud.Fragments.Profile;
import com.example.marketstud.databinding.ActivityDrawerBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.navigation.NavigationView;

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActivityDrawerBinding binding;
    GoogleSignInAccount account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showdp();
        setupdrawer();

    }

    private void setupdrawer(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,new Home());
        fragmentTransaction.commit();

        binding.menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawer.openDrawer(Gravity.LEFT);
            }
        });

        binding.navigationView.setNavigationItemSelectedListener(this);

    }

    private void showdp(){
        account = GoogleSignIn.getLastSignedInAccount(this);
        Glide.with(this).load(account.getPhotoUrl()).into(binding.profileIcon);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout,new Home());
                fragmentTransaction.commit();
                break;
            case R.id.nav_categories:
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.frame_layout,new Categories());
                fragmentTransaction1.commit();
                break;
            case R.id.nav_profile:
                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.frame_layout,new Profile());
                fragmentTransaction2.commit();
                break;

        }
        binding.drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}