package com.example.sprintm4_tryout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragment_home, fragment_packages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_home = new home_fragment();
        fragment_packages = new viajes_fragment();

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, fragment_home).commit();

    }

    public void travelPackages(View view) {

        transaction= getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragmentContainer, fragment_packages);
        transaction.addToBackStack(null);
        transaction.commit();
        view.setVisibility(View.GONE);

    }
}