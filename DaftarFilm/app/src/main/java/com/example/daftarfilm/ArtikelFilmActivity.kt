package com.example.daftarfilm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class ArtikelFilmActivity : AppCompatActivity(), View.OnClickListener {

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
        val buttonShare: ImageButton = findViewById(R.id.action_share)

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

        buttonShare.setOnClickListener(this)
    }
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.action_share -> {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, intent.getStringExtra(SINOPSIS_FILM))
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
    }
}