package org.myanmarhub.Market;

import org.myanmarhub.Market.Utilities.AccountCreater;
import org.myanmarhub.Market.Utilities.CustomTypeFace;
import org.myanmarhub.Market.Utilities.Defaulter;
import org.myanmarhub.Market.Utilities.SystemCons;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateAccountActivity extends Activity implements OnClickListener{
	
	public SharedPreferences settingPref;
	private TextView lblName, lblEmail, lblPassword, lblConfirmPassword, lblStreetNo, lblStreetName, lblTownship,
					 lblPostCode, lblCountry, lblCity;
	private EditText txtName, txtEmail, txtPassword, txtConfirmPassword, txtStreetNo, txtStreetName, txtTownship,txtCountry,
					 txtPostCode, txtCity;
	private Button btnCreate, btnCancel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Defaulter.set(this);
		setContentView(R.layout.create_account);
		findViews();
		CustomTypeFace ty = new CustomTypeFace(this);
		ty.setTypeFace(new Button[]{btnCancel,btnCreate},SystemCons.Font_Myanmar);
		ty.setTypeFace(new TextView[]{lblName, lblEmail, lblPassword, lblConfirmPassword, lblStreetNo, lblStreetName, lblTownship,
				 					  lblPostCode, lblCountry, lblCity},SystemCons.Font_Myanmar);
		ty.setTypeFace(new EditText[]{txtName, txtEmail, txtPassword, txtConfirmPassword, txtStreetNo, txtStreetName, txtTownship,
				 					  txtPostCode, txtCity},SystemCons.Font_Myanmar);
		
	}

	private void findViews(){
		lblName = (TextView) findViewById(R.id.ca_lblName);
		lblEmail = (TextView) findViewById(R.id.ca_lblEmail);
		lblPassword = (TextView) findViewById(R.id.ca_lblPassword);
		lblConfirmPassword = (TextView) findViewById(R.id.ca_lblConfirmPassword);
		lblCountry = (TextView) findViewById(R.id.ca_lblCountry);
		lblStreetNo = (TextView) findViewById(R.id.ca_lblStreetNo);
		lblStreetName = (TextView) findViewById(R.id.ca_lblStreetName);
		lblTownship = (TextView) findViewById(R.id.ca_lblTownship);
		lblPostCode = (TextView) findViewById(R.id.ca_lblPostCode);
		lblCity = (TextView) findViewById(R.id.ca_lblCity);
		
		txtName = (EditText) findViewById(R.id.ca_txtName);
		txtEmail = (EditText) findViewById(R.id.ca_txtEmail);
		txtPassword = (EditText) findViewById(R.id.ca_txtPassword);
		txtConfirmPassword = (EditText) findViewById(R.id.ca_txtConfirmPassword);
		txtCountry = (EditText) findViewById(R.id.ca_txtCountry);
		txtStreetNo = (EditText) findViewById(R.id.ca_txtStreetNo);
		txtStreetName = (EditText) findViewById(R.id.ca_txtStreetName);
		txtTownship = (EditText) findViewById(R.id.ca_txtTownship);
		txtPostCode = (EditText) findViewById(R.id.ca_txtPostCode);
		txtCity = (EditText) findViewById(R.id.ca_txtCity);
		
		btnCreate = (Button) findViewById(R.id.ca_btnCreate);
		btnCreate.setOnClickListener(this);
		btnCancel = (Button) findViewById(R.id.ca_btnCancel);
		btnCancel.setOnClickListener(this);
	}
		
	public void onClick(View v) {
		if (v.equals(btnCreate)){
			String name = txtName.getText().toString();
			String email = txtEmail.getText().toString();
			String password = txtPassword.getText().toString();
			String confirmPassword = txtConfirmPassword.getText().toString();
			String streetNo = txtStreetNo.getText().toString();
			String streetName = txtStreetName.getText().toString();
			String postCode = txtPostCode.getText().toString();
			String country = txtCountry.getText().toString();
			String township = txtTownship.getText().toString();
			String city = txtCity.getText().toString();
			
			if (name == null || name.length() == 0){
				txtName.setHint(CreateAccountActivity.this.getResources().getString(R.string.ca_hint_name));
				txtName.setHintTextColor(Color.RED);
			}else if (email == null || email.length() == 0){
				txtEmail.setHint(CreateAccountActivity.this.getResources().getString(R.string.ca_hint_email));
				txtEmail.setHintTextColor(Color.RED);
			}else if (password == null || password.length() == 0){
				txtPassword.setHint(CreateAccountActivity.this.getResources().getString(R.string.ca_hint_password));
				txtPassword.setHintTextColor(Color.RED);
			}else if (confirmPassword == null || confirmPassword.length() == 0){
				txtConfirmPassword.setHint(CreateAccountActivity.this.getResources().getString(R.string.ca_hint_confirmpassword));
				txtConfirmPassword.setHintTextColor(Color.RED);
			}else if (password.equals(confirmPassword) == false){
				txtPassword.setHint(CreateAccountActivity.this.getResources().getString(R.string.ca_hint_password));
				txtPassword.setHintTextColor(Color.RED);
				txtConfirmPassword.setHint(CreateAccountActivity.this.getResources().getString(R.string.ca_hint_confirmpassword));
				txtConfirmPassword.setHintTextColor(Color.RED);
			}else if (streetNo == null || streetNo.length() == 0){
				txtStreetNo.setHint(CreateAccountActivity.this.getResources().getString(R.string.ca_hint_streetno));
				txtStreetNo.setHintTextColor(Color.RED);
			}else if (streetName == null || streetName.length() == 0){
				txtStreetName.setHint(CreateAccountActivity.this.getResources().getString(R.string.ca_hint_streetname));
				txtStreetName.setHintTextColor(Color.RED);
			}else if (township == null || township.length() == 0){
				txtTownship.setHint(CreateAccountActivity.this.getResources().getString(R.string.ca_hint_township));
				txtTownship.setHintTextColor(Color.RED);
			}else if (city == null || city.length() == 0){
				txtCity.setHint(CreateAccountActivity.this.getResources().getString(R.string.ca_hint_city));
				txtCity.setHintTextColor(Color.RED);
			}else  if (country == null || country.length() == 0){
				txtCountry.setHint(CreateAccountActivity.this.getResources().getString(R.string.ca_hint_country));
				txtCountry.setHintTextColor(Color.RED);
			}else{
				AccountCreater creater = new AccountCreater(CreateAccountActivity.this);
				creater.create(email, password, name, streetNo, streetName, township, city, postCode, country);
			}			
		}else if (v.equals(btnCancel)){
			finish();
			startActivity(new Intent(CreateAccountActivity.this, MainActivity.class));
		}
	}
}
