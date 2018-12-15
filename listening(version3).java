package com.fce.cuba.eng;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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


    //mediaplayer
    Button playBtn;
    SeekBar volumeBar;
    MediaPlayer mp;
    TextView elapsedTimeLabel, remainingTimeLabel;
    int totalTime;
    SeekBar positionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening);


        elapsedTimeLabel = (TextView)findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = (TextView)findViewById(R.id.remainingTimeLabel);
        positionBar = (SeekBar)findViewById(R.id.positionBar);



        //working with arrays


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
        }
        );

        positionBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser){
                            mp.seekTo(progress);
                            positionBar.setProgress(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
        mButtonChoice1 = (Button)findViewById(R.id.btn1);
        mButtonChoice2 = (Button)findViewById(R.id.btn2);
        mButtonChoice3 = (Button)findViewById(R.id.btn3);
        mButtonChoice4 = (Button)findViewById(R.id.btn4);
        updateQuestion();

    }

    public void updateQuestion () {

        if(mQuestionNumber<mQuestionLibrary.getLength()){
            mp = MediaPlayer.create(this, mQuestionLibrary.getMusic(mQuestionNumber));
            mp.setLooping(true);
            mp.seekTo(0);
            mp.setVolume(0.5f, 0.5f);
            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber, 4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);

            totalTime = mp.getDuration();
            positionBar.setMax(totalTime);

            mQuestionNumber++;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(mp != null){
                        try{
                            Message msg = new Message ();
                            msg.what = mp.getCurrentPosition();
                            handler.sendMessage(msg);

                            Thread.sleep(1000);
                        }catch (InterruptedException e){}
                    }
                }
            }).start();

        } else {
            mp.stop();
            Toast.makeText(Listening.this, "It's done", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent("com.fce.cuba.eng.MailActivity");
            startActivity(intent);
        }

    }



    public void onClick (View view){
        Button answer = (Button) view;
        if(answer.getText()== mAnswer){
            Toast.makeText(Listening.this, "You are right!", Toast.LENGTH_SHORT).show();
            mp.stop();
            playBtn.setBackgroundResource(R.drawable.play);
        }else
            Toast.makeText(Listening.this, "No!", Toast.LENGTH_SHORT).show();
        mp.stop();
        playBtn.setBackgroundResource(R.drawable.play);

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

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int currentPosition = msg.what;
            //Update PositionBar
            positionBar.setProgress(currentPosition);

            //Update Labels
            String elapsedTime = createTimeLabel(currentPosition);
            elapsedTimeLabel.setText(elapsedTime);

            String remainingTime = createTimeLabel(totalTime-currentPosition);
            remainingTimeLabel.setText("- " +remainingTime);
        }
    };

    public String createTimeLabel (int time){
        String timeLable = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLable = min + ":";
        if (sec<10) timeLable += "0";
        timeLable += sec;

        return timeLable;
    }


    public void onBackPressed()
    {
        if (mp.isPlaying()) {
        mp.stop();}
        mQuestionNumber = 0;
        super.onBackPressed(); // or dialog.dismiss();

    }
}
