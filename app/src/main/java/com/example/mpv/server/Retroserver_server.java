package com.example.mpv.server;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Retroserver_server {
    private  static  final String base_url = "http://10.1.4.63//pemograman_mobile/";

    private static Retrofit retrofit;
    public static Retrofit getClient()
    {
        if(retrofit == null)
        {
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(5, TimeUnit.SECONDS)
                    .readTimeout(5, TimeUnit.SECONDS)
                    .writeTimeout(5, TimeUnit.SECONDS)
                    .build();
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }


}
