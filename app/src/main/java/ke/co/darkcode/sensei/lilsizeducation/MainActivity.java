package ke.co.darkcode.sensei.lilsizeducation;

import android.app.FragmentTransaction;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import java.util.HashMap;
import java.util.List;

import ke.co.darkcode.sensei.lilsizeducation.fragments.IntroductionFragment;
import ke.co.darkcode.sensei.lilsizeducation.fragments.MainActivityFragment;
import ke.co.darkcode.sensei.lilsizeducation.fragments.QuestionFragment;
import ke.co.darkcode.sensei.lilsizeducation.fragments.ResultsFragment;
import ke.co.darkcode.sensei.lilsizeducation.questions.MathQuestion;
import ke.co.darkcode.sensei.lilsizeducation.questions.MathQuestionGenerator;

public class MainActivity extends AppCompatActivity implements MainActivityFragment.MainActivityFragmentContainer{

    List<HashMap> mathQuestions;
    int position;
    FragmentTransaction transaction;
    int score;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score =0;
                position =-1;
                changeFragment();
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
            }
        });

        position =-1;
        score =0;
        changeFragment();
    }

    private void changeFragment(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.enter_anim, R.animator.exit_anim);
        transaction.replace(R.id.question_content, getCurrentFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private MainActivityFragment getCurrentFragment(){
        MainActivityFragment mainActivityFragment = null;
        if(position<0){
            mathQuestions = MathQuestionGenerator.generateQuestions(10);
            position++;
            mainActivityFragment = new IntroductionFragment();
        }else if(position >= mathQuestions.size()){
            mainActivityFragment = new ResultsFragment();
        }else{
           mainActivityFragment = new QuestionFragment();
        }
        return  mainActivityFragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public HashMap getNextQuestion() {
        return mathQuestions.get(position++);
    }


    @Override
    public void currentQuestionFinished(boolean correct) {
        if(mediaPlayer != null){
            mediaPlayer.reset();
            mediaPlayer.release();
        }

        if(correct){
            mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            score++;
        }else{
            mediaPlayer = MediaPlayer.create(this, R.raw.incorrect);
        }

        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                changeFragment();
            }
        });

    }

    @Override
    public void getNextFragment() {
        changeFragment();
    }

    public String finalResult(){
        String s = score+"/"+(position);
        position = -1;
        score =0;
        return s;
    }

}
