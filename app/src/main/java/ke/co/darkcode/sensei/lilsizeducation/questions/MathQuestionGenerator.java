package ke.co.darkcode.sensei.lilsizeducation.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by sensei on 23/12/15.
 */
public class MathQuestionGenerator {

    public static List<HashMap> generateQuestions(int no){
        MathQuestions generator = new MathQuestions(3);
        List<HashMap> questions = new ArrayList<>();
        for(int i=0; i<no; i++){
            questions.add(generator.generateQuestion());
        }
        return questions;
    }
}
