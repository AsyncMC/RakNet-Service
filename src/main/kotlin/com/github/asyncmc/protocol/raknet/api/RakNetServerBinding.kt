package com.github.asyncmc.protocol.raknet.api

import io.ktor.utils.io.core.*
import java.net.InetSocketAddress

/**
 * @author joserobjr
 * @since 2021-01-06
 */
interface RakNetServerBinding {
    val server: RakNetServer
    val guid: Long
    
    suspend fun sendWithoutQueue(target: InetSocketAddress, buffer: ByteReadPacket)
}
