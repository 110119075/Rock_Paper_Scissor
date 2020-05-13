package com.example.android.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.rockpaperscissor.Information;

import org.w3c.dom.Text;

public class ScoreActivity extends AppCompatActivity {
    //1 means rock,2 means paper,3 means scissor
//    int img_player1;
//    int img_player2;
//    String name_player_1;
//    String name_player_2;
    int player1_count = 0;
    int player2_count = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
//        img_player1=Information.image_selected_by_player_1;
//        img_player2=Information.image_selected_by_player_2;
//        name_player_1=Information.name_player1;
//        name_player_2=Information.name_player2;
        TextView message = findViewById(R.id.score_message);
        message.setText(getMessage());

        Information.player1_current_score += player1_count;
        Information.player2_current_score += player2_count;

        TextView player1_name = findViewById(R.id.score_player1_name_text_view);
        player1_name.setText(Information.name_player1);
        TextView player2_name = findViewById(R.id.score_player2_name_text_view);
        player2_name.setText(Information.name_player2);

        TextView score_player1_text = findViewById(R.id.current_score_player1_text_view);
        score_player1_text.setText(Integer.toString(Information.player1_current_score));
        TextView score_player2_text = findViewById(R.id.current_score_player2_text_view);
        score_player2_text.setText(Integer.toString(Information.player2_current_score));

        TextView round_indicator = findViewById(R.id.current_round);
        round_indicator.setText("Round " + Information.current_round_number + " completed");

        TextView finalMessage = findViewById(R.id.final_message);
        TextView gameOver = findViewById(R.id.game_over);
        final Button button = findViewById(R.id.next_round_button);

        if (Information.current_round_number < Information.number_of_rounds) {
            finalMessage.setVisibility(View.GONE);
            gameOver.setVisibility(View.GONE);
        } else {
            finalMessage.setVisibility(View.VISIBLE);
            gameOver.setVisibility(View.VISIBLE);
            button.setText("NEW GAME");
            if (Information.player1_current_score > Information.player2_current_score) {
                finalMessage.setText(Information.name_player1 + " won the game");
            } else if (Information.player1_current_score < Information.player2_current_score) {
                finalMessage.setText(Information.name_player2 + " won the game");
            } else {
                finalMessage.setText("Final result: draw");
            }

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TextView message=findViewById(R.id.score_message);

                if (Information.current_round_number >= Information.number_of_rounds) {
//                    if(Information.player1_current_score>Information.player2_current_score){
//                        message.setText(Information.name_player1+" won the game");
//                    }
//                    else if(Information.player1_current_score<Information.player2_current_score){
//                        message.setText(Information.name_player2+" won the game");
//                    }
//                    else{
//                        message.setText("final result: draw");
//                    }

//                    Toast.makeText(getApplicationContext(),"all rounds over",Toast.LENGTH_SHORT).show();
//                    return;
                    Intent intent1 = new Intent(ScoreActivity.this, MainActivity.class);
                    startActivity(intent1);
                    finish();
                } else {
                    Information.current_round_number++;
                    Intent intent = new Intent(ScoreActivity.this, Player1Activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    public String getMessage() {
        if (Information.image_selected_by_player_1 == Information.image_selected_by_player_2) {
            return "This round is a draw";
        } else {
            if (Information.image_selected_by_player_1 == 1) {
                if (Information.image_selected_by_player_2 == 2) {
                    player2_count++;
                    return ("Paper wraps rock ," + Information.name_player2 + " won in this round");
                } else {
                    player1_count++;
                    return ("Rock smashes scissor ," + Information.name_player1 + " won in this round");
                }
            } else if (Information.image_selected_by_player_1 == 2) {
                if (Information.image_selected_by_player_2 == 1) {
                    player1_count++;
                    return ("Paper wrap rock ," + Information.name_player1 + " won in this round");
                } else {
                    player2_count++;
                    return ("Scissor cuts paper ," + Information.name_player2 + " won in this round");
                }

            } else {
                if (Information.image_selected_by_player_2 == 1) {
                    player2_count++;
                    return ("Rock smashes scissor ," + Information.name_player2 + " won in this round");
                } else {
                    player1_count++;
                    return ("Scissor cuts paper ," + Information.name_player1 + " won in this round");
                }
            }
        }

    }


}
