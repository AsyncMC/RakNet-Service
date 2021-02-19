package com.github.asyncmc.protocol.raknet.api

import com.github.asyncmc.protocol.raknet.api.listener.RakNetConnectionRequestListener
import com.github.asyncmc.protocol.raknet.api.listener.RakNetPingListener
import com.github.asyncmc.protocol.raknet.api.listener.RakNetSessionCreated
import com.github.asyncmc.protocol.raknet.api.listener.RakNetUnknownPacketListener
import io.ktor.utils.io.core.*
import java.net.SocketAddress

data class RakNetListeners (
    var ping: RakNetPingListener = DefaultListener,
    var unknownPacket: RakNetUnknownPacketListener = DefaultListener,
    var connectionRequest: RakNetConnectionRequestListener = DefaultListener,
    var sessionCreated: RakNetSessionCreated = DefaultListener
) {
    private object DefaultListener : RakNetPingListener, RakNetUnknownPacketListener, RakNetConnectionRequestListener,
        RakNetSessionCreated {
        override suspend fun onRakNetPing(
            binding: RakNetServerBinding,
            sender: SocketAddress,
            guidClient: Long,
            sentTick: Long
        ) = byteArrayOf()

        override suspend fun isRakNetConnectionAllowed(binding: RakNetServerBinding, sender: SocketAddress): Boolean {
            return true
        }

        override suspend fun onRakNetSessionCreated(session: RakNetSession) = Unit
        
        override suspend fun onUnknownRakNetPacket(
            binding: RakNetServerBinding,
            content: ByteReadPacket,
            session: RakNetSession?
        ) = Unit
    }
}
