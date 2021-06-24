package com.example.flightgearcontrolapp.model

import java.io.PrintWriter
import java.net.Socket
import java.util.concurrent.ExecutorService

class FgConnection(val pool: ExecutorService, val host: String, val port: Int) {

    lateinit var fg: Socket
    lateinit var out: PrintWriter

    // connect to socket, based on given IP(host) and port
    fun connect() {
        pool.execute {
            fg = Socket(host, port)
            openStream()
        }
    }

    // return status of socket
    fun isAlive(): Boolean {
        return fg.isConnected
    }

    // close socket
    fun close() {
        out.close()
        fg.close()
    }

    // get new stream, used to send info via socket
    private fun openStream() {
        pool.execute {
            out = PrintWriter(fg.getOutputStream(), true)
        }
    }

    // send given message via stream
    fun send(message: String) {
        pool.execute {
            out.print(message)
            out.flush()
        }
    }

}