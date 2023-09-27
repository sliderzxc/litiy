package com.sliderzxc.wixy.core

typealias Parameters = List<Pair<String, String>>

class Request(
    var url: String,
    val parameters: Parameters?,
    val headers: Map<String, String>?,
    val body: String?,
    val method: String?
) {
    private constructor(builder: Builder) : this(
        checkNotNull(builder.url) { "url == null" },
        builder.parameters,
        builder.headers,
        builder.body,
        builder.method
    )

    class Builder {
        var url: String? = null
        var headers: Map<String, String> = emptyMap()
        var body: String? = null
        var method: String? = null
        var parameters: Parameters? = null

        fun build(): Request = Request(this)
    }
}