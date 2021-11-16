package com.example.mpv.server;


import com.example.mpv.model.aksi.Response_aksi;
import com.example.mpv.model.tamu.Response_tamu;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiRequest {


    @FormUrlEncoded
    @POST("hapus_data.php")
    Call<Response_aksi> hapus_data(@Field("id") String id);


    @FormUrlEncoded
    @POST("simpan_data.php")
    Call<Response_aksi> add_tamu(@Field("nama_tamu") String nama_tamu,
                                 @Field("alamat") String alamat,
                                 @Field("no_telpon") String no_telpon);

    @FormUrlEncoded
    @POST("edit_data.php")
    Call<Response_aksi> edit_tamu(@Field("id") String id,
                                  @Field("nama_tamu") String nama_tamu,
                                  @Field("alamat") String alamat,
                                  @Field("no_telpon") String no_telpon);


    @GET("tampil_data.php")
    Call<Response_tamu> get_tamu();



}


