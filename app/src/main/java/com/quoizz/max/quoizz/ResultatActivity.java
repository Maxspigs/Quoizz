package com.quoizz.max.quoizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultatActivity extends AppCompatActivity {
    EditText totalScore;
    Button button;
    boolean isCheating;
    TextView cheatMessage;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultat_activity);
        totalScore = findViewById(R.id.editText);
        isCheating = getIntent().getBooleanExtra("cheater", false);
        cheatMessage = findViewById(R.id.cheatText);

        score = getIntent().getIntExtra("finalScore", 0);

        totalScore.setText("Vous avez obtenu " + score + " sur 10");

        if(isCheating){
            cheatMessage.setText("Vous avez osez tricher.... ? Vous méritez un /dev/null...");
        }

        button = findViewById(R.id.button_return);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultatActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("index", -1);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }
}
