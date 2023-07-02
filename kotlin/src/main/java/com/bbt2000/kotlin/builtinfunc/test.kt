package com.bbt2000.kotlin.builtinfunc

data class People(val name: String, var age: Byte)

fun main() {
    var people: People? = null
    // 表示object不为null的条件下，才会去执行let函数体
    people?.let {
        it.name
        it.age
    }

    // 此处要调用people的name和age属性
    people = People("Carson", 25)
    with(people) {
        println("My name is $name, I'm $age years old.")
    }

    // 结合了let和with
    people?.run {
        println("My name is $name, I'm $age years old.")
    }

    // apply与run类似，区别在于apply返回对象本身，run返回最后一行的值/表达式
    val ret1 = people?.run {
        println("My name is $name, I'm $age years old.")
        999
    }
    println(ret1)
    val ret2 = people?.apply {
        println("My name is $name, I'm $age years old.")
        999
    }
    println(ret2)

}