package com.example.daftarfilm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DaftarFilmAdapter(private val lisFilm: ArrayList<Film>) : RecyclerView.Adapter<DaftarFilmAdapter.ListViewHolder>(){

    private lateinit var onItemClickCallback: OnItemClickCallback

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val posterFilm: ImageView = itemView.findViewById(R.id.poster_film)
        val judulFilm: TextView = itemView.findViewById(R.id.judul_film)
        val tahunRilis: TextView = itemView.findViewById(R.id.tahun_rilis)
        val sinopsisFilm: TextView = itemView.findViewById(R.id.sinopsis_film)
    }

    fun setOnItemCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.daftar_film, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = lisFilm.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (judul, tahun, sinopsis, poster) = lisFilm[position]
        Glide.with(holder.itemView.context)
            .load(poster)
            .into(holder.posterFilm)
        holder.judulFilm.text = judul
        holder.tahunRilis.text = tahun
        holder.sinopsisFilm.text = sinopsis
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(lisFilm[holder.adapterPosition])
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Film)
    }
}
