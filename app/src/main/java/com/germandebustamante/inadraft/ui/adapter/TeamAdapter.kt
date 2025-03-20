package com.germandebustamante.inadraft.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.germandebustamante.inadraft.util.loadGlideCenterImage
import com.germandebustamante.inadraft.R
import com.germandebustamante.inadraft.databinding.RowTeamBinding
import com.germandebustamante.inadraft.domain.TeamBO

class TeamAdapter(private val onTeamClickedListener : (TeamBO) -> Unit) : ListAdapter<TeamBO, TeamViewHolder>(TeamDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.binding.bind(getItem(position), onTeamClickedListener)
    }

}

//region viewholder

/**
 * ViewHolder personalizado para pintado de una formación de la lista
 */
class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
    val binding = RowTeamBinding.bind(view)
}

//endregion

//region diffcallback

/**
 * DiffCallback personalizado para mejorar el rendimiento y agregar animaciones por defecto a la lista
 */
object TeamDiffCallback: DiffUtil.ItemCallback<TeamBO>() {
    override fun areItemsTheSame(oldItem: TeamBO, newItem: TeamBO): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: TeamBO, newItem: TeamBO): Boolean =
        oldItem == newItem

}

//endregion

//region private functions

/**
 * Dado una formación en un item específico, pinta los datos de esta en dicha fila
 */
private fun RowTeamBinding.bind(team: TeamBO, onTeamClickedListener: (TeamBO) -> Unit) {
    rowTeamImgOfTeam.loadGlideCenterImage(team.shield)
    rowTeamLabelTeamName.text = team.name
    root.setOnClickListener { onTeamClickedListener(team) }
}

//endregion


