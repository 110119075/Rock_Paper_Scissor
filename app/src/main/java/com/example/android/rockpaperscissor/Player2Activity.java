package com.example.android.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Player2Activity extends AppCompatActivity {
    int imgPlayer2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        TextView textView2 = findViewById(R.id.name_player);
        textView2.setText("Hey " + Information.name_player2 + ", now your turn!!");

        textView2.setTextColor(getResources().getColor(R.color.player2Text));
        TextView commandMessage = findViewById(R.id.command_text_view);
        commandMessage.setTextColor(getResources().getColor(R.color.player2Text));
        LinearLayout parent = (LinearLayout) findViewById(R.id.parent_layout);
        parent.setBackgroundColor(getResources().getColor(R.color.player2Background));


        ImageView rock_img = findViewById(R.id.rock_image_view);
        rock_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "rock", Toast.LENGTH_SHORT).show();
                imgPlayer2 = 1;
                Information.image_selected_by_player_2 = imgPlayer2;
                Intent intent = new Intent(Player2Activity.this, ScoreActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ImageView paper_img = findViewById(R.id.paper_image_view);
        paper_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "paper", Toast.LENGTH_SHORT).show();
                imgPlayer2 = 2;
                Information.image_selected_by_player_2 = imgPlayer2;
                Intent intent = new Intent(Player2Activity.this, ScoreActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ImageView scissor_img = findViewById(R.id.scissors_image_view);
        scissor_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "scissor", Toast.LENGTH_SHORT).show();
                imgPlayer2 = 3;
                Information.image_selected_by_player_2 = imgPlayer2;
                Intent intent = new Intent(Player2Activity.this, ScoreActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
