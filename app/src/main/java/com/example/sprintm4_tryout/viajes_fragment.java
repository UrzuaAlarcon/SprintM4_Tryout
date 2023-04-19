package com.example.sprintm4_tryout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.sprintm4_tryout.databinding.ViajesFragmentBinding;
import com.example.sprintm4_tryout.modelo.Elements;
import com.example.sprintm4_tryout.modelo.ListAdapter;

import java.util.ArrayList;
import java.util.List;


public class viajes_fragment extends Fragment {

    List<Elements> elements;
    private ViajesFragmentBinding binding;
    private ListAdapter miAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= ViajesFragmentBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState){
        createRecyclerView();
    }

    public void createRecyclerView() {

        elements = new ArrayList<>();
        elements.add(new Elements(1,R.drawable.cancun, "Cancun", "7 dias - 6 noches", "USD $500 Todo incluido"));
        elements.add(new Elements(2,R.drawable.copacabana, "Copacabana", "5 dias - 4 noches", "USD $700 Todo incluido"));
        elements.add(new Elements(3,R.drawable.isla_de_pascua, "Isla de Pascua", "6 dias - 5 noches", "USD $400 Todo incluido"));
        elements.add(new Elements(4,R.drawable.vi_a_del_mar, "Viña del mar", "7 dias - 6 noches", "USD $600 Todo incluido"));




        miAdapter = new ListAdapter(elements,requireContext());
      //  miAdapter.setItems(elements);
      binding.rvViajes.setAdapter(miAdapter);
    }




}