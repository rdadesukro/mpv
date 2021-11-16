package com.example.mpv.model.tamu;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response_tamu {

	@SerializedName("data")
	private List<DataItem_tamu> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public void setData(List<DataItem_tamu> data){
		this.data = data;
	}

	public List<DataItem_tamu> getData(){
		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}