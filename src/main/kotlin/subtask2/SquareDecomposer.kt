package subtask2

import kotlin.collections.ArrayList
import kotlin.math.floor
import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        number.toDouble().let { n ->
            decompose(n - 1, n * n).apply {
                return this?.toTypedArray() ?: return null
            }
        }
    }

    private fun decompose(number: Double, remainSquare: Double): ArrayList<Int>? {

        when {
            remainSquare == 0.0 -> return arrayListOf()
            number <= 0.0 || remainSquare < 1.0 -> return null
            else -> (floor(sqrt(remainSquare - number * number))).apply {
                if (number == this || number < this) return null
                else decompose(this, remainSquare - number * number).apply {
                    if (this != null) {
                        add(number.toInt())
                        return this
                    }
                }
            }
        }

        return decompose(number - 1, remainSquare)
    }
}