package subtask3

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number[0] == '-') return null
        val res = mutableListOf<String>()
        for (i in number.indices) {
            for (j in 0 until number[i].toString().neighbors.size) {
                res.add(number.replaceRange(i..i, number[i].toString().neighbors[j]))
            }
        }
        return res.toTypedArray()
    }

    private val String.neighbors: List<String>
        get() = when (this) {
            "0" -> listOf("8")
            "1" -> listOf("2", "4")
            "2" -> listOf("1", "5", "3")
            "3" -> listOf("2", "6")
            "4" -> listOf("1", "5", "7")
            "5" -> listOf("2", "4", "6", "8")
            "6" -> listOf("3", "5", "9")
            "7" -> listOf("4", "8")
            "8" -> listOf("7", "5", "9", "0")
            "9" -> listOf("6", "8")
            else -> emptyList()
        }
}
