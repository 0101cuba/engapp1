TextView elapsedTimeLabel, remainingTimeLabel;
    int totalTime;
    SeekBar positionBar;



elapsedTimeLabel = (TextView)findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = (TextView)findViewById(R.id.remainingTimeLabel);
        positionBar = (SeekBar)findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
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
        // Thread (positionBar and timelabel)
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
        
        
        
        totalTime = mp.getDuration();
        
        
        
        
        
        
        
        
        
        
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
            elapsedTimeLabel.setText("- " +remainingTime);
        }
    };

    public String createTimeLabel (int time){
        String timeLable = "";
        int min = time / 1000 / 60;
        int sec = time % 1000 % 60;

        timeLable = min + ":";
        if (sec<10) timeLable += "0";
        timeLable += sec;

        return timeLable;
    }
