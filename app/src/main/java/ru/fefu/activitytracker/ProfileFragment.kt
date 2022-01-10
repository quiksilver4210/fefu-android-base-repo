package ru.fefu.activitytracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    companion object {

        const val TAG = "profile_fragment"

        fun newInstance(): ProfileFragment {
            val bundle = Bundle()
            val fragment = ProfileFragment()
            fragment.arguments = bundle
            return fragment
        }

    }
}