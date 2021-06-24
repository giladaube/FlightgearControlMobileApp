package com.example.flightgearcontrolapp.viewModel

import android.widget.SeekBar
import com.example.flightgearcontrolapp.model.CustomSeekBar
import com.example.flightgearcontrolapp.model.FgConnection
import com.example.flightgearcontrolapp.model.JoystickModel
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ViewModel {

    var pool: ExecutorService = Executors.newSingleThreadExecutor()
    lateinit var host: String
    var port: Int = 0
    lateinit var connection: FgConnection
    lateinit var joystick: JoystickModel

    // using FgConnection to connect to Flightgear
    fun connect(): Boolean {
        if (this::host.isInitialized && port != 0) {
            if (this::connection.isInitialized && connection.isAlive())
                connection.close()
            connection = FgConnection(pool, host, port)
            connection.connect()
            // create joystick
            joystick = JoystickModel(connection)
            return true
        }
        return false
    }

    // set throttle and rudder SeekBar, in order of sending given data
    fun setBar(throttleBar: SeekBar, rudderBar: SeekBar) {
        if (this::connection.isInitialized) {
            CustomSeekBar(throttleBar, 100, false, connection, "set /controls/engines/current-engine/throttle")
            CustomSeekBar(rudderBar, 200, true, connection, "set /controls/flight/rudder")
        }
    }

    // same for joystick
    fun setJoystick(aileron: Float, elevator: Float) {
        if (this::connection.isInitialized)
            joystick.setJoystick(aileron, elevator)
    }

}