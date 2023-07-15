package com.example.surveyapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonInfo (
    val person: Person?,
    val fColor: String,
    val fFood: String,
    val fBook: String
): Parcelable