package com.ugo.pastel.presentation.userdetails

import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.ugo.pastel.R
import com.ugo.pastel.databinding.FragmentUserDetailsBinding
import com.ugo.pastel.main.base.BaseFragment
import com.ugo.pastel.presentation.places.PlacesFragment

class UserDetailsFragment : BaseFragment<FragmentUserDetailsBinding, UserDetailsViewModel>(),
  UserDetailsTrait {

  //region Ui

  override val layoutRes: Int
    get() = R.layout.fragment_user_details

  //endregion

  // region Args

  val args: UserDetailsFragmentArgs by navArgs()

  // endregion

  // region WebSettings

  lateinit var webSettings: WebSettings

  // endregion

  //region View Model

  override val viewModel: UserDetailsViewModel
    by viewModels { factory }

  //endregion

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    // Init observers.
    initObservers()

    // Inflate WebView
    initializeWebSettings()

    // Setup Toolbar
    setupToolbar()

  }

  //region Binding

  override fun bindView(binding: FragmentUserDetailsBinding) {
    binding
      .also { it.disposables = disposables }
      .also { it.viewModel = viewModel }
  }

  //endregion

  //region Observers

  private fun initObservers() {
  }

  //endregion

  // region Initialize WebView
  private fun initializeWebSettings() {
    binding.articleWebView.loadUrl(getArticleUrl())
    webSettings = binding.articleWebView.settings
      .apply {
        this.javaScriptEnabled = true
        this.loadsImagesAutomatically
        this.javaScriptEnabled
      }
  }

  // endregion

  // region Toolbar

  private fun setupToolbar() {
//    binding.toolbar.txtHeader.text = PlacesFragment.APP_NAME
//    binding.toolbar.arrowBack.setOnClickListener {
//      navigateUp()
//    }
  }

  // endregion

  fun getArticleUrl(): String {
    return args.url
  }

}
