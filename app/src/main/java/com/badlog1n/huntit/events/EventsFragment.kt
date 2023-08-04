package com.badlog1n.huntit.events

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.badlog1n.huntit.R
import com.badlog1n.huntit.databinding.EventsFragmentBinding
import com.badlog1n.huntit.domain.EventsState
import com.badlog1n.huntit.domain.models.Match
import com.badlog1n.huntit.events.adapter.EventAdapter

class EventsFragment : Fragment(R.layout.events_fragment) {
    private var _binding: EventsFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: EventsViewModel by lazy {
        ViewModelProvider(this)[EventsViewModel::class.java]
    }
    private val adapter: EventAdapter by lazy { EventAdapter { eventClick(it) } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = EventsFragmentBinding.bind(view)
        binding.rcEvents.layoutManager = LinearLayoutManager(this@EventsFragment.context)
        binding.rcEvents.adapter = adapter
        binding.btnChooseDate.setOnClickListener{
            val customDatePicker = CustomDatePicker(requireContext()) { selectedDate ->
                viewModel.loadEvents(selectedDate)
                binding.progressBar.visibility = View.VISIBLE
                binding.rcEvents.visibility = View.GONE
            }
            customDatePicker.showDatePicker()
        }
        viewModel.listToObserve.observe(viewLifecycleOwner) { checkObserve(it) }
    }

    private fun checkObserve(eventState: EventsState) {
        when (eventState) {
            is EventsState.Success -> {
                binding.progressBar.visibility = View.GONE
                binding.rcEvents.visibility = View.VISIBLE
                adapter.submitList(eventState.events.data)
            }

            is EventsState.Error -> Toast.makeText(
                requireContext(),
                eventState.error.message,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun eventClick(event: Match) {
        EventBottomDialog(requireContext(), event).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}