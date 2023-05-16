package com.mesum.blitzcric

import android.graphics.Typeface
import android.graphics.fonts.Font
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
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



        val poppinsMedium = ResourcesCompat.getFont(this, com.mesum.blitzcric.R.font.poppins_medium)
        val poppinsLight = ResourcesCompat.getFont(this, com.mesum.blitzcric.R.font.poppins_light)
        val tabLayout = findViewById<TabLayout>(R.id.tabs)

            val vg =  tabLayout.getChildAt(0) as ViewGroup
            val tabsCount = vg.getChildCount();
            for (i in  0 until   tabsCount) {
            val  vgTab =  vg.getChildAt(i) as (ViewGroup)
            val tabChildsCount = vgTab.getChildCount();
            for (i in 0 until tabChildsCount) {
            val tabViewChild = vgTab.getChildAt(i)as View
            if (tabViewChild is TextView) {
                ( tabViewChild).setTypeface(poppinsLight, Typeface.BOLD);
            }

        }
        }

        tabLayout.getTabAt(1)?.select()
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

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        tabLayout.setupWithViewPager(viewPager)


        val mainpager = PagerMain(this, supportFragmentManager)
        val viewPager2: ViewPager = binding.viewPage2r
        viewPager2.adapter = mainpager
        findViewById<TabLayout>(R.id.tabLayout1).setupWithViewPager(viewPager2)


    }
}