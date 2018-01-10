package com.example.alarmclockapp;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.style.BulletSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

	Button setButton;
	EditText time;
	
	AlarmManager alarmmanager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = (EditText) findViewById (R.id.time);
        setButton = (Button) findViewById (R.id.set_button);
       
        setButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int time_in_sec = Integer.parseInt(time.getText().toString());
				Intent alramIntent = new Intent(MainActivity.this, AlarmReciver.class);
		        PendingIntent pin = PendingIntent.getBroadcast(getApplicationContext(), 1, alramIntent,PendingIntent.FLAG_UPDATE_CURRENT);
		        alarmmanager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
		        alarmmanager.set(AlarmManager.RTC_WAKEUP, 1000 * time_in_sec, pin);
				
		        Toast.makeText(getApplicationContext(), "Alarm Set for "+String.valueOf(time_in_sec) + "seconds", Toast.LENGTH_LONG).show();
			}
		});
        
    }
}
