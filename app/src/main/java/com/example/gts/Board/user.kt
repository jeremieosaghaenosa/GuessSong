package com.example.blackjack

import java.io.Serializable

//song track serializable that i use to add songs in this format everywhere
class user (): Serializable{

    var name: String = ""
    var guess: Long = 0
    var correct: Long = 0


    constructor(
        name: String,
        won: Long,
        corret: Long
    ) : this() {
        this.name = name
        this.guess = guess
        this.correct = correct

    }


    fun getname(): String{
        return this.name
    }
    fun getguess(): Long{
        return this.guess
    }
    fun getcorrect(): Long{
        return this.guess
    }
}