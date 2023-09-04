package com.example.daftarfilm

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Film(
    val judulFilm: String,
    val tahunRilis: String,
    val sinopsisFilm: String,
    val posterFilm: String
) : Parcelable
