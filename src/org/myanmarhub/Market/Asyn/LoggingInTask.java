package org.myanmarhub.Market.Asyn;

import org.myanmarhub.Market.HomeActivity;
import org.myanmarhub.Market.MainActivity;
import org.myanmarhub.Market.R;
import org.myanmarhub.Market.Utilities.Authenticater;
import org.myanmarhub.Market.Utilities.InternetConDetecter;
import org.myanmarhub.Market.Utilities.SystemCons;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.widget.Toast;

public class LoggingInTask extends AsyncTask<String, Integer, Boolean>{
	
	private Context mContext;
	private ProgressDialog dialog;
	private boolean mIsRemeber = false;
	private String mEmail, mPassword;
	private MainActivity mainActivity;
	
	public LoggingInTask(Context context, boolean isRemember){
		mContext = context;
		mIsRemeber = isRemember;
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		dialog = new ProgressDialog(mContext);
		dialog.setMessage(mContext.getResources().getString(R.string.dialog_logging_in));
		dialog.setCancelable(false);
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		dialog.show();
		InternetConDetecter detecter = new InternetConDetecter(mContext);
		if(detecter.isNetworkAvailable()==false){
			dialog.setOnCancelListener(mainActivity);
			dialog.cancel();
			Toast.makeText(mContext, mContext.getResources().getString(R.string.no_internet), Toast.LENGTH_LONG).show();
		}
	}
	
	@Override
	protected Boolean doInBackground(String... params) {
		mEmail = params[0];
		mPassword = params[1];
		Authenticater authen = new Authenticater(mContext);
		return authen.auth(mEmail, mPassword);
	}
	
	@Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);
		if (result == true){
			dialog.cancel();
			mContext.startActivity(new Intent(mContext,HomeActivity.class));
			if (mIsRemeber){
				SharedPreferences loginPref = mContext.getSharedPreferences(SystemCons.Pref_login,Context.MODE_PRIVATE);
				Editor edit = loginPref.edit();
				edit.putString(SystemCons.Pref_login_email, mEmail);
				edit.putString(SystemCons.Pref_login_password, mPassword);
				edit.commit();
			}
		}else{
			dialog.cancel();
		}
	}
	
	@Override
	protected void onCancelled() {
		super.onCancelled();
		dialog.cancel();
	}
	

}
