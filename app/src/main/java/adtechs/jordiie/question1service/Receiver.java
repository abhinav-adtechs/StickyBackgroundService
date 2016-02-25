package adtechs.jordiie.question1service;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Receiver extends BroadcastReceiver{

    private String TAG = "Broadcast Receiver" ;

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e(TAG, "Method onReceive");
        context.startService(new Intent(context.getApplicationContext(), BackgroundService.class));

    }
}
