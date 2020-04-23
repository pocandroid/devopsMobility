package com.devops.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FifthActivity extends AppCompatActivity {

    private Button btnPrev;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        btnPrev=(Button)findViewById(R.id.btnPrev);
        btnNext=(Button)findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(FifthActivity.this, SixthActivity.class);
                startActivity(intent);

            }
        });


        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(FifthActivity.this,FourthActivity.class);
                startActivity(intent);

            }
        });
    }
}
