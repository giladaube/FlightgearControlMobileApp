package com.example.flightgearcontrolapp.model

class JoystickModel(val connection: FgConnection) {

    // send data about aileron and elevator based on joystick location, to FG
    fun setJoystick(aileron: Float, elevator: Float) {
        val ail = getValue(aileron, 265, true)
        connection.send("set /controls/flight/aileron $ail\r\n")
        val elev = getValue(elevator, 265, true)
        connection.send("set /controls/flight/elevator $elev\r\n")
    }


    fun getValue(value: Float, limit: Int, isB: Boolean): Float {
        var result: Float = value
        val lim: Float = limit.toFloat()
        if (isB)
            result -= lim
        return (result / lim)
    }
}