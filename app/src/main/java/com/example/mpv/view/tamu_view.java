package com.example.mpv.view;

import com.example.mpv.model.tamu.DataItem_tamu;

import java.util.List;

public interface tamu_view {
    //data tamu
    void  tamu(List<DataItem_tamu> tamu );


    //sukses
    void Success(String pesan);

    //gagal
    void gagal(String pesan);
}
