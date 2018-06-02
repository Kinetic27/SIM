package kr.co.highton.slacks.sim

import android.annotation.SuppressLint
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.Toast

class MainActivity : BaseActivity() {

    override var viewId: Int = R.layout.activity_main
    override var toolbarId: Int? = R.id.toolbar
    private lateinit var toast: Toast
    private var backKeyPressedTime: Long = 200
    private var mViewPager: ViewPager? = null

    @SuppressLint("ShowToast")
    override fun onCreate() {
        showActionBar()

        toast = Toast.makeText(this, getString(R.string.press_back_button_one_more), Toast.LENGTH_SHORT)

        mViewPager = findViewById(R.id.viewPager)
        mViewPager!!.adapter = PagerAdapter(supportFragmentManager)
        mViewPager!!.currentItem = 0

        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)

        // set icons
        tabLayout.getTabAt(0)!!.text = "종목 소개"
        tabLayout.getTabAt(1)!!.text = "주변 시설"
        tabLayout.getTabAt(2)!!.text = "Q&A"
        tabLayout.getTabAt(3)!!.text = "Tip!"

        mViewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) = tab.select()

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

       /* viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {

            }
        })*/
    }

    override fun onBackPressed() {

        if (System.currentTimeMillis() > backKeyPressedTime + 500) {
            backKeyPressedTime = System.currentTimeMillis()
            toast.show()
            return
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 500) {
            toast.cancel()
            this.finish()
        }
    }

    inner class PagerAdapter(supportFragmentManager: FragmentManager) : FragmentStatePagerAdapter(supportFragmentManager) {

        override fun getItem(position: Int): Fragment? {

            return when (position) {
                0 ->
                    AdFragment()
                1 ->
                    FngFragment()
                2 ->
                    C2cFragment()
                3 ->
                    TipFragment()
                else ->
                    null
            }
        }

        override fun getCount(): Int = 4
    }
}
