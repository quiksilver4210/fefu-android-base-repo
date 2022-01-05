package ru.fefu.activitytracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import ru.fefu.activitytracker.databinding.FragmentActivityBinding

class ActivityFragment : Fragment(R.layout.fragment_activity) {
    private lateinit var binding: FragmentActivityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        const val TAG = "activity_fragment"

        fun newInstance(): ActivityFragment {
            val bundle = Bundle()
            val fragment = ActivityFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vpActivity.adapter = ActivityFragmentAdapter(this)
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

class ActivityFragmentAdapter(fragment: ActivityFragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
        if (position == 0) {
            MyActivityFragment.newInstance()
        } else {
            UsersActivityFragment.newInstance()
        }
}