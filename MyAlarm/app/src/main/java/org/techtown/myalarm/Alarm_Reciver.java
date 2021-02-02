package org.techtown.myalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class Alarm_Reciver extends BroadcastReceiver {

    Context context;

    @Override
    public void onReceive(Context context, Intent intent) {

        this.context = context;
        //intent로부터 전달받은 string
        String get_yout_string = intent.getExtras().getString("state");

        // RingtonePlayingService 서비스 intent 생성
        Intent service_intent = new Intent(context, RingtonePlayingService.class);

        //RingtonePlayinService로 extra string값 보내기
        service_intent.putExtra("state", get_yout_string);
        //start the ringtone service

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.BASE){
            this.context.startForegroundService(service_intent);
        } else{
            this.context.startService(service_intent);
        }


    }
}
