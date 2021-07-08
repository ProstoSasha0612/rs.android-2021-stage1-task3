package subtask2

import kotlin.math.sqrt

class SquareDecomposer {
    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 5) return null
        val res = mutableListOf<Int>()
        val n = number - 1
        res.add(n)
        val value = number * number - n * n
        val sqr = sqrt(value.toFloat()).toInt()
        res.addAll(value.findSolve(sqr))
        return if (res.contains(-1)) null else res.reversed().toTypedArray() //-1 находится в res, если невозможно
        // осуществить разложение на сумму квадратов
    }
}

private fun Int.findSolve(n: Int): List<Int> {
    val res = mutableListOf<Int>()
    if (this == 0) return res //выход из "успешной" рекурсии
    if (this.isSolveUnExist(n)) {
        return listOf(-1)
    } else {
        res.add(n)
        res.addAll((this - n * n).findSolve(sqrt((this - n * n).toFloat()).toInt()))
    }
    if (res.contains(-1)) {
        res.clear()
        res.addAll((this).findSolve(n - 1))
    }
    return res

}

private fun Int.isSolveUnExist(n: Int): Boolean {
    if (this >= 1000) return false
    var sum = (1..n).reduce { acc, i -> acc + i * i }
    return sum < this
}


