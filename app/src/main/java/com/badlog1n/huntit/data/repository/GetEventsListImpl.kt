package com.badlog1n.huntit.data.repository

import com.badlog1n.huntit.data.retrofit.EventApi
import com.badlog1n.huntit.data.retrofit.RetrofitImpl
import com.badlog1n.huntit.domain.models.MatchesResponse
import com.badlog1n.huntit.domain.repository.Repository

class GetEventsListImpl(private val remoteDataSource: EventApi = RetrofitImpl.getService()) : Repository.GetEventsList {
    override suspend fun getEventsList(date:String, getEventsListCallback: (MatchesResponse) -> Unit) {
        getEventsListCallback(remoteDataSource.getEventList(date))
    }
}