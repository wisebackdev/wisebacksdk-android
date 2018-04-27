package com.wiseback.wisebacksdktest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.wiseback.wisebacksdk.WiseActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, WiseActivity.class);
                intent.putExtra("formID", "VgcfNL");
                intent.putExtra("hasCloseButton", true); //optional, default: true
                intent.putExtra("showProgress", false); //optional, default: false
                intent.putExtra("animation", WiseActivity.Anim.DEFAULT); //optional, default: Anim.DEFAULT
                startActivity(intent);

                WiseActivity.setWiseEventListener(new WiseActivity.WiseEventListener() {
                    @Override
                    public void onStartLoading() {
                        Log.d("WISE_SDK", "onStartLoading: OK");
                    }

                    @Override
                    public void onFormLoaded() {
                        Log.d("WISE_SDK", "onFormLoaded: OK");
                    }

                    @Override
                    public void onErrorLoading(String description) {
                        Log.d("WISE_SDK", "onErrorLoading: " + description);
                    }

                    @Override
                    public void onFormClosed() {
                        Log.d("WISE_SDK", "onFormClosed: OK");
                    }
                });
            }
        });

    }
}
