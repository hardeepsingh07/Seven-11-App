package com.example.singh.seven_11;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class CreateProject extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_create_project);
		Button bCreateProject = (Button)findViewById(R.id.bCreateProject);
		Button bExit = (Button)findViewById(R.id.bExit);
		
		bCreateProject.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
               Intent intent = new Intent();
               PendingIntent pI = PendingIntent.getActivity(CreateProject.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                Notification notify = new Notification.Builder(CreateProject.this)
                        .setTicker("7-Eleven")
                        .setContentTitle("Welcome to 7-Eleven worksheet")
                        .setContentText("Please try to complete as much information as possible for efficient use.")
                        .setSmallIcon(R.drawable.seveneleven)
                        .setContentIntent(pI).getNotification();
                notify.flags = Notification.FLAG_AUTO_CANCEL;

                NotificationManager notifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notifyManager.notify(0,notify);
                Intent i = new Intent(CreateProject.this, Lotteries.class);
				startActivity(i);
			}
		});
		
		bExit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
                Toast.makeText(CreateProject.this, "Good Bye, Have a Nice Day", Toast.LENGTH_SHORT).show();
                finish();
			}
		});
		
	}


}
