package com.example.mpv.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mpv.R;
import com.example.mpv.adapter.adapter_tamu;
import com.example.mpv.model.tamu.DataItem_tamu;
import com.example.mpv.presenter.tamu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class menu_tamu extends AppCompatActivity implements tamu_view, adapter_tamu.OnImageClickListener {

    private ImageView imgData3;
    private TextView txtData3;
    private SwipeRefreshLayout swifeRefresh;
    private RecyclerView rvAku;
    private ProgressBar progressBar4;

    com.example.mpv.presenter.tamu tamu;
    private adapter_tamu adapter_tamu;
    private FloatingActionButton btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tamu);
        initView();
        tamu = new tamu(this, menu_tamu.this);
        tamu.get_tamu();


        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_data("baru","","","","");

            }
        });


        swifeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                tamu.get_tamu();
            }
        });
    }

    @Override
    public void tamu(List<DataItem_tamu> tamu) {
        try {
            adapter_tamu = new adapter_tamu(this, tamu, this);
            rvAku.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            rvAku.setHasFixedSize(true);
            adapter_tamu.notifyDataSetChanged();
            rvAku.setAdapter(adapter_tamu);
            swifeRefresh.setRefreshing(false);
            if (tamu.size() == 0) {
                progressBar4.setVisibility(View.VISIBLE);
            } else {
                progressBar4.setVisibility(View.GONE);
            }
        } catch (Exception e) {

        }
    }


    @Override
    public void Success(String pesan) {
        Toast.makeText(this, "" + pesan, Toast.LENGTH_SHORT).show();
        tamu.get_tamu();

    }

    @Override
    public void gagal(String pesan) {
        Toast.makeText(this, "" + pesan, Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        imgData3 = findViewById(R.id.img_data3);
        txtData3 = findViewById(R.id.txt_data3);
        swifeRefresh = findViewById(R.id.swifeRefresh);
        rvAku = findViewById(R.id.rv_aku);
        progressBar4 = findViewById(R.id.progressBar4);
        btnAddData = findViewById(R.id.btn_add_data);
    }

    @Override
    public void edit(String id, String nama_tamu, String alamat,String no_telpon) {
        add_data("edit",id,nama_tamu,alamat,no_telpon);

    }

    @Override
    public void hapus(String id) {
        hapus_data(id);
    }


    void hapus_data(String id_tamu) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Yakin Hapus Data?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        tamu.hapus_tamu(id_tamu);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();


    }

    void add_data(String jenis,String id_tamu,String nama,String alamat,String no_telpon) {
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.activity_add_edit, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText edit_nama = (EditText) promptsView.findViewById(R.id.edit_nama);
        final EditText edit_alamat = (EditText) promptsView.findViewById(R.id.edit_alamat);
        final EditText edit_no_telpon = (EditText) promptsView.findViewById(R.id.edit_no_telpon);

        if (jenis.equals("edit")){
            edit_nama.setText(nama);
            edit_alamat.setText(alamat);
            edit_no_telpon.setText(no_telpon);
        }


        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                final String nama = edit_nama.getText().toString().trim();
                                final  String alamat = edit_alamat.getText().toString().trim();
                                final  String no_telpon = edit_no_telpon.getText().toString().trim();
                                if (jenis.equals("baru")){
                                    tamu.simpan_tamu(nama,alamat,no_telpon);
                                }else {
                                    tamu.edit_tamu(id_tamu,nama,alamat,no_telpon);

                                }


                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}