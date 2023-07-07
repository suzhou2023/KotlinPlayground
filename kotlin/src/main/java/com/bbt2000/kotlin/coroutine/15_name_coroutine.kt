package com.bbt2000.kotlin.coroutine

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun myLog(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun main() = runBlocking(CoroutineName("main")) {
    myLog("Started main coroutine")
    // 运行两个后台值计算
    val v1 = async(CoroutineName("v1coroutine")) {
        delay(500)
        myLog("Computing v1")
        252
    }
    val v2 = async(CoroutineName("v2coroutine")) {
        delay(3000)
        myLog("Computing v2")
        6
    }
//    myLog("The answer for v1 / v2 = ${v1.await() / v2}")
}