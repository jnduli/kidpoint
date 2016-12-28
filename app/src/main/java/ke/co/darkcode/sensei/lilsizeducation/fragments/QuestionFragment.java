package ke.co.darkcode.sensei.lilsizeducation.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import ke.co.darkcode.sensei.lilsizeducation.R;
import ke.co.darkcode.sensei.lilsizeducation.questions.MathQuestion;

/**
 * Created by sensei on 23/12/15.
 */
public class QuestionFragment extends MainActivityFragment {

    private Activity mActivity;
    MathQuestion mathQuestion;
    ImageView imageView;

    private View.OnClickListener checkBoxCheckedListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox)v;
                boolean correct = mathQuestion.isCorrect((String) cb.getText());
                //imageView.setImageResource(R.drawable.correct);
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
        CheckBox checkBox = (CheckBox) v.findViewById(R.id.checkBox);
        CheckBox checkBox2 = (CheckBox) v.findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox) v.findViewById(R.id.checkBox3);
        CheckBox checkBox4 = (CheckBox) v.findViewById(R.id.checkBox4);
        imageView = (ImageView) v.findViewById(R.id.imageView);
        imageView.setVisibility(View.INVISIBLE);

        mActivity = getActivity();
        if(mActivity instanceof MainActivityFragmentContainer ){
            MainActivityFragmentContainer questionFragmentContainer = (MainActivityFragmentContainer) mActivity;
            mathQuestion = questionFragmentContainer.getNextQuestion();

            question.setText(mathQuestion.getmQuestion());

            checkBox.setText(mathQuestion.getmOptions().get(0));
            checkBox2.setText(mathQuestion.getmOptions().get(1));
            checkBox3.setText(mathQuestion.getmOptions().get(2));
            checkBox4.setText(mathQuestion.getmOptions().get(3));

            View.OnClickListener vo = checkBoxCheckedListener();
            checkBox.setOnClickListener(vo);
            checkBox2.setOnClickListener(vo);
            checkBox3.setOnClickListener(vo);
            checkBox4.setOnClickListener(vo);
        }
        return v;
    }



}
