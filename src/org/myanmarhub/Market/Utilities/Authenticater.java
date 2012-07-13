package org.myanmarhub.Market.Utilities;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class Authenticater {
	
	@SuppressWarnings("unused")
	private Context mContext;
	
	public Authenticater (Context context){
		mContext = context;
	}

	public boolean auth(String email, String password){
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    	nameValuePairs.add(new BasicNameValuePair(NetCons.User_Email,email));
    	nameValuePairs.add(new BasicNameValuePair(NetCons.User_Password,password));
    	String result = NetworkConnecter.getServerData(NetCons.loginUrl, nameValuePairs);
    	try{
    		JSONArray jArray = new JSONArray(result);
            JSONObject json_data = jArray.getJSONObject(0);
	         if (json_data.isNull(NetCons.User_Email) && json_data.isNull(NetCons.User_Email)){
	        	 return false;
	         }else{
	             return true;
	          }              
	    }catch(JSONException e){
	    }
    	return false;
	}
}
