package com.example.daftarfilm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var daftarFilm: RecyclerView
    private val list = ArrayList<Film>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        daftarFilm = findViewById(R.id.daftarFilm)
        daftarFilm.setHasFixedSize(true)

        list.addAll(getListFilm())
        showRecycleList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_me -> {
                val aboutMeActivity = Intent(this@MainActivity, AboutMeActivity::class.java)
                startActivity(aboutMeActivity)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListFilm(): ArrayList<Film> {
        val dataJudul = resources.getStringArray(R.array.film_judul)
        val dataTahun = resources.getStringArray(R.array.rilis_tahun)
        val dataSinopsis = resources.getStringArray(R.array.film_sinopsis)
        val dataPoster = resources.getStringArray(R.array.poster_film)
        val listFilm = ArrayList<Film>()
        for (i in dataJudul.indices) {
            val film = Film(dataJudul[i], dataTahun[i], dataSinopsis[i], dataPoster[i])
            listFilm.add(film)
        }
        return listFilm
    }

    private fun showRecycleList() {
        daftarFilm.layoutManager = LinearLayoutManager(this)
        val daftarFilmAdapter = DaftarFilmAdapter(list)
        daftarFilm.adapter = daftarFilmAdapter

        daftarFilmAdapter.setOnItemCallback(object : DaftarFilmAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Film) {
                showClickedFilm(data)
            }
        })
    }

    private fun showClickedFilm(film: Film) {
        val toArtikelFilm = Intent(this@MainActivity, ArtikelFilmActivity::class.java)
        toArtikelFilm
            .putExtra(ArtikelFilmActivity.JUDUL_FILM, film.judulFilm)
            .putExtra(ArtikelFilmActivity.TAHUN_RILIS, film.tahunRilis)
            .putExtra(ArtikelFilmActivity.SINOPSIS_FILM, film.sinopsisFilm)
            .putExtra(ArtikelFilmActivity.POSTER_FILM, film.posterFilm)
        startActivity(toArtikelFilm)
    }
}