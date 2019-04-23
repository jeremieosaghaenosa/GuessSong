package com.example.gts.Player

import java.io.Serializable

//song track serializable that i use to add songs in this format everywhere
class friend (): Serializable{

    var email: String = ""
    var name: String = ""
    var guess: Long = 0
    var correct: Long = 0
    var score: Long = 0


    constructor(
        email: String,
        name: String,
        guess: Long,
        correct: Long,
        score: Long
    ) : this() {
        this.email = email
        this.name = name
        this.guess = guess
        this.correct = correct
        this.score = score

    }

//    fun getemail(): String{
//        return this.email
//    }
//    fun getname(): String{
//        return this.name
//    }
//    fun getguess(): Long{
//        return this.guess
//    }
//    fun getcorrect(): Long{
//        return this.correct
//    }
//    fun getscore(): Long{
//        return this.score
//    }
}