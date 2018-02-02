package ke.co.darkcode.sensei.lilsizeducation.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

import ke.co.darkcode.sensei.lilsizeducation.R;
import ke.co.darkcode.sensei.lilsizeducation.questions.MathQuestion;

/**
 * Created by sensei on 23/12/15.
 */
public class QuestionFragment extends MainActivityFragment {

    private Activity mActivity;
    HashMap mathQuestion;
    ImageView imageView;

    private View.OnClickListener answerInputListener(final EditText answerInput, final String answer) {
        return new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String answerGiven = String.valueOf(answerInput.getText());
                boolean correct = false;
                if (answerGiven.trim().equalsIgnoreCase(answer))
                    correct = true;

                if(correct) imageView.setImageResource(R.drawable.correct);
                else imageView.setImageResource(R.drawable.wrong);
                imageView.setVisibility(View.VISIBLE);
                ((MainActivityFragmentContainer) mActivity).currentQuestionFinished(correct);
            }
        };
    }

    private View.OnClickListener checkBoxCheckedListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox)v;
                // boolean correct = mathQuestion.isCorrect((String) cb.getText());
                //imageView.setImageResource(R.drawable.correct);
                // change this to correct viewing
                boolean correct = true;
                if(correct) imageView.setImageResource(R.drawable.correct);
                else imageView.setImageResource(R.drawable.wrong);
                imageView.setVisibility(View.VISIBLE);
                ((MainActivityFragmentContainer) mActivity).currentQuestionFinished(correct);
            }
        };
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v= inflater.inflate(R.layout.fragment_question, container, false);

        TextView question = (TextView) v.findViewById(R.id.textView);
        //enable this option
        LinearLayout answerInputMode = (LinearLayout) v.findViewById(R.id.questionAnswerLinearLayout);
        answerInputMode.setVisibility(View.VISIBLE);

        LinearLayout checkBoxInputMode = (LinearLayout) v.findViewById(R.id.checkBoxLinearLayout);
        checkBoxInputMode.setVisibility(View.INVISIBLE);

        EditText answer = (EditText) v.findViewById(R.id.questionAnswerInput);
        Button checkAnswer = (Button) v.findViewById(R.id.checkAnswerInput);
/*        CheckBox checkBox = (CheckBox) v.findViewById(R.id.checkBox);
        CheckBox checkBox2 = (CheckBox) v.findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox) v.findViewById(R.id.checkBox3);
        CheckBox checkBox4 = (CheckBox) v.findViewById(R.id.checkBox4);*/
        imageView = (ImageView) v.findViewById(R.id.imageView);
        imageView.setVisibility(View.INVISIBLE);

        mActivity = getActivity();
        if(mActivity instanceof MainActivityFragmentContainer ){
            MainActivityFragmentContainer questionFragmentContainer = (MainActivityFragmentContainer) mActivity;
            mathQuestion = questionFragmentContainer.getNextQuestion();

            question.setText(mathQuestion.get("question").toString());


//            String [] choices = (String[]) mathQuestion.get("choices");
//            Log.e("choices", choices.toString());
          /*  checkBox.setText(choices[0]);
            checkBox2.setText(choices[1]);
            checkBox3.setText(choices[2]);
            checkBox4.setText(choices[3]);
*/
//            View.OnClickListener vo = checkBoxCheckedListener();
//            checkBox.setOnClickListener(vo);
//            checkBox2.setOnClickListener(vo);
//            checkBox3.setOnClickListener(vo);
//            checkBox4.setOnClickListener(vo);
            View.OnClickListener buttonClick = answerInputListener(answer, mathQuestion.get("answer").toString());
            checkAnswer.setOnClickListener(buttonClick);
        }
        return v;
    }



}
