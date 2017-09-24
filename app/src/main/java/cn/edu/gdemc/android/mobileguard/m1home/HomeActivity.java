package cn.edu.gdemc.android.mobileguard.m1home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import cn.edu.gdemc.android.mobileguard.R;
import cn.edu.gdemc.android.mobileguard.m1home.adapter.HomeAdapter;

public class HomeActivity extends AppCompatActivity {
    private GridView gv_home;
    private Long mExitTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        gv_home=(GridView)findViewById(R.id.gv_home);
        gv_home.setAdapter(new HomeAdapter(HomeActivity.this));
        gv_home.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    //
                }
            }
        });
    }


}
