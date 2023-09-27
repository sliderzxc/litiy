package com.sliderzxc.wixy.core

suspend fun main() {
    val wixy = WixyBuilder.build()
    val result = wixy.get(request = {
        url = "http://numbersapi.com/42"
    })
    println(result.body)
}