package com.fce.cuba.eng;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class Listening extends AppCompatActivity {
    private Arrays mQuestionLibrary = new Arrays();
    private Button mButtonChoice1, mButtonChoice2, mButtonChoice3, mButtonChoice4;
    private String mAnswer;
    private int mQuestionNumber = 0;
    private TextView mQuestionView;


    Button playBtn;
    SeekBar volumeBar;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening);

        playBtn = (Button)findViewById(R.id.playbtn);
        volumeBar = (SeekBar)findViewById(R.id.seekbar);
        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volumeNum = progress / 100f;
                mp.setVolume(volumeNum, volumeNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //mediaplayer
        mp = MediaPlayer.create(this, mQuestionLibrary.getMusic(0));
        mp.setLooping(true);
        mp.seekTo(0);
        mp.setVolume(0.5f, 0.5f);


        //working with arrays
        mButtonChoice1 = (Button)findViewById(R.id.btn1);
        mButtonChoice2 = (Button)findViewById(R.id.btn2);
        mButtonChoice3 = (Button)findViewById(R.id.btn3);
        mButtonChoice4 = (Button)findViewById(R.id.btn4);
        mQuestionView = (TextView)findViewById(R.id.textQuestions);
        updateQuestion();

        }

    public void updateQuestion () {
        if(mQuestionNumber<mQuestionLibrary.getLength()){
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber, 4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;

        } else
            Toast.makeText(Listening.this, "It's done", Toast.LENGTH_SHORT).show();
        //mp.stop();
    }



    public void onClick (View view){
        Button answer = (Button) view;
        if(answer.getText()== mAnswer){
            Toast.makeText(Listening.this, "You are right!", Toast.LENGTH_SHORT).show();
            mp.stop();
            playBtn.setBackgroundResource(R.drawable.play);
        }else
            mp.stop();
            playBtn.setBackgroundResource(R.drawable.play);
            Toast.makeText(Listening.this, "Fuck you!", Toast.LENGTH_SHORT).show();
        updateQuestion();
    }



    public void setPlayBtn (View view) {
        if (!mp.isPlaying()) {
            mp.start();
            playBtn.setBackgroundResource(R.drawable.stop);
        } else {
            mp.pause();
            playBtn.setBackgroundResource(R.drawable.play);
        }


    }


    /* private static final int[] btns ={
            R.id.btn1,
            R.id.btn2,
            R.id.btn4,
    };

    public void callmassive () {
        for (int id : btns)
        {
            Button button = (Button) findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent("com.fce.cuba.eng.FaqActivity");
                    startActivity(intent);
                }
            });
        }*/

}
