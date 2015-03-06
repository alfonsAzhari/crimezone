package com.Codelabs.crimezone.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Codelabs.crimezone.R;
import com.Codelabs.crimezone.model.ModelAdapterSosialisasi;
import com.Codelabs.crimezone.viewholder.ViewHolderSosialisasi;

import java.util.ArrayList;

public class AdapterSosialisasi extends RecyclerView.Adapter<ViewHolderSosialisasi> {

    private Context context;
    private ArrayList<ModelAdapterSosialisasi> item;

    public AdapterSosialisasi(Context context, ArrayList<ModelAdapterSosialisasi> item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public ViewHolderSosialisasi onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_sosialisasi, parent, false);
        ViewHolderSosialisasi viewHolder = new ViewHolderSosialisasi(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderSosialisasi holder, int position) {
        ModelAdapterSosialisasi sosialisasi = item.get(position);
        holder.txtTitle.setText(sosialisasi.getTitle());
        holder.txtTgl.setText(sosialisasi.getTgl());
        holder.txtAlamat.setText(sosialisasi.getAlamat());
    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
