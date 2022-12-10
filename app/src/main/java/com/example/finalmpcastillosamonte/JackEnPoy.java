package com.example.finalmpcastillosamonte;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;


public class JackEnPoy extends AppCompatActivity {
    ImageView imgRock;
    ImageView imgPaper;
    ImageView imgScissors;

    TextView txtBotScore;
    TextView txtUserScore;
    TextView txtWinOrLose;

    ImageView imgBotPick;
    ImageView imgUserPick;

    int botscore;
    int userscore;
    int jackEnPoy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jack_en_poy);


        ImageView presstohome = (ImageView) findViewById(R.id.imgPressToHome);
        imgRock = (ImageView) findViewById(R.id.imgRock);
        imgPaper = (ImageView) findViewById(R.id.imgPaper);
        imgScissors = (ImageView) findViewById(R.id.imgScissors);

        txtBotScore = (TextView) findViewById(R.id.txtBotScore);
        txtUserScore = (TextView) findViewById(R.id.txtUserScore);
        txtWinOrLose = (TextView) findViewById(R.id.txtWinOrLose);

        imgBotPick = (ImageView) findViewById(R.id.imgBotPick);
        imgUserPick = (ImageView) findViewById(R.id.imgUserPick);

        botscore = Integer.parseInt(txtBotScore.getText().toString());
        userscore= Integer.parseInt(txtUserScore.getText().toString());



        presstohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });




        imgRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rps_bot = (int) (Math.random() * 3);
                jackEnPoy = 0;
                imgUserPick.setImageResource(R.drawable.rock);

                if (jackEnPoy == 0){
                    if ((jackEnPoy == 0) && (rps_bot == 2)) {
                        txtWinOrLose.setText("Your Pick Won!");

                        match(true);
                    }
                    else if ((jackEnPoy == 0) && (rps_bot == 1)) {
                        txtWinOrLose.setText("Your Pick Lost!");

                        match(false);
                    }
                    else if(jackEnPoy == rps_bot){
                        txtWinOrLose.setText("It's a Draw!");
                    }
                }
                botPickImg(rps_bot);

            }
        });

        imgPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rps_bot = (int) (Math.random() * 3);
                jackEnPoy = 1;
                imgUserPick.setImageResource(R.drawable.paper);

                if (jackEnPoy == 1){
                    if ((jackEnPoy == 1) && (rps_bot==0)) {
                        txtWinOrLose.setText("Your Pick Won!");

                        match(true);
                    }
                    else if ((jackEnPoy == 1) && (rps_bot == 2)){
                        txtWinOrLose.setText("Your Pick Lost!");

                        match(false);
                    }
                    else if (jackEnPoy == rps_bot){
                        txtWinOrLose.setText("It's a Draw!");
                    }
                }
                botPickImg(rps_bot);

            }
        });

        imgScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rps_bot = (int) (Math.random() * 3);
                jackEnPoy = 2;
                imgUserPick.setImageResource(R.drawable.scissors);


                if (jackEnPoy == 2) {
                    if ((jackEnPoy == 2) && (rps_bot==1)) {
                        txtWinOrLose.setText("Your Pick Won!");

                        match(true);
                    }
                    else if((jackEnPoy == 2)&&(rps_bot == 0)){
                        txtWinOrLose.setText("Your Pick Lost!");

                        match(false);
                    }
                    else if (jackEnPoy == rps_bot){
                        txtWinOrLose.setText("It's a Draw!");
                    }
                }
                botPickImg(rps_bot);
            }
        });
    }


    public void botPickImg(int rps_bot){
        if (rps_bot == 0){
            imgBotPick.setImageResource(R.drawable.rock);
        }
        else if (rps_bot == 1){
            imgBotPick.setImageResource(R.drawable.paper);
        }
        else{
            imgBotPick.setImageResource(R.drawable.scissors);
        }
    }
    public void match(Boolean win){
        if (win){
            userscore++;
            txtUserScore.setText(String.valueOf(userscore));
        }
        else{
            botscore++;
            txtBotScore.setText(String.valueOf(botscore));
        }

        if (userscore==10){

            createPopupDialog();

        }
        else if (botscore==10){
            createPopupDialog();

        }
    }

    public void createPopupDialog(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        final View popupView = getLayoutInflater().inflate(R.layout.winorlose_popout, null);

        Button btnRetry = popupView.findViewById(R.id.btnRetry);
        Button btnExit = popupView.findViewById(R.id.btnExit);

        TextView txtMatchStatus = popupView.findViewById(R.id.txtMatchStatus);


        dialogBuilder.setView(popupView);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();


        if (botscore == 10) {
            txtMatchStatus.setText("You Lose");
            popupView.setBackgroundResource(R.color.lose);
        }
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botscore = 0;
                userscore = 0;
                txtBotScore.setText(String.valueOf(botscore));
                txtUserScore.setText(String.valueOf(userscore));
                dialog.dismiss();
            }
        });
    }

}