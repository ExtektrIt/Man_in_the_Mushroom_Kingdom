package com.andre.guryanov.testgame.engine

class Settings {
    var diceFaces = 6 //грани кубика
    var successfulAttack = (diceFaces - 1)..diceFaces  //5-6
    var turnLength = 10000   //время, выделяемое на ход в миллисек
}