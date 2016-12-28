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

        Random randomGen = new Random();
        int a = randomGen.nextInt(10);
        int b= randomGen.nextInt(10);

        String question = a +" + " + b + " = ";
        int solution = a+b;

        ArrayList<String> options = new ArrayList<>();
        String solutions = String.valueOf(solution);


        int solutionPosition = randomGen.nextInt(4);
         //generate three solutions randomly

        int count =0;

        for(int i=0; i<4; i++){
            int temp=0;
            int random =  randomGen.nextInt(4);
            while(random ==0 ) random= randomGen.nextInt(4);
            int addorsubtract = randomGen.nextInt(2);

            if(random == 0) temp = solution+random;
            else temp=solution-random;

            if(count == solutionPosition) options.add(solutions);
            else options.add(String.valueOf(temp));
            count++;
        }

        return new MathQuestion(question, solutions, options);
    }
}
