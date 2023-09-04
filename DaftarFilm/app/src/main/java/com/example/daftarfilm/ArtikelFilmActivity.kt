package com.example.daftarfilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ArtikelFilmActivity : AppCompatActivity() {

    companion object {
        const val JUDUL_FILM = "judul_film"
        const val TAHUN_RILIS = "tahun_rilis"
        const val SINOPSIS_FILM = "sinopsis_film"
        const val POSTER_FILM = "poster_film"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel_film)

        val judulFilm: TextView = findViewById(R.id.judul_artikel)
        val tahunRilis: TextView = findViewById(R.id.tahun_rilis)
        val sinopsisFilm: TextView = findViewById(R.id.sinopsis_film)
        val posterFilm: ImageView = findViewById(R.id.sampul_artikel)

        val judul = intent.getStringExtra(JUDUL_FILM)
        val rilis = intent.getStringExtra(TAHUN_RILIS)
        val sinopsis = intent.getStringExtra(SINOPSIS_FILM)
        val poster = intent.getStringExtra(POSTER_FILM)

        val text = "$judul"
        val tahun = "$rilis"
        val desk = "$sinopsis"
        val sampul = "$poster"

        judulFilm.text = text
        tahunRilis.text = tahun
        sinopsisFilm.text = desk
        Glide.with(this)
            .load(sampul)
            .into(posterFilm)
    }
}