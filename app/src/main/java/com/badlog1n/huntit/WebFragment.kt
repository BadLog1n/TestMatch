package com.badlog1n.huntit

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.badlog1n.huntit.databinding.FragmentWebviewBinding
import com.onesignal.OneSignal

class WebFragment : Fragment(R.layout.fragment_webview) {

    private var _binding: FragmentWebviewBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentWebviewBinding.bind(view)
        setupWebView()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(requireContext())
        OneSignal.setAppId(ONESIGNAL_APP_ID)
        OneSignal.promptForPushNotifications()
    }

    private fun setupWebView() {
        binding.webView.webViewClient = WebViewClient()
        val url = "https://www.example.com"
        binding.webView.loadUrl(url)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val ONESIGNAL_APP_ID = "65749f38-f3d7-4b18-8dad-0401a0bfa1fa"
    }
}