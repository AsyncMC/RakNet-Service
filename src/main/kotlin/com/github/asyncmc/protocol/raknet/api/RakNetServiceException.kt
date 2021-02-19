package com.github.asyncmc.protocol.raknet.api

/**
 * @author joserobjr
 * @since 2021-01-06
 */
class RakNetServiceException(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause) {
    constructor(cause: Throwable): this(null, cause)
}
