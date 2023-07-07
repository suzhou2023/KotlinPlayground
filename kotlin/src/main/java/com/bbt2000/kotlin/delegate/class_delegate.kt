package com.bbt2000.kotlin.delegate

interface Base {
    fun println()
}

class BaseImpl(val x: Int) : Base {
    override fun println() { println(x) }
}

class Derived(base: Base) : Base by base

fun main() {
    val b = BaseImpl(10)
    b.println()
    Derived(b).println()
}