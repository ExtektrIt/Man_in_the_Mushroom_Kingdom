package com.andre.guryanov.testgame.engine

object Settings {

    var diceFaces = 6 //грани кубика
    var successfulAttack = (diceFaces - 1)..diceFaces  //5-6
    var turnLength: LongRange = 1_000L..2_000L   //время, выделяемое на ход в миллисек

}