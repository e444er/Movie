package com.droidli.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.droidli.movie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var navController: NavController
    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        fun initGraph() {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment
            navController = navHostFragment.navController

            binding.mainBottomNav.setupWithNavController(navController)

            binding.mainBottomNav.setOnItemReselectedListener {
                when (it.itemId) {
                    R.id.discover_nav_graph -> {
                        popBack(R.id.discoverFragment)
                    }

                    R.id.tv_shows_nav_graph -> {
                        popBack(R.id.tvShowFragment)
                    }

                    R.id.movies_nav_graph -> {
                        popBack(R.id.moviesFragment)
                    }

                    R.id.soon_nav_graph -> {
                        popBack(R.id.soonFragment)
                    }

                    R.id.persons_nav_graph -> {
                        popBack(R.id.personsFragment)
                    }
                }
            }
        }
    }
    private fun popBack(@IdRes destinationId: Int, inclusive: Boolean = false) {
        navController.popBackStack(destinationId, inclusive)
    }
}