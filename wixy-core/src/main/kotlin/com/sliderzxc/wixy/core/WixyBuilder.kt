package com.sliderzxc.wixy.core

object WixyBuilder {
    fun build(): HttpLoader {
        return AndroidHttpLoader()
    }
}