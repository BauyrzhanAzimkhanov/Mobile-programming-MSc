package com.example.assignment2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.hide()

        val navigationView: BottomNavigationView = findViewById(R.id.navigation_view)

        val navigationHostFragment = supportFragmentManager.findFragmentById(R.id.navigation_host_fragment_activity_main) as NavHostFragment
        val navigationController = navigationHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.home_feed_menu, R.id.profile_menu, R.id.search_menu, R.id.add_post_menu, R.id.notifications_menu
            )
        )

        setupActionBarWithNavController(navigationController, appBarConfiguration)
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