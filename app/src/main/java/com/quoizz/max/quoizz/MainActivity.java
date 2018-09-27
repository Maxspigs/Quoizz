package com.quoizz.max.quoizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private ImageView imageView;
    private Button trueButton, falseButton, cheatButton;
    private Question[] quiz = ServiceQuestion.populate();

    private boolean answer;
    private int score = 0;
    private int currentQuestionNumber = 0;
    private boolean isCheating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = (TextView)findViewById(R.id.question);
        trueButton = (Button)findViewById(R.id.button_true);
        falseButton = (Button)findViewById(R.id.button_false);
        cheatButton = (Button)findViewById(R.id.button_cheat);

        int savedQuestionNumber = getIntent().getIntExtra("index", -1);
        int savedScore = getIntent().getIntExtra("finalScore",0 );
        boolean savedIsCheating = getIntent().getBooleanExtra("cheater", false);

        if(savedQuestionNumber != -1){
            this.currentQuestionNumber = savedQuestionNumber;
            this.score = savedScore;
            this.isCheating = savedIsCheating;
        }

        setQuestionAndAnswer(currentQuestionNumber);

        //Logic for true button
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer == true) {
                    MainActivity.this.score++;
                }
                onAnswer();
            }
        });


        //Logic for false button
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer == false) {
                    MainActivity.this.score++;
                }
                onAnswer();
            }
        });

        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CheatActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("index", currentQuestionNumber);
                bundle.putBoolean("answer", answer);
                if(isCheating){
                    bundle.putBoolean("cheater", isCheating);
                }
                changeActivity(i, bundle);
            }
        });

    }

    private void onAnswer() {
        if (currentQuestionNumber == quiz.length-1) {
            Intent i = new Intent(MainActivity.this, ResultatActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("index", -1);
            if(isCheating){
                bundle.putBoolean("cheater", isCheating);
            }
            changeActivity(i, bundle);
        }
        else{
            currentQuestionNumber++;
            setQuestionAndAnswer(currentQuestionNumber);
        }
    }

    private void changeActivity(Intent i, Bundle bundle) {
        bundle.putInt("finalScore", score);
        i.putExtras(bundle);
        finish();
        startActivity(i);
    }

    private void setQuestionAndAnswer(int questionNumber){
        answer = quiz[questionNumber].isReponse();
        question.setText((questionNumber+1) + ". " + quiz[questionNumber].getQuestion());
    }

}