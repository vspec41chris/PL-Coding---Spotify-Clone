package com.plcoding.spotifyclone.utils

open class Event<out T>(private val data: T) {

    var hasBeenHandle = false
        private set

    fun getContentIfNotHandle(): T? {
        return if(hasBeenHandle){
            null
        } else{
            hasBeenHandle = true
            data
        }
    }

    fun peekContent() = data
}