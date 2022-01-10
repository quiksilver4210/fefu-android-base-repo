package ru.fefu.activitytracker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.fefu.activitytracker.databinding.FragmentMyActivityDetailsBinding


class MyActivityDetailsFragment : Fragment() {
    private lateinit var binding: FragmentMyActivityDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyActivityDetailsBinding.inflate(inflater, container, false)
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

        const val TAG = "fragment_my_activity_details"

        fun newInstance(): MyActivityDetailsFragment {
            val bundle = Bundle()
            val fragment = MyActivityDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }

    }
}