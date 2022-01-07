package ru.fefu.activitytracker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import ru.fefu.activitytracker.R
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

        fun newInstance(): AllActivityFragment {
            val bundle = Bundle()
            val fragment = AllActivityFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vpActivity.adapter = AllActivityFragmentAdapter(this)
        TabLayoutMediator(
            binding.tlActivityGroup,
            binding.vpActivity
        ) { tab, position ->
            if (position == 0) {
                tab.text = "Моя"
            } else {
                tab.text = "Пользователи"
            }
        }.attach()
    }
}

class AllActivityFragmentAdapter(fragment: AllActivityFragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
        if (position == 0) {
            MyActivityFragment.newInstance()
        } else {
            UsersActivityFragment.newInstance()
        }
}
