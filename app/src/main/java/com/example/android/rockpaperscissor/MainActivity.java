package com.example.android.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText player_1;
    EditText player_2;
    EditText rounds;
//   public Information info=new Information(player_1.getText().toString(),player_2.getText().toString(),Integer.parseInt(rounds.getText().toString()));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Information.current_round_number = 1;
        Information.player1_current_score = 0;
        Information.player2_current_score = 0;
        Button button = findViewById(R.id.play_button);
        player_1 = findViewById(R.id.player1);
        player_2 = findViewById(R.id.player2);
        rounds = findViewById(R.id.no_of_rounds);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player_1.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "enter the name of player 1", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (player_2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "enter the name of player 2", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (rounds.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "enter the number of rounds", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (rounds.getText().toString().length() > 2) {
                    Toast.makeText(getApplicationContext(), "number of rounds should be between 1 to 15", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Integer.parseInt(rounds.getText().toString()) < 1 || Integer.parseInt(rounds.getText().toString()) > 15) {
                    Toast.makeText(getApplicationContext(), "number of rounds should be between 1 to 15", Toast.LENGTH_SHORT).show();
                    return;
                }
                Information.number_of_rounds = Integer.parseInt(rounds.getText().toString());
                Information.name_player1 = player_1.getText().toString();
                Information.name_player2 = player_2.getText().toString();
                Intent intent = new Intent(MainActivity.this, Player1Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
