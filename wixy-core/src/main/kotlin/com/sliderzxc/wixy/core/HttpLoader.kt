package com.sliderzxc.wixy.core

interface HttpLoader {
    suspend fun get(request: Request.Builder.() -> Unit): HttpResponse
    suspend fun post(request: Request.Builder.() -> Unit): HttpResponse
    suspend fun put(request: Request.Builder.() -> Unit): HttpResponse
    suspend fun patch(request: Request.Builder.() -> Unit): HttpResponse
    suspend fun delete(request: Request.Builder.() -> Unit): HttpResponse
    suspend fun head(request: Request.Builder.() -> Unit): HttpResponse
    suspend fun method(request: Request.Builder.() -> Unit): HttpResponse
}