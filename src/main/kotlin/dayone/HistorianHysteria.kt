package dayone

import java.io.File
import java.io.InputStream
import kotlin.math.abs

fun main(args: Array<String>) {
    val inputStream: InputStream = File("/Users/amins/Documents/learning-resources/advent-of-code-2024/src/main/kotlin/dayone/input.txt").inputStream()
    val listOne = mutableListOf<Int>()
    val listTwo = mutableListOf<Int>()

    inputStream.bufferedReader().forEachLine {
        val splitStr = it.split("   ").toTypedArray()

        listOne.add(splitStr[0].toInt())
        listTwo.add(splitStr[1].toInt())
    }

    listOne.sort()
    listTwo.sort()

    var partOneTotal = 0

    for (i in listOne.indices) {
        partOneTotal += abs(listOne[i] - listTwo[i])
    }

    println("Part One Answer: $partOneTotal")

    var partTwoTotal = 0

    for (i in listOne) {
        partTwoTotal += i * listTwo.count{it == i}
    }

    println("Part Two Answer: $partTwoTotal")
}
