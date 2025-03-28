package com.germandebustamante.inadraft.presentation.playerSelection

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.germandebustamante.inadraft.databinding.DialogChoosePlayerBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerSelectionDialog : DialogFragment() {

    //region class attributes
    private val args: PlayerSelectionDialogArgs by navArgs()
    private var binding: DialogChoosePlayerBinding? = null
    private var adapter: PlayerMiniGameAdapter? = null
    private val viewModel: PlayerSelectionViewModel by viewModels()
    //endregion

    //region override methods
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        isCancelable = false
        adapter = PlayerMiniGameAdapter {
            getListener()?.putPlayerInCard(it.player.id, args.playerCardId)
            dismiss()
        }.also {
            binding?.choosePlayerDialogListOfPlayers?.adapter = it
        }
        return binding?.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogChoosePlayerBinding.inflate(layoutInflater)
        return MaterialAlertDialogBuilder(requireActivity())
            .setView(binding?.root)
            .setCancelable(false)
            .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVMObservers()
        viewModel.loadRandomPlayers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        adapter = null
    }
    //endregion

    //region private methods
    private fun getListener(): PlayerSelectionListener? {
        val targetFragmentIndex = parentFragmentManager.fragments.size - 2
        val targetFragment = parentFragmentManager.fragments[targetFragmentIndex]
        return when {
            targetFragment is PlayerSelectionListener -> targetFragment
            parentFragment is PlayerSelectionListener -> parentFragment as PlayerSelectionListener
            activity is PlayerSelectionListener -> activity as PlayerSelectionListener
            else -> null
        }
    }

    private fun setupVMObservers() {
        viewModel.randomPlayers.observe(viewLifecycleOwner) {
            adapter?.submitList(it.toList())
        }
    }
    //endregion

}