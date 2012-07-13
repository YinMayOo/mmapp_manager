package org.myanmarhub.Market;

import java.util.Locale;

import org.myanmarhub.Market.Asyn.LoggingInTask;
import org.myanmarhub.Market.Utilities.CustomTypeFace;
import org.myanmarhub.Market.Utilities.Defaulter;
import org.myanmarhub.Market.Utilities.SystemCons;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, OnCancelListener{
	
	public SharedPreferences settingPref;
	public SharedPreferences loginPref;
	private CustomTypeFace tf;
	private String currentLocale;
	private TextView lblEmail, lblPassword, lblForget;
	private EditText txtEmail, txtPassword;
	private CheckBox chkKeep;
	private Button btnSignIn, btnCreate;
	private LoggingInTask logInTask;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//		initialize preference file
        loginPref = this.getSharedPreferences(SystemCons.Pref_login, MODE_PRIVATE);
        if (loginPref.contains(SystemCons.Pref_login_email)==true){
        	finish();
        	startActivity(new Intent(this,HomeActivity.class));
        }
        Defaulter.set(this);
        setContentView(R.layout.main);  //Display Activity
        findViews(); // find views
        currentLocale = Locale.getDefault().getDisplayLanguage();
        changeTypeFace();
    }

    /**Called to find view */
    public void findViews(){
    	lblEmail = (TextView) findViewById(R.id.main_lblEmail);
    	lblPassword = (TextView) findViewById(R.id.main_lblPassword);
    	lblForget = (TextView) findViewById(R.id.main_lblForget);
    	txtEmail = (EditText) findViewById(R.id.main_txtEmail);
    	txtPassword = (EditText) findViewById(R.id.main_txtPassword);
    	chkKeep = (CheckBox) findViewById(R.id.main_chkKeepMeLoggedIn);
    	btnSignIn = (Button) findViewById(R.id.main_btnSignIn);
    	btnSignIn.setOnClickListener(this);
    	btnCreate = (Button) findViewById(R.id.main_btnCreateAccount);
    	btnCreate.setOnClickListener(this);
    }

    /**Change font */
    public void changeTypeFace(){
    	if (currentLocale.equals(SystemCons.Locale_mm)){
        	tf = new CustomTypeFace(this);  //initialize typeFace
//        	Change font here
        	tf.setTypeFace(new EditText[]{txtEmail,txtPassword}, SystemCons.Font_Myanmar);
        	tf.setTypeFace(new TextView[]{lblEmail,lblPassword,lblForget}, SystemCons.Font_Myanmar);
        	tf.setTypeFace(new CheckBox[]{chkKeep}, SystemCons.Font_Myanmar);
        	tf.setTypeFace(new Button[]{btnCreate, btnSignIn}, SystemCons.Font_Myanmar);        	
        }
    }

	public void onClick(View v) {
		if (v.equals(btnSignIn)){
			String email = txtEmail.getText().toString();
	        String password = txtPassword.getText().toString();
			logInTask = new LoggingInTask(MainActivity.this, chkKeep.isChecked());
			logInTask.execute(email,password);
		}else if (v.equals(btnCreate)){
			finish();
			startActivity(new Intent(MainActivity.this,CreateAccountActivity.class));
		}
		
	}
	
	/** OncancelledListener for ProgressDialog in LoggingInTask */
	public void onCancel(DialogInterface dialog) {
		if (logInTask != null && logInTask.getStatus() != AsyncTask.Status.FINISHED){
			logInTask.cancel(true);
		}
	}

}