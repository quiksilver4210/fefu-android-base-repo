package ru.fefu.activitytracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.fefu.activitytracker.databinding.FragmentAllActivityBinding

class AllActivityFragment : Fragment(R.layout.fragment_all_activity) {
    private lateinit var binding: FragmentAllActivityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        const val TAG = "all_activity_fragment"

        fun newInstance(): ActivityFragment {
            val bundle = Bundle()
            val fragment = ActivityFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}
