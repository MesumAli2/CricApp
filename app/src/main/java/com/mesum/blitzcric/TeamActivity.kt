package com.mesum.blitzcric

import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.view.View
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

// Make the status bar transparent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.statusBarColor = Color.TRANSPARENT
        }


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
        createList()

    }


    fun createList(){

        val mutablelist = mutableListOf<CricketPlayer>()
        mutablelist.add(0, CricketPlayer(resources.getDrawable(R.drawable.rohitsharma), name = "Shikhar Dhawan (c)",
        type = "Batsman , Left Handed Bat"))
        mutablelist.add(1, CricketPlayer(resources.getDrawable(R.drawable.liam), name = "Liam Livingstone",
            type = "Batsman , Right Handed Bat"))
        mutablelist.add(2, CricketPlayer(resources.getDrawable(R.drawable.athavara), name = "Atharva Taide",
            type = "Batsman , Left Handed Bat"))
        mutablelist.add(3, CricketPlayer(resources.getDrawable(R.drawable.raza), name = "Sikandar Raza",
            type = "Allrounder , Right Handed Bat"))
        mutablelist.add(4, CricketPlayer(resources.getDrawable(R.drawable.sharukh), name = "Shahrukh Khan" ,
            type = "Batsman , Right Handed Bat"))

        mutablelist.add(5, CricketPlayer(resources.getDrawable(R.drawable.harpeet), name = "Harpreet Brar",
            type = "Allrounder , Right Handed Bat"))

        mutablelist.add(6, CricketPlayer(resources.getDrawable(R.drawable.sam), name = "Sam Curran",
            type = "Allrounder , Left Handed Bat"))

        mutablelist.add(7, CricketPlayer(resources.getDrawable(R.drawable.rishi), name = "Rishi Dhawan",
            type = "Allrounder , Right Handed Bat"))

        mutablelist.add(8, CricketPlayer(resources.getDrawable(R.drawable.baltej), name = "Baltej Singh",
            type = "Allrounder , Right Handed Bat"))

        mutablelist.add(8, CricketPlayer(resources.getDrawable(R.drawable.baltej), name = "Baltej Singh",
            type = "Allrounder , Right Handed Bat"))

        val adapter = PlayerAdapter(mutablelist, context = this)
        binding.rvMain.adapter = adapter

    }
}