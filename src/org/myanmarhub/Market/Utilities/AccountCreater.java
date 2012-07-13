package org.myanmarhub.Market.Utilities;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.widget.Toast;

public class AccountCreater {

	private Context mContext;
	
	public AccountCreater (Context context){
		mContext = context;
	}

	public boolean create(String email, String password, String name, String streetNo, String streetName,
						  String township,String city, String postCode, String country){
		
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    	nameValuePairs.add(new BasicNameValuePair(NetCons.User_Email,email));
    	nameValuePairs.add(new BasicNameValuePair(NetCons.User_Password,password));
    	nameValuePairs.add(new BasicNameValuePair(NetCons.User_Name,name));
    	nameValuePairs.add(new BasicNameValuePair(NetCons.User_StreetName,streetName));
    	nameValuePairs.add(new BasicNameValuePair(NetCons.User_StreetNo,streetNo));
    	nameValuePairs.add(new BasicNameValuePair(NetCons.User_Township,township));
    	nameValuePairs.add(new BasicNameValuePair(NetCons.User_PostCode,postCode));
    	nameValuePairs.add(new BasicNameValuePair(NetCons.User_Country,country));
    	nameValuePairs.add(new BasicNameValuePair(NetCons.User_City,city));
    	
    	String result = NetworkConnecter.getServerData(NetCons.registerUrl, nameValuePairs);
//    	try{
//    		JSONArray jArray = new JSONArray(result);
//            JSONObject json_data = jArray.getJSONObject(0);
//	         if (json_data.isNull(NetCons.User_Email) && json_data.isNull(NetCons.User_Email)){
//	        	 return false;
//	         }else{
//	             return true;
//	          }              
//	    }catch(JSONException e){
//	    }
    	Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
    	return false;
	}
}
