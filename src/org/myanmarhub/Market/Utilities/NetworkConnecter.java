package org.myanmarhub.Market.Utilities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator.RequestorType;
import java.util.ArrayList;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.RequestProxyAuthentication;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import android.util.Log;

public class NetworkConnecter {

	public static String getServerData(String requestUrl, ArrayList<NameValuePair> nameValuePairs) {
 	   
 	   InputStream is = null;
 	   
 	   String result = "";
 	   
	 	// proxy
	 	  final String PROXY = "localhost";
	 	  // proxy host
	 	  final HttpHost PROXY_HOST = new HttpHost(PROXY, 8080);
	 	  HttpParams httpParameters = new BasicHttpParams();
	 	  DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
	 	  httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, PROXY_HOST);
	 	  RequestProxyAuthentication proxy = new RequestProxyAuthentication();
	 	  HttpCon
	 	  proxy.process(request, context)
 	   
//	 	  //http post
// 	    try{
// 	            HttpClient httpclient = new DefaultHttpClient();
// 	            HttpPost httppost = new HttpPost(requestUrl);
// 	            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
// 	            HttpResponse response = httpclient.execute(httppost);
// 	            HttpEntity entity = response.getEntity();
// 	            is = entity.getContent();

 	    }catch(Exception e){
 	            Log.e("log_tag", "Error in http connection "+e.toString());
 	    }

 	    //convert response to string
 	    try{
 	            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
 	            StringBuilder sb = new StringBuilder();
 	            String line = null;
 	            while ((line = reader.readLine()) != null) {
 	                    sb.append(line + "\n");
 	            }
 	            is.close();
 	            result=sb.toString();
 	    }catch(Exception e){
 	            Log.e("log_tag", "Error converting result "+e.toString());
 	    }
 	    
 	    return result;
 	}    
}
