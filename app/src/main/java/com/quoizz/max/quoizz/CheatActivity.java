package com.quoizz.max.quoizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    public static final String TAG = "CheatActivity";

    TextView answerCheat;
    Button buttonYes, buttonNo, buttonReturn;
    boolean isCheating;
    int currentQuestionNumber, score;
    boolean answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cheat_activity);
        answerCheat = (TextView)findViewById(R.id.answer_cheat);

        currentQuestionNumber = getIntent().getIntExtra("index", 0);
        answer = getIntent().getBooleanExtra("answer", false);
        score = getIntent().getIntExtra("finalScore", 0);
        isCheating = getIntent().getBooleanExtra("cheater", false);


        buttonYes = findViewById(R.id.button_yes);
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerCheat.setText("La réponse est " + answer);
                isCheating = true;
            }
        });

        buttonNo = findViewById(R.id.button_no);
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity();
            }
        });

        buttonReturn = findViewById(R.id.button_cheat_return);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity();
            }
        });


    }

    private void changeActivity() {
        Intent i = new Intent(CheatActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("index", currentQuestionNumber);
        bundle.putInt("finalScore", score);
        if(isCheating){
            bundle.putBoolean("cheater", isCheating);

        }
        i.putExtras(bundle);
        startActivity(i);
    }
}
