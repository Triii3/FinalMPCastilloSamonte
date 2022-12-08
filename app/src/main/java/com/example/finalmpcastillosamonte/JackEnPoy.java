package com.example.finalmpcastillosamonte;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Scanner;

public class JackEnPoy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jack_en_poy);

        ImageView presstohome = (ImageView) findViewById(R.id.imgPressToHome);
        Button btnPopOut = (Button) findViewById(R.id.btnPopOut);
        presstohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnPopOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopupDialog();
            }
        });

        ImageView imgRock = (ImageView) findViewById(R.id.imgRock);
        ImageView imgPaper = (ImageView) findViewById(R.id.imgPaper);
        ImageView imgScissors = (ImageView) findViewById(R.id.imgScissors);

        TextView txtBotScore = (TextView) findViewById(R.id.txtBotScore);
        TextView txtUserScore = (TextView) findViewById(R.id.txtUserScore);

                Random rand = new Random();
                Scanner sc = new Scanner(System.in);
                System.out.println("Rock(0), Paper(1), Scissors(2):");

                int upperbound = 3;
                int lowerbound = 0;

                int jackEnPoy = sc.nextInt();
                int rps_bot = rand.nextInt(upperbound - lowerbound) + lowerbound;


                String result = "";
                if (jackEnPoy == 0){
                    if (jackEnPoy == rps_bot){
                        result = "It is a Draw.";
                    }
                    else if ((jackEnPoy == 0) && (rps_bot == 1)) {
                        result = "You Lost.";
                    }
                    else{
                        result = "You won!";
                    }
                }

                if (jackEnPoy == 1){
                    if ((jackEnPoy == rps_bot)) {
                        result = "It is a Draw.";
                    }
                    else if ((jackEnPoy == 1) && (rps_bot == 2)){
                        result = "You lost.";
                    }
                    else {
                        result = "You won!";
                    }
                }


                if (jackEnPoy == 2) {
                    if ((jackEnPoy == rps_bot)) {
                        result = "It is a Draw.";
                    }
                    else if((jackEnPoy == 2)&&(rps_bot == 0)){
                        result = "You lost.";
                    }
                    else{
                        result = "You won!";
                    }
                }

                System.out.println("\nYou chose"+jackEnPoy);
                System.out.println("\nThe program chose"+rps_bot);
                System.out.println(result);

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

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}