package dayfour

import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    val inputStream: InputStream = File("/Users/amins/Documents/learning-resources/advent-of-code-2024/src/main/kotlin/dayfour/test.txt").inputStream()
    val crossword = mutableListOf<MutableList<Char>>()

    inputStream.bufferedReader().forEachLine { it ->
        val row = mutableListOf<Char>()
        it.forEach {  row.add(it) }
        crossword.add(row)
    }

    var xmasCount = 0
    var masCount = 0


    for (x in crossword.indices) {
        for (y in crossword[x].indices) {
            if (crossword[x][y] == 'X') {
                var word = "XMAS"

                if (checkWest(crossword, x, y, word)) {
                    xmasCount++
                }

                if (checkEast(crossword, x, y, word)) {
                    xmasCount++
                }

                if (checkNorth(crossword, x, y, word)) {
                    xmasCount++
                }

                if (checkSouth(crossword, x, y, word)) {
                    xmasCount++
                }

                if (checkNorthWest(crossword, x, y, word)) {
                    xmasCount++
                }

                if (checkNorthEast(crossword, x, y, word)) {
                    xmasCount++
                }

                if (checkSouthEast(crossword, x, y, word)) {
                    xmasCount++
                }

                if (checkSouthWest(crossword, x, y, word)) {
                    xmasCount++
                }

                word = "MAS"

                if (checkNorthWest(crossword, x, y, word)) {
                    masCount++
                }

                if (checkNorthEast(crossword, x, y, word)) {
                    masCount++
                }

                if (checkSouthEast(crossword, x, y, word)) {
                    masCount++
                }

                if (checkSouthWest(crossword, x, y, word)) {
                    masCount++
                }
            }
        }
    }

    println("Part One Answer: $xmasCount")
    println("Part Two Answer: $masCount")
}

fun checkDirection(crossword: MutableList<MutableList<Char>>, x: Int, y: Int, dx: Int, dy: Int, word: String): Boolean {
    var str = ""

    for (i in word.indices) {
        val newX = x + dx * i
        val newY = y + dy * i

        if (newX !in crossword.indices || newY !in crossword[0].indices) return false

        str += crossword[newX][newY]
    }

    if (str == word) {
        return true
    }

    return false
}

fun checkWest(crossword: MutableList<MutableList<Char>>, x: Int, y: Int, word: String): Boolean {
    return checkDirection(crossword, x, y, -1, 0, word)
}

fun checkNorth(crossword: MutableList<MutableList<Char>>, x: Int, y: Int, word: String): Boolean {
    return checkDirection(crossword, x, y, 0, -1, word)
}

fun checkEast(crossword: MutableList<MutableList<Char>>, x: Int, y: Int, word: String): Boolean {
    return checkDirection(crossword, x, y, 1, 0, word)
}

fun checkSouth(crossword: MutableList<MutableList<Char>>, x: Int, y: Int, word: String): Boolean {
    return checkDirection(crossword, x, y, 0, 1, word)
}

fun checkNorthWest(crossword: MutableList<MutableList<Char>>, x: Int, y: Int, word: String): Boolean {
    return checkDirection(crossword, x, y, -1, -1, word)
}

fun checkNorthEast(crossword: MutableList<MutableList<Char>>, x: Int, y: Int, word: String): Boolean {
    return checkDirection(crossword, x, y, 1, -1, word)
}

fun checkSouthEast(crossword: MutableList<MutableList<Char>>, x: Int, y: Int, word: String): Boolean {
    return checkDirection(crossword, x, y, 1, 1, word)
}

fun checkSouthWest(crossword: MutableList<MutableList<Char>>, x: Int, y: Int, word: String): Boolean {
    return checkDirection(crossword, x, y, -1, 1, word)
}

