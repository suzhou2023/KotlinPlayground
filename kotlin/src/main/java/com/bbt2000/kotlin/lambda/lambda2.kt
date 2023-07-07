package com.bbt2000.kotlin.lambda


// 定义了一个高阶函数，它的参数是(Int) -> String类型的函数
// 功能是从1到100随机找一个数来调用传入的函数
fun highOrderFunc(func: (Int) -> String) {
    func((1..100).random())
}


fun main() {
    // 看看下面几种调用的写法
    // 把lambda写在括号里面
    highOrderFunc(func = { a -> a.toString() })
    // 把lambda写在括号外面
    highOrderFunc { a -> a.toString() }
    // 省略lambda的参数，使用默认参数it
    highOrderFunc { it.toString() }
}