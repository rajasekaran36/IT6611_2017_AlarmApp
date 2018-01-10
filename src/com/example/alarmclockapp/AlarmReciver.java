package com.example.alarmclockapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlarmReciver extends BroadcastReceiver{

	NotificationCompat.Builder builder;
	NotificationManager manager;
	Notification notification;
	
	@Override
	public void onReceive(Context context, Intent arg1) {
		builder = new NotificationCompat.Builder(context);
        manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("Alarm Notification");
        builder.setContentText("This is for your reminder");
        notification = builder.build();
        manager.notify(0, notification);
	}

}
