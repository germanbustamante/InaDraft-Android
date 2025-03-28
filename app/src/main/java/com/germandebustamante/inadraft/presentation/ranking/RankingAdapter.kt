package com.germandebustamante.inadraft.presentation.ranking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.germandebustamante.inadraft.R
import com.germandebustamante.inadraft.databinding.RowGameBinding
import com.germandebustamante.inadraft.domain.game.model.GameBO

private const val DATE_FORMAT_GAME = "MM/dd/yyyy"

class GameAdapter : ListAdapter<GameBO, GameViewHolder>(GameBODiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_game, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = getItem(position)
        holder.binding.bind(game, currentList.indexOf(game) + 1)
    }
}

//region viewHolder
class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = RowGameBinding.bind(view)
}

//endregion

//region diffCallback
object GameBODiffCallback : DiffUtil.ItemCallback<GameBO>() {
    override fun areItemsTheSame(oldItem: GameBO, newItem: GameBO): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: GameBO, newItem: GameBO): Boolean =
        oldItem == newItem

}

//endregion

//region private methods
private fun RowGameBinding.bind(game: GameBO, position: Int) {
    rowGameLabelGamePosition.text = position.toString().plus(".")
    rowGameLabelUserGame.text = game.userNickname
    //rowGameLabelGameDate.text = SimpleDateFormat(DATE_FORMAT_GAME).format(game.date)
    rowGameLabelGameScore.text = game.score.toString()
}
//endregion

