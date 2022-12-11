package com.example.finalmpcastillosamonte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtUsername = (TextView) findViewById(R.id.txtUsername);

        ImageView imgJackEnPoy  =(ImageView)findViewById(R.id.imgJackEnPoy);
        ImageView imgMemory  =(ImageView)findViewById(R.id.imgMemory);

        Intent i = getIntent();
        String myName = i.getStringExtra("my_name");
        txtUsername.setText(myName);

        imgJackEnPoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jepAct = new Intent(getApplicationContext(), JackEnPoy.class);
                startActivity(jepAct);
            }
        });


/*
        Happy Birthday! Goodmorning!
        Shawarawt kay Tri
        Yo tara na valo
*/
    }
}