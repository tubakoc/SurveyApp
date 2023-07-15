package com.example.surveyapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person (
    val nameSurname : String,
    val email: String,
    val age : Int,
    val phone : Int,
    val city : String
):Parcelable