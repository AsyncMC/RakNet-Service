package com.github.asyncmc.protocol.raknet.api

/**
 * @author joserobjr
 * @since 2021-01-06
 */
enum class RakNetReliability {
    UNRELIABLE,
    UNRELIABLE_SEQUENCED,
    RELIABLE,
    RELIABLE_ORDERED,
    RELIABLE_SEQUENCED,
    UNRELIABLE_WITH_ACK_RECEIPT,
    RELIABLE_WITH_ACK_RECEIPT,
    RELIABLE_ORDERED_WITH_ACK_RECEIPT
    ;
    val reliable = name.startsWith("RELIABLE")
    val ordered = "_ORDERED" in name
    val sequenced = "_SEQUENCED" in name
    val withAckReceipt = "_WITH_ACK_RECEIPT" in name
    val size = run { 
        var size = 0
        if (reliable) {
            size += 3
        }
        if (sequenced) {
            size += 3
        }
        if (ordered) {
            size += 4
        }
        size
    }
    companion object {
        private val byId = values()
        operator fun get(id: Int) = byId[id]
    }
}
