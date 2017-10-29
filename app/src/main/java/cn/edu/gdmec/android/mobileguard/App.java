package cn.edu.gdmec.android.mobileguard;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by my on 2017/10/22.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
    public void correctSIM(){
        SharedPreferences sp = getSharedPreferences("config", Context.MODE_PRIVATE);
        //获取防盗保护状态
        boolean protecting = sp.getBoolean("protecting", true);
        if (protecting){
            //得到绑定SIM卡的串号
            String bindsim = sp.getString("sim","");
            //得到手机现有的SIM卡串号
            TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
            String realsim = tm.getSimSerialNumber();
            realsim = "999";
            if (bindsim.equals(realsim)){
                Log.i("","sim卡未发生变化，还是您的手机");
            }else {
                Log.i("","SIM卡变化了");
                String safenumber = sp.getString("safephone","");
                if (!TextUtils.isEmpty(safenumber)){
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(safenumber,null,
                            "你的亲友的手机的SIM卡已经被更换！",null,null);
                }
            }




        }
    }


}
