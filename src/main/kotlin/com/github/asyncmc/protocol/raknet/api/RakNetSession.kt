package com.github.asyncmc.protocol.raknet.api

import io.ktor.utils.io.core.*
import kotlinx.coroutines.flow.StateFlow
import java.net.InetSocketAddress

/**
 * @author joserobjr
 * @since 2021-01-06
 */
interface RakNetSession: Closeable {
    val binding: RakNetServerBinding
    val server get() = binding.server
    val guid: Long
    val remote: InetSocketAddress
    
    @ExperimentalUnsignedTypes
    val protocolVersion: UByte
    
    val state: StateFlow<RakNetSessionState>
    
    suspend fun send(data: ByteReadPacket)
    fun sendBlocking(data: ByteReadPacket)

    suspend fun send(
        content: ByteReadPacket,
        priority: RakNetPriority = RakNetPriority.MEDIUM,
        reliability: RakNetReliability = RakNetReliability.RELIABLE_ORDERED,
        channel: Int = 0
    )

    suspend fun sendWithoutQueue(data: ByteReadPacket)

    override fun close() {
        close(null)
    }
    
    fun close(message: String?, reason: Throwable? = null)
}
