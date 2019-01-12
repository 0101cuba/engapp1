package com.fce.cuba.eng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    ImageView ImageView;
    ViewGroup v;

    //Button viewy, viewno;

    private List<ImageView> correctImageView, notcorrectImageView;
    public final int[] notcorrectIMAGEVIEW_IDS = {
            R.id.imageView,

    };

    private List<Button> notcorrectbuttons, correctbuttons;
    private static final int[] notcorrectBUTTON_IDS = {
            R.id.button1,
            R.id.button2,
            R.id.button3,
    };
    private static final int[] correctbuttonsBUTTON_IDSe = {
            R.id.button,

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

       // notcorrectbuttons = new ArrayList<Button>();
        // or slightly better
        // buttons = new ArrayList<Button>(BUTTON_IDS.length);
        for(int id : notcorrectBUTTON_IDS) {
            Button button = (Button)findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    notcorrectImageView = new ArrayList<ImageView>();
                    for(int id : notcorrectIMAGEVIEW_IDS){
                       ImageView ImageView = (ImageView)findViewById(id);

                    //ImageView = (ImageView) findViewById(R.id.imageView);
                    ImageView.setImageResource(R.drawable.no);}
                    Toast.makeText(TestActivity.this, "It's not correct!", Toast.LENGTH_SHORT).show();

                }
            });

            //notcorrectbuttons.add(button); //hz zachem, vzyal so stackoverflow
        }

        //correctbuttons = new ArrayList<Button>();
        // or slightly better
        // buttons = new ArrayList<Button>(BUTTON_IDS.length);
        for(int id : correctbuttonsBUTTON_IDSe) {
            Button button = (Button)findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageView = (ImageView) findViewById(R.id.imageView);
                    ImageView.setImageResource(R.drawable.yes);
                    Toast.makeText(TestActivity.this, "You are right!", Toast.LENGTH_SHORT).show();
                }
            });
            //correctbuttons.add(button); //hz zachem, vzyal so stackoverflow
        }



    }




}
