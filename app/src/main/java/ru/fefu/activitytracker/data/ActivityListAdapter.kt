package ru.fefu.activitytracker.data

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.ui.fragments.AllActivityFragment
import ru.fefu.activitytracker.ui.fragments.MyActivityDetailsFragment
import ru.fefu.activitytracker.ui.fragments.UserActivityDetailsFragment


class ActivityListAdapter(
    activityData: List<ActivityData>,
    private val fragmentManager: FragmentManager
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var activityDataList = mutableListOf<ActivityDataModel>()

    init {
        val processedData = mutableMapOf<String, MutableList<ActivityData>>()
        activityData.forEach {
            if (processedData[it.date] == null) {
                processedData[it.date] = mutableListOf(it)
            } else {
                processedData[it.date]?.add(it)
            }

        }

        processedData.forEach { (date, data) ->
            activityDataList.add(SummaryActivityData(date))
            data.forEach {
                activityDataList.add(it)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_ACTIVITY_CARD -> {
                ActivityDataViewHolder.create(parent)
            }
            TYPE_DATE_SUMMARY -> {
                SummaryActivityDateViewHolder.create(parent)
            }
            else -> {
                throw Exception("Error reading holder type")
            }
        }
    }

    companion object {
        private const val TYPE_ACTIVITY_CARD = 0
        private const val TYPE_DATE_SUMMARY = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (activityDataList[position]::class == ActivityData::class) {
            TYPE_ACTIVITY_CARD
        } else {
            TYPE_DATE_SUMMARY
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentData = activityDataList[position]
        when (holder.itemViewType) {
            TYPE_ACTIVITY_CARD -> {
                (holder as ActivityDataViewHolder).bind(
                    currentData as ActivityData
                )

                val detailFragmentTag: String
                val detailFragmentInstance: Fragment
                if (currentData.username.isEmpty()) {
                    detailFragmentTag = MyActivityDetailsFragment.TAG
                    detailFragmentInstance = MyActivityDetailsFragment.newInstance()
                } else {
                    detailFragmentTag = UserActivityDetailsFragment.TAG
                    detailFragmentInstance = UserActivityDetailsFragment.newInstance()
                }


                holder.itemView.setOnClickListener {
                    val currentFragment = fragmentManager.findFragmentByTag(AllActivityFragment.TAG)
                    fragmentManager.beginTransaction().apply {
                        if (currentFragment != null) {
                            hide(currentFragment)
                        }
                        add(
                            R.id.fcvActivity,
                            detailFragmentInstance,
                            detailFragmentTag
                        )
                        addToBackStack(detailFragmentTag)
                        commit()
                    }
                }
            }
            TYPE_DATE_SUMMARY -> (holder as SummaryActivityDateViewHolder).bind(
                currentData as SummaryActivityData
            )
        }


    }

    override fun getItemCount(): Int {
        return activityDataList.size
    }


}