package com.bsp.app.tekstsat;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.TextView;

public class TekstSatProvider extends AppWidgetProvider {
	
	public static String TekstSatUpdate = "Tekst_Sat_Update";
	private static AlarmManager alarmManager;
	private static PendingIntent pendingIntent;
	public static TextView tvMjesec;
	
	@Override
	public void onDisabled(Context context) {
		super.onDisabled(context);
		alarmManager.cancel(pendingIntent);
	}
	
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		super.onDeleted(context, appWidgetIds);
		alarmManager.cancel(pendingIntent);
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);
		
		if (TekstSatUpdate.equals(intent.getAction())) {
			AppWidgetManager appWM = AppWidgetManager.getInstance(context);
			ComponentName cName = new ComponentName(context, TekstSatProvider.class);
			int[] ids = appWM.getAppWidgetIds(cName);
			final int N = ids.length;
			for (int i = 0; i < N; i++) {
				int appID = ids[i];
				updateWidgets(context, appWM, appID);
			}			
			
			SatKonfigurator.Sekunda = 59;
			SatKonfigurator.SetWidgetAlarm(context, alarmManager);
		}
	}
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		
		final int N = appWidgetIds.length;
		for (int i = 0; i < N; i++) {
			int appID = appWidgetIds[i];
			updateWidgets(context, appWidgetManager, appID);
		}		
	}

	public static void updateWidgets(Context context,
			AppWidgetManager appWidgetManager, int appID) {
		
		SatKonverter sk = new SatKonverter();
		
		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.main);
		
		views.setTextViewText(R.id.txtSat, sk.VratiSate());
		views.setTextViewText(R.id.txtDan, sk.VratiDane());		
		views.setTextViewText(R.id.txtMjesec, sk.VratiMjesece());
		views.setTextViewText(R.id.txtGodina, sk.VratiGodinu());
		views.setTextViewText(R.id.txtSG, sk.VratiSedmicuUGod());
		views.setTextViewText(R.id.txtDG, sk.VratiDanUGod());
		
		appWidgetManager.updateAppWidget(appID, views);
	}

	public static void SaveAlarmManager(AlarmManager aManager,
			PendingIntent pIntent) {
		alarmManager = aManager;
		pendingIntent = pIntent;		
	}
}
