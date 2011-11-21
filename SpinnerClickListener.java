package com.bsp.app.tekstsat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class SpinnerClickListener implements OnItemSelectedListener {

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		Toast.makeText(arg0.getContext(), "Period: " + 
				arg0.getItemAtPosition(arg2).toString(), Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		
	}
	
}
