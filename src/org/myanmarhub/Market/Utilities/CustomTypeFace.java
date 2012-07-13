package org.myanmarhub.Market.Utilities;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class CustomTypeFace {

	private Context mContext;
	
	public CustomTypeFace (Context context){
		mContext = context;
	}
	
	public void setTypeFace (TextView[] textViews, String font){
		
		Typeface customTypeface = Typeface.createFromAsset(mContext.getAssets(), font);
	    for (int i = 0; i < textViews.length;i++){
		    textViews[i].setTypeface(customTypeface);
	    }
		
	}
	
	public void setTypeFace (EditText[] editTexts, String font){
		
		Typeface customTypeface = Typeface.createFromAsset(mContext.getAssets(), font);
	    for (int i = 0; i < editTexts.length;i++){
	    	editTexts[i].setTypeface(customTypeface);
	    }
		
	}
	
	public void setTypeFace (CheckBox[] checkBoxes, String font){
		
		Typeface customTypeface = Typeface.createFromAsset(mContext.getAssets(), font);
	    for (int i = 0; i < checkBoxes.length;i++){
	    	checkBoxes[i].setTypeface(customTypeface);
	    }
		
	}
	
	public void setTypeFace (Button[] buttons, String font){
		
		Typeface customTypeface = Typeface.createFromAsset(mContext.getAssets(), font);
	    for (int i = 0; i < buttons.length;i++){
	    	buttons[i].setTypeface(customTypeface);
	    }
		
	}
	
	public void setTypeFace (TextView[] textViews, String font, float fontSize){
		
		Typeface customTypeface = Typeface.createFromAsset(mContext.getAssets(), font);
	    for (int i = 0; i < textViews.length;i++){
		    textViews[i].setTypeface(customTypeface);
		    textViews[i].setTextSize(fontSize);
	    }
		
	}
}
