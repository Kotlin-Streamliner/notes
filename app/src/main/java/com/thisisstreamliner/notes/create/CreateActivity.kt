package com.thisisstreamliner.notes.create

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

import com.thisisstreamliner.notes.R
import com.thisisstreamliner.notes.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)


        textView.text =
            if (intent.getStringExtra(NavigationActivity.FRAGMENT_TYPE_KEY) == NavigationActivity.FRAGMENT_VALUE_TASK) "this is a task"
            else "this is a note"
    }
}
