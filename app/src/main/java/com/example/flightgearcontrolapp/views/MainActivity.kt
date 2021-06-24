package com.example.flightgearcontrolapp.views

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.flightgearcontrolapp.R
import com.example.flightgearcontrolapp.viewModel.ViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // add viewModel
        val viewModel: ViewModel = ViewModel()

        viewModel.pool.execute {
            // get IP address and port to connect FG
            val hostText: EditText = findViewById(R.id.con_ipaddress)
            hostText.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {
                    if (s.toString() != "")
                        viewModel.host = s.toString()
                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence, start: Int,
                    before: Int, count: Int
                ) {
                }

            })

            val portText: EditText = findViewById(R.id.con_port)
            portText.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {
                    if (s.toString() != "")
                        viewModel.port = s.toString().toInt()
                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence, start: Int,
                    before: Int, count: Int
                ) {
                }
            })
        }

        val throttleBar: SeekBar = findViewById(R.id.throttleBar)
        val rudderBar: SeekBar = findViewById(R.id.rudderBar)
        // connect to FG via given IP and port
        val connectionBtn: Button = findViewById(R.id.connect_btn)
        connectionBtn.setOnClickListener {
            if (viewModel.connect()) {
                Toast.makeText(applicationContext,"Connection established",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext,"Please try again",Toast.LENGTH_SHORT).show()
            }
            viewModel.setBar(throttleBar, rudderBar)
        }

        val joystickView: View = findViewById(R.id.joystickView)
        val joystick: ImageView = findViewById(R.id.joystick)

        viewModel.pool.execute {
            // get location on screen of joystick.
            // send data to FG via viewModel and update location on screen

            joystickView.setOnTouchListener(View.OnTouchListener { _, event ->
                if (event.x in 120.0..650.0 && event.y in 120.0..650.0)
                    when (event.action) {
                            MotionEvent.ACTION_DOWN -> {
                            }
                            MotionEvent.ACTION_MOVE -> {
                                viewModel.setJoystick(event.x - 120, event.y - 120)

                                joystick.x = event.x -120
                                joystick.y = event.y -120
                            }
                            MotionEvent.ACTION_UP -> {
                            }
                        }
                    return@OnTouchListener true
            })
        }
    }
}