package com.Codelabs.crimezone.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Codelabs.crimezone.R;
import com.Codelabs.crimezone.api.ApiReferences;
import com.Codelabs.crimezone.model.ModelAdapterTimeline;
import com.Codelabs.crimezone.viewholder.ViewHolderTimeline;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Alfons on 3/3/2015.
 */
public class AdapterTimeline extends RecyclerView.Adapter<ViewHolderTimeline> {

    private Context context;
    private ArrayList<ModelAdapterTimeline> item;

    public AdapterTimeline(Context context, ArrayList<ModelAdapterTimeline> item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public ViewHolderTimeline onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_timeline, parent, false);
        ViewHolderTimeline viewHolder = new ViewHolderTimeline(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderTimeline holder, int position) {
        ModelAdapterTimeline timeline = item.get(position);
        Picasso.with(context).load(ApiReferences.getUrlImage() + timeline.getIdFoto().replaceAll(" ", "%20")).into(holder.imgFotoKejahatan);
        holder.txtUser.setText(timeline.getUser());
        holder.txtTitle.setText(timeline.getTitle());
        holder.txtTglPost.setText(timeline.getTglPost());
        holder.txtAddress.setText(timeline.getAddress());
        holder.txtTagKejahatan.setText(timeline.getTagPost());
    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
