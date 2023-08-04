package com.badlog1n.huntit.domain

import com.badlog1n.huntit.domain.models.MatchesResponse
import com.badlog1n.huntit.domain.repository.Repository

class GetEventsListUseCase(private val repository: Repository.GetEventsList) {
    suspend fun invoke(date: String, getEventsListCallback: (MatchesResponse) -> Unit) {
        repository.getEventsList(date, getEventsListCallback)
    }
}