package com.bbt2000.kotlin.lambda

fun sum(a: Int, b: Int) : Int {
    return a + b
}

// 定义了一个高阶函数，它的参数是(Int) -> String类型的函数
// 功能是从1到100随机找一个数来调用传入的函数，并打印
fun highOrderFunc(func: (Int) -> String) {
    println(func((1..100).random()))
}

fun highOrderFunc2(a: Int, func: (Int) -> String) {
    println(func(a))
}

fun main() {
    // 函数赋值给变量
//    val varf = sum // 这种写法会报错
    val varf = ::sum // 把sum包装成对象
    println(sum(1, 2))
    println(varf(1, 2)) // 语法糖
    println(varf.invoke(1, 2))
    println((::sum)(1, 2)) // 语法糖
    println((::sum).invoke(1, 2))

    // 匿名函数
    val varf2 = fun(param: Int): String {
        return param.toString()
    }
    // varf2的类型是：(Int) -> String
    println(varf2 is (Int) -> String)

    // 匿名函数改写成lambda形式
    val varf3 = { param: Int -> param.toString() }
    println(varf3 is (Int) -> String)
    // 只有一个参数时, lambda写法可以省略该参数，但是要能推断其类型
    val varf4 : (Int) -> String = { it.toString() }

    // 总结：lambda、匿名函数和::sum(函数名前面加2个冒号)一样，本质上都是函数类型的对象

    // 高阶函数如何调用
    // 函数类型对象
    highOrderFunc(varf2)
    // 匿名函数
    highOrderFunc(fun(param: Int): String {
        return param.toString()
    })
    // lambda写法
    highOrderFunc({ param -> param.toString() })
    highOrderFunc() { param -> param.toString() }
    highOrderFunc { it.toString() }
    highOrderFunc { (it * it).toString() }

    highOrderFunc2(100, { param -> param.toString() })
    highOrderFunc2(100) { param -> param.toString() }
    highOrderFunc2(100) { it.toString() }
    highOrderFunc2(100) { (it * it).toString() }
}