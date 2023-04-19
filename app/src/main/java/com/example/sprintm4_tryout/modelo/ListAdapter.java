package com.example.sprintm4_tryout.modelo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sprintm4_tryout.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Elements> mData;
    private LayoutInflater mInflater;
    private Context context;


    public ListAdapter(List<Elements> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.rv_item, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems(List<Elements> items) {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView destinationImage;
        TextView destination, timeFor, price;

        ViewHolder(View itemView) {
            super(itemView);
            destinationImage = itemView.findViewById(R.id.image);
            destination = itemView.findViewById(R.id.destination);
            timeFor = itemView.findViewById(R.id.timefor);
            price = itemView.findViewById(R.id.price);
        }

        public void bindData(final Elements item) {
            Drawable d = context.getDrawable(item.getImage());
            destinationImage.setImageDrawable(d);
            destination.setText(item.getDestination());
            timeFor.setText(item.getTimeFor());
            price.setText(item.getPrice());
        }
    }
}