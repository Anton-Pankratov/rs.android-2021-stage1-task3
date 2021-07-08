package subtask3

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.startsWith('-')) return null
        val numbers = arrayListOf<String>()
        number.forEachIndexed { index, keyChar ->
            combinations[keyChar]?.forEach { neighbour ->
                numbers.add(number.replace(number.elementAt(index), neighbour))
            }
        }
        return numbers.toTypedArray()
    }

    private val combinations = mapOf('1' to "24", '2' to "135",
        '3' to "26", '4' to "157", '5' to "2468", '6' to "359",
        '7' to "48", '8' to "5790", '9' to "68", '0' to "8"
    )
}
