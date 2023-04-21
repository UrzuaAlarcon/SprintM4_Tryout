package com.example.sprintm4_tryout.modelo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.sprintm4_tryout.NuevoPaquete;
import com.example.sprintm4_tryout.R;
import com.example.sprintm4_tryout.home_fragment;
import com.example.sprintm4_tryout.viajes_fragment;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragment_home, fragment_packages, fragment_newTravel;

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        fragment_home = new home_fragment();
        fragment_packages = new viajes_fragment(this);
        fragment_newTravel = new NuevoPaquete();

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, fragment_home).commit();
    }

    public void travelPackages(View view) {

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment_packages);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void crearViaje(View view) {

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment_newTravel);
        transaction.addToBackStack(null);
        transaction.commit();
    }





}
