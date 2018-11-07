package com.fce.cuba.eng;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFaq, btnTests, btnHelp;
        btnFaq = (Button) findViewById(R.id.faq);
        btnTests = (Button) findViewById(R.id.tests);
        btnHelp = (Button) findViewById(R.id.help);


        btnFaq.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick (View view){
                        Intent intent = new Intent("com.fce.cuba.eng.FaqActivity");
                        startActivity(intent);
                    }
                });
        btnHelp.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick (View view){
                        Intent intent = new Intent("com.fce.cuba.eng.HelpActivity");
                        startActivity(intent);
                    }
                });
        btnTests.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick (View view){
                        Intent intent = new Intent("com.fce.cuba.eng.HelpActivity");
                        startActivity(intent);
                    }
                });


    }


}
