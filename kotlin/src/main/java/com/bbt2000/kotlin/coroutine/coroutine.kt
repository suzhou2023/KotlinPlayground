package com.bbt2000.kotlin.coroutine

import kotlinx.coroutines.*

//fun main() = runBlocking { // this: CoroutineScope
//    launch { // launch a new coroutine and continue
//        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
//        println("World!") // print after delay
//    }
//    println("Hello") // main coroutine continues while a previous one is delayed
//}

//fun main() = runBlocking { // this: CoroutineScope
//    launch { doWorld() }
//    println("Hello")
//}
//
//// this is your first suspending function
//suspend fun doWorld() {
//    delay(1000)
//    println("World!")
//}

//fun main() = runBlocking {
//    doWorld()
//}
//
//suspend fun doWorld() = coroutineScope {  // this: CoroutineScope
//    launch {
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello")
//}

//fun main() = runBlocking {
//    doWorld()
//    println("Done")
//}
//
//// Concurrently executes both sections
//suspend fun doWorld() = coroutineScope { // this: CoroutineScope
//    launch {
//        delay(2000L)
//        println("World 2")
//    }
//    launch {
//        delay(1000L)
//        println("World 1")
//    }
//    println("Hello")
//}

//fun main() = runBlocking {
////sampleStart
//    val job = launch { // launch a new coroutine and keep a reference to its Job
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello")
//    job.join() // wait until child coroutine completes
//    println("Done")
////sampleEnd
//}

//fun main() = runBlocking {
////sampleStart
//    val job = launch {
//        repeat(1000) {
//            println("job: I'm sleeping $it ...")
//            delay(500L)
//        }
//    }
//    delay(2000L) // 延迟一段时间
//    println("main: I'm tired of waiting!")
//    job.cancel() // 取消该作业
//    job.join() // 等待作业执行结束
////    job.cancelAndJoin()
//    println("main: Now I can quit.")
////sampleEnd
//}

fun main() = runBlocking {
//sampleStart
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) { // 可以被取消的计算循环
            // 每秒打印消息两次
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // 等待一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消该作业并等待它结束
    println("main: Now I can quit.")
//sampleEnd
}