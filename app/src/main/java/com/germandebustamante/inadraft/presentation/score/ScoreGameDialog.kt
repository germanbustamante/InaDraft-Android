package com.germandebustamante.inadraft.presentation.score

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.germandebustamante.inadraft.R
import com.germandebustamante.inadraft.commonAndroid.showToast
import com.germandebustamante.inadraft.databinding.DialogScoreGameBinding
import com.germandebustamante.inadraft.util.NUMBER_OF_PLAYERS
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScoreGameDialog : DialogFragment() {

    //region class attributes
    private val args: ScoreGameDialogArgs by navArgs()
    private var binding: DialogScoreGameBinding? = null
    private val viewModel: ScoreGameViewModel by viewModels()
    //endregion

    //region override methods
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        isCancelable = false
        binding?.apply {
            setupViews(args.totalPunctuation, args.teamAverage)
            setupListeners()
        }
        return binding?.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogScoreGameBinding.inflate(layoutInflater)
        return MaterialAlertDialogBuilder(requireActivity())
            .setView(binding?.root)
            .setCancelable(false)
            .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVMObservers()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    //endregion

    //region private methods
    @RequiresApi(Build.VERSION_CODES.O)
    private fun DialogScoreGameBinding.setupViews(
        totalPunctuation: Int,
        teamAverage: Float,
    ) {
        scoreGameDialogRatingBarTeamMedia.rating = (teamAverage / NUMBER_OF_PLAYERS / 1.5).toFloat()
        scoreGameDialogLabelTotalScore.text = totalPunctuation.toString()
        scoreGameDialogLabelTeamMedia.text = teamAverage.toInt().toString()
        scoreGameDialogProgressIndicatorTotalScore.progress = totalPunctuation / 10
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun DialogScoreGameBinding.setupListeners() {
        scoreGameDialogBtnAddGame.setOnClickListener {
            root.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.loadingGrayTransparent))
            it.isEnabled = false
            scoreGameDialogProgressIndicatorLoadingAddGame.isVisible = true

            viewModel.insertGame(userNickname = scoreGameDialogInputLayUserNick.text.toString())
        }
    }

    private fun setupVMObservers() {
        viewModel.operationSuccess.observe(viewLifecycleOwner) {
            showToast(getString(R.string.dialog_score_game__snackbar__game_added_success))
            findNavController().navigate(R.id.action_scoreGameDialog_to_home_fragment)
        }
    }
    //endregion
}