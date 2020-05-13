package com.example.android.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Player1Activity extends AppCompatActivity {
    //1 means rock,2 means paper,3 means scissor
    int imgnumber_player1 = 0;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        TextView textView1 = findViewById(R.id.name_player);
        textView1.setText("Hey " + Information.name_player1 + ", it's your turn!!");
        textView1.setTextColor(getResources().getColor(R.color.player1Text));

        TextView commandMessage = findViewById(R.id.command_text_view);
        commandMessage.setTextColor(getResources().getColor(R.color.player1Text));

        LinearLayout parent = (LinearLayout) findViewById(R.id.parent_layout);
        parent.setBackgroundColor(getResources().getColor(R.color.player1Background));
        ImageView rock_img = findViewById(R.id.rock_image_view);
        rock_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "rock", Toast.LENGTH_SHORT).show();
                imgnumber_player1 = 1;
                Information.image_selected_by_player_1 = imgnumber_player1;
                Intent intent = new Intent(Player1Activity.this, Player2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        ImageView paper_img = findViewById(R.id.paper_image_view);
        paper_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "paper", Toast.LENGTH_SHORT).show();
                imgnumber_player1 = 2;
                Information.image_selected_by_player_1 = imgnumber_player1;
                Intent intent = new Intent(Player1Activity.this, Player2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        ImageView scissor_img = findViewById(R.id.scissors_image_view);
        scissor_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "scissor", Toast.LENGTH_SHORT).show();
                imgnumber_player1 = 3;
                Information.image_selected_by_player_1 = imgnumber_player1;
                Intent intent = new Intent(Player1Activity.this, Player2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
