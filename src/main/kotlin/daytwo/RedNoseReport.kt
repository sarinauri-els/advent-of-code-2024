package daytwo

import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    val inputStream: InputStream =
        File("/Users/amins/Documents/learning-resources/advent-of-code-2024/src/main/kotlin/daytwo/input.txt")
            .inputStream()

    var safeReportCount = 0

    inputStream.bufferedReader().forEachLine {
        val report = it.split(" ").toTypedArray()

        var isSafe = true
        var direction = ""

        val x = report[0].toInt()
        val y = report[1].toInt()

        val diff = x - y

        if (diff == 0) {
            isSafe = false
        } else if (diff > 0) {
            direction = "desc"
        } else {
            direction = "asc"
        }

        for (i in 0..< report.size - 1) {
            if (!isSafe(report[i].toInt(), report[i + 1].toInt(), direction)) {
                isSafe = false
            }
        }

        if (isSafe) {
            safeReportCount++
        }
    }

    val partOneAnswer = safeReportCount
    println("Part One Answer: $partOneAnswer")

//    val partTwoAnswer = safeReportCount + canDampen
//    println("Part Two Answer: $partTwoAnswer")
}

fun isSafe(x: Int, y: Int, direction: String): Boolean {
    val diff = x - y

    if (direction == "desc" && y < x) {
        if (diff in 1..3) {
            return true
        }
    } else if (direction == "asc" && y > x) {
        if (diff in -3..-1) {
            return true
        }
    }

    return false
}


