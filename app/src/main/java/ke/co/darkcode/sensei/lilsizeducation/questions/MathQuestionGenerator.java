package ke.co.darkcode.sensei.lilsizeducation.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sensei on 23/12/15.
 */
public class MathQuestionGenerator {
    List<MathQuestion> questions;

    public static List<MathQuestion> generateQuestions(int no){
        List<MathQuestion> questions = new ArrayList<>();
        for(int i=0; i<no; i++){
            questions.add(generateQuestion());
        }
        return questions;
    }

    private static MathQuestion generateQuestion(){
        return null;
    }
}
