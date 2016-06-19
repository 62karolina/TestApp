package com.mrc.testapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ControlActivity extends AppCompatActivity {

    int i = 0;
    int b = 0;
    TextView numberQ;
    TextView mQuestionTextView;
    TextView statistic;
    Button mTrueButton;
    Button mFalseButton;
    ImageButton mNextButton;
    Random random = new Random();

    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse("1 + 1 = 5", false),
            new TrueFalse("2 + 8 = 10", true),
            new TrueFalse("7 < 1 ", false),
            new TrueFalse("10 + 7 = 17", true),
            new TrueFalse("4 > 2", true),
            new TrueFalse("1 + 5 = 10", false),
            new TrueFalse("6 / 1 = 6", true),
            new TrueFalse("8 + 8 = 16", true),
            new TrueFalse("9 + 10 = 9", false),
            new TrueFalse("0 + 7 = 7", true),
            new TrueFalse("9 > 10", false),
            new TrueFalse("0 / 7 = 0", true),
    };
    private int mCurrentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        numberQ = (TextView)findViewById(R.id.numberQest);
        statistic = (TextView)findViewById(R.id.statistic);

        mQuestionTextView = (TextView)findViewById(R.id.quest);

        mTrueButton = (Button)findViewById(R.id.mTrue);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton = (Button)findViewById(R.id.mFalse);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextButton = (ImageButton)findViewById(R.id.mNextButton);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                b++;
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                numberQ.setText("Вопрос №" + String.valueOf(mCurrentIndex + 1));
                updateQuestion();

                if(b == 10){
                    statistic.setText("Отвечено правильно на " + String.valueOf(i));
                    mNextButton.setVisibility(View.INVISIBLE);
                }

            }
        });


        updateQuestion();

    }

    private void updateQuestion() {
        String question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);


    }

    private int checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            return i++;
        } else {
            return i;
        }

    }


}
