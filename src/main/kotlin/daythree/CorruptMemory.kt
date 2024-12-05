package daythree

import java.io.BufferedReader
import java.io.File

fun main(args: Array<String>) {

    val bufferedReader: BufferedReader = File("/Users/amins/Documents/learning-resources/advent-of-code-2024/src/main/kotlin/daythree/input.txt")
        .bufferedReader()
    val input = bufferedReader.use { it.readText() }

    val mulRegex = """mul\((\d{1,3}),\s*(\d{1,3})\)""".toRegex()
    val mulParsed = mulRegex.findAll(input)

    var partOneAnswer = 0

    mulParsed.forEach {
        partOneAnswer += ( it.groupValues[1].toInt() * it.groupValues[2].toInt() )
    }

    println("Part One Answer: $partOneAnswer")

    println()

    val mulCondRegex = """mul\((\d{1,3}),\s*(\d{1,3})\)|(don't\(\))|(do\(\))""".toRegex()
    val mulCondParsed = mulCondRegex.findAll(input)

    var isDisabled = false
    var partTwoAnswer = 0

    mulCondParsed.forEach {
        if (it.groupValues[3].isNotBlank()) {
            isDisabled = true
        } else if (it.groupValues[4].isNotBlank()) {
            isDisabled = false
        } else {
            if (!isDisabled) {
                partTwoAnswer += it.groupValues[1].toInt() * it.groupValues[2].toInt()
            }
        }
    }

    println("Part Two Answer: $partTwoAnswer")
}
