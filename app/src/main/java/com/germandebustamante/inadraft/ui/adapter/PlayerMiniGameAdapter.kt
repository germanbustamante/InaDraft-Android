package com.germandebustamante.inadraft.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.germandebustamante.inadraft.util.loadGlideCenterImage
import com.germandebustamante.inadraft.R
import com.germandebustamante.inadraft.databinding.RowPlayerMiniGameBinding
import com.germandebustamante.inadraft.domain.PlayerBO

class PlayerMiniGameAdapter(private val onPlayerSelectedListener: (PlayerBO) -> Unit) :
    ListAdapter<PlayerBO, PlayerMiniGameViewHolder>(
        PlayerBODiffCallback
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerMiniGameViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_player_mini_game, parent, false)
        return PlayerMiniGameViewHolder(view, onPlayerSelectedListener)
    }

    override fun onBindViewHolder(holder: PlayerMiniGameViewHolder, position: Int) {
        holder.binding.bind(getItem(position))
    }

    fun getPlayer(position: Int): PlayerBO = currentList[position]

}

//region viewholders

/**
 * ViewHolder personalizado para pintado de un jugador sin detalle en la lista
 */
class PlayerMiniGameViewHolder(view: View, onPlayerSelectedListener: (PlayerBO) -> Unit) :
    RecyclerView.ViewHolder(view) {
    val binding = RowPlayerMiniGameBinding.bind(view)

    init {
        itemView.setOnClickListener {
            if (bindingAdapterPosition != RecyclerView.NO_POSITION) {
                val player = (bindingAdapter as? PlayerMiniGameAdapter)?.getPlayer(bindingAdapterPosition)
                if (player != null) {
                    onPlayerSelectedListener(player)
                }
            }
        }
    }
}

//endregion

//region private methods

/**
 * Dado un jugador en un item específico, pinta los datos de este en dicha fila
 */
private fun RowPlayerMiniGameBinding.bind(player: PlayerBO) {
    rowPlayerMiniGameCardViewPlayerMiniCard.apply {
        playerMiniCardLabelPlayerMedia.text = player.average.toString()
        playerMiniCardLabelPlayerPosition.text = player.position.name
        playerMiniCardImgPlayerShield.loadGlideCenterImage(player.team.shield)
        playerMiniCardLabelPlayerName.text = player.firstName
        playerMiniCardImgPlayerPhoto.loadGlideCenterImage(player.photo)
    }
    rowPlayerMiniGameImgPlayerShield.loadGlideCenterImage(player.team.shield)
    rowPlayerMiniGameLabelPlayerShield.text = player.team.name
    rowPlayerMiniGameLabelPlayerPosition.text = player.position.getFullName()
}

//endregion


