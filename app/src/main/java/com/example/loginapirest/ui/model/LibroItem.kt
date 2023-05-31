package com.example.loginapirest.ui.model

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Parcelize
@Serializable
data class LibroItem(
    val id: Int,
    val nombre: String
) : Parcelable