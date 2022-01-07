package ru.fefu.activitytracker

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.fefu.activitytracker.data.ActivityData
import ru.fefu.activitytracker.data.ActivityDataModel
import ru.fefu.activitytracker.data.SummaryActivityData


class ActivityListAdapter(private val activityDataList: List<ActivityDataModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
            TYPE_ACTIVITY_CARD -> (holder as ActivityDataViewHolder).bind(
                currentData as ActivityData
            )
            TYPE_DATE_SUMMARY -> (holder as SummaryActivityDateViewHolder).bind(
                currentData as SummaryActivityData
            )
        }

    }

    override fun getItemCount(): Int {
        return activityDataList.size
    }

    private var itemClickListener: (Int) -> Unit = {}
    fun setItemClickListener(listener: (Int) -> Unit) {
        itemClickListener = listener
    }


}