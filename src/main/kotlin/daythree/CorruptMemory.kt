package daythree

import java.io.BufferedReader
import java.io.File

fun main(args: Array<String>) {

    val bufferedReader: BufferedReader = File("/Users/amins/Documents/learning-resources/advent-of-code-2024/src/main/kotlin/daythree/test.txt")
        .bufferedReader()
    val input = bufferedReader.use { it.readText() }

    val mulRegex = """mul\((\d{1,3}),\s*(\d{1,3})\)""".toRegex()
    val mulParsed = mulRegex.findAll(input)

    var partOneAnswer = 0

    mulParsed.forEach {
        println( it.groupValues )
        partOneAnswer += ( it.groupValues[1].toInt() * it.groupValues[2].toInt() )
    }

    println("Part One Answer: $partOneAnswer")
}