package com.lakj.comspace.simpletextclient;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.signin.SignIn;

public class VirtualWaitress extends Activity {

    Button btnSignIn,btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual_waitress);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);
            btnSignIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });


                btnSignUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent signUp = new Intent(VirtualWaitress.this,SignUp.class);
                        startActivity(signUp);
                        overridePendingTransition(R.anim.fadin, R.anim.fadout);

                    }
                });

                btnSignIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent signIn = new Intent(VirtualWaitress.this,SignIn.class);
                        startActivity(signIn);
                        overridePendingTransition(R.anim.fadin, R.anim.fadout);
                    }
                });
            };


     };
