package com.example.android.rockpaperscissor;

public class Information {
    public static String name_player1=null;
    public static String name_player2=null;
    public static int number_of_rounds=0;
    public static int image_selected_by_player_1=0;
    public static int image_selected_by_player_2=0;
    public static int player1_current_score=0;
    public static int player2_current_score=0;
    public static int current_round_number=1;
    public Information(String player1,String player2,int no_of_rounds){
        name_player1=player1;
        name_player2=player2;
        number_of_rounds=no_of_rounds;
    }


}
