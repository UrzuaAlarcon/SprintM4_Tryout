package com.example.sprintm4_tryout;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sprintm4_tryout.databinding.FragmentNuevoPaqueteBinding;
import com.example.sprintm4_tryout.modelo.Elements;

import java.util.List;

public class NuevoPaquete extends Fragment {

    private FragmentNuevoPaqueteBinding binding;

    public Button btnSaveTravel;

    List<Elements> elements2;

    private int image;
    private String destination;
    private String timeFor;
    private String price;



    public NuevoPaquete() {
        // Required empty public constructor
    }

    public NuevoPaquete(int image, String destination, String timeFortxt, String price) {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nuevo_paquete, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.destinationImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(intent,1);
            }
        });

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // saveTravel();
            }
        });
    }


    public void saveTravel(){

        image = binding.destinationImage.getImageAlpha();
        destination = binding.destinationTravel.getText().toString();
        timeFor = binding.timeForTravel.getText().toString();
        price = binding.priceTravel.getText().toString();

        Elements elements = new Elements();
        elements.setImage(image);
        elements.setDestination(destination);
        elements.setTimeFor(timeFor);
        elements.setPrice(price);


        Log.i("pruebas", "setBtnSaveTravel: ");

    }



}
