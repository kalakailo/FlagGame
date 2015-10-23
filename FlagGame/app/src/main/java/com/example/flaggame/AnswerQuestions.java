package com.example.flaggame;

/**
 * Created by Михайлик on 22.10.2015.
 */
public class AnswerQuestions {
    private int mAnswer;
    private int mCountry;
    private int mFlag;

    public AnswerQuestions(int answer, int country, int flag) {
        mAnswer = answer;
        mCountry = country;
        mFlag = flag;
    }

    public int getCountry() {
        return mCountry;
    }

    public void setCountry(int country) {
        mCountry = country;
    }

    public int getAnswer() {
        return mAnswer;
    }

    public void setAnswer(int answer) {
        mAnswer = answer;
    }

    public int getFlag() {
        return mFlag;
    }

    public void setFlag(int flag) {
        mFlag = flag;
    }


}
