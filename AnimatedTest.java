package com.fce.cuba.eng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AnimatedTest extends AppCompatActivity {
    public static final int[] constant = {1, 2, 3, 4};
    final int instead = 1;
    final int rather = 2;
    final int except = 3;
    final int sooner = 4;

    final int cause = 5;
    final int mean = 6;
    final int result = 7;
    final int lead = 8;
    TextView tx, text1, tx2, answ1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_test);

        tx2 = (TextView) findViewById(R.id.answ);
        answ1 = (TextView) findViewById(R.id.answ1);
        tx = (TextView) findViewById(R.id.text);
        text1 = (TextView) findViewById(R.id.text1);
        registerForContextMenu(tx);
        registerForContextMenu(text1);


    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()){
            case R.id.text:
                menu.add(0, instead, 0, "instead");
                menu.add(0, rather, 0, "rather");
                menu.add(0, except, 0, "except");
                menu.add(0, sooner, 0, "sooner");
                break;
            case R.id.text1:
                menu.add(0, cause, 0, "cause");
                menu.add(0, mean, 0, "mean");
                menu.add(0, result, 0, "result");
                menu.add(0, lead, 0, "lead");
                break;

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case instead:
                tx2.setText("instead");
                Toast.makeText(AnimatedTest.this, "It's correct!", Toast.LENGTH_SHORT).show();
                break;
            case rather:
                Toast.makeText(AnimatedTest.this, "It's not correct!", Toast.LENGTH_SHORT).show();
                break;
            case except:
                Toast.makeText(AnimatedTest.this, "It's not correct!", Toast.LENGTH_SHORT).show();
                break;
            case sooner:
                Toast.makeText(AnimatedTest.this, "It's not correct!", Toast.LENGTH_SHORT).show();
                break;


            case cause:
                answ1.setText("cause");
                Toast.makeText(AnimatedTest.this, "It's correct!", Toast.LENGTH_SHORT).show();
                break;
            case mean:
                Toast.makeText(AnimatedTest.this, "It's not correct!", Toast.LENGTH_SHORT).show();
                break;
            case result:
                Toast.makeText(AnimatedTest.this, "It's not correct!", Toast.LENGTH_SHORT).show();
                break;
            case lead:
                Toast.makeText(AnimatedTest.this, "It's not correct!", Toast.LENGTH_SHORT).show();
                break;


        }

        return super.onContextItemSelected(item);
    }
}
