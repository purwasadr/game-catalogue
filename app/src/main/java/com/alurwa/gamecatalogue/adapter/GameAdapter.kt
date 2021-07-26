package com.alurwa.gamecatalogue.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alurwa.gamecatalogue.databinding.ListItemGameBinding
import com.alurwa.gamecatalogue.model.Game
import com.alurwa.gamecatalogue.utils.DataDummy

/**
 * Created by Purwa Shadr Al 'urwa on 15/05/2021
 */

class GameAdapter(
    private val onClickCallback: (game: Game) -> Unit
) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    private val games: List<Game> = DataDummy.gameList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ListItemGameBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = games.size

    inner class ViewHolder(
        private val binding: ListItemGameBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val gameData = games[position]

            with(binding) {
                root.setOnClickListener {
                    onClickCallback.invoke(gameData)
                }
                game = gameData
            }
        }
    }
}