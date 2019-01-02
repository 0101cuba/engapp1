package com.fce.cuba.eng;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
    LinearLayout a1, a2, b1, b2, c1, c2;
    Button btntest, btnexam;
    Dialog dialog;
    int nazhataya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1 = (LinearLayout)findViewById(R.id.a1);
        a2 = (LinearLayout)findViewById(R.id.a2);
        b1 = (LinearLayout)findViewById(R.id.b1);
        b2 = (LinearLayout)findViewById(R.id.b2);
        c1 = (LinearLayout)findViewById(R.id.c1);
        c2 = (LinearLayout)findViewById(R.id.c2);
        dialog = new Dialog(this);


        a1.setOnClickListener(new Click());
        a2.setOnClickListener(new Click());
        b1.setOnClickListener(new Click());
        b2.setOnClickListener(new Click());
        c1.setOnClickListener(new Click());
        c2.setOnClickListener(new Click());


    }


    public class Click implements View.OnClickListener{

        @Override
        public void onClick(View v){
            dialog.setContentView(R.layout.dialogresults);
            btntest = (Button) dialog.findViewById(R.id.btntest);
            btnexam = (Button) dialog.findViewById(R.id.btnexam);
            switch (v.getId()){
                case R.id.a1:
                    btntest.setOnClickListener(new ClickOnDialog());
                    btnexam.setOnClickListener(new ClickOnDialog());
                    break;
                case R.id.a2:
                    btntest.setOnClickListener(new ClickOnDialog());
                    btnexam.setOnClickListener(new ClickOnDialog());
                    break;
                case R.id.b1:
                    btntest.setOnClickListener(new ClickOnDialog());
                    btnexam.setOnClickListener(new ClickOnDialog());
                    break;
                case R.id.b2:
                    btntest.setOnClickListener(new ClickOnDialog());
                    btnexam.setOnClickListener(new ClickOnDialog());
                    break;
                case R.id.c1:
                    btntest.setOnClickListener(new ClickOnDialog());
                    btnexam.setOnClickListener(new ClickOnDialog());
                    break;
                case R.id.c2:
                    btntest.setOnClickListener(new ClickOnDialog());
                    btnexam.setOnClickListener(new ClickOnDialog());
                    break;
            }
            nazhataya = v.getId();
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        }



        public class ClickOnDialog implements View.OnClickListener{
            @Override
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.btntest:
                        dialog.dismiss();
                        if(nazhataya == R.id.a1){
                        Intent intent = new Intent("com.fce.cuba.eng.Listening");
                        startActivity(intent);}
                        if(nazhataya == R.id.a2){
                            Intent intent = new Intent("com.fce.cuba.eng.TestActivity");
                            startActivity(intent);}
                        if(nazhataya == R.id.b1){
                            Intent intent = new Intent("com.fce.cuba.eng.MailActivity");
                            startActivity(intent);}
                        if(nazhataya == R.id.b2){
                            Intent intent = new Intent("com.fce.cuba.eng.TestActivity");
                            startActivity(intent);}
                        if(nazhataya == R.id.c1){
                            Intent intent = new Intent("com.fce.cuba.eng.MailActivity");
                            startActivity(intent);}
                        if(nazhataya == R.id.c2){
                            Intent intent = new Intent("com.fce.cuba.eng.Listening");
                            startActivity(intent);}
                        break;
                    case R.id.btnexam:
                        dialog.dismiss();
                        if(nazhataya == R.id.a1){
                            Intent intent = new Intent("com.fce.cuba.eng.MailActivity");
                            startActivity(intent);}
                        if(nazhataya == R.id.a2){
                            Intent intent = new Intent("com.fce.cuba.eng.AnimatedTest");
                            startActivity(intent);}
                        if(nazhataya == R.id.b1){
                            Intent intent = new Intent("com.fce.cuba.eng.Listening");
                            startActivity(intent);}
                        if(nazhataya == R.id.b2){
                            Intent intent = new Intent("com.fce.cuba.eng.AnimatedTest");
                            startActivity(intent);}
                        if(nazhataya == R.id.c1){
                            Intent intent = new Intent("com.fce.cuba.eng.Listening");
                            startActivity(intent);}
                        if(nazhataya == R.id.c2){
                            Intent intent = new Intent("com.fce.cuba.eng.MailActivity");
                            startActivity(intent);}
                        break;

                }
            }
        }
    }
}


