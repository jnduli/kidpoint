package ke.co.darkcode.sensei.lilsizeducation.questions;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import ke.co.darkcode.sensei.lilsizeducation.utils.SettingsUtils;

/**
 * Created by sensei on 23/12/15.
 */
public class MathQuestionGenerator {

    public static List<HashMap> generateQuestions(int no, Context con){
        MathQuestions generator = new MathQuestions(SettingsUtils.getMathsLevel(con));
        List<HashMap> questions = new ArrayList<>();
        for(int i=0; i<no; i++){
            questions.add(generator.generateQuestion());
        }
        return questions;
    }
}
