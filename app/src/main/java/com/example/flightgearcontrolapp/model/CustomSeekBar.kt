package com.example.flightgearcontrolapp.model

import android.widget.SeekBar

class CustomSeekBar(
    val bar: SeekBar,
    val limit: Int,
    val isB: Boolean,
    val connection: FgConnection,
    val message: String
) {

    init {
        executeBar()
    }

    private fun executeBar() {
        // set on change listener for given SeekBar
        bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                val sendValue: Float = getValue(progress.toFloat(), limit, isB)
                // send data to FG
                connection.send("$message $sendValue\r\n")
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
            }
        })
    }

    fun getValue(value: Float, limit: Int, isB: Boolean): Float {
        var result: Float = value
        val lim: Float = limit.toFloat()
        if (isB)
            result -= lim
        return (result / lim)
    }
}