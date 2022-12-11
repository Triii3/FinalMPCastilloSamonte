package com.example.finalmpcastillosamonte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editUsername = (EditText) findViewById(R.id.editUsername);
        Button btnUsername = (Button) findViewById(R.id.btnUsername);

        btnUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myUsername = editUsername.getText().toString();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("my_name",myUsername);
                startActivity(i);
                finish();
            }
        });

    }
}