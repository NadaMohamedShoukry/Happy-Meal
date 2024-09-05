package com.example.happymeal.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.happymeal.R
import com.example.happymeal.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment
        navController = navHostFragment.navController

        //to connect bottom navigator with navgraph
        binding.bottomNavigationView.setupWithNavController(navController)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.homeScreenFragment2 -> {
                    Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.homeScreenFragment2)
                    true
                }
                R.id.favouritesFragment2 ->{
                    Toast.makeText(this, "Fav clicked", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.favouritesFragment2)
                    true
                }
                R.id.searchScreenFragment2 ->{
                    Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.searchScreenFragment2)
                    true
                }
                R.id.profileFragment2 ->{
                    Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.profileFragment2)
                    true
                }
                else-> false

            }
        }

    }


}