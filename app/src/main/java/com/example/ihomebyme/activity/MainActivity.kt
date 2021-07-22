package com.example.ihomebyme.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.ihomebyme.R
import com.example.ihomebyme.fragment.charge.ChargeFragment
import com.example.ihomebyme.fragment.fund.FoundFragment
import com.example.ihomebyme.fragment.projects.ProjectFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var fragment: Fragment? = null

    private val initSupportFragmentManager by lazy {
        fragment = supportFragmentManager.findFragmentById(R.id.container)
    }

    private val startFirstFragment by lazy {
        bottomNavigation.selectedItemId = R.id.itemProject
        fragment = ProjectFragment()
        switchToFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initSupportFragmentManager
        startFirstFragment

        bottomNavigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.itemFund -> {
                    fragment = FoundFragment()
                    switchToFragment()
                    true
                }
                R.id.itemProject -> {
                    fragment = ProjectFragment()
                    switchToFragment()
                    true
                }
                R.id.itemCharge -> {
                    fragment = ChargeFragment()
                    switchToFragment()
                    true
                }
                else -> false
            }
        }
    }

    private fun switchToFragment() {
        supportFragmentManager.commit {
            replace(R.id.container, fragment!!)
        }
    }
}