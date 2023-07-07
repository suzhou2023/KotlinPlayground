package com.bbt2000.kotlin.coroutine

import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("My job is ${coroutineContext[Job]}")
}