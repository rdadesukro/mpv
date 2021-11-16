package com.example.mpv.model.tamu;

import com.google.gson.annotations.SerializedName;

public class DataItem_tamu {

	@SerializedName("nama_tamu")
	private String namaTamu;

	@SerializedName("id")
	private String id;

	@SerializedName("no_telpon")
	private String noTelpon;

	@SerializedName("alamat")
	private String alamat;

	public void setNamaTamu(String namaTamu){
		this.namaTamu = namaTamu;
	}

	public String getNamaTamu(){
		return namaTamu;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setNoTelpon(String noTelpon){
		this.noTelpon = noTelpon;
	}

	public String getNoTelpon(){
		return noTelpon;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"nama_tamu = '" + namaTamu + '\'' + 
			",id = '" + id + '\'' + 
			",no_telpon = '" + noTelpon + '\'' + 
			",alamat = '" + alamat + '\'' + 
			"}";
		}
}