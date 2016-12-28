package ke.co.darkcode.sensei.lilsizeducation.fragments;

import android.app.Fragment;

import ke.co.darkcode.sensei.lilsizeducation.questions.MathQuestion;

/**
 * Created by sensei on 28/12/15.
 */
public class MainActivityFragment extends Fragment {

    public interface MainActivityFragmentContainer{

        public MathQuestion getNextQuestion();
        public void currentQuestionFinished(boolean correct);
        public void getNextFragment();
    }
}
