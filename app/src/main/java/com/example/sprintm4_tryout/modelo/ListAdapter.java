package com.example.sprintm4_tryout.modelo;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.sprintm4_tryout.R;
import com.example.sprintm4_tryout.database.AppDatabase;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    //Atributos globales de caracter estructural
    private LayoutInflater mInflater;
    private Context context;
    private List<Elements> mData;

    //constructor
    public ListAdapter(List<Elements> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    //Metodo que retorna el largo de la lista de datos
    @Override
    public int getItemCount() {
        return mData.size();
    }

    //creador del ViewHolder
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.rv_item, null);
        return new ListAdapter.ViewHolder(view); //retorna la vista
    }

    //Metodo que actualiza la vista de los elementos
    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems(List<Elements> items) {
        mData = items;
    }

    //Metodo que notifica al RecycleView de los cambios realizados
    public void update(){
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Atributos que contiene la vista del VieHolder
        ImageView destinationImage;
        TextView destination, timeFor, price;

        //Vista del ViewHolder
        ViewHolder(View itemView) {
            super(itemView);
            destinationImage = itemView.findViewById(R.id.image);
            destination = itemView.findViewById(R.id.destination);
            timeFor = itemView.findViewById(R.id.timefor);
            price = itemView.findViewById(R.id.price);
        }

        //Paso de los elementos al ViewHolder
        public void bindData(final Elements item) {


            destinationImage.setImageURI(Uri.parse(item.getImage()));
            destination.setText(item.getDestination());
            timeFor.setText(item.getTimeFor());
            price.setText(item.getPrice());
        }

    }
}