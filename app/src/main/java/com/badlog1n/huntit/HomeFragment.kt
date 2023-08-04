package com.badlog1n.huntit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnGoToWebsite = view.findViewById<View>(R.id.btnGoToWebsite)
        btnGoToWebsite.setOnClickListener {
            findNavController(view).navigate(R.id.action_homeFragment_to_webFragment)
        }
        val btnContinueInApp = view.findViewById<View>(R.id.btnContinueInApp)
        btnContinueInApp.setOnClickListener {
            findNavController(view).navigate(R.id.action_homeFragment_to_eventsFragment)
        }
    }
}