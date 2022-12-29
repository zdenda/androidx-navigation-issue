package com.android.navigation.example.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDeepLinkBuilder
import com.android.navigation.example.NOTIFICATION_CHANNEL_ID
import com.android.navigation.example.R
import com.android.navigation.example.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val button: Button = binding.buttonNotification
        button.setOnClickListener {
            val context = requireContext()

            // Create PendingIntent with Dashboard screen destination
            val pendingIntent = NavDeepLinkBuilder(context)
                    .setGraph(R.navigation.mobile_navigation)
                    .setDestination(R.id.navigation_dashboard)
                    .createPendingIntent()

            // Create Notification
            val notification = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                    .setSmallIcon(android.R.drawable.btn_star_big_on)
                    .setContentText("Click on Me!")
                    .setContentIntent(pendingIntent)
                    .build()

            NotificationManagerCompat.from(context).notify(1, notification)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}