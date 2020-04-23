package com.applications.androidApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

public class MainActivity extends AppCompatActivity {

    private Button btnPrev;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrev=(Button)findViewById(R.id.btnPrev);
        btnNext=(Button)findViewById(R.id.btnNext);

        btnPrev.setEnabled(false);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);

            }
        });
     AppCenter.start(getApplication(), "03d2977e-0a16-4557-af34-edb684b1c488",
                  Analytics.class, Crashes.class);

    }
}
