package com.bbt2000.kotlin.lambda

// 定义一个函数
fun sum(a: Int, b: Int): Int {
    println("$a + $b = ${a + b}")
    return a + b
}

// 另一种写法
fun sum2() = fun(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    // 函数名前加双冒号是一个对象
    val fObject = ::sum
    println(fObject is (Int, Int) -> Int)

    // 调用一个函数
    sum(1, 2)
    // 也可以这样写，但这其实是语法糖
    fObject(1, 2)
    // 实际上是
    fObject.invoke(1, 2)
}