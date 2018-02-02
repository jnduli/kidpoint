package ke.co.darkcode.sensei.lilsizeducation

import ke.co.darkcode.sensei.lilsizeducation.questions.MathQuestions
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

/**
 * Created by rookie on 1/1/18.
 */

class MathQuestionsTest{

    @Test fun level1QuestionsGenerationTest(){
        val level1 = MathQuestions(1)
        // level 1 should only contain additions of single digit numbers
        val quiz = level1.generateQuestion()
        assertThat(quiz.get("question").toString().contains('+'), `is`(true))
        val first: String = quiz.get("question").toString().split('+')[0].trim();
        assertThat(first.length, `is`(1))
    }
    @Test fun level2QuestionsGenerationTest(){
        // level 2 should contain addition and subtraction of single digit numbers
        val level2 = MathQuestions(2)
        var question = level2.generateQuestion()
        assertThat(question.size, `is`(2))

        //at least one question should be - and one question + in group of 10 questions
        var plusFound = false
        var subtFound = false
        for (i in 1..10){
            question = level2.generateQuestion()
            if (question.get("question").toString().contains('-'))
                subtFound = true
            if (question.get("question").toString().contains('+'))
                plusFound = true
        }

        assertThat(plusFound, `is` (true))
        assertThat(subtFound, `is` (true))
    }

    @Test fun level3QuestionsGenerationTest() {
        val level3 = MathQuestions(3)
        var question = level3.generateQuestion()
        // at least some questions should have 2 digits
        var twoDigitsFound = false
        var plusFound = false
        var subtFound = false

        for (i in 1..10) {
            val questionString = question.get("question").toString()
            if (questionString.contains('-')) {
                subtFound = true
                if (questionString.split('-')[0].trim().length == 2)
                    twoDigitsFound = true
            }else if (questionString.contains('+')) {
                plusFound = true
                if (questionString.split('+')[0].trim().length == 2)
                    twoDigitsFound = true
            }
            question = level3.generateQuestion()
        }
        assertThat(plusFound, `is` (true))
        assertThat(subtFound, `is` (true))
        assertThat(twoDigitsFound, `is` (true))

    }
}