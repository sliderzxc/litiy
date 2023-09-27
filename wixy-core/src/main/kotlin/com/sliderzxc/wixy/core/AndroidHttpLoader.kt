package com.sliderzxc.wixy.core

import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.toRequestBody

class AndroidHttpLoader(
    private val client: OkHttpClient = OkHttpClient()
) : HttpLoader {

    override suspend fun get(request: Request.Builder.() -> Unit): HttpResponse {
        val requestBuilder = Request.Builder()
        request(requestBuilder)
        val wixyRequest = requestBuilder.build()

        val okHttpRequest = okhttp3.Request.Builder()
            .url(wixyRequest.url)
            .apply {
                wixyRequest.headers?.forEach { (name, value) ->
                    addHeader(name, value)
                }
                wixyRequest.body?.let {
                    post(it.toRequestBody(null))
                }
            }
            .build()

        val response = client.newCall(okHttpRequest).execute()
        val statusCode = response.code
        val responseBody = response.body?.string() ?: ""

        return HttpResponse(statusCode, responseBody)
    }

    override suspend fun post(request: Request.Builder.() -> Unit): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun put(request: Request.Builder.() -> Unit): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun patch(request: Request.Builder.() -> Unit): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun delete(request: Request.Builder.() -> Unit): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun head(request: Request.Builder.() -> Unit): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun method(request: Request.Builder.() -> Unit): HttpResponse {
        TODO("Not yet implemented")
    }
}
