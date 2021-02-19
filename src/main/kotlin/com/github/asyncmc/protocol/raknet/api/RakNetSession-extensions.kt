package com.github.asyncmc.protocol.raknet.api

import io.ktor.utils.io.core.*

/**
 * @author joserobjr
 * @since 2021-01-07
 */
suspend inline fun RakNetSession.send(
    priority: RakNetPriority, 
    reliability: RakNetReliability, 
    headerSizeHint: Int = 0, 
    crossinline builder: BytePacketBuilder.()->Unit
) = send(buildPacket(headerSizeHint, builder), priority, reliability)
