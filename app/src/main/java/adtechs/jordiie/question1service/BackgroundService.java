package adtechs.jordiie.question1service;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class BackgroundService extends Service{

    private static String TAG = "ClassBackgroundService" ;
    public PendingIntent pendingIntent ;
    private Intent intent ;
    private int mNotificationId = 001;
    private NotificationManager notificationManager ;
    private int num = 0 ;

    NotificationCompat.Builder builder =
            new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Service Application")
                    .setContentText("Service Started and Running")
                    .setContentIntent(pendingIntent)
                    .setOngoing(true)
                    .setAutoCancel(false)
                    .setNumber(num);

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        intent = new Intent(this, MainActivity.class) ;
        pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT) ;

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE) ;

    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();

        notificationManager.notify(mNotificationId, builder.build());

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        builder.setContentText("Service Still Running").setOngoing(false).setNumber(num++) ;
        notificationManager.notify(mNotificationId, builder.build());
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
        builder.setContentText("Service Destroyed").setOngoing(false).setNumber(num++) ;
        notificationManager.notify(mNotificationId, builder.build());

        sendBroadcast(new Intent("RestartService"));

        super.onDestroy();
    }
}


