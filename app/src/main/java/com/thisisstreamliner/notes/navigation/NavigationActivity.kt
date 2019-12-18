package com.thisisstreamliner.notes.navigation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.thisisstreamliner.notes.R
import com.thisisstreamliner.notes.create.CreateActivity
import com.thisisstreamliner.notes.notes.NotesListFragment
import com.thisisstreamliner.notes.tasks.TasksListFragment
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity(), TouchActionDelegate {

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_tasks -> {
                    replaceFragment(TasksListFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notes -> {
                    replaceFragment(NotesListFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        replaceFragment(TasksListFragment.newInstance())
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentHolder, fragment)
            .commit()
    }

    private fun goToCreateActivity(fragmentValue : String) {
        val intent = Intent(this, CreateActivity::class.java).apply {
            putExtra(FRAGMENT_TYPE_KEY, fragmentValue)
        }
        startActivity(intent)
    }

    override fun onAddButtonClicked(fragmentValue : String) {
        goToCreateActivity(fragmentValue)
    }



    companion object {

        const val FRAGMENT_TYPE_KEY = "f_t_k"
        const val FRAGMENT_VALUE_TASK = "f_v_t"
        const val FRAGMENT_VALUE_NOTE = "f_v_n"

    }
}

interface TouchActionDelegate {
    fun onAddButtonClicked(fragmentValue: String)
}