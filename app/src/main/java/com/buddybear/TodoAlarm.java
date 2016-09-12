package com.buddybear;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;

import java.util.Calendar;

/**
 * @author Prabu
 *
 */
public class TodoAlarm extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
	 

		// Vibrate the mobile phone
		Vibrator vibrator = (Vibrator) context
				.getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate(2000);
		Uri at = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		 Ringtone r = RingtoneManager.getRingtone(context,at );
		    r.play();

		    NotificationManager mNM;
	        mNM = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
	        // Set the icon, scrolling text and timestamp

		PendingIntent examIntent = PendingIntent.getActivity(context, 0, new Intent(context, TodoFirstPage.class), 0);
	         // Notification notification = new Notification(R.drawable.four, "Demo !",System.currentTimeMillis());
	        // The PendingIntent to launch our activity if the user selects this notification

		Calendar c = Calendar.getInstance();
		int currentDate = c.get(Calendar.DATE);
		int month = c.get(Calendar.MONTH);

			Notification.Builder builder = new Notification.Builder(context);

			builder.setSmallIcon(R.drawable.main_logo)
					.setContentTitle("Sõber Karu")
					.setContentText("Sul on veel täitmata eesmärke!")

					.setContentIntent(examIntent);
			builder.setAutoCancel(true);
			Notification notification = builder.getNotification();
			mNM.notify(R.drawable.choto_logo, notification);


		    
	}



 
}
