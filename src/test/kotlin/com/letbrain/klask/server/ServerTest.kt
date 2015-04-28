package com.letbrain.klask.server

import com.letbrain.klask.Klask
import com.letbrain.klask.staticPath
import org.junit.Assert
import org.junit.Test

class ServerTest {
    object app : Klask(staticPath = staticPath)

    Test
    fun testStatic() {
        app.run(onBackground = true)
        Assert.assertEquals("Hello, world!", app.server.client.get("/static/").data)
        app.stop()
    }
}

fun main(args: Array<String>) {
    val app = object : Klask(staticPath = staticPath) {
        init {
            route("/") { ->
                return@route "Hello, world!"
            }
        }
    }
    app.run()
}
