package com.example.finalmpcastillosamonte;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Guessing extends AppCompatActivity {

    ImageView imgGuess;
    ImageView imgRandom;

    EditText betNumber;
    EditText guessNumber;

    TextView txtCredentials;
    TextView txtTotalCash;

    Button btnPlaceBet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);

        ImageView homePress = (ImageView) findViewById(R.id.imgHomePress);
        imgGuess = (ImageView) findViewById(R.id.imgGuess);
        imgRandom = (ImageView) findViewById(R.id.imgRandom);
        betNumber = (EditText) findViewById(R.id.betNumber);
        guessNumber = (EditText) findViewById(R.id.guessNumber);
        txtCredentials = (TextView) findViewById(R.id.txtCredentials);
        txtTotalCash = (TextView) findViewById(R.id.txtTotalCash);
        btnPlaceBet = (Button) findViewById(R.id.btnPlaceBet);

        homePress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnPlaceBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int guess = Integer.parseInt(guessNumber.getText().toString());
                int randomNum = (int) (Math.random() * 9);
                int totalCash = Integer.parseInt(txtTotalCash.getText().toString());
                int bet = Integer.parseInt(betNumber.getText().toString());

                if (betNumber.getText().toString().isEmpty()){
                    txtCredentials.setTextColor(Color.RED);
                    txtCredentials.setText("Please enter your BET!");
                }
                else if (guessNumber.getText().toString().isEmpty()){
                    txtCredentials.setTextColor(Color.RED);
                    txtCredentials.setText("Please enter your GUESS number!");
                }

                if (totalCash == 0) {
                    btnPlaceBet.setText("Play again?");
                    txtTotalCash.setText("0");
                    createDialog(totalCash, guess, randomNum);
                } else
                    setUserImgGuess(guess, randomNum, totalCash, bet);

            }
        });
    }

    public void checkWinLose(int guess, int randomNum, int totalCash, int bet) {
        int winBet = totalCash + bet;
        int loseBet = totalCash - bet;
        if (guess == randomNum)
        {
            txtTotalCash.setText("" + winBet);
            txtCredentials.setTextColor(Color.GREEN);
            txtCredentials.setText("Congrats! You just won " + bet + " PESOS!");
        }
        else
        {
            txtTotalCash.setText("" + loseBet);
            txtCredentials.setTextColor(Color.RED); txtCredentials.setText("Aww.. You lose "+bet +" PESOS. Better luck next time!");
        }
    }

    public void setUserImgGuess(int guess, int randomNum, int totalCash, int bet){
        if (bet > totalCash) {
            overBet(bet, totalCash);
        } else
            if (guess == 0) {
                imgGuess.setImageResource(R.drawable.number0);
                setCompImgGuess(randomNum);
                checkWinLose(guess,randomNum,totalCash,bet);
            } else if (guess == 1){
                imgGuess.setImageResource(R.drawable.number1);
                setCompImgGuess(randomNum);
                checkWinLose(guess,randomNum,totalCash,bet);
            } else if (guess == 2){
                imgGuess.setImageResource(R.drawable.number2);
                setCompImgGuess(randomNum);
                checkWinLose(guess,randomNum,totalCash,bet);
            } else if (guess == 3){
                imgGuess.setImageResource(R.drawable.number3);
                setCompImgGuess(randomNum);
                checkWinLose(guess,randomNum,totalCash,bet);
            } else if (guess == 4){
                imgGuess.setImageResource(R.drawable.number4);
                setCompImgGuess(randomNum);
                checkWinLose(guess,randomNum,totalCash,bet);
            } else if (guess == 5){
                imgGuess.setImageResource(R.drawable.number5);
                setCompImgGuess(randomNum);
                checkWinLose(guess,randomNum,totalCash,bet);
            } else if (guess == 6){
                imgGuess.setImageResource(R.drawable.number6);
                setCompImgGuess(randomNum);
                checkWinLose(guess,randomNum,totalCash,bet);
            } else if (guess == 7){
                imgGuess.setImageResource(R.drawable.number7);
                setCompImgGuess(randomNum);
                checkWinLose(guess,randomNum,totalCash,bet);
            } else if (guess == 8){
                imgGuess.setImageResource(R.drawable.number8);
                setCompImgGuess(randomNum);
                checkWinLose(guess,randomNum,totalCash,bet);
            } else if (guess == 9){
                imgGuess.setImageResource(R.drawable.number9);
                setCompImgGuess(randomNum);
                checkWinLose(guess,randomNum,totalCash,bet);
            } else if (guess > 9){
                txtCredentials.setText("Only numbers [0-9] allowed to guess!");
                imgGuess.setImageResource(R.drawable.mystery);
                imgRandom.setImageResource(R.drawable.mystery);
            }
    }

    public void overBet( int bet, int totalCash){
        imgGuess.setImageResource(R.drawable.mystery);
        imgRandom.setImageResource(R.drawable.mystery);
        txtCredentials.setTextColor(Color.RED);
        txtCredentials.setText("Insufficient Funds!");
    }

    public void setCompImgGuess(int randomNum){
        if (randomNum == 0){
            imgRandom.setImageResource(R.drawable.number0);
        }
        else if (randomNum == 1){
            imgRandom.setImageResource(R.drawable.number1);
        }
        else if (randomNum == 2){
            imgRandom.setImageResource(R.drawable.number2);
        }
        else if (randomNum == 3){
            imgRandom.setImageResource(R.drawable.number3);
        }
        else if (randomNum == 4){
            imgRandom.setImageResource(R.drawable.number4);
        }
        else if (randomNum == 5){
            imgRandom.setImageResource(R.drawable.number5);
        }
        else if (randomNum == 6){
            imgRandom.setImageResource(R.drawable.number6);
        }
        else if (randomNum == 7){
            imgRandom.setImageResource(R.drawable.number7);
        }
        else if (randomNum == 8){
            imgRandom.setImageResource(R.drawable.number8);
        }
        else if (randomNum == 9){
            imgRandom.setImageResource(R.drawable.number9);
        }
    }

    public void createDialog(int totalCash, int guess, int randomNum){
        AlertDialog.Builder dialogBuild = new AlertDialog.Builder(this);
        final View popup = getLayoutInflater().inflate(R.layout.lose_popout, null);
        Button btnRetry1 = popup.findViewById(R.id.btnRetry);
        Button btnExit1 = popup.findViewById(R.id.btnExit);
        TextView txtMatchStatus1 = popup.findViewById(R.id.txtMatchStatus);

        dialogBuild.setView(popup);
        AlertDialog dialog1 = dialogBuild.create();
        dialog1.show();

        if (totalCash == 0) {
            txtMatchStatus1.setText("You Lose!");
        }

        btnExit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnRetry1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgGuess.setImageResource(R.drawable.mystery);
                imgRandom.setImageResource(R.drawable.mystery);
                betNumber.setText("");
                guessNumber.setText("");
                btnPlaceBet.setText("Place bet!");
                btnPlaceBet.setClickable(true);
                txtCredentials.setText("");
                txtTotalCash.setText("1000");
                dialog1.dismiss();
            }
        });

    }

}