package com.bbt2000.kotlin.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    println("runBlocking thread: ${Thread.currentThread().name}")

    launch { // 运行在父协程的上下文中，即 runBlocking 主协程
        println("launch thread: ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Unconfined) { // 不受限的——将工作在主线程中
        println("Unconfined thread：${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default) { // 将会获取默认调度器
        println("Default thread：${Thread.currentThread().name}")
    }

    launch(newSingleThreadContext("MyOwnThread")) { // 将使它获得一个新的线程
        println("newSingleThreadContext thread： ${Thread.currentThread().name}")
    }
}