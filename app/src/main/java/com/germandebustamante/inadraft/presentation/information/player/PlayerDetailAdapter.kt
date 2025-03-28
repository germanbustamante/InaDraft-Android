package com.germandebustamante.inadraft.presentation.information.player

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.germandebustamante.inadraft.R
import com.germandebustamante.inadraft.databinding.RowPlayerDetailBinding
import com.germandebustamante.inadraft.domain.player.model.FullInfoPlayer
import com.germandebustamante.inadraft.domain.player.model.PlayerBO
import com.germandebustamante.inadraft.domain.team.model.TeamBO
import com.germandebustamante.inadraft.commonAndroid.loadGlideCenterImage

class PlayerDetailAdapter : ListAdapter<FullInfoPlayer, PlayerDetailViewHolder>(PlayerBODiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PlayerDetailViewHolder =
        PlayerDetailViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_player_detail, parent, false))

    override fun onBindViewHolder(holder: PlayerDetailViewHolder, position: Int) {
        val (player, team) = getItem(position)
        holder.binding.bind(player, team)
    }


}

//region viewHolder
class PlayerDetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = RowPlayerDetailBinding.bind(view)
}
//endregion

//region diffCallback
object PlayerBODiffCallback : DiffUtil.ItemCallback<FullInfoPlayer>() {
    override fun areItemsTheSame(
        oldItem: FullInfoPlayer,
        newItem: FullInfoPlayer,
    ): Boolean = oldItem.player.id == newItem.player.id

    override fun areContentsTheSame(
        oldItem: FullInfoPlayer,
        newItem: FullInfoPlayer,
    ): Boolean = oldItem == newItem
}
//endregion

//region private methods
private fun RowPlayerDetailBinding.bind(player: PlayerBO, team: TeamBO) {
    rowPlayerDetailContent.apply {
        playerDetailCardLabelPlayerMedia.text = player.calculatePlayerAverage().toString()
        playerDetailCardLabelPlayerPosition.text = player.position
        playerDetailCardImgPlayerShield.loadGlideCenterImage(team.shield)
        playerDetailCardLabelPlayerName.text = player.name.uppercase()
        playerDetailCardImgPlayerPhoto.loadGlideCenterImage(player.photo)
        playerDetailCardLabelPlayerKickPunctuation.text = player.kick.toString()
        playerDetailCardLabelPlayerBodyPunctuation.text = player.body.toString()
        playerDetailCardLabelPlayerControlPunctuation.text = player.control.toString()
        playerDetailCardLabelPlayerGuardPunctuation.text = player.guard.toString()
        playerDetailCardLabelPlayerSpeedPunctuation.text = player.speed.toString()
        playerDetailCardLabelPlayerGutsPunctuation.text = player.guts.toString()

    }
}
//endregion