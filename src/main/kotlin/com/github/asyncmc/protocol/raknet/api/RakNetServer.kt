package com.github.asyncmc.protocol.raknet.api

import java.io.Closeable

/**
 * @author joserobjr
 * @since 2021-01-06
 */
interface RakNetServer: Closeable {
    val bindings: List<RakNetServerBinding>
}
