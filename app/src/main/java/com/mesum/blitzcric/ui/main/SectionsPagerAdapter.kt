package com.mesum.blitzcric.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mesum.blitzcric.R

private val TAB_TITLES = arrayOf(
    "INFO",
    "SQUAD",
    "ODDS",
    "FANCY ODDS",
    "POINT TABLE"

)


class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES.get(position)
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 5
    }
}