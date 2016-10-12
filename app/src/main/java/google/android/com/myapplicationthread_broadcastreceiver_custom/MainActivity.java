package google.android.com.myapplicationthread_broadcastreceiver_custom;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    private final static String ACTION_RECEIVE_SMS = "com.exemple.broadcast.CUSTOM_INTENT";
    ComponentName monReceiver;
    PackageManager pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monReceiver=new ComponentName(this,MonReceiver.class);
        pm=getPackageManager();
    }

    @Override
    protected void onResume() {
        super.onResume();

        pm.setComponentEnabledSetting(monReceiver,PackageManager.COMPONENT_ENABLED_STATE_ENABLED,PackageManager.DONT_KILL_APP);
    }


    @Override
    protected void onPause() {
        super.onPause();
        pm.setComponentEnabledSetting(monReceiver,PackageManager.COMPONENT_ENABLED_STATE_DISABLED,PackageManager.DONT_KILL_APP);
    }


    public void broadcastIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("com.exemple.broadcast.CUSTOM_INTENT");
        sendBroadcast(intent);

    }

}
