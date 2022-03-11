package com.amrabdelhamiddiab.pharmacy_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.PreferenceManager
import com.amrabdelhamiddiab.core.data.IPreferenceHelper
import com.amrabdelhamiddiab.pharmacy_1.databinding.ActivityMainBinding
import com.amrabdelhamiddiab.pharmacy_1.databinding.AppBarMainBinding
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.MyDrawerController
import com.amrabdelhamiddiab.pharmacy_1.framework.utilis.checkInternetConnection
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(), MyDrawerController {
    companion object {
        const val TAG = "MainActivity"
    }

    private val navController: NavController by lazy {
        Navigation.findNavController(this, R.id.nav_host_fragment_content_main)
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navigationView: NavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: MaterialToolbar
    private lateinit var collapsingToolbar: CollapsingToolbarLayout
    private lateinit var appBarLayout: AppBarLayout
    private lateinit var appBar: AppBarMainBinding

    //  private lateInit var fab: FloatingActionButton
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var preferenceHelper: IPreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appBarLayout = binding.appBarMain.appbar
        collapsingToolbar = binding.appBarMain.collapsing
        preferenceHelper = PreferenceManager(this.applicationContext)
        drawerLayout = binding.drawerLayout
        navigationView = binding.navigationView
        appBar = binding.appBarMain
        toolbar = binding.appBarMain.toolbar
        //fab = binding.appBarMain.floatingActionButton
        bottomNavigationView = binding.appBarMain.contentMain.bottomNavigationView
        setSupportActionBar(toolbar)
        /* fab.setOnClickListener {
            SnackBar.make(it, "Replace with your own action", SnackBar.LENGTH_LONG)
                .setAction("Action", null).show()

        }*/
        bottomNavigationView.setupWithNavController(navController)
        navigationView.setupWithNavController(navController)
        //to hide up button when this fragments selected
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.cartFragment,
                R.id.searchFragment,
                R.id.favoriteFragment,
                R.id.homeFragment
            ), drawerLayout
        )
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        //----------------------------
        //to hide the appBarLayout in any fragment
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.loginFragment ||
                destination.id == R.id.signupFragment ||
                destination.id == R.id.resetPasswordFragment
            ) {
                Log.d(TAG, destination.toString() + "666666666666666666666666666666666")
                appBarLayout.visibility = View.GONE
                bottomNavigationView.visibility = View.GONE;
            } else {
                appBarLayout.visibility = View.VISIBLE
                bottomNavigationView.visibility = View.VISIBLE;
            }
        }
        //------------------------------
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (checkInternetConnection(this)) {
            return when (item.itemId) {
                R.id.action_Logout -> {
                    Log.d(TAG, "Selected :  $item")
                    try {
                        run {
                            FirebaseAuth.getInstance().signOut()
                            preferenceHelper.setUserLoggedIn(false)
                            Log.d(TAG, FirebaseAuth.getInstance().currentUser.toString())
                            navController.navigate(R.id.nested_graph_login)
                            true
                        }
                    } catch (e: Exception) {
                        Log.d(TAG, " error in mainActivity  " + e.message.toString())
                        super.onOptionsItemSelected(item)
                    }
                }
                else -> super.onOptionsItemSelected(item)
            }
        } else {
            Toast.makeText(
                this,
                "No Network please turn on",
                Toast.LENGTH_SHORT
            ).show()
            return super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_app_bar, menu)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun setDrawerLocked() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        toolbar.visibility = View.GONE
        //  fab.visibility = View.GONE
        bottomNavigationView.visibility = View.GONE
    }

    override fun setDrawerUnlocked() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        toolbar.visibility = View.VISIBLE
        //  fab.visibility = View.VISIBLE
        bottomNavigationView.visibility = View.VISIBLE
    }

}