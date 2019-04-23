package com.example.gts

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

}


class Test1 {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        val myClass = MyClass()
        val result = myClass.add(2, 2)
        val expected = 4

        assertEquals(expected, result)
    }
}
