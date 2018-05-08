package com.example.mgluc.androidshoppracadyplomowa;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class  MainActivity extends AppCompatActivity {

    Button btnSignIn,btnSignUp;
    TextView sloganWeFeedYou;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //uzycie activity_main

        btnSignIn = (Button) findViewById(R.id.btnSignIn); //referencja do obiektu btnsignin
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        sloganWeFeedYou = (TextView) findViewById(R.id.sloganWeFeedYou) ;

        Typeface font= Typeface.createFromAsset(getAssets(),"fonts/Nabila.ttf");
        sloganWeFeedYou.setTypeface(font); //ustawienie czcionki

        btnSignIn.setOnClickListener(new View.OnClickListener() { //listener na klikniecie
            @Override //klasa anonimowa, przeciazenie onClick
            public void onClick(View view) {
                Intent signIn = new Intent(MainActivity.this,SignIn.class);
                startActivity(signIn);

            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(MainActivity.this,SignUp.class);
                startActivity(signUp);

            }

        });

    }



}
