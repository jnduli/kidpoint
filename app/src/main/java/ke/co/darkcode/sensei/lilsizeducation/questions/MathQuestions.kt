package ke.co.darkcode.sensei.lilsizeducation.questions

/**
 * Created by rookie on 1/1/18.
 */
class MathQuestions(val level: Int): Questionable{
    var question: String = ""
    var choises: Array<String> = null
    fun generateQuestion() {

    }
    override fun getNextQuestion(): String {
        return "1 + 1"
    }

    override fun getChoices(): Array<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCorrect(chosen: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}