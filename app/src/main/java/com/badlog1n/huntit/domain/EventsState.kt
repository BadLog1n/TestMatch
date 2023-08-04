package com.badlog1n.huntit.domain

import com.badlog1n.huntit.domain.models.MatchesResponse

sealed class EventsState {
    data class Success(
        val events: MatchesResponse,
    ) : EventsState()

    class Error(val error: Throwable) : EventsState()
}