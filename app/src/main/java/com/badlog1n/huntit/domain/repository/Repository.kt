package com.badlog1n.huntit.domain.repository

import com.badlog1n.huntit.domain.models.MatchesResponse

interface Repository {
    interface GetEventsList {
        suspend fun getEventsList(
            getEventsListCallback: String,
            getEventsListCallback1: (MatchesResponse) -> Unit
        )
    }
}