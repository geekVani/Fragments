
 package com.example.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import org.jetbrains.annotations.Nullable

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // creating objects of each layout
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        var viewPager = findViewById<ViewPager>(R.id.tab_viewpager)
        var tabLayout = findViewById<TabLayout>(R.id.tab_tablayout)

        // As we set NoActionBar as theme to this activity
        // so when we run this project then this activity doesn't
        // show title. And for this reason, we need to run
        // setSupportActionBar method
        setSupportActionBar(toolbar)
        setupViewPager(viewPager)

        // If we dont use setupWithViewPager() method then
        // tabs are not used or shown when activity opened
        tabLayout.setupWithViewPager(viewPager)
        
    }

     // This function is used to add items in arraylist and assign
     // the adapter to view pager
     private fun setupViewPager(viewPager: ViewPager?) {
         var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

         // LoginFragment is the name of Fragment and the Login
         // is a title of tab
         adapter.addFragment(LoginFragment(), "Login")
         adapter.addFragment(SignupFragment(), "Signup")

         // setting adapter to view pager.
         viewPager!!.setAdapter(adapter)

     }
 }

 class ViewPagerAdapter : FragmentPagerAdapter{
     // objects of arraylist. One is of Fragment type and
     // another one is of String type.*/
     private final var fragmentList1: ArrayList<Fragment> = ArrayList()
     private final var fragmentTitleList1: ArrayList<String> = ArrayList()

     // this is a secondary constructor of ViewPagerAdapter class.
     public constructor(supportFragmentManager: FragmentManager)
             : super(supportFragmentManager)

     // returns which item is selected from arraylist of fragments.
     override fun getItem(position: Int): Fragment {
         return fragmentList1.get(position)
     }

     // returns which item is selected from arraylist of titles.
     @Nullable
     override fun getPageTitle(position: Int): CharSequence {
         return fragmentTitleList1.get(position)
     }

     // returns the number of items present in arraylist.
     override fun getCount(): Int {
         return fragmentList1.size
     }

     // this function adds the fragment and title in 2 separate  arraylist.
     fun addFragment(fragment: Fragment, title: String) {
         fragmentList1.add(fragment)
         fragmentTitleList1.add(title)
     }
 }
