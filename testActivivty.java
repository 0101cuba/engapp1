 public void getAnsw () {
        viewy = (Button) findViewById(R.id.correct);
        viewno = (Button)findViewById(R.id.correct1);
        img = (ImageView)findViewById(R.id.que);

        viewy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                img.setImageResource(R.drawable.yes);
            }
        });
