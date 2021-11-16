package com.example.mpv.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mpv.R;
import com.example.mpv.model.tamu.DataItem_tamu;

import java.util.List;

public class adapter_tamu extends RecyclerView.Adapter<adapter_tamu.ViewHolder> {


    private Context ctx;
    private List<DataItem_tamu> mList ;
    private OnImageClickListener onImageClickListener;
    public adapter_tamu(Context ctx, List<DataItem_tamu> mList , OnImageClickListener onImageClickListener) {
        this.mList = mList;
        this.ctx = ctx;
        this.onImageClickListener = onImageClickListener;

    }
    public interface OnImageClickListener {
        void edit(String id,String nama_tamu,String alamat,String no_telpon);
        void hapus(String id);
    }

    @NonNull
    @Override
    public adapter_tamu.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.model_tamu, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_tamu.ViewHolder holder, int position) {

        final DataItem_tamu dm = mList.get(position);
        holder.alamat.setText(dm.getAlamat());
        holder.no_telpon.setText(dm.getNoTelpon());
        holder.nama_tamu.setText(dm.getNamaTamu());

        holder.hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickListener.hapus(dm.getId());

            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickListener.edit(dm.getId(),dm.getNamaTamu(), dm.getAlamat(), dm.getNoTelpon());

            }
        });

    }

    @Override
    public int getItemCount() {

        return mList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nama_tamu,alamat,no_telpon;
        public ImageView edit,hapus;
        public ViewHolder(View itemView) {
            super(itemView);
            this.nama_tamu = (TextView) itemView.findViewById(R.id.txt_nama);
            this.alamat = (TextView) itemView.findViewById(R.id.txt_alamat);
            this.no_telpon = (TextView) itemView.findViewById(R.id.txt_no_telpon);
            this.edit = (ImageView) itemView.findViewById(R.id.btn_edit);
            this.hapus = (ImageView) itemView.findViewById(R.id.btn_delete);
        }
    }
}
