package ru.fefu.activitytracker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.activitytracker.data.ActivityData
import ru.fefu.activitytracker.data.ActivityDataModel
import ru.fefu.activitytracker.data.SummaryActivityData
import ru.fefu.activitytracker.databinding.FragmentMyActivityBinding


class MyActivityFragment : Fragment() {
    private lateinit var binding: FragmentMyActivityBinding
    private val adapter = ActivityListAdapter(getActivityData())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("Test", "JERE1")
        adapter.setItemClickListener {
            Log.v("Test", "JERE1")
            val fragmentManager = parentFragment?.parentFragmentManager
            val currentFragment = fragmentManager?.findFragmentByTag(MyActivityDetailsFragment.TAG)
            fragmentManager?.beginTransaction()?.apply {
                Log.v("Test", "JERE1")
                if (currentFragment != null) {
                    hide(currentFragment)
                }
                add(
                    R.id.vpActivity,
                    MyActivityDetailsFragment.newInstance(),
                    MyActivityDetailsFragment.TAG
                )
                addToBackStack(ActivityFragment.TAG)
                commit()
            }
        }

        binding.rvActivities.adapter = adapter
        binding.rvActivities.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {

        fun newInstance(): MyActivityFragment {
            val bundle = Bundle()
            val fragment = MyActivityFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    private fun getActivityData(): List<ActivityDataModel> {
        return listOf(
            SummaryActivityData("29 Мая 2021"),
            ActivityData("5 км", "2 часа", "Велосипед", "", "29.05.2021"),
            SummaryActivityData("28 Мая 2021"),
            ActivityData("6 км", "2 часа", "Серфинг", "", "28.05.2021"),
            ActivityData("5 км", "2 часа", "Велосипед", "", "28.05.2021"),
            ActivityData("7 км", "2 часа", "Велосипед", "", "28.05.2021"),
            ActivityData("5 км", "2 часа", "Велосипед", "", "28.05.2021"),
            ActivityData("5 км", "2 часа", "Велосипед", "", "28.05.2021"),
            ActivityData("5 км", "2 часа", "Велосипед", "", "28.05.2021"),
        )
    }
}