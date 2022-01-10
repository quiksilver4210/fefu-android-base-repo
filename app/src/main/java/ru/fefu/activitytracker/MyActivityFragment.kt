package ru.fefu.activitytracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class MyActivityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_my_activity, container, false)
    }

    companion object {

        fun newInstance(): MyActivityFragment {
            val bundle = Bundle()
            val fragment = MyActivityFragment()
            fragment.arguments = bundle
            return fragment
        }

    }
}