package adtechs.jordiie.question1service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button startServiceButton;
    private Button stopServiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeBindings();

        startServiceButton.setOnClickListener(this);
        stopServiceButton.setOnClickListener(this);
    }

    private void initializeBindings(){
        startServiceButton = (Button) findViewById(R.id.main_start_service_btn) ;
        stopServiceButton = (Button) findViewById(R.id.main_stop_service_btn) ;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.main_start_service_btn : startService(v) ;
                                break;
            case R.id.main_stop_service_btn: stopService(v);
                    break;
        }
    }

    public void startService(View view) {
        startService(new Intent(getBaseContext(), BackgroundService.class));
    }

    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), BackgroundService.class));
    }

}
