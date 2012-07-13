package org.myanmarhub.Market.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Defaulter {
	
	public static SharedPreferences settingPref;
	
	public static void set(Context context){
		 settingPref = context.getSharedPreferences(SystemCons.Pref_defaultSetting, Context.MODE_PRIVATE);
//			check if defaultSettings is already applied
	     if (settingPref.contains(SystemCons.Pref_defaultSetting_locale)==false){
	        //initialize settings with default value.
	        Editor editor = settingPref.edit();
	        editor.putString("locale", "mm");
	        editor.commit();
	       }
//	      Set Default Language
	        LocaleLoader.load(context,settingPref.getString(SystemCons.Pref_defaultSetting_locale,"mm"));
	}
}
