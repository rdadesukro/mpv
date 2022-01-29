package com.example.mpv.presenter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.mpv.model.aksi.Response_aksi;
import com.example.mpv.model.tamu.DataItem_tamu;
import com.example.mpv.model.tamu.Response_tamu;
import com.example.mpv.server.ApiRequest;
import com.example.mpv.server.Retroserver_server;
import com.example.mpv.view.tamu_view;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class tamu {

    //new

    private Context ctx;
    private tamu_view countryView;
    private Retroserver_server countryService;
    public tamu(tamu_view view, Context ctx) {
        this.countryView = view;
        this.ctx = ctx;

        if (this.countryService == null) {
            this.countryService = new Retroserver_server();
        }
    }

    public void get_tamu() {
        ApiRequest api = Retroserver_server.getClient().create(ApiRequest.class);
        Call<Response_tamu> call = api.get_tamu();

        call.enqueue(new Callback<Response_tamu>() {
            @Override
            public void onResponse(Call<Response_tamu> call, Response<Response_tamu> response) {

                try {

                    if (response.isSuccessful()) {
                        Response_tamu data = response.body();
                        if (data != null && data.getData() != null) {
                            List<DataItem_tamu> result = data.getData();
                            countryView.tamu(result);
                        }
                    }
                } catch (Exception e) {
                    Log.i("eror_pertanyaan", "onResponse: "+e.getMessage());
                    Log.e("onResponse", "There is an error" + e);
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Response_tamu> call, Throwable t) {
                t.printStackTrace();
                Log.i("cek_error", "onFailure: " + t);
                if (t instanceof IOException) {

                    Log.i("cek_error", "onFailure: " + t);
                } else {

                    Log.i("cek_error", "onFailure: " + t);
                }
            }
        });
    }
    public void hapus_tamu(String id) {
        ProgressDialog pDialog = new ProgressDialog(ctx);
        pDialog = new ProgressDialog(ctx);
        pDialog.setTitle("Mohon Tunggu!!!");
        pDialog.setMessage("Hapus Data...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.show();
        ProgressDialog finalPDialog = pDialog;
        ApiRequest api = Retroserver_server.getClient().create(ApiRequest.class);
        Call<Response_aksi> sendbio = api.hapus_data(id);

        sendbio.enqueue(new Callback<Response_aksi>() {
            @Override
            public void onResponse(Call<Response_aksi> call, Response<Response_aksi> response) {
                try {
                    String kode = response.body().getKode();
                    String pesan = response.body().getMessage();

                    if (kode.equals("1")) {
                        finalPDialog.dismiss();
                        countryView.Success(pesan);

                    } else {
                        finalPDialog.dismiss();
                        countryView.gagal(pesan);
                    }
                }catch (Throwable e){
                    countryView.gagal(e.getMessage());
                    Toast.makeText(ctx, ""+response.code(), Toast.LENGTH_SHORT).show();
                    Log.i("cek_error_login", "onResponse: "+e);
                    finalPDialog.dismiss();
                }



            }
            @Override
            public void onFailure(Call<Response_aksi> call, Throwable t) {
                Log.e("cek_eror_login", "onFailure: "+t);

                Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
            }
        });

    }
//
    public void simpan_tamu(String nama,String alamat,String no_telpon) {
        ProgressDialog pDialog = new ProgressDialog(ctx);
        pDialog = new ProgressDialog(ctx);
        pDialog.setTitle("Mohon Tunggu!!!");
        pDialog.setMessage("Simapan Data Tamu...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.show();
        ProgressDialog finalPDialog = pDialog;
        ApiRequest api = Retroserver_server.getClient().create(ApiRequest.class);
        Call<Response_aksi> sendbio = api.add_tamu(nama,alamat,no_telpon);

        sendbio.enqueue(new Callback<Response_aksi>() {
            @Override
            public void onResponse(Call<Response_aksi> call, Response<Response_aksi> response) {
                try {
                    String kode = response.body().getKode();
                    String pesan = response.body().getMessage();

                    if (kode.equals("1")) {
                        finalPDialog.dismiss();
                        countryView.Success(pesan);

                    } else {
                        finalPDialog.dismiss();
                        countryView.gagal(pesan);
                    }
                }catch (Throwable e){
                    countryView.gagal(e.getMessage());
                    Toast.makeText(ctx, ""+response.code(), Toast.LENGTH_SHORT).show();
                    Log.i("cek_error_login", "onResponse: "+e);
                    finalPDialog.dismiss();
                }



            }
            @Override
            public void onFailure(Call<Response_aksi> call, Throwable t) {
                Log.e("cek_eror_login", "onFailure: "+t);

                Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
            }
        });

    }

    public void edit_tamu(String id,String nama,String alamat,String no_telpon) {
        ProgressDialog pDialog = new ProgressDialog(ctx);
        pDialog = new ProgressDialog(ctx);
        pDialog.setTitle("Mohon Tunggu!!!");
        pDialog.setMessage("Edit Data Tamu...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.show();
        ProgressDialog finalPDialog = pDialog;
        ApiRequest api = Retroserver_server.getClient().create(ApiRequest.class);
        Call<Response_aksi> sendbio = api.edit_tamu(id,nama,alamat,no_telpon);

        sendbio.enqueue(new Callback<Response_aksi>() {
            @Override
            public void onResponse(Call<Response_aksi> call, Response<Response_aksi> response) {
                try {
                    String kode = response.body().getKode();
                    String pesan = response.body().getMessage();

                    if (kode.equals("1")) {
                        finalPDialog.dismiss();
                        countryView.Success(pesan);

                    } else {
                        finalPDialog.dismiss();
                        countryView.gagal(pesan);
                    }
                }catch (Throwable e){
                    countryView.gagal(e.getMessage());
                    Toast.makeText(ctx, ""+response.code(), Toast.LENGTH_SHORT).show();
                    Log.i("cek_error_login", "onResponse: "+e);
                    finalPDialog.dismiss();
                }



            }
            @Override
            public void onFailure(Call<Response_aksi> call, Throwable t) {
                Log.e("cek_eror_login", "onFailure: "+t);

                Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
            }
        });

    }



    }


