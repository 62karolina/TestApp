package com.mrc.testapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class LessonsActivity extends AppCompatActivity {

    Button tablica;
    ScrollView tablePic;
    Button sumRazn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        tablePic = (ScrollView)findViewById(R.id.scrollView);


        tablica =(Button)findViewById(R.id.tab_ymn);
        tablica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tablePic.getVisibility() == View.INVISIBLE){

                    tablePic.setVisibility(View.VISIBLE);
                } else tablePic.setVisibility(View.INVISIBLE);
            }
        });

        sumRazn = (Button)findViewById(R.id.sumraz);
        sumRazn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonsActivity.this, SumYdal_Activity.class);
                startActivity(intent);

            }
        });


    }
}
