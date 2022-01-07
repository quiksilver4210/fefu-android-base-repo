package ru.fefu.activitytracker.data

data class ActivityData(
    val distance: String,
    val duration: String,
    val type: String,
    val username: String,
    val date: String
) : ActivityDataModel
