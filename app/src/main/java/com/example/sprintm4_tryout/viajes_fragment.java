package com.example.sprintm4_tryout;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.sprintm4_tryout.database.AppDatabase;
import com.example.sprintm4_tryout.databinding.ViajesFragmentBinding;
import com.example.sprintm4_tryout.modelo.Elements;
import com.example.sprintm4_tryout.modelo.ListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class viajes_fragment extends Fragment {

    List<Elements> elements;

    private ViajesFragmentBinding binding;
    private ListAdapter miAdapter;

    private Context context1;
    public viajes_fragment(Context context) {
        context1 = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= ViajesFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState){
        createRecyclerView();
    }

    public void createRecyclerView() {



        elements = new ArrayList<>();
        /*elements.add(new Elements(1,R.drawable.cancun, "Cancun", "7 dias - 6 noches", "USD $500 Todo incluido"));
        elements.add(new Elements(2,R.drawable.copacabana, "Copacabana", "5 dias - 4 noches", "USD $700 Todo incluido"));
        elements.add(new Elements(3,R.drawable.isla_de_pascua, "Isla de Pascua", "6 dias - 5 noches", "USD $400 Todo incluido"));
        elements.add(new Elements(4,R.drawable.vi_a_del_mar, "Viña del mar", "7 dias - 6 noches", "USD $600 Todo incluido"));*/


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {

                // Insertar el animal y su ficha en la base de datos
                elements = AppDatabase.getDatabase(requireContext()).daoElements().obtenerElementos();
                Log.i("pruebas", "setBtnSaveTravel: " + elements);

             //    new Handler(Looper.getMainLooper()).post(() -> miAdapter.notifyDataSetChanged());

            }

        });
        try {
            executorService.awaitTermination(2000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {

        }
        miAdapter = new ListAdapter(elements,requireContext());
       // miAdapter.setItems(elements);
      //  miAdapter.setItems(elements);
      binding.rvViajes.setAdapter(miAdapter);
        miAdapter.setItems(elements);
        miAdapter.update();
    }




}