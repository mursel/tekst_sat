package com.bsp.app.tekstsat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class SatKonfigurator extends Activity {
	
	Spinner spinner;
	Spinner sSedmice;
	Spinner sSati;
	Spinner sDani;
	Spinner sMjeseci;
	Spinner sGodine;
	Spinner sDaniUk;
	Spinner sSedUk;
		
	Button btnSave;
	Button btnCancel;
	static PendingIntent pIntent;
	TextView txtMinute;
	int appID = AppWidgetManager.INVALID_APPWIDGET_ID;
	public static int Sekunda = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setResult(RESULT_CANCELED);
		
		setContentView(R.layout.tekstsatconfig);
				
		btnSave = (Button)findViewById(R.id.button1);
		btnSave.setOnClickListener(OnBtnSaveClick);
		
		btnCancel = (Button)findViewById(R.id.button2);
		btnCancel.setOnClickListener(OnBtnCancelClick);
		
		spinner = (Spinner)findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, 
				R.array.periodi, 
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new SpinnerClickListener());
		

		ArrayAdapter<CharSequence> boje = ArrayAdapter.createFromResource(
				this,
				R.array.boje,
				android.R.layout.simple_spinner_item);
		boje.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		sDaniUk = (Spinner)findViewById(R.id.spDaniUk);
		sDaniUk.setOnItemSelectedListener(onClickBoje);
		sDaniUk.setAdapter(boje);
		
		sSedUk = (Spinner)findViewById(R.id.spSedUk);
		sSedUk.setOnItemSelectedListener(onClickBoje);
		sSedUk.setAdapter(boje);
		
		sSedmice = (Spinner)findViewById(R.id.spSedmice);
		sSedmice.setOnItemSelectedListener(onClickBoje);
		sSedmice.setAdapter(boje);
		
		sSati = (Spinner)findViewById(R.id.spSati);
		sSati.setOnItemSelectedListener(onClickBoje);
		sSati.setAdapter(boje);
		
		sDani = (Spinner)findViewById(R.id.spDani);
		sDani.setOnItemSelectedListener(onClickBoje);
		sDani.setAdapter(boje);
		
		sGodine = (Spinner)findViewById(R.id.spGodine);
		sGodine.setOnItemSelectedListener(onClickBoje);
		sGodine.setAdapter(boje);
		
		sMjeseci = (Spinner)findViewById(R.id.spMjeseci);
		sMjeseci.setOnItemSelectedListener(onClickBoje);
		sMjeseci.setAdapter(boje);
		
		AlarmManager aManager = (AlarmManager)getSystemService(ALARM_SERVICE);
		TekstSatProvider.SaveAlarmManager(aManager, null);
		
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		if (extras != null) {
			appID = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
					AppWidgetManager.INVALID_APPWIDGET_ID);
		}
		
		if (appID == AppWidgetManager.INVALID_APPWIDGET_ID) {
			finish();
		}
		
	}
	
	OnClickListener OnBtnCancelClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			AlarmManager aManager = (AlarmManager)getSystemService(ALARM_SERVICE);
			aManager.cancel(pIntent);
			Toast.makeText(SatKonfigurator.this, "Alarm de-aktiviran!", Toast.LENGTH_SHORT).show();
		}
	};
	
	OnClickListener OnBtnSaveClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			final Context ctx = SatKonfigurator.this;
			
			AppWidgetManager appWM = AppWidgetManager.getInstance(ctx);
			
			TekstSatProvider.updateWidgets(ctx, appWM, appID);
			
			AlarmManager aManager = (AlarmManager)getSystemService(ALARM_SERVICE);
			SetWidgetAlarm(ctx, aManager);
						
			Toast.makeText(ctx, "Alarm aktiviran!", Toast.LENGTH_SHORT).show();
			
			Intent intent2 = new Intent();
			intent2.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appID);
			setResult(RESULT_OK, intent2);
			finish();
			
		}
	};
	
	OnItemSelectedListener onClickBoje = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			
			String tag = arg0.getTag().toString();
		
			if (isSdPresent()) 
			{
				try {
				
					File rootDir = Environment.getExternalStorageDirectory();
					File appDir = new File(rootDir.getAbsolutePath(), "/bsp/tekstsat/data/");
					
					
					StringBuffer sb = new StringBuffer();
					
					if (!appDir.exists()) {
						appDir.mkdirs();
						
						File appFile = new File(appDir, "podaci.dat");	
						FileOutputStream fos = new FileOutputStream(appFile, true);
						
						if (tag.equalsIgnoreCase("sati")) {
							sb.append(Boje.VratiBoju(arg2));
						}else if (tag.equalsIgnoreCase("godine")) {
							sb.append(Boje.VratiBoju(arg2));
						}else if (tag.equalsIgnoreCase("mjeseci")) {
							sb.append(Boje.VratiBoju(arg2));
						}else if (tag.equalsIgnoreCase("dani")) {
							sb.append(Boje.VratiBoju(arg2));
						}else if (tag.equalsIgnoreCase("sedmiceukupno")) {
							sb.append(Boje.VratiBoju(arg2));
						}else if (tag.equalsIgnoreCase("daniukupno")) {
							sb.append(Boje.VratiBoju(arg2));
						}else if (tag.equalsIgnoreCase("sedmice")) {
							sb.append(Boje.VratiBoju(arg2));
						}
						
						fos.write(sb.toString().getBytes());
						fos.close();
						
					}else
					{
						File appFile = new File(appDir, "podaci.dat");
						FileInputStream fis = new FileInputStream(appFile);
						
						int ch;
						while ((ch = fis.read()) != -1) {
							sb.append((char)ch);
						}
						
						fis.close();
											
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {			
		}
		
	};
	
	public static void SetWidgetAlarm(Context context, AlarmManager aManager)
	{
		Intent intent = new Intent(TekstSatProvider.TekstSatUpdate);
		pIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		
		if(Sekunda == 0)
		{
			Log.d("TEKSTSATWIDGET", "SEKUNDA == " + String.valueOf(Sekunda));
			int trenSekunda = calendar.get(Calendar.SECOND);
			trenSekunda = 60 - trenSekunda;
			calendar.add(Calendar.SECOND, trenSekunda);
		}else{
			Log.d("TEKSTSATWIDGET", "SEKUNDA == " + String.valueOf(Sekunda));
			calendar.add(Calendar.SECOND, Sekunda);
		}
		
		aManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 60 * 1000, pIntent);
		TekstSatProvider.SaveAlarmManager(aManager, pIntent);				
	}
	
	public static boolean isSdPresent() {
		 
		return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
		 
	}
}
