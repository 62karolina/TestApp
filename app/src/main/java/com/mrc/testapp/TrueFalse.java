package com.mrc.testapp;

/**
 * Created by Каролина on 18.06.2016.
 */
public class TrueFalse {

    private String mQuestion;
    private boolean mTrueQuestion;

    public TrueFalse(String question, boolean trueQuestion) {
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }

    public String getQuestion() {
        return mQuestion;
    }
    public void setQuestion(String question) {
        mQuestion = question;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }
    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }


}
