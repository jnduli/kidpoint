package ke.co.darkcode.sensei.lilsizeducation.questions

/**
 * Created by rookie on 1/1/18.
 */

interface Questionable {

    fun getNextQuestion() : String
    fun getChoices() : Array<String>
    fun isCorrect(chosen: String) : Boolean

}