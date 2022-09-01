package com.ugo.pastel

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.ugo.pastel.databinding.ActivityMainBinding
import com.ugo.pastel.main.base.BaseActivity
import com.ugo.pastel.presentation.places.PlacesViewModel
import dagger.android.HasAndroidInjector

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainTrait, HasAndroidInjector{

    //region View Model

     override val viewModel: MainViewModel
            by viewModels { factory }

    val placesViewModel: PlacesViewModel
            by viewModels { factory }

    //endregion

    //region Ui

    override val layoutResId: Int
        get() = R.layout.activity_main

    //endregion

    //region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        // Search for navigation host fragment.
        val host = supportFragmentManager
            .findFragmentById(R.id.appNavHostFragment) as NavHostFragment

        // Find nav controller.
        navigationController = host.navController

        // Init Navigation drawer
        initializeNavigationDrawer()

        // Initialize Observers
        initObservers()

    }

    //endregion

    // region Observers

    private fun initObservers() {
    }

    // endregion

    // region Navigation Drawer

    private fun initializeNavigationDrawer() {
        // Initialize Navigation Drawer
        binding.navView.setupWithNavController(navigationController)

        // Disable icon tints.
        binding.navView.itemIconTintList = null

    }

    fun openDrawer() {
        binding.drawerLayout.openDrawer(GravityCompat.START)
    }

    // endregion

    //region Navigation Controller

    private lateinit var navigationController: NavController

    //endregion


    override fun onBackPressed() {
        super.onBackPressed()
        placesViewModel.deleteAllUsers()

    }

}