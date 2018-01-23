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
        val question = level1.getNextQuestion().split(" ")
        assertThat(question.size, `is`(3))
        //val firstNo = question.split(" ".toRegex()


    }
}