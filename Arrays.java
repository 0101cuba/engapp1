package com.fce.cuba.eng;

public class Arrays {
    private int musics [] = {R.raw.sad, R.raw.sad2, R.raw.sad3, R.raw.sad4};

    private String textQuestions [] = {
            "1. FUck you",
            "2. I said fuck you",
            "3. AInt got me?",
            "4. Fuuuck you"
    };


    private String multipleChoice[][] = {
            {"P1", "P2", "P3", "P4",},
            {"P5", "P6", "P7", "P8",},
            {"P9", "P10", "P11", "P12",},
            {"P13", "P14", "P15", "P16"}
    };

    private String mCorrectAnswers[] = {"P2", "P8", "P9", "P16"};


    public int getLength(){
        return textQuestions.length;
    }
    public int getMusic (int a){
        int music = musics[a];
        return music;
    }

    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }



    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num-1];
        return choice0;

    }
    public String getCorrectAnswer (int a) {
        String b = mCorrectAnswers[a];
        return b;
    }

}
