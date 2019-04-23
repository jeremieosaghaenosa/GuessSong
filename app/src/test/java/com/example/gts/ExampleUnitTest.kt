//package com.example.gts
//
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import com.example.gts.Player.PlayerSet
//import org.junit.Test
//
//import org.junit.Assert.*
//import android.R
//import com.google.firebase.auth.FirebaseAuth
//
//
///**
// * Example local unit test, which will execute on the development machine (host).
// *
// * See [testing documentation](http://d.android.com/tools/testing).
// */
//class ExampleUnitTest {
//    @Test
//    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)
//    }
//
//}
//
//
//class Test1 {
//    @Test
//    @Throws(Exception::class)
//    fun onClick() {
//        val PS = PlayerSet()
//        val layout = R.layout.player
//        var text = "Bob"
//        var button: Button = layout.findViewById(R.id.changeNameButton);
//
//        button.setOnClickListener {
//            PS.updateName("Bob")
//        }
//        val result = "BoB"
//        val expected = text
//
//        assertEquals(expected, result)
//    }
//}
//
//class Test2 {
//    @Test
//    @Throws(Exception::class)
//    fun onClick() {
//        val PS = Login()
//        private lateinit var mAuth: FirebaseAuth
//        val layout = R.layout.bubble
//        var email = "bob@gmail.com"
//        var text = "bobisawesome"
//
//        var button: Button = layout.findViewById(R.id.loginButton);
//
//        button.setOnClickListener {
//            PS.signIn()
//        }
//
//        mAuth.currentUser = "bob@gmail.com"
//        val result = "bob@gmail.com"
//        val expected = mAuth.currentUser
//
//        assertEquals(expected, result)
//    }
//}
//
//
//class Test3 {
//    @Test
//    @Throws(Exception::class)
//    fun onClick() {
//        val PS = PlayerSet()
//        private lateinit var mAuth: FirebaseAuth
//        val layout = R.layout.player
//        var email = "bob@gmail.com"
//        var text = "bobisawesome"
//
//        var button: Button = layout.findViewById(R.id.signout);
//
//        button.setOnClickListener {
//        }
//
//        val result = ""
//        val expected = mAuth.currentUser
//
//        assertEquals(expected, result)
//    }
//}
