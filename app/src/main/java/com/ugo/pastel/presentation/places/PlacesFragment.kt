package com.ugo.pastel.presentation.places

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.ugo.pastel.R
import com.ugo.pastel.databinding.FragmentPlacesBinding
import com.ugo.pastel.main.base.BaseFragment
import com.ugo.pastel.presentation.places.adapter.NewsItem
import com.ugo.pastel.presentation.places.adapter.UsersEventHook
import com.ugo.pastel.utility.context.doOnNextPage

class PlacesFragment : BaseFragment<FragmentPlacesBinding, PlacesViewModel>(), PlacesTrait {

  //region Ui

  override val layoutRes: Int
    get() = R.layout.fragment_places

  //endregion

  //region View Model

  override val viewModel: PlacesViewModel
    by viewModels { factory }

  //endregion

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    openNavDrawer()

    // Init observers.
    initObservers()

    // Setup RecyclerView
    initializeRecyclerView()

    // Init EventHooks
    initializeEventHooks()

    // Setup Toolbar
    setupToolbar()

    viewModel.fetchNewsArticles()
  }

  //region Binding

  override fun bindView(binding: FragmentPlacesBinding) {
    binding
      .also { it.disposables = disposables }
      .also { it.viewModel = viewModel }
  }

  //endregion

  //region Observers

  private fun initObservers() {
    viewModel.users.observe(viewLifecycleOwner, ::showItems)
    viewModel.newsClickAction.observe(viewLifecycleOwner, this::navigateToUserDetails)
  }

  //endregion

  fun openNavDrawer() {
    binding.toolbar.imgUser.setOnClickListener {
      binding.toolbar.imgUser.setOnClickListener {
        openDrawer()
      }
    }
  }

  //region Recycler View

  private fun initializeRecyclerView() = with(binding.recyclerUsers) {

    // Call to request next page.
    doOnNextPage {
      viewModel.loadNextPage()
    }

      binding.recyclerUsers.addItemDecoration(
        DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
      )


    // Assign adapter to recycler view.
    adapter = itemsAdapter
  }

  //endregion

  //region Items

  private val itemsAdapter: FastItemAdapter<NewsItem> by lazy { FastItemAdapter() }

  private fun showItems(items: List<NewsItem>) {

    // Set new list items.
    itemsAdapter.setNewList(items)
  }

  //endregion

  //region Event Hook

  private fun initializeEventHooks() {

    // Add event hooks.
    itemsAdapter
      .addEventHook(UsersEventHook(viewModel::onUserItemClicked))
  }

  //endregion

  // region Toolbar

  private fun setupToolbar() {
    binding.toolbar.txtHeader.text = APP_NAME
  }

  // endregion

  companion object {
    const val APP_NAME = "Pastel"
  }
}
