package cn.edu.gdmec.android.mobileguard.m2theftguard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import cn.edu.gdmec.android.mobileguard.R;

/**
 * Created by zhuang zhu on 2017-10-15.
 */

public class Setup2Activity extends BaseSetupActivity implements View.OnClickListener{
    private TelephonyManager mTelephonyManager;
    private Button mBindSiMBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_2);
        //设置第二个小圆点颜色
        ((RadioButton)findViewById(R.id.rb_second)).setChecked(true);
        mTelephonyManager = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        //找到布局中的SIM卡绑定的按钮
        mBindSiMBtn = (Button)findViewById(R.id.btn_sim);
        mBindSiMBtn.setOnClickListener(this);
        if (isBind()){
            mBindSiMBtn.setEnabled(false);
        }else {
            mBindSiMBtn.setEnabled(true);
        }

    }
    private boolean isBind(){
        String simString = sp.getString("sim",null);
        if (TextUtils.isEmpty(simString)){
            return false;
        }
        return true;
    }

    @Override
    public void showNext() {
        startActivityAndFinishSelf(Setup3Activity.class);
        if (!isBind()){
            Toast.makeText(this, "您还没有绑定SIM卡！", Toast.LENGTH_SHORT).show();
        }
        startActivityAndFinishSelf(Setup3Activity.class);
    }

    @Override
    public void showPre() {
        startActivityAndFinishSelf(Setup1Activity.class);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_sim:
                break;
        }

    }
    //绑定simka
    private void bindSIM(){
        if (!isBind()){
            String simSeriaNumber = mTelephonyManager.getSimSerialNumber();
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("sim",simSeriaNumber);
            edit.commit();
            Toast.makeText(this, "SIM卡绑定成功！", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "SIM卡已经绑定！", Toast.LENGTH_SHORT).show();
            mBindSiMBtn.setEnabled(false);
        }
    }
}


