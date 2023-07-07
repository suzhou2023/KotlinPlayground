package com.bbt2000.kotlin.lambda

// 匿名函数1
val func1 = fun(a: Int): String {
    return a.toString()
}

// 匿名函数2
val func2 = fun(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    // 匿名函数都是函数类型的对象
    println(func1 is (Int) -> String)
    println(func2 is (Int, Int) -> Int)

    // 匿名函数可以写成lambda形式
    val lambda1 = { a: Int -> a.toString() }
    val lambda2 = { a: Int, b: Int -> a + b }
    println(lambda1 is (Int) -> String)
    println(lambda2 is (Int, Int) -> Int)

    // 只有一个参数时，如果能推断其类型，lambda写法可以省略该参数
    val lambda: (Int) -> String = { it.toString() }

    // 总结：lambda、匿名函数本质上都是函数类型的对象
}