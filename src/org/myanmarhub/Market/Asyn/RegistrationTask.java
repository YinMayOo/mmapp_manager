package org.myanmarhub.Market.Asyn;

import org.myanmarhub.Market.HomeActivity;
import org.myanmarhub.Market.MainActivity;
import org.myanmarhub.Market.R;
import org.myanmarhub.Market.Utilities.Authenticater;
import org.myanmarhub.Market.Utilities.InternetConDetecter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

public class RegistrationTask extends AsyncTask<String, Integer, Boolean> {
	private Context mContext;
	private ProgressDialog dialog;
	private String mEmail, mPassword, mName, mStreetNo, mStreetName, mTownship, mPostCode, mCountry, mCity;
	private MainActivity mainActivity;
	
	public RegistrationTask(Context context, boolean isRemember){
		mContext = context;
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		dialog = new ProgressDialog(mContext);
		dialog.setMessage(mContext.getResources().getString(R.string.dialog_registering));
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
		mName = params[2];
		mStreetNo = params[3];
		mStreetName = params[4];
		mTownship = params[5];
		mPostCode = params[6];
		mCountry = params[7];
		mCity = params[8];
		Authenticater authen = new Authenticater(mContext);
		return authen.auth(mEmail, mPassword);
	}
	
	@Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);
		if (result == true){
			dialog.cancel();
			mContext.startActivity(new Intent(mContext,HomeActivity.class));
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
