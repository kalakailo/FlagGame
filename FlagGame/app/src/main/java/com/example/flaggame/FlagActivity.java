package com.example.flaggame;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FlagActivity extends AppCompatActivity{
    private ImageButton vNext;
    private ImageButton vFind;
    private ImageButton vTrue;
    private ImageButton vFalse;
    public static final String EXTRA_ANSWER = "EXTRA_ANSWER";
    public static final String EXTRA_FLAG = "EXTRA_FLAG";
    public static final String EXTRA_COUNTRY = "EXTRA_COUNTRY";

    private TextView mQuestionTextView;
    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_ukraine, R.drawable.ukraine, true),
            new TrueFalse(R.string.question_austria, R.drawable.austria, true),
            new TrueFalse(R.string.question_belgium, R.drawable.belgium, true),
            new TrueFalse(R.string.question_canada, R.drawable.canada, false),
            new TrueFalse(R.string.question_china, R.drawable.china, true),
            new TrueFalse(R.string.question_england, R.drawable.england, false),
            new TrueFalse(R.string.question_brazil, R.drawable.brazil, true),
            new TrueFalse(R.string.question_france, R.drawable.france, false),
            new TrueFalse(R.string.question_sweden, R.drawable.sweden, false),
            new TrueFalse(R.string.question_germany, R.drawable.germany, true),
    };
    private AnswerQuestions[] mAnswerBank = new AnswerQuestions[]{
            new AnswerQuestions(R.string.answer_ukraine, R.drawable.ukraine,R.string.country_ukraine),
            new AnswerQuestions(R.string.answer_austria, R.drawable.austria,R.string.country_austria),
            new AnswerQuestions(R.string.answer_belgium, R.drawable.belgium,R.string.country_belgium),
            new AnswerQuestions(R.string.answer_canada, R.drawable.canada,R.string.country_canada),
            new AnswerQuestions(R.string.answer_china, R.drawable.china,R.string.country_china),
            new AnswerQuestions(R.string.answer_england, R.drawable.england,R.string.country_england),
            new AnswerQuestions(R.string.answer_brazil, R.drawable.brazil,R.string.country_brazil),
            new AnswerQuestions(R.string.answer_france, R.drawable.france,R.string.country_france),
            new AnswerQuestions(R.string.answer_sweden, R.drawable.sweden,R.string.country_sweden),
            new AnswerQuestions(R.string.answer_germany, R.drawable.germany,R.string.country_germany),
    };
    private int mCurrentIndex = 0;

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);
        final ImageView imageView = (ImageView) findViewById(R.id.activity_flag_imageView);
        imageView.setImageResource(mQuestionBank[mCurrentIndex].getFlag());
        mQuestionTextView = (TextView) findViewById(R.id.activity_flag_textView);
        mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getQuestion());


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        vNext = (ImageButton) findViewById(R.id.activity_flag_next);
        vNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                int question = mQuestionBank[mCurrentIndex].getQuestion();
                mQuestionTextView.setText(question);
                imageView.setImageResource(mQuestionBank[mCurrentIndex].getFlag());

                mCurrentIndex = (mCurrentIndex + 1) % mAnswerBank.length;
                int answer = mAnswerBank[mCurrentIndex].getAnswer();
                mQuestionTextView.setText(answer);
                imageView.setImageResource(mAnswerBank[mCurrentIndex].getFlag());
            }
        });
        vFind = (ImageButton) findViewById(R.id.activity_flag_find_out);
        vFind.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.activity_flag_find_out:
                        AnswerQuestions flag = mAnswerBank[mCurrentIndex];
                        Intent intent = new Intent(FlagActivity.this, FindOut.class);
                        intent.putExtra(EXTRA_ANSWER,flag.getAnswer());
                        intent.putExtra(EXTRA_COUNTRY,flag.getCountry());
                        intent.putExtra(EXTRA_FLAG,flag.getFlag());
                        startActivity(intent);
                        break;
                    default:
                        break;
                }

            }
        });
        vTrue = (ImageButton) findViewById(R.id.activity_flag_true);
        vTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        vFalse = (ImageButton) findViewById(R.id.activity_flag_false);
        vFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
    }

}
