package com.fce.cuba.eng;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    LinearLayout a1, a2, b1, b2, c1, c2;
    Button btnFaq, btnTests, btnHelp, btntest, btnexam;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1 = (LinearLayout)findViewById(R.id.a1);


        btnFaq = (Button) findViewById(R.id.faq);
        btnTests = (Button) findViewById(R.id.tests);
        btnHelp = (Button) findViewById(R.id.help);
        dialog = new Dialog(this);



        btnFaq.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent("com.fce.cuba.eng.MailActivity");
                        startActivity(intent);
                    }
                });
        btnHelp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showdialog();
                    }
                });
        btnTests.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent("com.fce.cuba.eng.TestActivity");
                        startActivity(intent);

                    }
                });


    }

    public void showdialog(){
        dialog.setContentView(R.layout.dialogresults);
        btntest = (Button) dialog.findViewById(R.id.btntest);
        btnexam = (Button) dialog.findViewById(R.id.btnexam);

        btntest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = new Intent("com.fce.cuba.eng.Listening");
                startActivity(intent);
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

}


