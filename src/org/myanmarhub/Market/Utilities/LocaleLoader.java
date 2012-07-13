package org.myanmarhub.Market.Utilities;

import java.util.Locale;

import android.content.Context;
import android.content.res.Configuration;

public class LocaleLoader {

	//Change the locale at the start depending on the user setting
	public static void load(Context context, String languageToLoad){
	    //Check if the locale is system default
	    if (Locale.getDefault().getDisplayLanguage().equals(languageToLoad)==false){
	    	Locale locale = new Locale(languageToLoad); 
	 	    Locale.setDefault(locale);
	    	Configuration config = new Configuration();
	 	    config.locale = locale;
	 	    context.getResources().updateConfiguration(config, 
	 	    		context.getResources().getDisplayMetrics());
	    }	   
	}
}
