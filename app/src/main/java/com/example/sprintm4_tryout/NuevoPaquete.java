package com.example.sprintm4_tryout;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sprintm4_tryout.database.AppDatabase;
import com.example.sprintm4_tryout.database.DaoElements;
import com.example.sprintm4_tryout.databinding.FragmentNuevoPaqueteBinding;
import com.example.sprintm4_tryout.modelo.Elements;

import java.net.URI;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NuevoPaquete extends Fragment {

    private FragmentNuevoPaqueteBinding binding;

    public Button btnSaveTravel;

    private Context context;

    List<Elements> elements;

    private Uri image;
    private String destination;
    private String timeFor;
    private String price;

    Uri imageUri;



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
        context = getContext();
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
                saveTravel();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            binding.destinationImage.setImageURI(imageUri);
        }
    }


    public void saveTravel(){

        AppDatabase db = AppDatabase.getDatabase(context);
        DaoElements daoElements = db.daoElements();

        image = imageUri;
        destination = binding.destinationTravel.getText().toString();
        timeFor = binding.timeForTravel.getText().toString();
        price = binding.priceTravel.getText().toString();

        Elements elements = new Elements();
        elements.setImage(image.toString());
        elements.setDestination(destination);
        elements.setTimeFor(timeFor);
        elements.setPrice(price);

        //daoElements.insertarElemento(elements);


        Log.i("pruebas", "setBtnSaveTravel: ");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {

                // Insertar el animal y su ficha en la base de datos
                long idElemento = daoElements.insertarElemento(elements); // Insertar el animal en la tabla

                Log.i("insertar", "insertar: ");


            }

        });

    }



}
