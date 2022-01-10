package ru.fefu.activitytracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class UsersActivityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_users_activity, container, false)
    }

    companion object {

        fun newInstance(): UsersActivityFragment {
            val bundle = Bundle()
            val fragment = UsersActivityFragment()
            fragment.arguments = bundle
            return fragment
        }

    }
}