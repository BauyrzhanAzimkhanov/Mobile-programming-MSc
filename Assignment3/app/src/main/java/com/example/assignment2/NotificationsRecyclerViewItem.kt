package com.example.assignment2

import java.sql.Timestamp

data class NotificationsRecyclerViewItem (
    val username: String,
    val action: String,
    val timestamp: Timestamp
)