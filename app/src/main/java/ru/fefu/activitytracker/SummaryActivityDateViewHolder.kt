package ru.fefu.activitytracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.fefu.activitytracker.data.SummaryActivityData

class SummaryActivityDateViewHolder(activitySummary: View) :
    RecyclerView.ViewHolder(activitySummary) {
    private val tvSummaryDate: TextView = activitySummary.findViewById(R.id.tvSummaryDate)

    fun bind(summaryData: SummaryActivityData) {
        tvSummaryDate.text = summaryData.date
    }

    companion object {
        fun create(parent: ViewGroup): SummaryActivityDateViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_date_summary, parent, false)
            return SummaryActivityDateViewHolder(view)
        }
    }
}