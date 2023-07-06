package com.bbt2000.kotlin.classs

enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

data class Data(val value: Int)

class NormalClass(val value: Int)

fun main() {
    println(Color.RED is Color)
    println(Color.GREEN.rgb.toString(16))
    println(Data(3).value)
    println(NormalClass(5).value)
}