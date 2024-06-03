package com.example.bottomnavigation

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val homeFragment=FirstFragment()
        val messageFragment=SecondFragment()
        val profileFragment=ThirdFragment()

        setCurrentFragment(homeFragment)
        val bottomNavigationView:BottomNavigationView=findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener {it->
            when(it.itemId){
                R.id.home ->setCurrentFragment(homeFragment)
                R.id.message->setCurrentFragment(messageFragment)
                R.id.profile->setCurrentFragment(profileFragment)
            }
            true
        }
        bottomNavigationView.getOrCreateBadge(R.id.message).apply {
            number=3
            isVisible=true;
        }
    }
    private fun setCurrentFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout,fragment)
            commit()
        }
    }
}