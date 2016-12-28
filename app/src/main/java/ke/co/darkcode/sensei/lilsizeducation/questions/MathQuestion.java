package ke.co.darkcode.sensei.lilsizeducation.questions;

import java.util.List;

/**
 * Created by sensei on 23/12/15.
 */
public class MathQuestion {

    private String mQuestion;
    private String mSolution;
    private List<String> mOptions;

    public List<String> getmOptions() {
        return mOptions;
    }

    public String getmQuestion() {
        return mQuestion;
    }

    public String getmSolution() {
        return mSolution;
    }

    public MathQuestion(String question, String solution, List<String> options){
        mQuestion = question;
        mSolution = solution;
        mOptions = options;
    }

    public boolean isCorrect(String chosenSolution){
        return chosenSolution==mSolution;
    }


}
