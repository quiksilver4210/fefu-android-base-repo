package ru.fefu.activitytracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.fefu.activitytracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            initDefaultActivity()
        }

        initNavListener()
    }

    private fun initDefaultActivity() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fcvActivityTracker, ActivityFragment.newInstance(), ActivityFragment.TAG)
            commit()
        }
    }

    private fun initNavListener() {
        binding.bnvMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_activity -> {
                    changeFragment(
                        supportFragmentManager.findFragmentByTag(ProfileFragment.TAG),
                        supportFragmentManager.findFragmentByTag(ActivityFragment.TAG)
                    )
                    true
                }
                R.id.action_profile -> {
                    changeFragment(
                        supportFragmentManager.findFragmentByTag(ActivityFragment.TAG),
                        supportFragmentManager.findFragmentByTag(ProfileFragment.TAG)
                    )
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun changeFragment(currentFragment: Fragment?, newFragment: Fragment?) {
        if (newFragment == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.fcvActivityTracker, ProfileFragment.newInstance(), ProfileFragment.TAG)
                commit()
            }
        } else {
            supportFragmentManager.beginTransaction().apply {
                show(newFragment)
                commit()
            }
        }

        if (currentFragment != null) {
            supportFragmentManager.beginTransaction().apply {
                hide(currentFragment)
                commit()
            }
        }

    }
}