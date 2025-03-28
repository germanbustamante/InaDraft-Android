package com.germandebustamante.inadraft.presentation.playerSelection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.germandebustamante.inadraft.R
import com.germandebustamante.inadraft.databinding.RowPlayerMiniGameBinding
import com.germandebustamante.inadraft.domain.player.model.FullInfoPlayer
import com.germandebustamante.inadraft.commonAndroid.loadGlideCenterImage

class PlayerMiniGameAdapter(private val onPlayerSelectedListener: (FullInfoPlayer) -> Unit) :
    ListAdapter<FullInfoPlayer, PlayerMiniGameViewHolder>(FullInfoPlayerDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerMiniGameViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_player_mini_game, parent, false)
        return PlayerMiniGameViewHolder(view, onPlayerSelectedListener)
    }

    override fun onBindViewHolder(holder: PlayerMiniGameViewHolder, position: Int) {
        holder.binding.bind(getItem(position))
    }

    fun getPlayer(position: Int): FullInfoPlayer = currentList[position]

}

//region viewHolders
class PlayerMiniGameViewHolder(view: View, onPlayerSelectedListener: (FullInfoPlayer) -> Unit) :
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
private fun RowPlayerMiniGameBinding.bind(player: FullInfoPlayer) {
    rowPlayerMiniGameCardViewPlayerMiniCard.apply {
        playerMiniCardLabelPlayerMedia.text = player.player.calculatePlayerAverage().toString()
        playerMiniCardLabelPlayerPosition.text = player.player.position
        playerMiniCardImgPlayerShield.loadGlideCenterImage(player.team.shield)
        playerMiniCardLabelPlayerName.text = player.player.firstName
        playerMiniCardImgPlayerPhoto.loadGlideCenterImage(player.player.photo)
    }
    rowPlayerMiniGameImgPlayerShield.loadGlideCenterImage(player.team.shield)
    rowPlayerMiniGameLabelPlayerShield.text = player.team.name
    rowPlayerMiniGameLabelPlayerPosition.text = player.player.position
}

//endregion

object FullInfoPlayerDiffCallback : DiffUtil.ItemCallback<FullInfoPlayer>() {
    override fun areItemsTheSame(
        oldItem: FullInfoPlayer,
        newItem: FullInfoPlayer,
    ): Boolean = oldItem.player.id == newItem.player.id

    override fun areContentsTheSame(
        oldItem: FullInfoPlayer,
        newItem: FullInfoPlayer,
    ): Boolean = oldItem == newItem
}


