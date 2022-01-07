package ru.fefu.activitytracker.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.fefu.activitytracker.R

class ActivityDataViewHolder(activityCard: View) : RecyclerView.ViewHolder(activityCard) {
    private val tvActivityDistance: TextView = activityCard.findViewById(R.id.tvActivityDistance)
    private val tvActivityDate: TextView = activityCard.findViewById(R.id.tvActivityDate)
    private val tvActivityDuration: TextView = activityCard.findViewById(R.id.tvActivityDuration)
    private val tvActivityUsername: TextView = activityCard.findViewById(R.id.tvActivityUsername)
    private val tvActivityType: TextView = activityCard.findViewById(R.id.tvActivityType)


    fun bind(activityData: ActivityData) {
        tvActivityDistance.text = activityData.distance
        tvActivityDate.text = activityData.date
        tvActivityDuration.text = activityData.duration
        tvActivityType.text = activityData.type
        tvActivityUsername.text = activityData.username
    }

    companion object {
        fun create(parent: ViewGroup): ActivityDataViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_activity, parent, false)
            return ActivityDataViewHolder(view)
        }
    }
}