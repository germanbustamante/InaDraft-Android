package com.germandebustamante.inadraft.presentation.formation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.germandebustamante.inadraft.databinding.FragmentFormationListBinding
import com.germandebustamante.inadraft.ui.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FormationListFragment : BaseFragment<FragmentFormationListBinding>() {

    //region class attributes
    private val viewModel: FormationListViewModel by viewModels()
    private var adapter: FormationAdapter? = null
    //endregion

    //region override methods
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = inflateViewBinding(inflater, container)

        binding?.apply {
            setupDrawerWithFragmentToolbar(formationListFragmentToolbarTop)
            adapter = FormationAdapter { onFormationSelected(it) }.also {
                setupRecyclerView(it)
            }
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.loadFormations()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter = null
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentFormationListBinding =
        FragmentFormationListBinding.inflate(inflater, container, false)
    //endregion

    //region private methods
    private fun setupObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.formations.collect { adapter?.submitList(it) }
            }
        }
    }
    //endregion
}
