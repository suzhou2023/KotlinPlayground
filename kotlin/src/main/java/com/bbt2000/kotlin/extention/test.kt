package com.bbt2000.kotlin.extention


// 为Any?类型扩展toString()函数
fun Any?.toString(): String {
    if (this == null) return "NULL"
    return toString()
}

class TestInterface

fun TestInterface.test(): String = ""

fun main() {
    val a = null
    println(a.toString())
}