package ke.co.darkcode.sensei.lilsizeducation.questions

/**
 * Created by rookie on 1/1/18.
 */
class MathQuestions(val level: Int){

    companion object {
        val MAX_MATHS_LEVEL = 6
    }

    // TODO: fix and test choices, fix and test answer
    fun generateQuestion(): HashMap<String, Any> {
        val operations = arrayOf('+', '-', '*', '/')
        var randomLimit = 10;
        var operationsIndex = 1

        when (level) {
            1 -> {
                randomLimit = 10
                operationsIndex = 1
            }
            2 -> {
                randomLimit = 10
                operationsIndex = 2
            }
            3 -> {
                randomLimit = 100
                operationsIndex = 2
            }
            4 -> {
                randomLimit = 10000
                operationsIndex = 3
            }
            5 -> {
                randomLimit = 1000
                operationsIndex = 4
            }
            6 -> {
                randomLimit = 100000
                operationsIndex = 4
            }
        }


        var first = (Math.random() * randomLimit).toInt();
        var operation = operations[(Math.random() * operationsIndex).toInt()]
        var second = (Math.random() * randomLimit).toInt();


        val question = HashMap<String, Any>()
        question.put("question", generateQuestionString(first, operation, second))
        question.put("answer", generateAnswer(first, operation, second))

        return question
    }

    fun generateQuestionString (first :Int, operation: Char, second :Int) : String{
        var firstString = first
        var secondString = second
        if (operation == '-' || operation == '/') {
            if (second > first) {
                firstString = second
                secondString = first
            }
        }
        return firstString.toString() + operation + secondString.toString()
    }

    fun generateAnswer(first :Int, operation: Char, second :Int) : String {
        var answer = 0
        when (operation) {
            '+' -> answer = first + second
            '-' -> answer = Math.abs(first - second)
            '*' -> answer = first * second
            '/' -> {
                if (second > first) {
                    answer = second / first
                }
                answer = first / second
            }

        }
        return answer.toString()
    }
}