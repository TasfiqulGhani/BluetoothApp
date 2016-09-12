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
public class AlarmReciver extends BroadcastReceiver {
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

		PendingIntent examIntent = PendingIntent.getActivity(context, 0, new Intent(context, NewsFeedFirstPage.class), 0);
	         // Notification notification = new Notification(R.drawable.four, "Demo !",System.currentTimeMillis());
	        // The PendingIntent to launch our activity if the user selects this notification

		Calendar c = Calendar.getInstance();
		int currentDate = c.get(Calendar.DATE);
		int month = c.get(Calendar.MONTH);
		if(month==0 && currentDate==1){
			Notification.Builder builder = new Notification.Builder(context);

			builder.setSmallIcon(R.drawable.main_logo)
					.setContentText("Uuel aastal uue hooga!")

					.setContentTitle("Sõber Karu")
					.setContentIntent(examIntent);
			builder.setAutoCancel(true);
			Notification notification = builder.getNotification();
			mNM.notify(R.drawable.main_logo, notification);
		}else if(month==1 && currentDate==14) {
			Notification.Builder builder = new Notification.Builder(context);

			builder.setSmallIcon(R.drawable.main_logo)
					.setContentText("Sõbrapäev on tore päev!")
					.setContentTitle("Sõber Karu")

					.setContentIntent(examIntent);
			builder.setAutoCancel(true);
			Notification notification = builder.getNotification();
			mNM.notify(R.drawable.main_logo, notification);

		}else if(month==1 && currentDate==24) {
			Notification.Builder builder = new Notification.Builder(context);

			builder.setSmallIcon(R.drawable.main_logo)
					.setContentText("Head vabariigi aastapäeva!")
					.setContentTitle("Sõber Karu")

					.setContentIntent(examIntent);
			builder.setAutoCancel(true);
			Notification notification = builder.getNotification();
			mNM.notify(R.drawable.main_logo, notification);
		}else if(month==2 && currentDate==14) {
			Notification.Builder builder = new Notification.Builder(context);

			builder.setSmallIcon(R.drawable.main_logo)
					.setContentText("Ilusat emakeelepäeva!")

					.setContentTitle("Sõber Karu")
					.setContentIntent(examIntent);
			builder.setAutoCancel(true);
			Notification notification = builder.getNotification();
			mNM.notify(R.drawable.main_logo, notification);
		}




		else if(month==4 && currentDate==15) {
			Notification.Builder builder = new Notification.Builder(context);

			builder.setSmallIcon(R.drawable.main_logo)
					.setContentText("Veeda päev perega - on perepäev!")
					.setContentTitle("Sõber Karu")

					.setContentIntent(examIntent);
			builder.setAutoCancel(true);
			Notification notification = builder.getNotification();
			mNM.notify(R.drawable.main_logo, notification);
		}else if(month==4 && currentDate==31) {
			Notification.Builder builder = new Notification.Builder(context);

			builder.setSmallIcon(R.drawable.main_logo)
					.setContentText("Homme on lastekaitsepäev!")
					.setContentTitle("Sõber Karu")

					.setContentIntent(examIntent);
			builder.setAutoCancel(true);
			Notification notification = builder.getNotification();
			mNM.notify(R.drawable.main_logo, notification);
		}else if(month==8 && currentDate==1) {
			Notification.Builder builder = new Notification.Builder(context);

			builder.setSmallIcon(R.drawable.main_logo)
					.setContentText("Rõõmsat tarkusepäeva!")
					.setContentTitle("Sõber Karu")

					.setContentIntent(examIntent);
			builder.setAutoCancel(true);
			Notification notification = builder.getNotification();
			mNM.notify(R.drawable.main_logo, notification);
		}else if(month==9 && currentDate==27) {
			Notification.Builder builder = new Notification.Builder(context);

			builder.setSmallIcon(R.drawable.main_logo)
					.setContentText("Täna on kaisukarupäev!")

					.setContentTitle("Sõber Karu")
					.setContentIntent(examIntent);
			builder.setAutoCancel(true);
			Notification notification = builder.getNotification();
			mNM.notify(R.drawable.main_logo, notification);
		}else if(month==10 && currentDate==20) {
			Notification.Builder builder = new Notification.Builder(context);

			builder.setSmallIcon(R.drawable.main_logo)
					.setContentText("On ülemaailmne lastepäev!")

					.setContentTitle("Sõber Karu")
					.setContentIntent(examIntent);
			builder.setAutoCancel(true);
			Notification notification = builder.getNotification();
			mNM.notify(R.drawable.main_logo, notification);
		}else{

		}

		    
	}


 
}
