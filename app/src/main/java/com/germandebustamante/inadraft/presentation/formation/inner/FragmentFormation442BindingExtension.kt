package com.germandebustamante.inadraft.presentation.formation.inner

import android.content.res.ColorStateList
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.germandebustamante.inadraft.R
import com.germandebustamante.inadraft.databinding.FragmentFormation442Binding
import com.germandebustamante.inadraft.databinding.PlayerMiniCardBinding
import com.germandebustamante.inadraft.domain.player.model.FullInfoPlayer
import com.germandebustamante.inadraft.presentation.formation.inner.Formation442Fragment.Companion.FORMATION_4_4_2_ID
import com.germandebustamante.inadraft.util.NUMBER_OF_PLAYERS
import com.germandebustamante.inadraft.commonAndroid.loadGlideCenterImage

private const val GOALKEEPER_ABBREVIATED = "GK"
private const val DEFENSE_ABBREVIATED = "DF"
private const val MIDFIELD_ABBREVIATED = "MF"
private const val FORWARD_ABBREVIATED = "FW"
private const val FACTOR_RATING_BAR = 1.5

//region public methods
fun FragmentFormation442Binding.setupInitialViews() {
    formation442BtnAddGame.iconTint =
        ColorStateList.valueOf(ContextCompat.getColor(root.context, R.color.white))
    PositionPreviewLabelGoalkeeper.root.text = GOALKEEPER_ABBREVIATED
    PositionPreviewLabelDefender1.root.text = DEFENSE_ABBREVIATED
    PositionPreviewLabelDefender2.root.text = DEFENSE_ABBREVIATED
    PositionPreviewLabelDefender3.root.text = DEFENSE_ABBREVIATED
    PositionPreviewLabelDefender4.root.text = DEFENSE_ABBREVIATED
    PositionPreviewLabelMidfielder1.root.text = MIDFIELD_ABBREVIATED
    PositionPreviewLabelMidfielder2.root.text = MIDFIELD_ABBREVIATED
    PositionPreviewLabelMidfielder3.root.text = MIDFIELD_ABBREVIATED
    PositionPreviewLabelMidfielder4.root.text = MIDFIELD_ABBREVIATED
    PositionPreviewLabelForward1.root.text = FORWARD_ABBREVIATED
    PositionPreviewLabelForward2.root.text = FORWARD_ABBREVIATED
    contentFormationBase.formationFragmentToolbarTittle.text = FORMATION_4_4_2_ID
}

fun FragmentFormation442Binding.setupListeners() {
    formation442Goalkeeper.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Defender1.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Defender2.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Defender3.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Defender4.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Midfielder1.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Midfielder2.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Midfielder3.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Midfielder4.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Forward1.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Forward2.root.setOnClickListener { onPlayerCardClicked(it) }
}

fun FragmentFormation442Binding.changeCardsClickable(isClickable: Boolean) {
    formation442Goalkeeper.root.isClickable = isClickable
    formation442Defender1.root.isClickable = isClickable
    formation442Defender2.root.isClickable = isClickable
    formation442Defender3.root.isClickable = isClickable
    formation442Defender4.root.isClickable = isClickable
    formation442Midfielder1.root.isClickable = isClickable
    formation442Midfielder2.root.isClickable = isClickable
    formation442Midfielder3.root.isClickable = isClickable
    formation442Midfielder4.root.isClickable = isClickable
    formation442Forward1.root.isClickable = isClickable
    formation442Forward2.root.isClickable = isClickable
}

fun FragmentFormation442Binding.onPlayerCardClicked(playerCard: View) {
    changeCardsClickable(false)
    val playerPositionId = when (playerCard.id) {
        R.id.formation442Goalkeeper -> "GK"
        R.id.formation442Defender1, R.id.formation442Defender2, R.id.formation442Defender3, R.id.formation442Defender4 -> "DF"
        R.id.formation442Midfielder1, R.id.formation442Midfielder2, R.id.formation442Midfielder3, R.id.formation442Midfielder4 -> "MF"
        R.id.formation442Forward1, R.id.formation442Forward2 -> "FW"
        else -> ""
    }
    root.findNavController()
        .navigate(
            Formation442FragmentDirections.actionFormation442FragmentToChoosePlayerDialog(
                playerPositionId,
                playerCard.id
            )
        )
}

fun FragmentFormation442Binding.onPlayersDraftChanged(
    playersMap: MutableMap<Int, FullInfoPlayer>,
    formationId: Int,
) {
    drawAverageTeam(playersMap.values.toList())
    playersMap.forEach {
        drawPlayerInCard(it.value, it.key)
    }

    if (playersMap.size == NUMBER_OF_PLAYERS) {
        formation442BtnAddGame.apply {
            isEnabled = true
            setBackgroundColor((ContextCompat.getColor(root.context, R.color.colorPrimary)))
            setOnClickListener {
                val totalPunctuation = playersMap.values.sumOf { it.player.calculatePlayerAverage() }
                root.findNavController()
                    .navigate(
                        Formation442FragmentDirections.actionFormation442FragmentToScoreGameDialog(
                            totalPunctuation,
                            (totalPunctuation / NUMBER_OF_PLAYERS).toFloat(),
                            formationId
                        )
                    )
            }
        }
    }
}
//endregion

//region private methods

private fun FragmentFormation442Binding.drawPlayerInCard(player: FullInfoPlayer, playerCardId: Int?) {
    when (playerCardId) {
        R.id.formation442Goalkeeper -> drawPlayer(formation442Goalkeeper, player)
        R.id.formation442Defender1 -> drawPlayer(formation442Defender1, player)
        R.id.formation442Defender2 -> drawPlayer(formation442Defender2, player)
        R.id.formation442Defender3 -> drawPlayer(formation442Defender3, player)
        R.id.formation442Defender4 -> drawPlayer(formation442Defender4, player)
        R.id.formation442Midfielder1 -> drawPlayer(formation442Midfielder1, player)
        R.id.formation442Midfielder2 -> drawPlayer(formation442Midfielder2, player)
        R.id.formation442Midfielder3 -> drawPlayer(formation442Midfielder3, player)
        R.id.formation442Midfielder4 -> drawPlayer(formation442Midfielder4, player)
        R.id.formation442Forward1 -> drawPlayer(formation442Forward1, player)
        R.id.formation442Forward2 -> drawPlayer(formation442Forward2, player)
    }
}

private fun drawPlayer(playerCardMiniBinding: PlayerMiniCardBinding, player: FullInfoPlayer) {
    playerCardMiniBinding.apply {
        root.isClickable = false
        playerMiniCardLabelPlayerMedia.text = player.player.calculatePlayerAverage().toString()
        playerMiniCardLabelPlayerPosition.text = player.player.position
        playerMiniCardImgPlayerShield.loadGlideCenterImage(player.team.shield)
        playerMiniCardImgPlayerPhoto.loadGlideCenterImage(player.player.photo)
        playerMiniCardLabelPlayerName.text = player.player.firstName
    }
}

private fun FragmentFormation442Binding.drawAverageTeam(players: List<FullInfoPlayer>) {
    val averageTeamDraft = (players.sumOf { it.player.calculatePlayerAverage() } / NUMBER_OF_PLAYERS).toFloat()
    contentFormationBase.apply {
        formationFragmentToolbarRatingNumber.text = averageTeamDraft.toInt().toString()
        formationFragmentToolbarRatingBar.rating =
            (averageTeamDraft / NUMBER_OF_PLAYERS)
    }
}
//endregion
