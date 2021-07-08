package subtask1

class Combinator {

    fun checkChooseFromArray(array: Array<Int>) = array.iterate()

    private fun Array<Int>.iterate(): Int? {
        (1 until last()).forEach {
            (first() * factorialOf(it) * factorialOf(last() - it)).apply {
                if (factorialOf(last()) >= this) return it
            }
        }
        return null
    }

    private infix fun factorialOf(number: Int): Int {
        return when (number) {
            0, 1 -> 1
            else -> factorialOf(number - 1) * number
        }
    }
}