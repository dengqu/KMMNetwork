package com.example.kmmnetwork

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}