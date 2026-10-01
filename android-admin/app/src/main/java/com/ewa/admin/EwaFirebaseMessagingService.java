package com.ewa.admin;
import android.app.*;
import android.content.*;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.*;
import java.util.Map;

public class EwaFirebaseMessagingService extends FirebaseMessagingService {
    public static final String CHANNEL="ewa_live_updates";
    @Override public void onMessageReceived(RemoteMessage msg){
        Map<String,String>d=msg.getData();
        show(d.get("title"),d.get("body"),d.get("section"),d.get("event_id"));
    }
    @Override public void onNewToken(String token){
        getSharedPreferences("ewa_admin",MODE_PRIVATE).edit().putString("pending_fcm_token",token).apply();
    }
    private void show(String title,String body,String section,String eventId){
        NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=26)nm.createNotificationChannel(new NotificationChannel(CHANNEL,"EWA Live Updates",NotificationManager.IMPORTANCE_HIGH));
        Intent i=new Intent(this,MainActivity.class).putExtra("ewa_section",section==null?"Dashboard":section);
        PendingIntent pi=PendingIntent.getActivity(this,(eventId==null?body:eventId).hashCode(),i,PendingIntent.FLAG_UPDATE_CURRENT|PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder b=new NotificationCompat.Builder(this,CHANNEL).setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(title==null?"EWA Update":title).setContentText(body==null?"New activity in EWA":body)
            .setStyle(new NotificationCompat.BigTextStyle().bigText(body)).setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true).setContentIntent(pi).setDefaults(NotificationCompat.DEFAULT_ALL);
        nm.notify((eventId==null?String.valueOf(System.currentTimeMillis()):eventId).hashCode(),b.build());
    }
}
