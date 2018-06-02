package kr.co.highton.slacks.sim

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
* Created by Kinetic on 2018-06-02.
*/

class AdFragment : Fragment() {
    private var summer = true
    private var winter = false
    private var ground = true
    private var water = false
    private var ball = false
    private var other = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_ad, container, false)
        view.findViewById<Button>(R.id.summer_btn).setOnClickListener { changeSelect(it) }
        view.findViewById<Button>(R.id.winter_btn).setOnClickListener { changeSelect(it) }
        view.findViewById<Button>(R.id.ground_btn).setOnClickListener { changeSelect(it) }
        view.findViewById<Button>(R.id.water_btn).setOnClickListener { changeSelect(it) }
        view.findViewById<Button>(R.id.ball_btn).setOnClickListener { changeSelect(it) }
        view.findViewById<Button>(R.id.other_btn).setOnClickListener { changeSelect(it) }

        return view
    }

    private fun changeSelect(v: View) {
        var dotColor = true
        when ((v as Button).text.toString()) {
            "하계 종목" -> {
                if (winter) {
                    summer = !summer
                    dotColor = summer
                }
            }
            "동계 종목" -> {
                if (summer) {
                    winter = !winter
                    dotColor = winter
                }
            }
            "육상종목" -> {
                if (water || ball || other) {
                    ground = !ground
                    dotColor = ground
                }
            }
            "수상종목" -> {
                if (ground || ball || other) {
                    water = !water
                    dotColor = water
                }
            }
            "구기종목" -> {
                if (ground || water || other) {
                    ball = !ball
                    dotColor = ball
                }
            }
            "기타종목" -> {
                if (ground || water || ball) {
                    other = !other
                    dotColor = other
                }
            }
        }

        v.background = if (dotColor) {
            ResourcesCompat.getDrawable(resources, R.drawable.round_effect_select, null)
        } else ResourcesCompat.getDrawable(resources, R.drawable.round_effect_unselect, null)
    }


}
