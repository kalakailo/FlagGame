package com.example.flaggame;

/**
 * Created by Михайлик on 12.10.2015.
 */
public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;
    private int mFlag;


    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }

    public int getFlag() {
        return mFlag;
    }

    public void setFlag(int flag) {
        mFlag = flag;
    }

    public TrueFalse(int question, int flag, boolean trueQuestion) {

        mQuestion = question;
        mTrueQuestion = trueQuestion;
        mFlag = flag;
    }
}
