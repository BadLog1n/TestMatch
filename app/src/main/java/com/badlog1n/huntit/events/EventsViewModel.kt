package com.badlog1n.huntit.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.badlog1n.huntit.data.repository.GetEventsListImpl
import com.badlog1n.huntit.domain.EventsState
import com.badlog1n.huntit.domain.GetEventsListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventsViewModel : ViewModel() {
    private var _listToObserve: MutableLiveData<EventsState> = MutableLiveData()
    val listToObserve: LiveData<EventsState> get() = _listToObserve

     fun loadEvents(date: String) {
        val getEventsListImpl = GetEventsListImpl()
        val getEvents = GetEventsListUseCase(getEventsListImpl)
        viewModelScope.launch(Dispatchers.IO) {
            getEvents.invoke(date) {
                _listToObserve.postValue(EventsState.Success(it))
            }
        }
    }
}