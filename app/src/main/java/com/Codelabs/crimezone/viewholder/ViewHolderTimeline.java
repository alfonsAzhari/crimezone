package com.Codelabs.crimezone.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Codelabs.crimezone.R;


public class ViewHolderTimeline extends RecyclerView.ViewHolder {

    public TextView txtUser;
    public TextView txtAddress;
    public TextView txtTglPost;
    public ImageView imgFotoKejahatan;
    public TextView txtTagKejahatan;
    public TextView txtTitle;

    public ViewHolderTimeline(View itemView) {
        super(itemView);
        txtUser = (TextView)itemView.findViewById(R.id.txt_user_timeline);
        txtAddress = (TextView)itemView.findViewById(R.id.txt_address_post_timeline);
        txtTglPost = (TextView)itemView.findViewById(R.id.txt_tgl_post_timeline);
        imgFotoKejahatan = (ImageView)itemView.findViewById(R.id.img_timeline);
        txtTagKejahatan = (TextView)itemView.findViewById(R.id.txt_tag_timeline);
        txtTitle = (TextView)itemView.findViewById(R.id.txt_title_timeline);
    }
}
