package com.bbt2000.kotlin.delegate

import kotlin.properties.Delegates

var observableProp: String by Delegates.observable("默认值：xxx") {
        property, oldValue, newValue ->
    println("property: $property: $oldValue -> $newValue ")
}
// 测试
fun main() {
    observableProp = "第一次修改值"
    observableProp = "第二次修改值"
}
