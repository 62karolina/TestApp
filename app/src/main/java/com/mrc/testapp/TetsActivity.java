package com.mrc.testapp;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class TetsActivity extends AppCompatActivity {

    int i = 1;
    TextView numberQ;
    TextView mQuestionTextView;
    Button mTrueButton;
    Button mFalseButton;
    ImageButton mNextButton;

    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse("1 + 1 = 5", false),
            new TrueFalse("2 + 8 = 10", true),
            new TrueFalse("7 + 1 = 9", false),
            new TrueFalse("10 + 7 = 17", true),
            new TrueFalse("4 + 2 = 6", true),
            new TrueFalse("1 + 5 = 10", false),
            new TrueFalse("6 + 1 = 5", false),
            new TrueFalse("8 + 8 = 16", true),
            new TrueFalse("9 + 10 = 9", false),
            new TrueFalse("0 + 7 = 7", true),
    };
    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tets);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        numberQ = (TextView)findViewById(R.id.numberQest);


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
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                numberQ.setText("Вопрос №" + String.valueOf(mCurrentIndex + 1));
                updateQuestion();
            }
        });

        updateQuestion();

    }

    private void updateQuestion() {
        String question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
    }
}
