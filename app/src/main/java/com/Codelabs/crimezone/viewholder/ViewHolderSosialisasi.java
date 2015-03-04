package com.Codelabs.crimezone.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.Codelabs.crimezone.R;


public class ViewHolderSosialisasi extends RecyclerView.ViewHolder {

    public TextView txtTitle;
    public TextView txtTgl;
    public TextView txtAlamat;

    public ViewHolderSosialisasi(View itemView) {
        super(itemView);
        txtTitle = (TextView)itemView.findViewById(R.id.txt_sosialisasi_nama);
        txtTgl = (TextView)itemView.findViewById(R.id.txt_sosialisasi_tgl_kegiatan);
        txtAlamat = (TextView)itemView.findViewById(R.id.txt_sosialisasi_alamat_kegiatan);
    }
}
