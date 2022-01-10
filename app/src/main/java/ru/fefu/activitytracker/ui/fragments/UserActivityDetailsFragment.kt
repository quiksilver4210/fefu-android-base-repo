package ru.fefu.activitytracker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.fefu.activitytracker.databinding.FragmentUserActivityDetailsBinding


class UserActivityDetailsFragment : Fragment() {
    private lateinit var binding: FragmentUserActivityDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserActivityDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = binding.tbActivityDetail
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    companion object {

        const val TAG = "fragment_user_activity_details"

        fun newInstance(): UserActivityDetailsFragment {
            val bundle = Bundle()
            val fragment = UserActivityDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }

    }
}