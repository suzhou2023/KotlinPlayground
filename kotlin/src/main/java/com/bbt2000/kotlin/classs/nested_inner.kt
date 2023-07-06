package com.bbt2000.kotlin.classs

class Outer {
    val value: Int = 1
    class Nested(a: Int) {
        val value = a
    }
}

interface OuterInterface {
    class InnerClass
    interface InnerInterface
}

class OuterClass {
    class InnerClass
    interface InnerInterface
}

class Outer2 {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
    }
}

fun main() {
    // 嵌套类、接口
    Outer.Nested(100)
    OuterInterface.InnerClass()
    val a: OuterInterface.InnerInterface
    val b: OuterClass.InnerInterface

}
