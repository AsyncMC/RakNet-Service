package com.github.asyncmc.protocol.raknet.api

import kotlinx.coroutines.Job
import java.net.InetSocketAddress

/**
 * @author joserobjr
 * @since 2021-01-06
 */
data class RakNetConfig @ExperimentalUnsignedTypes constructor(
    val socketAddresses: Set<InetSocketAddress> = mutableSetOf(),
    var listeners: RakNetListeners = RakNetListeners(),
    var parentJob: Job? = null,
    val supportedProtocols: MutableSet<UByte> = mutableSetOf(),
    var maxConnections: Int = -1
)
