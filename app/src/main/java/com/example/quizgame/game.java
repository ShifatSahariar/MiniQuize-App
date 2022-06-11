package com.example.quizgame;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.hardware.lights.LightState;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class game extends AppCompatActivity {
    MyReceiver brodcastreceiver = new MyReceiver();
    private static final String TAG = "game";
    private TextView questions,question;
    private Button option1,option2,option3,option4,nextbtn;
    private Timer quiztimer;
    private int totaltimeinminute=1;
    private int seconds =0;
    private  List<QuestionList> questionLists;
    private int currentQuestiinPosition =0;
    private String selectedoptionbyuser ="";
    private boolean Btn1Clicked,Btn2Clicked,Btn3Clicked,Btn4Clicked;
    private String whichNotClicked;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentQPos",currentQuestiinPosition);
        outState.putString("selByUser",selectedoptionbyuser);
        outState.putString("buttonNotClicked",whichNotClicked);

        questionLists.get(currentQuestiinPosition).setUseranswer(selectedoptionbyuser);




    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentQuestiinPosition = savedInstanceState.getInt("currentQPos");
        selectedoptionbyuser = savedInstanceState.getString("selByUser");
        questions.setText((currentQuestiinPosition+1)+"/"+questionLists.size());
        question.setText(questionLists.get(currentQuestiinPosition).getQuestion());
        option1.setText(questionLists.get(currentQuestiinPosition).getOption1());
        option2.setText(questionLists.get(currentQuestiinPosition).getOption2());
        option3.setText(questionLists.get(currentQuestiinPosition).getOption3());
        option4.setText(questionLists.get(currentQuestiinPosition).getOption4());
        whichNotClicked = savedInstanceState.getString("buttonNotClicked");
        switch (whichNotClicked){
                case "option1" :
                    option1.setBackgroundResource(R.drawable.round_backred);
                    option1.setTextColor(Color.WHITE);
                    revealAnswer();
                    questionLists.get(currentQuestiinPosition).setUseranswer(selectedoptionbyuser);
                    break;
                 case "option2" :
                     option2.setBackgroundResource(R.drawable.round_backred);
                     option2.setTextColor(Color.WHITE);
                     revealAnswer();
                     questionLists.get(currentQuestiinPosition).setUseranswer(selectedoptionbyuser);
                    break;
                case "option3" :
                    option3.setBackgroundResource(R.drawable.round_backred);
                    option3.setTextColor(Color.WHITE);
                    revealAnswer();
                    questionLists.get(currentQuestiinPosition).setUseranswer(selectedoptionbyuser);
                    break;
                case "option4" :
                    option4.setBackgroundResource(R.drawable.round_backred);
                    option4.setTextColor(Color.WHITE);
                    revealAnswer();
                    questionLists.get(currentQuestiinPosition).setUseranswer(selectedoptionbyuser);
                    break;
        }




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        final ImageView backbtn =findViewById(R.id.backbutton);
//        final TextView timer =findViewById(R.id.counter);
        final TextView selectedtopicname =findViewById(R.id.topicname);
        questions=findViewById(R.id.questions);
        question=findViewById(R.id.question);
        option1 =findViewById(R.id.option1);
        option2 =findViewById(R.id.option2);
        option3 =findViewById(R.id.option3);
        option4 =findViewById(R.id.option4);
        nextbtn=findViewById(R.id.nextbtn);
        final String gettopicname =getIntent().getStringExtra("topicname");
        selectedtopicname.setText(gettopicname);
        questionLists=QuestionBank.getQuestions(gettopicname);

        //startTimer(timer);
        questions.setText((currentQuestiinPosition+1)+"/"+questionLists.size());
        question.setText(questionLists.get(0).getQuestion());
        option1.setText(questionLists.get(0).getOption1());
        option2.setText(questionLists.get(0).getOption2());
        option3.setText(questionLists.get(0).getOption3());
        option4.setText(questionLists.get(0).getOption4());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedoptionbyuser.isEmpty()){
                    whichNotClicked ="option1";
                    selectedoptionbyuser =option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.round_backred);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionLists.get(currentQuestiinPosition).setUseranswer(selectedoptionbyuser);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedoptionbyuser.isEmpty()){
                    whichNotClicked ="option2";

                    selectedoptionbyuser =option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.round_backred);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionLists.get(currentQuestiinPosition).setUseranswer(selectedoptionbyuser);

                }

            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedoptionbyuser.isEmpty()){
                    whichNotClicked ="option3";
                    selectedoptionbyuser =option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.round_backred);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionLists.get(currentQuestiinPosition).setUseranswer(selectedoptionbyuser);

                }

            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedoptionbyuser.isEmpty()){
                    whichNotClicked ="option4";
                    selectedoptionbyuser =option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.round_backred);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionLists.get(currentQuestiinPosition).setUseranswer(selectedoptionbyuser);

                }

            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedoptionbyuser.isEmpty()){
                    Toast.makeText(game.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }else {
                    changeNextquestion();
                }

            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter =new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(brodcastreceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(brodcastreceiver);
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private void changeNextquestion(){
        currentQuestiinPosition++;
        if ((currentQuestiinPosition+1 ==questionLists.size())){
            nextbtn.setText("Submit Quiiz");

        }

        if (currentQuestiinPosition<questionLists.size()){

            selectedoptionbyuser="";
            option1.setBackgroundResource(R.drawable.round2);
            option1.setTextColor(Color.parseColor("#1f6BB8"));

            option2.setBackgroundResource(R.drawable.round2);
            option2.setTextColor(Color.parseColor("#1f6BB8"));
            option3.setBackgroundResource(R.drawable.round2);
            option3.setTextColor(Color.parseColor("#1f6BB8"));
            option4.setBackgroundResource(R.drawable.round2);
            option4.setTextColor(Color.parseColor("#1f6BB8"));

            questions.setText((currentQuestiinPosition+1)+"/"+questionLists.size());
            question.setText(questionLists.get(currentQuestiinPosition).getQuestion());
            option1.setText(questionLists.get(currentQuestiinPosition).getOption1());
            option2.setText(questionLists.get(currentQuestiinPosition).getOption2());
            option3.setText(questionLists.get(currentQuestiinPosition).getOption3());
            option4.setText(questionLists.get(currentQuestiinPosition).getOption4());



        } else {
            Intent intent = new Intent(game.this,results.class);
            intent.putExtra("correct",getcorrectanswers());
            intent.putExtra("incorrect",getincorrectanswers());
            startActivity(intent);
          finish();
        }
    }
/*
    private void startTimer(TextView timertextview){
        quiztimer =new Timer();

        quiztimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if(seconds==0){
                    totaltimeinminute--;
                    seconds=59;
                }
                else if(seconds ==0 && totaltimeinminute==0) {
                    quiztimer.purge();
                    quiztimer.cancel();
                    Toast.makeText(game.this, "Time Over", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(game.this,results.class);
                    intent.putExtra("correct",getcorrectanswers());
                    intent.putExtra("incorrect",getincorrectanswers());
                    startActivity(intent);
                    finish();

                }
                else{

                    seconds--;

                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalMinutes = String.valueOf(totaltimeinminute);
                        String finalSeconds = String.valueOf(seconds);

                        if (finalMinutes.length() ==1){
                            finalMinutes= "0" +finalMinutes;
                        }

                        if (finalSeconds.length() ==1){
                            finalSeconds= "0" +finalSeconds;
                        }

                        timertextview.setText(finalMinutes +":"+finalSeconds);
                    }
                });


            }
        },1000,1000);
    }
*/
    private int getcorrectanswers(){
            int correctAnswers=0;
            for (int i =0;i<questionLists.size();i++){
                final String getUserSelectedAnswer =questionLists.get(i).getUseranswer();
                final String getAnswer =questionLists.get(i).getAnswer();
                if(getUserSelectedAnswer.equals(getAnswer)){
                    correctAnswers++;
                    Log.d(TAG, "getcorrectanswers: "+correctAnswers);
                }
            }

            return correctAnswers;

        }

    private int getincorrectanswers(){
        int incorrectAnswers=0;
        for (int i =0;i<questionLists.size();i++){
            final String getUserSelectedAnswer =questionLists.get(i).getUseranswer();
            final String getAnswer =questionLists.get(i).getAnswer();
            if(!getUserSelectedAnswer.equals(getAnswer)){
                incorrectAnswers++;
            }
        }

        Log.d(TAG, "getincorrectanswers: "+incorrectAnswers);
        return incorrectAnswers;

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
       quiztimer.purge();
       quiztimer.cancel();
       Intent goback = new Intent(game.this,MainActivity.class);
       startActivity(goback);
       finish();
    }



    private void revealAnswer(){
        final String getAnswer =questionLists.get(currentQuestiinPosition).getAnswer();
        if (option1.getText().toString().equals((getAnswer))){
            option1.setBackgroundResource(R.drawable.roundbackticked);
            option1.setTextColor(Color.WHITE);
        }
        else if(option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.roundbackticked);
            option2.setTextColor(Color.WHITE);

        }else if(option3.getText().toString().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.roundbackticked);
            option3.setTextColor(Color.WHITE);

        }else if (option4.getText().toString().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.roundbackticked);
            option4.setTextColor(Color.WHITE);

        }
    }
}