package com.kiran.internetchecking;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kiran.internetchecking.config.MyApplication;
import com.kiran.internetchecking.config.NetworkListener;

public class MainActivity extends AppCompatActivity
implements NetworkListener.InternetListener {
    private Button btnCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCheck = (Button) findViewById(R.id.netcheck);

        checkConnection();

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConnection();
            }
        });
    }

    private void checkConnection(){
        boolean isConnected = NetworkListener.isConnected();
       showMessage(isConnected);
    }

    private void showMessage(boolean isConnected){
        if(isConnected){
            Toast.makeText(getApplicationContext(),"Internet Connected...!",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"Internet Not Connected...!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        MyApplication.getInstance().setNetworkListener(this);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showMessage(isConnected);
    }
}
