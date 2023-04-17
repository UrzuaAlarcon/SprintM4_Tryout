package com.example.sprintm4_tryout;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.sprintm4_tryout.databinding.FragmentNuevoPaqueteBinding;
import com.example.sprintm4_tryout.databinding.ViajesFragmentBinding;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

public class NuevoPaquete extends Fragment {

    private FragmentNuevoPaqueteBinding binding;

    public Button btnSaveTravel;



    public NuevoPaquete() {
        // Required empty public constructor
    }

    public NuevoPaquete(String destination, String timeFortxt, String price) {
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            binding.destinationImage.setImageURI(uri);
        }
    }
    public interface nuevoPaqueteListener {
        void onDatosNuevoPaqueteIngresados(NuevoPaquete datos);
    }
   private nuevoPaqueteListener listener;

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        try {
            listener = (nuevoPaqueteListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "debe implementar la clase nuevoPaqueteListener");
        }
    }

    public void saveTravel(){

        int image = binding.destinationImage.getImageAlpha();
        String destination = binding.destinationTravel.getEditableText().toString();
        String timeFortxt = binding.timeForTravel.getEditableText().toString();
        String price = binding.priceTravel.getEditableText().toString();
        //NuevoPaquete nuevoPaquete = new NuevoPaquete(image, destination, timeFortxt, price);
        //listener.onDatosNuevoPaqueteIngresados(nuevoPaquete);

        Log.i("pruebas", "setBtnSaveTravel: ");

    }

}
