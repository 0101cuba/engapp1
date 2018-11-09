package com.fce.cuba.eng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ImageView;
    Button viewy, viewno, button, button1, button2, button3;

    //private List<Button> buttons;
   // private static final int[] BUTTON_IDS = {
          //  R.id.correct1,
            //R.id.correct2,
            //R.id.correct3,
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button button = (Button)findViewById(R.id.correct);
        Button button1 = (Button)findViewById(R.id.correct1);
        Button button2 = (Button)findViewById(R.id.correct2);
        Button button3 = (Button)findViewById(R.id.correct3);


        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);}
    @Override
    public void onClick (View v) {
        ImageView ImageView = (ImageView)findViewById(R.id.imageView3);
        switch (v.getId()) {
           case R.id.correct:
               ImageView.setImageResource(R.drawable.yes);
               Toast.makeText(TestActivity.this, "You were right!", Toast.LENGTH_SHORT).show();
               break;
           case R.id.correct1:
               ImageView.setImageResource(R.drawable.no);
               Toast.makeText(TestActivity.this, "It's not correct!", Toast.LENGTH_SHORT).show();
               break;
           case R.id.correct2:
               ImageView.setImageResource(R.drawable.no);
               Toast.makeText(TestActivity.this, "It's not correct!", Toast.LENGTH_SHORT).show();
               break;
           case R.id.correct3:
               ImageView.setImageResource(R.drawable.no);
               Toast.makeText(TestActivity.this, "It's not correct!", Toast.LENGTH_SHORT).show();
               break;
       }
        }



}






_________________
Человеческий способ
package com.fce.cuba.eng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    ImageView ImageView;
    Button viewy, viewno;

    private List<Button> buttons, correctbuttons;
    private static final int[] BUTTON_IDS = {
            R.id.correct1,
            R.id.correct2,
            R.id.correct3,

    };
    private static final int[] BUTTON_IDSe = {
            R.id.correct,
            R.id.eweodincorerct,

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        buttons = new ArrayList<Button>();
        // or slightly better
        // buttons = new ArrayList<Button>(BUTTON_IDS.length);
        for(int id : BUTTON_IDS) {
            Button button = (Button)findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageView = (ImageView) findViewById(R.id.imageView3);
                    ImageView.setImageResource(R.drawable.no);
                    Toast.makeText(TestActivity.this, "It's not correct!", Toast.LENGTH_SHORT).show();
                }
            });
            buttons.add(button); //hz zachem, vzyal so stackoverflow
        }

        correctbuttons = new ArrayList<Button>();
        // or slightly better
        // buttons = new ArrayList<Button>(BUTTON_IDS.length);
        for(int id : BUTTON_IDSe) {
            Button button = (Button)findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageView = (ImageView) findViewById(R.id.imageView3);
                    ImageView.setImageResource(R.drawable.yes);
                    Toast.makeText(TestActivity.this, "You were right!", Toast.LENGTH_SHORT).show();
                }
            });
            correctbuttons.add(button); //hz zachem, vzyal so stackoverflow
        }




    }
}
