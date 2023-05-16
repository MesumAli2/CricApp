package com.mesum.blitzcric

import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.mesum.blitzcric.databinding.ActivityTeamBinding
import com.mesum.blitzcric.ui.main.SectionsPagerAdapter


class TeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTeamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter

        val poppinsMedium = ResourcesCompat.getFont(this, com.mesum.blitzcric.R.font.poppins_medium)
        val poppinsLight = ResourcesCompat.getFont(this, com.mesum.blitzcric.R.font.poppins_light)
        val tabLayout = binding.tabs









        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val tabLayout =
                    (tabLayout.getChildAt(0) as ViewGroup).getChildAt(tab.position) as LinearLayout
                val tabTextView = tabLayout.getChildAt(1) as TextView
                tabTextView.setTypeface(poppinsMedium)


            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val tabLayout =
                    (tabLayout.getChildAt(0) as ViewGroup).getChildAt(tab.position) as LinearLayout
                val tabTextView = tabLayout.getChildAt(1) as TextView
                tabTextView.setTypeface(poppinsLight)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
        tabLayout.setupWithViewPager(viewPager)


    }
}