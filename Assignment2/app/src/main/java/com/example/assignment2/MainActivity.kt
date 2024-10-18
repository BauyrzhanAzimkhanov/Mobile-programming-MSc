package com.example.assignment2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigationView: BottomNavigationView = findViewById(R.id.navigation_view)
        val navigationHostFragment = supportFragmentManager.findFragmentById(R.id.navigation_host_fragment_activity_main) as NavHostFragment
        val navigationController = navigationHostFragment.navController

        navigationView.setupWithNavController(navigationController)
        bottomNavItemChangeListener(navigationView, navigationController)

    }
    private fun bottomNavItemChangeListener(navigationView: BottomNavigationView, navigationController: NavController) {
        navigationView.setOnItemSelectedListener { item ->
            if (item.itemId != navigationView.selectedItemId) {
                navigationController.popBackStack(item.itemId, inclusive = true, saveState = false)
                navigationController.navigate(item.itemId)
            }
            true
        }
    }

}