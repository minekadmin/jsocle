package com.github.jsocle.client

import com.github.jsocle.Klask
import org.junit.Assert
import org.junit.Test

public class TestClientTest {
    object app : Klask() {
        init {
            route("/") { ->
                return@route "index"
            }
        }
    }

    Test
    fun testGet() {
        Assert.assertEquals("index", app.client.get("/").data)
    }
}