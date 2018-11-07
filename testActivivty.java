package com.fce.cuba.eng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {
    ImageView ImageView;
    Button viewy, viewno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        viewy = (Button) findViewById(R.id.correct);
        viewno = (Button) findViewById(R.id.correct1);
        ImageView = (ImageView) findViewById(R.id.imageView3);

       viewy.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView.setImageResource(R.drawable.yes);
                Toast.makeText(TestActivity.this, "You were right!", Toast.LENGTH_SHORT).show();
           }
        });

       viewno.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ImageView.setImageResource(R.drawable.no);
               Toast.makeText(TestActivity.this, "It's not correct!", Toast.LENGTH_SHORT).show();
           }
       });
    }
    
}

