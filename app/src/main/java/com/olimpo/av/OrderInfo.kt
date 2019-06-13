package com.olimpo.av

import java.util.*

class OrderInfo(
    var id: Long = 0,
    var guestName: String? = null,
    var status: Status? = null,
    var isBegin: Boolean = false
) {
    enum class Status {
        CHECK_IN,
        REVERSE,
        BLANK;


        companion object {

            private val VALUES = Collections.unmodifiableList(Arrays.asList(*values()))
            private val SIZE = VALUES.size
            private val RANDOM = Random()

            fun randomStatus(): Status {
                return VALUES[RANDOM.nextInt(SIZE)]
            }
        }
    }
}
