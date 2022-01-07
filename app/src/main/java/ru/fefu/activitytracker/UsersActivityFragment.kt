package ru.fefu.activitytracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.activitytracker.data.ActivityData
import ru.fefu.activitytracker.data.ActivityDataModel
import ru.fefu.activitytracker.data.SummaryActivityData
import ru.fefu.activitytracker.databinding.FragmentUsersActivityBinding


class UsersActivityFragment : Fragment() {
    private lateinit var binding: FragmentUsersActivityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvActivities.adapter = ActivityListAdapter(getActivityData())
        binding.rvActivities.layoutManager = LinearLayoutManager(requireContext())

    }

    companion object {

        fun newInstance(): UsersActivityFragment {
            val bundle = Bundle()
            val fragment = UsersActivityFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    private fun getActivityData(): List<ActivityDataModel> {
        return listOf(
            SummaryActivityData("29 Мая 2021"),
            ActivityData("5 км", "2 часа", "Велосипед", "@username1", "29.05.2021"),
            SummaryActivityData("28 Мая 2021"),
            ActivityData("6 км", "2 часа", "Серфинг", "@username2", "28.05.2021"),
            ActivityData("5 км", "2 часа", "Велосипед", "@username3", "28.05.2021"),
            ActivityData("7 км", "2 часа", "Велосипед", "@username4", "28.05.2021"),
            ActivityData("5 км", "2 часа", "Велосипед", "@username", "28.05.2021"),
            ActivityData("5 км", "2 часа", "Велосипед", "@username", "28.05.2021"),
            ActivityData("5 км", "2 часа", "Велосипед", "@username", "28.05.2021"),
        )
    }
}